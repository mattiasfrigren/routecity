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
        addRandomNodesToSession(10);
        createClosedCircuitWithAllNodes();
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

        Node nodeArr[] = new Node[Session.getSession().getLoadedNodes().size()];
        int i = 0;
        for (Node node :Session.getSession().getLoadedNodes().keySet()) {
            nodeArr[i] = node;
            i++;
        }
        for (int j = 0; j <nodeArr.length ; j++) {
            if (j==0){
                connectNode(nodeArr[nodeArr.length-1],nodeArr[j]);
                connectNode(nodeArr[j+1],nodeArr[j]);
            }
            else if (j<nodeArr.length-1 && j!=0){
            connectNode(nodeArr[j-1],nodeArr[j]);
            connectNode(nodeArr[j+1],nodeArr[j]);}
            else {
                connectNode(nodeArr[nodeArr.length-2],nodeArr[j]);
                connectNode(nodeArr[0],nodeArr[j]);
            }
        }


    }

    private void connectNode(Node nodeToAddAt, Node nodeToConnectTo)
    {
        nodeToConnectTo.addConnectedNode(nodeToAddAt);
        System.out.println("connected node:" +nodeToAddAt.getStreetName()+ " to node: " + nodeToConnectTo.getStreetName());
    }

    public void addRandomExtraConnectionAtRandomNodes(int i) {

    }

    public void addRandomExtraConnectionAtRandomNode() {
        int firstRandomNode = new Random().nextInt(Session.getSession().getLoadedNodes().size());
        int SecoundRandomNode = new Random().nextInt(Session.getSession().getLoadedNodes().size());
        
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
