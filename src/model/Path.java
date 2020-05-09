package model;

import java.util.ArrayList;

public class Path
{
    private ArrayList<Node> nodePath = new ArrayList<>();
    private float totalDistance = 0;

    public Path(Node startNode, Node nextNode, float distanceBetween)
    {
        nodePath.add(startNode);
        nodePath.add(nextNode);
        totalDistance = distanceBetween;
    }

	public ArrayList<Node> getNodePath()
	{
		return nodePath;
	}

	public float getTotalDistance() {
        return totalDistance;
    }

    public void addNextNodeToPath(Node node, float distanceBetween)
	{
		nodePath.add(node);
		totalDistance += distanceBetween;
	}
}
