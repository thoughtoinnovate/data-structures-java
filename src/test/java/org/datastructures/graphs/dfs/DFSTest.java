package org.datastructures.graphs.dfs;

import org.datastructures.graphs.GraphNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DFSTest {

    private Map<Character, GraphNode<Character>> graph;

    @BeforeEach
    void setUp() {
        graph = new HashMap<>();

        GraphNode<Character> k = new GraphNode<>('k', new GraphNode[]{});
        GraphNode<Character> h = new GraphNode<>('h', new GraphNode[]{});
        GraphNode<Character> g = new GraphNode<>('g', new GraphNode[]{h});
        GraphNode<Character> i = new GraphNode<>('i', new GraphNode[]{g, k});
        GraphNode<Character> j = new GraphNode<>('j', new GraphNode[]{i});
        GraphNode<Character> f = new GraphNode<>('f', new GraphNode[]{g, i});

        graph.put('k', k);
        graph.put('h', h);
        graph.put('g', g);
        graph.put('i', i);
        graph.put('j', j);
        graph.put('f', f);
    }

    @Test
    void haspath() {
        Assertions.assertTrue(BFS.haspath(graph.get('f'), graph.get('k')));
        Assertions.assertFalse(BFS.haspath(graph.get('j'), graph.get('f')));
        Assertions.assertFalse(BFS.haspath(graph.get('k'), graph.get('f')));
        Assertions.assertTrue(BFS.haspath(graph.get('j'), graph.get('h')));
    }
}