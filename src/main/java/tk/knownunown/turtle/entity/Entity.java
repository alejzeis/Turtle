package tk.knownunown.turtle.entity;

import javafx.geometry.BoundingBox;
import tk.knownunown.turtle.math.Vector3;

/**
 * Created by andrew on 6/8/14.
 */
public class Entity {

    public boolean isTile;
    public static final BoundingBox bb = new BoundingBox(0, 0, 0, 0, 0, 0);
    public Vector3 position = new Vector3(0, 0, 0);
    public String name;

}
