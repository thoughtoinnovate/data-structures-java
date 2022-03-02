package org.datastructures.trees.binarytree.dfs;

import org.datastructures.trees.binarytree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepthFirstSearchTest {

    private Node<Character> binaryTree;

    @BeforeEach
    void setUp() {
        //leaf nodes
        Node<Character> d = new Node<>('d', null, null);
        Node<Character> e = new Node<>('e', null, null);
        Node<Character> f = new Node<>('f', null, null);

        //set parents
        Node<Character> b = new Node<>('b', d, e);
        Node<Character> c = new Node<>('c', null, f);

        //set root node
        binaryTree = new Node<>('a', b, c);
    }

    @Test
    void getValues() {

        //Test iterative DFS
        List<Character> result = List.of(new Character[]{'a', 'b', 'd', 'e', 'c', 'f'});
        List<Character> values = DepthFirstSearch.getValues(binaryTree);
        Assertions.assertTrue(result.containsAll(values));

        //Recursion Test
        List<Character> valuesUsingRecursion = DepthFirstSearch.getValuesUsingRecursion(binaryTree);
        Assertions.assertTrue(result.containsAll(valuesUsingRecursion));
    }
}