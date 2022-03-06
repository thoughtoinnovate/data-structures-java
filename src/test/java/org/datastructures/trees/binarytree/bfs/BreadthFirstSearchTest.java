package org.datastructures.trees.binarytree.bfs;

import org.datastructures.trees.binarytree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BreadthFirstSearchTest {

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
        List<Character> result = List.of(new Character[]{'a', 'b', 'c', 'd', 'e', 'f'});
        List<Character> values = BreadthFirstSearch.getValues(binaryTree);
        System.out.println(values);
        boolean status = true;

        for (int i = 0; i < values.size(); i++) {

            if (result.get(i) != values.get(i)) {
                status = false;
            }

        }
        Assertions.assertTrue(status);
    }

    @Test
    void hasNode() {

        Assertions.assertTrue(BreadthFirstSearch.hasNode(binaryTree, 'e'));
        Assertions.assertFalse(BreadthFirstSearch.hasNode(binaryTree, 'z'));
    }
}