package com.aniversex.repository;

import com.aniversex.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository gives ready-made CRUD methods.
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
