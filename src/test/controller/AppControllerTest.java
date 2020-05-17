package test.controller;

import controller.AppController;
import controller.Utillity;
import java.io.IOException;
import model.Node;
import model.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

	// test if random node is added to session.
    @Test
    void addRandomNodesToSession() throws IOException
	{
		AppController.getController(); // Making sure to create the controller.
    	int sizeAtStart = Session.getSession().getLoadedNodes().size();  // Checking if controller added anything to session at start.

		AppController.getController().addRandomNodesToSession(5);  // adding 5 nodes.

		assertEquals(sizeAtStart + 5, Session.getSession().getLoadedNodes().size(), "Something is wrong in adding new random nodes to session");
    }
// tests that we create a closed circle with all the new nodes.
    @Test
    void createClosedCircuitWithAllNodes() throws IOException
	{

		AppController.getController();

		for (Node node: Session.getSession().getLoadedNodes()) {
			assertTrue( node.getConnectedNodes().size() >= 2, "Node: " + node.getStreetName() + " Do not have two connections.");
		}
    }

// adds an extra connection for a random nodes
    @Test
    void addRandomExtraConnectionAtRandomNode() throws IOException
	{
		AppController.getController();

		int totalExpectedNodeConnections = (Session.getSession().getLoadedNodes().size() * 2) + 8;  // +8 because there is 4 random connections.
		int totalNodeConnections = 0;
		for (Node node: Session.getSession().getLoadedNodes()) {
			totalNodeConnections += node.getConnectedNodes().size();
		}
		assertEquals(totalExpectedNodeConnections, totalNodeConnections, "Did not add extra connection");
    }
}