package controller;

import model.Coordinates;
import model.Node;
import model.Path;
import model.Session;

public class Utillity {

    private static float getFlightPathDistance(Node startNode, Node endNode)
    {
        Coordinates start = startNode.getCoordinates();
        Coordinates end = endNode.getCoordinates();

    	return getFlightPathDistance(start, end);
    }

	private static float getFlightPathDistance(Coordinates start, Coordinates end)
	{
		return (float) Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
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
    public static float getFlightPathDistanceTest(Coordinates start, Coordinates end)
    {
        return getFlightPathDistance(start, end);
    }
}
