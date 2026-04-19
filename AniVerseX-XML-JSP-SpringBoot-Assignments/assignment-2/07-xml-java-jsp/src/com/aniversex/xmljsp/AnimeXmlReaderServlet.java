package com.aniversex.xmljsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimeXmlReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Anime> animeList = new ArrayList<>();

        try {
            // Read anime.xml from web application root.
            String xmlPath = getServletContext().getRealPath("/anime.xml");
            File xmlFile = new File(xmlPath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("anime");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Anime anime = new Anime();

                    anime.setAnimeId(getValue(element, "animeId"));
                    anime.setTitle(getValue(element, "title"));
                    anime.setGenre(getValue(element, "genre"));
                    anime.setEpisodes(Integer.parseInt(getValue(element, "episodes")));
                    anime.setRating(Double.parseDouble(getValue(element, "rating")));
                    anime.setShortReview(getValue(element, "shortReview"));
                    anime.setRecommendationType(getValue(element, "recommendationType"));

                    animeList.add(anime);
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error while reading anime.xml", e);
        }

        req.setAttribute("animeList", animeList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/anime-list.jsp");
        dispatcher.forward(req, resp);
    }

    private String getValue(Element parent, String tagName) {
        return parent.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
