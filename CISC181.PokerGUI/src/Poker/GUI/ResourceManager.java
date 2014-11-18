package Poker.GUI;


import java.net.URL;
import javax.swing.ImageIcon;
import poker.Card;

/**
 * Utility class responsible for retrieving resource files.
 * 
 */
public abstract class ResourceManager {
    
    private static final String IMAGE_PATH_FORMAT = "/img/%s"; 
    
    /**
     * Returns the image of a specific card.
     * 
     * @param card
     *            The card.
     * 
     * @return The image.
     */
    public static ImageIcon getCardImage(Card card) {
        // Use image order, which is different from value order.
        String CardImageFileName = card.getCardImg();
        String path = String.format(IMAGE_PATH_FORMAT, CardImageFileName);
        return getIcon(path);
    }
    
    /**
     * Returns an image resource.
     * 
     * @param path
     *            The path on the classpath.
     * 
     * @return The image resource.
     * 
     * @throws RuntimeException
     *             If the resource could not be found.
     */
    public static ImageIcon getIcon(String path) {
        URL url = ResourceManager.class.getResource(path);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            throw new RuntimeException("Resource file not found: " + path);
        }
    }
    
}
