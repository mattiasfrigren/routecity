package test.controller;

import controller.AppController;
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
    void addRandomNodesToSession() {

		AppController.getController(); // Making sure to create the controller.
    	int sizeAtStart = Session.getSession().getLoadedNodes().size();  // Checking if controller added anything to session at start.

		AppController.getController().addRandomNodesToSession(5);  // adding 5 nodes.

		assertEquals(sizeAtStart + 5, Session.getSession().getLoadedNodes().size(), "Something is wrong in adding new random nodes to session");
    }

    @Test
    void createClosedCircuitWithAllNodes() {
    }

    @Test
    void addRandomExtraConnectionAtRandomNodes() {
    }

    @Test
    void addRandomExtraConnectionAtRandomNode() {
    }

    @Test
    void resetAllNodes() {
    }

    @Test
    void resetSelectedNodes() {
    }
}