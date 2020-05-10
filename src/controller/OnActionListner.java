package controller;

import java.io.IOException;
import model.Node;

public class OnActionListner {

    public static Node[] CalculateShortestPath()
    {
        return null; //Utillity.djikstrasGetShortestPath(Session.getSession().getSelectedStartNode(), Session.getSession().getSelectedEndNode());
    }

    public static void resetSelectedNodes() throws IOException
	{
        AppController.getController().resetSelectedNodes();
    }

    public static void resetAllNodes() throws IOException
	{
        AppController.getController().resetAllNodes();
    }

    public static void AddExtraConnectionAtRandomNode() throws IOException
	{
        AppController.getController().addRandomExtraConnectionAtRandomNode();
    }

    public static void createNewSession() throws IOException
	{
        AppController.getController().initializeProgram();
    }

    // TODO Dev add nodes freely.
}
