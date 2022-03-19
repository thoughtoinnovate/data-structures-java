package org.datastructures.trees.binarytree.bfs;

import org.datastructures.trees.binarytree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BreadthFirstSearchTest {

    private Node<Character> binaryTree;
    private Node<Integer> intTree;

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

        //Integer tree here

        //leafs
        Node<Integer> _4 = new Node<>(4, null, null);
        Node<Integer> _2 = new Node<>(2, null, null);
        Node<Integer> _1 = new Node<>(1, null, null);

        //parents
        Node<Integer> _11 = new Node<>(11, _4, _2);
        Node<Integer> _5 = new Node<>(5, null, _1);

        //root
        intTree = new Node<>(3, _11, _5);


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

    @Test
    void sumOfInt() {
        Assertions.assertTrue(26 == BreadthFirstSearch.sumOfInt(intTree));
    }

    @Test
    void findMin() {
        Integer min = BreadthFirstSearch.findMin(intTree);
        Assertions.assertTrue(min.equals(1));
    }
}