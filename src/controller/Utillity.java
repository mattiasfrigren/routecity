package controller;

import model.Node;
import model.Path;
import model.Session;

public class Utillity {

    private static float getFlightPathDistance(Node startNode, Node endNode)
    {
        return 0;
    }

    public static Path djikstrasGetShortestPath(Node startNode, Node endNode)
    {
        //new PathValue(null, 25);
        return null;
    }

	public static boolean checkIfNodeWithCoordinatesExist(int x, int y)
	{
        for (Node node: Session.getSession().getLoadedNodes().keySet())
        {
            if (node.getCoordinates().getX() == x && node.getCoordinates().getY() == y )
            {
                return true;
            }
        }
	    return false;
	}

    /* TEST */
    public static float getFlightPathDistanceTest(Node startNode, Node endNode)
    {
        return getFlightPathDistance(startNode, endNode);
    }
}
