package model;

public class Path
{
    private Node[] nodePath;
    private float totalDistance;

    public Path(Node[] nodePath, float totalDistance)
    {
        this.nodePath = nodePath;
        this.totalDistance = totalDistance;
    }

    public Node[] getNodePath() {
        return nodePath;
    }

    public float getTotalDistance() {
        return totalDistance;
    }
}
