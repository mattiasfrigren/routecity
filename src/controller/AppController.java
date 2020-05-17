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

    public static AppController getController() throws IOException
	{
        if (controller == null)
        {
            controller = new AppController();
        }
        return controller;
    }

    public void initializeProgram() throws IOException
	{
     	addRandomNodesToSession(10);
        Utillity.createClosedCircuitWithAllNodes();
       	addRandomExtraConnectionAtRandomNodes(4);
     	view = new RouteCityApplication();

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

	private boolean isConnected(int index1, int index2)
	{
		return isConnected(Session.getSession().getLoadedNodes().get(index1), Session.getSession().getLoadedNodes().get(index2));
	}

    private boolean isConnected(Node node1, Node node2)
	{
		return node1.getConnectedNodes().contains(node2);
	}

    public void addRandomExtraConnectionAtRandomNodes(int i) {
		for (int j = 0; j < i; j++)
		{
			addRandomExtraConnectionAtRandomNode();
		}
    }

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
