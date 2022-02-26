package org.datastructures.graphs;

import java.util.Arrays;

public class GraphNode<T> {

    private final T node;
    private final GraphNode[] neighbours;

    public GraphNode(T node, GraphNode[] neighbours) {
        this.node = node;
        this.neighbours = neighbours;
    }

    public T getNode() {
        return node;
    }

    public GraphNode[] getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return "GraphNode{" + "node=" + node + ", neighbours=" + Arrays.toString(neighbours) + '}';
    }
}
