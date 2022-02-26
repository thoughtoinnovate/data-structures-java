package org.datastructures.graphs.dfs;

import org.datastructures.graphs.GraphNode;

import java.util.Stack;

/**
 * Class representing depth first search operations on a graph.
 */
public class BFS {


    public static <T> void printDFSRecursion(GraphNode startNode) {

        System.out.println(String.valueOf(startNode.getNode()));

        if (null == startNode.getNeighbours() || startNode.getNeighbours().length == 0) {
            return;
        }

        for (GraphNode node : startNode.getNeighbours()) {
            printDFSRecursion(node);
        }

    }


    public static <T> String printDepthFirst(GraphNode<T> startNode) {

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

    /**
     * Detects if there is a path between two nodes.
     *
     * @param source
     * @param destination
     * @return
     */
    public static boolean haspath(GraphNode source, GraphNode destination) {

        if (source.getNode().equals(destination.getNode())) {
            return true;
        }

        if (null == source.getNeighbours() || 0 == source.getNeighbours().length) {
            return false;
        }

        for (GraphNode neighbour : source.getNeighbours()) {

            if (haspath(neighbour, destination)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        GraphNode<Character> e = new GraphNode<>('e', null);
        GraphNode<Character> f = new GraphNode<>('f', null);
        GraphNode<Character> d = new GraphNode<>('d', new GraphNode[]{f});
        GraphNode<Character> c = new GraphNode<>('c', new GraphNode[]{e});
        GraphNode<Character> b = new GraphNode<>('b', new GraphNode[]{d});
        GraphNode<Character> a = new GraphNode<>('a', new GraphNode[]{c, b});


        System.out.println(printDepthFirst(a));
        System.out.println("Printing using recursion");
        printDFSRecursion(a);

    }


}
