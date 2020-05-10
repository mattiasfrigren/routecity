package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Coordinates;
import model.Node;
import model.Session;

public class Utillity {

    private static float getFlightPathDistance(Node startNode, Node endNode)
    {
    	return getFlightPathDistance(startNode.getCoordinates(), endNode.getCoordinates());
    }

	private static float getFlightPathDistance(Coordinates start, Coordinates end)
	{
		return (float) Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
	}

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

		// Didnt find node
        return null;
    }

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

	public static void connectNode(int index1, int index2)
	{
		connectNode(Session.getSession().getLoadedNodes().get(index1), Session.getSession().getLoadedNodes().get(index2));
	}

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
