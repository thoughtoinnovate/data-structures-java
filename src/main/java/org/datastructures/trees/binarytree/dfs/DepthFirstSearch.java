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

    public static <T> boolean hasNode(Node<T> root, T target) {

        if (null == root) {
            return false;
        }

        if (target.equals(root.getValue())) {
            return true;
        }

        return hasNode(root.getRight(), target) || hasNode(root.getLeft(), target);

    }

    public static Integer iterativeSum(Node<Integer> root) {

        if (null == root) return 0;

        Integer sum = 0;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {

            Node node = nodeStack.pop();
            if (null != node.getValue()) sum = sum + (Integer) node.getValue();
            if (null != node.getRight()) nodeStack.push(node.getRight());
            if (null != node.getLeft()) nodeStack.push(node.getLeft());

        }
        return sum;
    }

    public static Integer recursiveSum(Node<Integer> root) {

        if (null == root) {
            return 0;
        }


        return root.getValue() + recursiveSum(root.getLeft()) + recursiveSum(root.getRight());

    }

    public static Integer findMinIterative(Node<Integer> root) {

        if (root == null) {
            return null;
        }

        Integer min = Integer.MAX_VALUE;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {

            Node node = nodeStack.pop();

            if (null != node.getValue() && ((Integer) node.getValue()) < min) {
                min = (Integer) node.getValue();
            }

            if (null != node.getRight()) nodeStack.push(node.getRight());
            if (null != node.getLeft()) nodeStack.push(node.getLeft());
        }

        return min;

    }

    public static Integer findMinRecursive(Node<Integer> root) {

        if (null == root) {
            return Integer.MAX_VALUE;
        }

        Integer right = findMinRecursive(root.getRight());
        Integer left = findMinRecursive(root.getLeft());

        return right < left ? Math.min(right, root.getValue()) : Math.min(left, root.getValue());
    }

    /**
     * Returns maximum sum of a path from root to leaf nodes.
     *
     * @return
     */
    public static Integer maxRootLeafSumPath(Node<Integer> root) {

        //base case for null node
        if (null == root) return Integer.MIN_VALUE;

        //reached the leaf node
        if (null == root.getLeft() && null == root.getRight()) {
            return root.getValue();
        }

        //Recursive call until leaf node is reached
        int max = Math.max(maxRootLeafSumPath(root.getRight()), maxRootLeafSumPath(root.getLeft()));

        return max + root.getValue();
    }


}
