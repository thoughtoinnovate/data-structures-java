package org.datastructures.graphs.Problems.unidirected.componentcount;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComponentCount {

    public static <T> int componentCount(Map<T, List<T>> graph) {

        int count = 0;
        Set<T> visited = new HashSet<>();

        //Traverse every node
        for (Map.Entry<T, List<T>> node : graph.entrySet()) {

            if (explore(graph, node.getKey(), visited)) {
                count += 1;
            }
        }
        return count;

    }

    private static <T> boolean explore(Map<T, List<T>> graph, T node, Set<T> visited) {

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (T neighbour : graph.get(node)) {
            explore(graph, neighbour, visited);
        }

        return true;
    }

    public static <T> int longestComponent(Map<T, List<T>> graph) {

        Set<T> visited = new HashSet<>();
        int longest = 0;

        for (Map.Entry<T, List<T>> node : graph.entrySet()) {
            int countNodes = countNodes(graph, node.getKey(), visited);

            if (longest < countNodes) {
                longest = countNodes;
            }
        }

        return longest;

    }


    private static <T> int countNodes(Map<T, List<T>> graph, T node, Set<T> visited) {

        if (visited.contains(node)) {
            return 0;
        }

        visited.add(node);
        int count = 1;

        for (T neighbour : graph.get(node)) {
            count += countNodes(graph, neighbour, visited);
        }

        return count;
    }
}
