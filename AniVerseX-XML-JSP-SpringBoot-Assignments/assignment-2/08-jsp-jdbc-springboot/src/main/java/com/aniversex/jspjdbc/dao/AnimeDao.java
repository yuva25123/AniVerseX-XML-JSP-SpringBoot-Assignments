package com.aniversex.jspjdbc.dao;

import com.aniversex.jspjdbc.model.Anime;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimeDao {

    private final DataSource dataSource;

    public AnimeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Add new anime record
    public void addAnime(Anime anime) {
        String sql = "INSERT INTO anime (title, genre, episodes, rating, short_review) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, anime.getTitle());
            ps.setString(2, anime.getGenre());
            ps.setInt(3, anime.getEpisodes());
            ps.setDouble(4, anime.getRating());
            ps.setString(5, anime.getShortReview());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while adding anime", e);
        }
    }

    // Get all anime records
    public List<Anime> getAllAnime() {
        String sql = "SELECT anime_id, title, genre, episodes, rating, short_review FROM anime ORDER BY anime_id";
        List<Anime> animeList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                animeList.add(mapAnime(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching anime list", e);
        }

        return animeList;
    }

    // Get one anime record by id
    public Anime getAnimeById(Integer animeId) {
        String sql = "SELECT anime_id, title, genre, episodes, rating, short_review FROM anime WHERE anime_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, animeId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapAnime(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching anime by id", e);
        }

        return null;
    }

    // Update existing anime record
    public void updateAnime(Anime anime) {
        String sql = "UPDATE anime SET title = ?, genre = ?, episodes = ?, rating = ?, short_review = ? WHERE anime_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, anime.getTitle());
            ps.setString(2, anime.getGenre());
            ps.setInt(3, anime.getEpisodes());
            ps.setDouble(4, anime.getRating());
            ps.setString(5, anime.getShortReview());
            ps.setInt(6, anime.getAnimeId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while updating anime", e);
        }
    }

    // Delete anime record
    public void deleteAnime(Integer animeId) {
        String sql = "DELETE FROM anime WHERE anime_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, animeId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting anime", e);
        }
    }

    private Anime mapAnime(ResultSet rs) throws SQLException {
        Anime anime = new Anime();
        anime.setAnimeId(rs.getInt("anime_id"));
        anime.setTitle(rs.getString("title"));
        anime.setGenre(rs.getString("genre"));
        anime.setEpisodes(rs.getInt("episodes"));
        anime.setRating(rs.getDouble("rating"));
        anime.setShortReview(rs.getString("short_review"));
        return anime;
    }
}
