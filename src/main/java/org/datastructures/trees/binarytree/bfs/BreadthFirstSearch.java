package org.datastructures.trees.binarytree.bfs;

import org.datastructures.trees.binarytree.Node;

import java.util.*;

/**
 * Binary Tree BFS traversal
 */
public class BreadthFirstSearch {

    /**
     * BFS traversal of the Binary Tree
     *
     * @param root
     * @param <T>
     * @return
     */
    public static <T> List<T> getValues(Node<T> root) {

        if (null == root) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();

        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {

            Node node = nodeQueue.poll();
            result.add((T) node.getValue());

            if (null != node.getLeft()) nodeQueue.add(node.getLeft());
            if (null != node.getRight()) nodeQueue.add(node.getRight());

        }
        return result;
    }

    public static <T> boolean hasNode(Node<T> root, T target) {

        if (null == root) {
            return false;
        }

        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();

            if (target.equals(currentNode.getValue())) {
                return true;
            }

            if (null != currentNode.getLeft()) {
                nodeQueue.add(currentNode.getLeft());
            }
            if (null != currentNode.getRight()) {
                nodeQueue.add(currentNode.getRight());
            }

        }
        return false;

    }

    public static Integer sumOfInt(Node<Integer> root) {

        if (root == null) {
            return 0;
        }

        Integer sum = 0;
        Queue<Node> nodeQueue = new ArrayDeque<>();

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();

            if (null != node.getValue()) sum = sum + (Integer) node.getValue();

            if (null != node.getLeft()) nodeQueue.add(node.getLeft());
            if (null != node.getRight()) nodeQueue.add(node.getRight());

        }

        return sum;

    }
}
