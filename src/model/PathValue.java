package model;

public class PathValue {
    private Node[] nodePath;
    private float distance;

    public PathValue(Node[] nodePath, float distance)
    {
        this.nodePath = nodePath;
        this.distance = distance;
    }

    public Node[] getNodePath() {
        return nodePath;
    }

    public float getDistance() {
        return distance;
    }
}
