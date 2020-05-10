package model;

import java.util.ArrayList;

public class Node {
    private String streetName;
	private Coordinates coordinates;

	public float gCost;
	public float hCost;
	public float fCost;

	public Node cameFromNode;

    private ArrayList<Node> connectedNodes;

    public Node(String streetName, int coordinateX, int coordinateY)
    {
        this.streetName = streetName;
        coordinates = new Coordinates(coordinateX, coordinateY);
        connectedNodes = new ArrayList<>();
    }

    public String getStreetName() {
        return streetName;
    }

    public ArrayList<Node> getConnectedNodes() {
        return connectedNodes;
    }

    public void addConnectedNode(Node node) {
    	connectedNodes.add(node);
    }

	public Coordinates getCoordinates()
	{
		return coordinates;
	}

	public void calculateFCost() {
    	fCost = gCost + hCost;
	}
}
