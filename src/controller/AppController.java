package controller;

import java.util.Random;
import javax.swing.DefaultListSelectionModel;
import model.Constants;
import model.Node;
import model.Session;
import view.RouteCityApplication;

public class AppController {

    private static AppController controller;
    private int currentNameIndex = 0;

    private AppController()
    {
        initializeProgram();
    }

    public static AppController getController()
    {
        if (controller == null)
        {
            controller = new AppController();
        }
        return controller;
    }

    public void initializeProgram()
    {
        //addRandomNodesToSession(10);
        //createClosedCircuitWithAllNodes();
       // addRandomExtraConnectionAtRandomNodes(1);
        // TODO Initialize view // Update it.

    }

    public void addRandomNodesToSession(int amount)
    {
		for (int i = 0; i < amount; i++)
		{
			addRandomNodeToSession();
		}

    }

    private void addRandomNodeToSession()
	{
		int x = new Random().nextInt(Constants.maxXCoordinate);
		int y = new Random().nextInt(Constants.maxYCoordinate);

		for (int i = 0; i < 50; i++)
		{
			if (!Utillity.checkIfNodeWithCoordinatesExist(x, y))	{
				break;
			}
			System.out.println("Coordinate is already taken, randoms a new one");
		}


		if (!Utillity.checkIfNodeWithCoordinatesExist(x, y))
		{
			Session.getSession().addToLoadedNodes(new Node(Constants.streetNames[currentNameIndex], x, y));
			currentNameIndex++;
		}
		else
		{
			System.out.println("Could not find an unique coordinate for the node, tried to random one 50 times.");
		}

	}

    public void createClosedCircuitWithAllNodes()
    {

    }

    private void connectNode(Node nodeToAddAt, Node nodeToConnectTo)
    {

    }

    public void addRandomExtraConnectionAtRandomNodes(int i) {

    }

    public void addRandomExtraConnectionAtRandomNode() {

    }

    public void resetAllNodes()
    {
        Session.getSession().resetSession();
        // TODO Add view reset.
    }

    public void resetSelectedNodes() {
        Session.getSession().setSelectedStartNode(null);
        Session.getSession().setSelectedEndNode(null);
        // TODO Update view
    }

    /* TESTS */

    private void connectNodeTest(Node nodeToAddAt, Node nodeToConnectTo)
    {
        connectNode(nodeToAddAt, nodeToConnectTo);
    }

}
