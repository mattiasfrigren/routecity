package model;

import java.util.ArrayList;

public class Node {
    private String streetName;
    private int coordinateX;
    private int coordinateY;

    private ArrayList<Node> connectedNodes;

    public Node(String streetName, int coordinateX, int coordinateY)
    {
        this.streetName = streetName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        connectedNodes = new ArrayList<>();
    }

    public String getStreetName() {
        return streetName;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public ArrayList<Node> getConnectedNodes() {
        return connectedNodes;
    }

    public void addConnectedNode(Node node) {
        connectedNodes.add(node);
    }
}
