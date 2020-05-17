package controller;

import java.io.IOException;
import java.util.Random;
import model.Constants;
import model.Node;
import model.Session;
import view.RouteCityApplication;

public class AppController {

    private static AppController controller;
    private int currentNameIndex = 0;
    private RouteCityApplication view;

    private AppController() throws IOException
	{
        initializeProgram();
    }

	/**
	 * Singelton, returns controller.
	 *
	 */
    public static AppController getController() throws IOException
	{
        if (controller == null)
        {
            controller = new AppController();
        }
        return controller;
    }

	/**
	 *  Initialize everything in the program.
	 *
	 */
    public void initializeProgram() throws IOException
	{
     	addRandomNodesToSession(10);
        Utillity.createClosedCircuitWithAllNodes();
       	addRandomExtraConnectionAtRandomNodes(4);
     	view = new RouteCityApplication();

    }

	/**
	 * Adds an amount of nodes to Session with random coordinates that is not taken.
	 *
	 * @param amount The amounts of nodes to add.
	 */
    public void addRandomNodesToSession(int amount)
    {
		for (int i = 0; i < amount; i++)
		{
			addRandomNodeToSession();
		}

    }

	/**
	 * Adds a node to Session with random coordinates that is not taken.
	 *
	 */
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
			if (currentNameIndex < Constants.streetNames.length)
			{
				Session.getSession().addToLoadedNodes(new Node(Constants.streetNames[currentNameIndex], x, y));
			}
			else
				{
					Session.getSession().addToLoadedNodes(new Node("Lasse " + currentNameIndex, x, y));
			}
			currentNameIndex++;
		}
		else
		{
			System.out.println("Could not find an unique coordinate for the node, tried to random one 50 times.");
		}

	}

	/**
	 * Checking if a node in Session already is connected with another node.
	 *
	 * @param index1 the node index to check at.
	 * @param index2 the node index to check with index1.
	 * @return true if index1 node has connection with index2.
	 */
	private boolean isConnected(int index1, int index2)
	{
		return isConnected(Session.getSession().getLoadedNodes().get(index1), Session.getSession().getLoadedNodes().get(index2));
	}

	/**
	 * Checking if a node in Session already is connected with another node.
	 *
	 * @param node1 the node to check at.
	 * @param node2 the node to check with node1.
	 * @return true if node has connection with node2.
	 */
    private boolean isConnected(Node node1, Node node2)
	{
		return node1.getConnectedNodes().contains(node2);
	}

	/**
	 * Adds an amount of extra connections to nodes in Session.
	 *
	 * @param amount the amount of random extra connections to add.
	 */
    public void addRandomExtraConnectionAtRandomNodes(int amount) {
		for (int j = 0; j < amount; j++)
		{
			addRandomExtraConnectionAtRandomNode();
		}
    }

	/**
	 * Adds random extra connection to nodes in Session.
	 *
	 */
    public void addRandomExtraConnectionAtRandomNode() {

    	if (Session.getSession().getLoadedNodes().size() < 2)
		{
			return;
		}

    	int maxNodes = Session.getSession().getLoadedNodes().size();

		int randomNode = new Random().nextInt(maxNodes);
		int randomNode2 = new Random().nextInt(maxNodes);

		for (int i = 0; i < 50; i++)
		{
			if (randomNode2 == randomNode || isConnected(randomNode, randomNode2))
			{
				randomNode = new Random().nextInt(maxNodes);
				randomNode2 = new Random().nextInt(maxNodes);
			}
			else
			{
				break;
			}
		}

		if (randomNode2 != randomNode || !isConnected(randomNode, randomNode2))
		{
			Utillity.connectNode(randomNode, randomNode2);
		}
		else
		{
			System.out.println("Was not able to add random connection to node");
		}
    }

	/**
	 * Reset all nodes, in session and in view and gives you a fresh new load.
	 *
	 */
    public void resetAllNodes() throws IOException {
        Session.getSession().resetSession();
        view.resetView();
		currentNameIndex = 0;
		addRandomNodesToSession(10);
		Utillity.createClosedCircuitWithAllNodes();
		addRandomExtraConnectionAtRandomNodes(4);
		view.initializeAllNodes();
    }


}
