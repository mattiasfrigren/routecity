package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Coordinates;
import model.Node;
import model.Session;

public class Utillity {

	/**
	 * Caluclate straight path distance between two coordinates.
	 *
	 * @param startNode the node you wanna calculate straight path from.
	 * @param endNode the node you wanna calculate straight path to.
	 * @return float value of the distance between startNode and endNode
	 */
    private static float getFlightPathDistance(Node startNode, Node endNode)
    {
    	return getFlightPathDistance(startNode.getCoordinates(), endNode.getCoordinates());
    }

	/**
	 * Caluclate straight path distance between two coordinates.
	 *
	 * @param start the coordinate you wanna calculate straight path from.
	 * @param end the coordinate you wanna calculate straight path to.
	 * @return float value of the distance between startNode and endNode
	 */
	private static float getFlightPathDistance(Coordinates start, Coordinates end)
	{
		return (float) Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
	}

	/**
	 * Caluclates path to walk from one node to another.
	 *
	 * @param startNode the node you wanna calculate path from.
	 * @param endNode the node you wanna calculate path to.
	 * @return ArrayList with the path of nodes with shortest path from startNode to endNode.
	 */
    public static ArrayList<Node> djikstrasGetShortestPath(Node startNode, Node endNode)
    {
    	ArrayList<Node> openList = new ArrayList<>();
    	ArrayList<Node> closedList = new ArrayList<>();

    	openList.add(startNode);

		for (Node node: Session.getSession().getLoadedNodes())
		{
			node.gCost = Float.MAX_VALUE;
			node.calculateFCost();
			node.cameFromNode = null;
		}

		startNode.gCost = 0;
		startNode.hCost = getFlightPathDistance(startNode, endNode);
		startNode.calculateFCost();

		while(openList.size() > 0)
		{
			Node currentNode = getLowestFCostNode(openList);
			if (currentNode == endNode)
			{
				return calculatePath(endNode);
			}

			openList.remove(currentNode);
			closedList.add(currentNode);

			for (Node connectedNode : currentNode.getConnectedNodes())
			{
				if (closedList.contains(connectedNode))
				{
					continue;
				}

				float tentativeGCost = currentNode.gCost + getFlightPathDistance(currentNode, connectedNode);

				if (tentativeGCost < connectedNode.gCost)
				{
					connectedNode.cameFromNode = currentNode;
					connectedNode.gCost = tentativeGCost;
					connectedNode.hCost = getFlightPathDistance(connectedNode, endNode);
					connectedNode.calculateFCost();

					if (!openList.contains(connectedNode))
					{
						openList.add(connectedNode);
					}
				}
			}
		}

		// Didn't find path to node.
        return null;
    }

	/**
	 * After caluclating djikstras you use this to get the path.
	 *
	 * @param endNode The last node you sat value at.
	 * @return ArrayList of the path of nodes.
	 */
    private static ArrayList<Node> calculatePath(Node endNode)
	{
		ArrayList<Node> path = new ArrayList<>();
		path.add(endNode);
		Node currentNode = endNode;

		while (currentNode.cameFromNode != null)
		{
			path.add(currentNode.cameFromNode);
			currentNode = currentNode.cameFromNode;
		}
		Collections.reverse(path);
		return path;
	}

	/**
	 * Get the node with lowest FCost from list of nodes.
	 *
	 * @param nodes the node you wanna calculate path from.
	 * @return Node with lowest FCost.
	 */
    private static Node getLowestFCostNode(ArrayList<Node> nodes)
	{
		Node lowestFCostNode = nodes.get(0);
		for (int i = 1; i < nodes.size(); i++)
		{
			if (nodes.get(i).fCost < lowestFCostNode.fCost)
			{
				lowestFCostNode = nodes.get(i);
			}
		}
		return lowestFCostNode;
	}

	/**
	 * Checking if a node in Session already have the coordinates.
	 *
	 * @param x The x coordinate value.
	 * @param y The y coordinate value.
	 * @return true if a node exists at coordinate.
	 */
	public static boolean checkIfNodeWithCoordinatesExist(int x, int y)
	{
        for (Node node: Session.getSession().getLoadedNodes())
        {
            if (node.getCoordinates().getX() == x && node.getCoordinates().getY() == y )
            {
                return true;
            }
        }
	    return false;
	}

	/**
	 * Connecting all nodes with each other in a closed circuit.
	 *
	 */
	public static void createClosedCircuitWithAllNodes()
	{
		int connectTo = 0;
		for (int i = 0; i < Session.getSession().getLoadedNodes().size(); i++)
		{
			connectTo = i + 1;
			if (i == Session.getSession().getLoadedNodes().size() - 1)
			{
				connectTo = 0;
			}
			connectNode(i, connectTo);
		}
	}

	/**
	 * Connecting node by index with other node by index.
	 *
	 * @param index1 The index of the node you want to connect in Session.
	 * @param index2 The index of the node you want to connect with index2 in Session.
	 */
	public static void connectNode(int index1, int index2)
	{
		connectNode(Session.getSession().getLoadedNodes().get(index1), Session.getSession().getLoadedNodes().get(index2));
	}

	/**
	 * Connecting node by with other node.
	 *
	 * @param nodeToAddAt The node you want to connect in Session.
	 * @param nodeToConnectTo The node you want to connect with index2 in Session.
	 */
	public static void connectNode(Node nodeToAddAt, Node nodeToConnectTo)
	{
		nodeToAddAt.addConnectedNode(nodeToConnectTo);
		nodeToConnectTo.addConnectedNode(nodeToAddAt);
		System.out.println("connected node:" +nodeToAddAt.getStreetName()+ " to node: " + nodeToConnectTo.getStreetName());
		System.out.println("connected node:" +nodeToConnectTo.getStreetName()+ " to node: " + nodeToAddAt.getStreetName());
	}

    /* TEST */
    public static float getFlightPathDistanceTest(Coordinates start, Coordinates end)
    {
        return getFlightPathDistance(start, end);
    }
}
