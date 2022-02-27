package org.datastructures.graphs.Problems.componentcount;

import org.datastructures.graphs.Problems.unidirected.UndirectedGraph;
import org.datastructures.graphs.Problems.unidirected.componentcount.ComponentCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ComponentCountTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void componentCount() {

        Character[][] rawGraph = new Character[][]{
                new Character[]{'1', '2'},
                new Character[]{'5', '6'},
                new Character[]{'6', '8'},
                new Character[]{'4', '6'},
                new Character[]{'7', '6'},
                new Character[]{'3', '0'}
        };

        Map<Character, List<Character>> graph = UndirectedGraph.buildUndirectedGraph(rawGraph);
        System.out.println(graph);
        int componentCount = ComponentCount.componentCount(graph);
        System.out.println(componentCount);
        Assertions.assertTrue(componentCount == 3);


    }


    @Test
    void longestComponent() {

        Character[][] rawGraph = new Character[][]{
                new Character[]{'1', '0'},
                new Character[]{'0', '8'},
                new Character[]{'5', '0'},
                new Character[]{'5', '8'},
                new Character[]{'3', '2'},
                new Character[]{'3', '4'},
                new Character[]{'2', '4'}
        };

        Map<Character, List<Character>> graph = UndirectedGraph.buildUndirectedGraph(rawGraph);
        System.out.println(graph);
        int longestCount = ComponentCount.longestComponent(graph);
        System.out.println(longestCount);
        Assertions.assertTrue(4==longestCount);
    }
}