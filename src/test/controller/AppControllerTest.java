package test.controller;

import controller.AppController;
import controller.Utillity;
import java.io.IOException;
import model.Node;
import model.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    @Test
    void getController() {
    }

    @Test
    void initializeProgram() {
    }

    @Test
    void addRandomNodesToSession() throws IOException
	{
		AppController.getController(); // Making sure to create the controller.
    	int sizeAtStart = Session.getSession().getLoadedNodes().size();  // Checking if controller added anything to session at start.

		AppController.getController().addRandomNodesToSession(5);  // adding 5 nodes.

		assertEquals(sizeAtStart + 5, Session.getSession().getLoadedNodes().size(), "Something is wrong in adding new random nodes to session");
    }

    @Test
    void createClosedCircuitWithAllNodes() throws IOException
	{

		AppController.getController().addRandomNodesToSession(5);  // adding 5 nodes.

		Utillity.createClosedCircuitWithAllNodes();
		for (Node node: Session.getSession().getLoadedNodes()) {
			assertEquals(2, node.getConnectedNodes().size(), "Node: " + node.getStreetName() + " Do not have two connections.");
		}
    }

    @Test
    void addRandomExtraConnectionAtRandomNodes() {
    }

    @Test
    void addRandomExtraConnectionAtRandomNode() throws IOException
	{
		AppController.getController().addRandomNodesToSession(5);  // adding 5 nodes.
		Utillity.createClosedCircuitWithAllNodes();

		AppController.getController().addRandomExtraConnectionAtRandomNode();
		int totalExpectedNodeConnections = (Session.getSession().getLoadedNodes().size() * 2) + 2;
		int totalNodeConnections = 0;
		for (Node node: Session.getSession().getLoadedNodes()) {
			totalNodeConnections += node.getConnectedNodes().size();
		}
		assertEquals(totalExpectedNodeConnections, totalNodeConnections, "Did not add extra connection");
    }

    @Test
    void resetAllNodes() {
    }

    @Test
    void resetSelectedNodes() {
    }
}