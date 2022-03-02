package org.datastructures.trees.binarytree.dfs;

import org.datastructures.trees.binarytree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Contains Binary Tree Operations implemented using Depth First Search.
 */
public class DepthFirstSearch {

    /***
     * Iterative way DFS.
     * @return
     */
    public static <T> List<T> getValues(Node<T> root) {

        if (null == root) {
            return null;
        }

        List<T> result = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {

            Node node = nodeStack.pop();
            result.add((T) node.getValue());
            //push right node
            if (null != node.getRight()) nodeStack.push(node.getRight());
            //push left
            if (null != node.getLeft()) nodeStack.push(node.getLeft());
        }


        return result;
    }

    /**
     * Get Binary Tree DFS Values using recursion
     *
     * @param root
     * @return
     */
    public static <T> List<T> getValuesUsingRecursion(Node<T> root) {

        if (null == root) return null;

        List<T> result = new ArrayList<>();
        result.add(root.getValue());
        List<T> left = getValuesUsingRecursion(root.getLeft());
        List<T> right = getValuesUsingRecursion(root.getRight());

        if (left != null && right != null) {
            left.addAll(right);
        } else {
            left = (null == left) ? right : left;
        }

        if (null != left) result.addAll(left);


        return result;

    }


}