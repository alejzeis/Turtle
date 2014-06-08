package tk.knownunown.turtle.entity;

import javafx.geometry.BoundingBox;

/**
 * Created by andrew on 6/8/14.
 */
public class Entity {

    public boolean isTile;
    public static final BoundingBox bb = new BoundingBox(0, 0, 0, 0, 0, 0);
    public double[] position = {0, 0, 0}; //xyz format
    public String name;

}
