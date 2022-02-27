package org.datastructures.graphs.Problems.componentcount;

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
}
