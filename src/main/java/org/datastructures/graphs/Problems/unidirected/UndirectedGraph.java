package org.datastructures.graphs.Problems.unidirected;

import java.util.*;

/**
 * Undirected graph
 */
public class UndirectedGraph {

    public static <T> Map<T, List<T>> buildUndirectedGraph(T[][] edges) {

        if (null == edges || 0 == edges.length) {
            return null;
        }

        Map<T, List<T>> graph = new HashMap<>();

        for (T[] edge : edges) {

            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;

    }

    public static <T> boolean hasPath(T[][] edges, T source, T destination) {

        if (source == destination) {
            return true;
        }

        Map<T, List<T>> graph = buildUndirectedGraph(edges);
        System.out.println(graph);

        return hasPath(graph, source, destination, new HashSet<T>());

    }

    private static <T> boolean hasPath(Map<T, List<T>> graph, T source, T destination, Set<T> visited) {

        if (source == destination) {
            return true;
        }

        if (!graph.containsKey(source) || visited.contains(source)) {
            return false;
        }

        visited.add(source);

        for (T neighbour : graph.get(source)) {
            if (hasPath(graph, neighbour, destination, visited)) {
                return true;
            }
        }

        return false;

    }
}
