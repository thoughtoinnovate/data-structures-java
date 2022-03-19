package org.datastructures.trees.binarytree.dfs;

import org.datastructures.trees.binarytree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepthFirstSearchTest {

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

        //Test iterative DFS
        List<Character> result = List.of(new Character[]{'a', 'b', 'd', 'e', 'c', 'f'});
        List<Character> values = DepthFirstSearch.getValues(binaryTree);

        boolean status = true;

        status = isSame(result, values);
        Assertions.assertTrue(status);

        //Recursion Test
        status = true;
        List<Character> valuesUsingRecursion = DepthFirstSearch.getValuesUsingRecursion(binaryTree);
        status = isSame(result, valuesUsingRecursion);
        Assertions.assertTrue(status);
    }

    private boolean isSame(List<Character> result, List<Character> values) {

        for (int i = 0; i < values.size(); i++) {

            if (result.get(i) != values.get(i)) {
                return false;
            }

        }
        return true;
    }

    @Test
    void hasNode() {
        Assertions.assertTrue(DepthFirstSearch.hasNode(binaryTree, 'e'));
        Assertions.assertFalse(DepthFirstSearch.hasNode(binaryTree, 'z'));
    }

    @Test
    void iterativeSum() {
        Integer result = DepthFirstSearch.iterativeSum(intTree);
        Assertions.assertTrue(26 == result);
    }

    @Test
    void recursiveSum() {
        Integer result = DepthFirstSearch.recursiveSum(intTree);
        Assertions.assertTrue(26 == result);
    }

    @Test
    void findMinIterative() {
        Integer minIterative = DepthFirstSearch.findMinIterative(intTree);
        Assertions.assertTrue(1 == minIterative);
    }

    @Test
    void findMinRecursive() {
        Integer minRecursive = DepthFirstSearch.findMinRecursive(intTree);
        Assertions.assertTrue(1 == minRecursive);
    }

    @Test
    void maxRootLeafSumPath() {

        //Integer tree here

        //leafs
        Node<Integer> _4 = new Node<>(4, null, null);
        Node<Integer> _2 = new Node<>(2, null, null);
        Node<Integer> _1 = new Node<>(1, null, null);

        //parents
        Node<Integer> _11 = new Node<>(11, _4, _2);
        Node<Integer> _3 = new Node<>(3, null, _1);

        //root
        intTree = new Node<>(5, _11, _3);

        Integer maxSum = DepthFirstSearch.maxRootLeafSumPath(intTree);
        Assertions.assertTrue(20 == maxSum);
        Assertions.assertTrue(Integer.MIN_VALUE == DepthFirstSearch.maxRootLeafSumPath(null));

    }

    @Test
    void maxRootLeafSumPathIterative() {

        //Integer tree here

        //leafs
        Node<Integer> _4 = new Node<>(4, null, null);
        Node<Integer> _2 = new Node<>(2, null, null);
        Node<Integer> _1 = new Node<>(1, null, null);

        //parents
        Node<Integer> _11 = new Node<>(11, _4, _2);
        Node<Integer> _3 = new Node<>(3, null, _1);

        //root
        intTree = new Node<>(5, _11, _3);

        Integer result = DepthFirstSearch.maxRootLeafSumPathIterative(intTree);
        Assertions.assertTrue(20 == result);

    }
}