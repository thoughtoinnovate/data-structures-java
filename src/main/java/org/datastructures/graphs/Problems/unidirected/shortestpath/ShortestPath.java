package org.datastructures.graphs.Problems.unidirected.shortestpath;

import org.datastructures.graphs.Problems.unidirected.UndirectedGraph;

import java.util.*;

public class ShortestPath {

    public class NodeDistanceEntry<T> {
        private T node;
        private int distance;

        public NodeDistanceEntry(T node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public T getNode() {
            return node;
        }

        public void setNode(T node) {
            this.node = node;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public <T> NodeDistanceEntry<T> findShortestPathBFS(T[][] edges, T source, T destination) {

        Map<T, List<T>> graph = UndirectedGraph.buildUndirectedGraph(edges);

        NodeDistanceEntry<T> nodeDistanceEntry = new NodeDistanceEntry<>(source, 0);
        Queue<NodeDistanceEntry> traversalQueue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        traversalQueue.add(nodeDistanceEntry);

        while (!traversalQueue.isEmpty()) {

            nodeDistanceEntry = traversalQueue.poll();

            if (nodeDistanceEntry.node == destination) {
                return nodeDistanceEntry;
            }

            visited.add((T) nodeDistanceEntry.getNode());
            List<T> nodelist = graph.get(nodeDistanceEntry.getNode());

            for (T node : nodelist) {
                if (!visited.contains(node)) {
                    traversalQueue.add(new NodeDistanceEntry(node, nodeDistanceEntry.getDistance() + 1));
                }
            }

        }
        nodeDistanceEntry.setDistance(-1);
        return nodeDistanceEntry;
    }

}
