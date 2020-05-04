package test.controller;


import java.util.HashMap;
import model.Coordinates;
import static org.junit.jupiter.api.Assertions.*;

import controller.Utillity;
import model.Constants;
import model.Node;
import model.Session;

import org.junit.jupiter.api.Test;

class UtillityTest {

    @Test
    void djikstrasGetShortestPath() {
    }

    @Test
    void getFlightPathDistanceTest()
	{
		Coordinates start = new Coordinates(10, 10);
		Coordinates end = new Coordinates(10, 15);
    	assertEquals(5, Utillity.getFlightPathDistanceTest(start, end));
    }

    @Test
	void checkIfNodeWithCoordinatesExist()
	{
        Node testNode = new Node(Constants.streetNames[0],15,15);
        Session.getSession().addToLoadedNodes(testNode);
        assertTrue(Utillity.checkIfNodeWithCoordinatesExist(15,15),"Coordinates on Node already exists");
        assertFalse(Utillity.checkIfNodeWithCoordinatesExist(15,25),"Space in Coordinates are free");
    }
}