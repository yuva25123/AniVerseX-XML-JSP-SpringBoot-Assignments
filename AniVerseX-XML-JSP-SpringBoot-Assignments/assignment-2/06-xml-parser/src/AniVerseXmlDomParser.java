import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AniVerseXmlDomParser {

    public static void main(String[] args) {
        try {
            // Read anime.xml from the current folder.
            File xmlFile = new File("anime.xml");

            // Create DOM parser objects.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList animeList = document.getElementsByTagName("anime");

            System.out.println("AniVerseX - XML DOM Parser Output");
            System.out.println("Total Records: " + animeList.getLength());
            System.out.println("--------------------------------------------------");

            for (int i = 0; i < animeList.getLength(); i++) {
                Node node = animeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element anime = (Element) node;

                    String animeId = getTagValue(anime, "animeId");
                    String title = getTagValue(anime, "title");
                    String genre = getTagValue(anime, "genre");
                    String episodes = getTagValue(anime, "episodes");
                    String rating = getTagValue(anime, "rating");
                    String shortReview = getTagValue(anime, "shortReview");
                    String recommendationType = getTagValue(anime, "recommendationType");

                    System.out.println("Anime ID           : " + animeId);
                    System.out.println("Title              : " + title);
                    System.out.println("Genre              : " + genre);
                    System.out.println("Episodes           : " + episodes);
                    System.out.println("Rating             : " + rating);
                    System.out.println("Short Review       : " + shortReview);
                    System.out.println("RecommendationType : " + recommendationType);
                    System.out.println("--------------------------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error while parsing XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to safely fetch XML tag values.
    private static String getTagValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}
