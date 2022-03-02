package org.datastructures.trees.binarytree;

/**
 * Represents Binary Tree Node
 */
public class Node<T> {
    private T value;
    private Node left;
    private Node right;

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}