package controller;

import java.io.IOException;

public class OnActionListner {

	/**
	 * Actionlistner methood to call on button click.
	 *
	 */
    public static void resetAllNodes() throws IOException
	{
        AppController.getController().resetAllNodes();
    }

	/**
	 * Actionlistner methood to call on button click.
	 *
	 */
    public static void AddExtraConnectionAtRandomNode() throws IOException
	{
        AppController.getController().addRandomExtraConnectionAtRandomNode();
    }

}
