package controller;

import model.Path;
import model.Session;

public class OnActionListner {

    public static Path CalculateShortestPath()
    {
        return Utillity.djikstrasGetShortestPath(Session.getSession().getSelectedStartNode(), Session.getSession().getSelectedEndNode());
    }

    public static void resetSelectedNodes()
    {
        AppController.getController().resetSelectedNodes();
    }

    public static void resetAllNodes()
    {
        AppController.getController().resetAllNodes();
    }

    public static void AddExtraConnectionAtRandomNode()
    {
        AppController.getController().addRandomExtraConnectionAtRandomNode();
    }

    public static void createNewSession()
    {
        AppController.getController().initializeProgram();
    }

    // TODO Dev add nodes freely.
}
