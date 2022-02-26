package org.datastructures.graphs.Problems.unidirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UndirectedGraphTest {

    @Test
    void hasPath() {

        Character[][] graph = new Character[][]{
                new Character[]{'i', 'j'},
                new Character[]{'k', 'i'},
                new Character[]{'m', 'k'},
                new Character[]{'k', 'l'},
                new Character[]{'o', 'n'}};

        Assertions.assertTrue(UndirectedGraph.hasPath(graph, 'j', 'm'));
        Assertions.assertFalse(UndirectedGraph.hasPath(graph, 'i', 'o'));
    }

}