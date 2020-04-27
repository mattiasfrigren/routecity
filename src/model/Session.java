package model;

import java.awt.*;
import java.util.HashMap;

public class Session {
    private static Session session;
    private Node selectedStartNode;
    private Node selectedEndNode;

    private HashMap<Node, Image> loadedNodes;

    private Session()
    {
        loadedNodes = new HashMap<>();
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

    public HashMap<Node, Image> getLoadedNodes() {
        return loadedNodes;
    }

    public void setLoadedNodes(HashMap<Node, Image> loadedNodes) {
        this.loadedNodes = loadedNodes;
    }

    public void addToLoadedNodes(Node node) {
        Image image = null;
        loadedNodes.put(node, image);
    }

    public void removeFromLoadedNodes(Node node) {
        loadedNodes.remove(node);
    }
}
