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
}
