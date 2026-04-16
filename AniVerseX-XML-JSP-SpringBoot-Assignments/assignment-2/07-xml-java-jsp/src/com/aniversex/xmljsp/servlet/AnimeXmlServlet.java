package com.aniversex.xmljsp.servlet;

import com.aniversex.xmljsp.model.Anime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimeXmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Anime> animeList = new ArrayList<>();

        try {
            // Read XML file from WEB-INF so users cannot edit it directly in browser.
            String xmlPath = getServletContext().getRealPath("/WEB-INF/data/anime.xml");
            File xmlFile = new File(xmlPath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("anime");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Anime anime = new Anime(
                            getTagValue("animeId", element),
                            getTagValue("title", element),
                            getTagValue("genre", element),
                            Integer.parseInt(getTagValue("episodes", element)),
                            Double.parseDouble(getTagValue("rating", element)),
                            getTagValue("shortReview", element),
                            getTagValue("recommendationType", element)
                    );

                    animeList.add(anime);
                }
            }

            request.setAttribute("animeList", animeList);

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error while reading anime.xml: " + e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/anime-list.jsp");
        dispatcher.forward(request, response);
    }

    private String getTagValue(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list.getLength() > 0) {
            return list.item(0).getTextContent().trim();
        }
        return "";
    }
}
