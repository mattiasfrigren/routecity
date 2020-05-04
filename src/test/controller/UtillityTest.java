package test.controller;


import static org.junit.jupiter.api.Assertions.*;

import controller.Utillity;
import model.Constants;
import model.Node;
import model.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtillityTest {

    @Test
    void djikstrasGetShortestPath() {
    }

    @Test
    void getFlightPathDistanceTest() {
    }

    @Test
	void checkIfNodeWithCoordinatesExist()
	{
        Node testNode = new Node(Constants.streetNames[0],15,15);
        Session.getSession().addToLoadedNodes(testNode);
        Assertions.assertTrue(Utillity.checkIfNodeWithCoordinatesExist(15,15),"Coordinates on Node already exists");
        Assertions.assertFalse(Utillity.checkIfNodeWithCoordinatesExist(15,25),"Space in Coordinates are free");

    }
}