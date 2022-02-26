package org.datastructures.graphs.bfs;

import org.datastructures.graphs.Graph;
import org.datastructures.graphs.GraphNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Breadth First Search
 */
public class BFS {

    public static String getBFS(GraphNode graphNode) {

        StringBuilder result = new StringBuilder();
        Queue<GraphNode> nodeQueue = new ArrayDeque<>();

        nodeQueue.add(graphNode);

        while (!nodeQueue.isEmpty()) {

            GraphNode node = nodeQueue.poll();
            result.append(String.valueOf(node.getNode()));
            result.append(",");

            if (null == node.getNeighbours() || 0 == node.getNeighbours().length) {
                continue;
            }

            for (GraphNode neighbour : node.getNeighbours()) {
                nodeQueue.add(neighbour);
            }

        }

        return result.toString();
    }

    public static void main(String[] args) {

        GraphNode<Character> e = new GraphNode<>('e', null);
        GraphNode<Character> f = new GraphNode<>('f', null);
        GraphNode<Character> d = new GraphNode<>('d', new GraphNode[]{f});
        GraphNode<Character> c = new GraphNode<>('c', new GraphNode[]{e});
        GraphNode<Character> b = new GraphNode<>('b', new GraphNode[]{d});
        GraphNode<Character> a = new GraphNode<>('a', new GraphNode[]{b, c});

        GraphNode<Character>[] graphNodes = new GraphNode[]{a, b, c, d, e, f};
        Graph<Character> graph = new Graph(graphNodes);

        System.out.println(getBFS(a));


    }

}
