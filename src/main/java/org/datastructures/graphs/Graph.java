package org.datastructures.graphs;

/**
 * Represents Graph
 */
public final class Graph<T> {

    private final GraphNode<T>[] graphNodes;

    public Graph(GraphNode<T>[] graphNodes) {
        this.graphNodes = graphNodes;
    }

    public GraphNode<T>[] getGraphNodes() {
        return graphNodes;
    }

    @Override
    public String toString() {
        return "Graph{" + "graphNodes=" + graphNodes + '}';
    }
}
