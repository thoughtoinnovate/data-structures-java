package org.datastructures.graphs.dfs;

import org.datastructures.graphs.Graph;
import org.datastructures.graphs.GraphNode;

import java.util.Stack;

/**
 * Class representing depth first search operations on a graph.
 */
public class DFS {


    public static <T> void printDFSRecursion(GraphNode startNode) {

        System.out.println(String.valueOf(startNode.getNode()));

        if (null == startNode.getNeighbours() || startNode.getNeighbours().length == 0) {
            return;
        }

        for (GraphNode node : startNode.getNeighbours()) {
            printDFSRecursion(node);
        }

    }


    public static <T> String printDepthFirst(Graph graph, GraphNode<T> startNode) {

        Stack<GraphNode> nodeStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        if (null == startNode) {
            return null;
        }

        nodeStack.push(startNode);

        while (!nodeStack.isEmpty()) {

            GraphNode node = nodeStack.pop();
            result.append(String.valueOf(node.getNode()));
            result.append(",");


            if (null == node.getNeighbours() || 0 == node.getNeighbours().length) {
                continue;
            }

            for (GraphNode neighbour : node.getNeighbours()) {
                nodeStack.push(neighbour);
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
        GraphNode<Character> a = new GraphNode<>('a', new GraphNode[]{c, b});

        GraphNode<Character>[] graphNodes = new GraphNode[]{a, b, c, d, e, f};
        Graph<Character> graph = new Graph(graphNodes);

        System.out.println(printDepthFirst(graph, a));
        System.out.println("Printing using recursion");
        printDFSRecursion(a);

    }


}
