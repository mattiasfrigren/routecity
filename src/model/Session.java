package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Session {
    private static Session session;
    private Node selectedStartNode;
    private Node selectedEndNode;

    private ArrayList<Node> loadedNodes;

    private Session()
    {
        loadedNodes = new ArrayList<>();
    }

    public static Session getSession()
    {
        if (session == null)
        {
            session = new Session();
        }

        return session;
    }

    public void resetSession()
    {
        session = new Session();
    }

    public Node getSelectedStartNode() {
        return selectedStartNode;
    }

    public void setSelectedStartNode(Node selectedStartNode) {
        this.selectedStartNode = selectedStartNode;
    }

    public Node getSelectedEndNode() {
        return selectedEndNode;
    }

    public void setSelectedEndNode(Node selectedEndNode) {
        this.selectedEndNode = selectedEndNode;
    }

    public ArrayList<Node> getLoadedNodes() {
        return loadedNodes;
    }

    public void addToLoadedNodes(Node node) {
    	this.loadedNodes.add(node);
    }

    public void removeFromLoadedNodes(Node node) {
        loadedNodes.remove(node);
    }
}
