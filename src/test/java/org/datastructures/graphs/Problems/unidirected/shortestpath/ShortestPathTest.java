package org.datastructures.graphs.Problems.unidirected.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathTest {

    @Test
    void findShortestPathBFS() {

        Character[][] rawGraph = new Character[][]{
                new Character[]{'w', 'x'},
                new Character[]{'w', 'v'},
                new Character[]{'x', 'y'},
                new Character[]{'y', 'z'},
                new Character[]{'v', 'z'}
        };

        ShortestPath shortestPath = new ShortestPath();

        ShortestPath.NodeDistanceEntry<Character> shortestPathBFS = shortestPath.findShortestPathBFS(rawGraph, 'w', 'z');
        Assertions.assertTrue(shortestPathBFS.getNode()=='z');
        Assertions.assertTrue(2== shortestPathBFS.getDistance());

    }
}