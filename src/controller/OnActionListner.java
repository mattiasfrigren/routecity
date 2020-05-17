package controller;

import java.io.IOException;

public class OnActionListner {

    public static void resetAllNodes() throws IOException
	{
        AppController.getController().resetAllNodes();
    }

    public static void AddExtraConnectionAtRandomNode() throws IOException
	{
        AppController.getController().addRandomExtraConnectionAtRandomNode();
    }

}
