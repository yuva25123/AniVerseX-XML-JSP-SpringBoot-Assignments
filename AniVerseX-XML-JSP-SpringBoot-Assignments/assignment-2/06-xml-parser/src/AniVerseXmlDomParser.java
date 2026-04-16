import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AniVerseXmlDomParser {

    public static void main(String[] args) {
        // By default, parser reads anime.xml from current folder.
        String xmlPath = args.length > 0 ? args[0] : "anime.xml";

        try {
            File xmlFile = new File(xmlPath);
            if (!xmlFile.exists()) {
                System.out.println("XML file not found: " + xmlFile.getAbsolutePath());
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList animeList = document.getElementsByTagName("anime");

            System.out.println("AniVerseX - XML DOM Parser Output");
            System.out.println("Total Anime Records: " + animeList.getLength());
            System.out.println("---------------------------------------");

            for (int i = 0; i < animeList.getLength(); i++) {
                Node node = animeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element animeElement = (Element) node;

                    String animeId = getTagValue("animeId", animeElement);
                    String title = getTagValue("title", animeElement);
                    String genre = getTagValue("genre", animeElement);
                    String episodes = getTagValue("episodes", animeElement);
                    String rating = getTagValue("rating", animeElement);
                    String shortReview = getTagValue("shortReview", animeElement);
                    String recommendationType = getTagValue("recommendationType", animeElement);

                    System.out.println("Record " + (i + 1));
                    System.out.println("animeId            : " + animeId);
                    System.out.println("title              : " + title);
                    System.out.println("genre              : " + genre);
                    System.out.println("episodes           : " + episodes);
                    System.out.println("rating             : " + rating);
                    System.out.println("shortReview        : " + shortReview);
                    System.out.println("recommendationType : " + recommendationType);
                    System.out.println("---------------------------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("Error while parsing XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Utility method to read text value of a tag.
    private static String getTagValue(String tagName, Element parentElement) {
        NodeList list = parentElement.getElementsByTagName(tagName);
        if (list.getLength() > 0) {
            Node node = list.item(0);
            return node.getTextContent().trim();
        }
        return "";
    }
}
