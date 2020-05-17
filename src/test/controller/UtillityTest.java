package test.controller;


import java.util.ArrayList;
import model.Coordinates;
import static org.junit.jupiter.api.Assertions.*;

import controller.Utillity;
import model.Constants;
import model.Node;
import model.Session;

import org.junit.jupiter.api.Test;

class UtillityTest {

	// test so our algoritm acually gets the shortest path between our nodes.
    @Test
    void djikstrasGetShortestPath() {

    	Node node1 = new Node("Namn1", 20, 20);
		Node node2 = new Node("Namn2", 10, 10);
		Node node3 = new Node("Namn3", 30, 30);
		Node node4 = new Node("Namn4", 40, 40);
		Node node5 = new Node("Namn5", 50, 50);
    	Session.getSession().addToLoadedNodes(node1);
		Session.getSession().addToLoadedNodes(node2);
		Session.getSession().addToLoadedNodes(node3);
		Session.getSession().addToLoadedNodes(node4);
		Session.getSession().addToLoadedNodes(node5);

		Utillity.createClosedCircuitWithAllNodes();

		ArrayList<Node> correctNodes = new ArrayList<>();
		correctNodes.add(node1);
		correctNodes.add(node5);
		correctNodes.add(node4);
		assertEquals(correctNodes,Utillity.djikstrasGetShortestPath(node1, node4));

    }
// gets the "flightPath" between 2 coordiantes.
    @Test
    void getFlightPathDistanceTest()
	{
		Coordinates start = new Coordinates(10, 10);
		Coordinates end = new Coordinates(10, 15);
    	assertEquals(5, Utillity.getFlightPathDistanceTest(start, end));
    }
// checks if a node with taken coordinates exists.
    @Test
	void checkIfNodeWithCoordinatesExist()
	{
        Node testNode = new Node(Constants.streetNames[0],15,15);
        Session.getSession().addToLoadedNodes(testNode);
        assertTrue(Utillity.checkIfNodeWithCoordinatesExist(15,15),"Coordinates on Node already exists");
        assertFalse(Utillity.checkIfNodeWithCoordinatesExist(15,25),"Space in Coordinates are free");
    }
}