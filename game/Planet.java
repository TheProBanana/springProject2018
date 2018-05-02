package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author Skylor Criqui
 */
public class Planet extends Entity{
    
    public Planet(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr) {
        super(layer, image, x, y, r, dx, dy, dr);
    }
    
}
