package controller;

import model.Node;
import model.Session;
import view.RouteCityApplication;

public class AppController {

    private static AppController controller;

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
        addRandomExtraConnectionAtRandomNodes(1);
        // TODO Initialize view // Update it.

    }

    public void addRandomNodesToSession(int amount)
    {

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

    private boolean checkIfNodeWithCoordinatesExist(int x, int y)
    {
        return false;
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

    private boolean checkIfNodeWithCoordinatesExistTest(int x, int y)
    {
        return checkIfNodeWithCoordinatesExist(x, y);
    }
}
