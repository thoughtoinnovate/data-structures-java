package org.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayTest {

    @Test
    void add() {
        MyArray<Integer> myArray = new MyArray<>(0);
        assertEquals(0, myArray.getLength());
        myArray.add(1);
        myArray.add(2);

        assertEquals(2, myArray.getLength());
    }

    @Test
    void getAt() {
        MyArray<Integer> myArray = new MyArray<>(2);
        myArray.setAt(1, 23);

        assertEquals(23, myArray.getAt(1));

    }

    @Test
    void addAt() {

        MyArray<Integer> myArray = new MyArray<>(2);
        myArray.setAt(0, 1);
        myArray.setAt(1, 2);
        myArray.addAt(1, 5);
        assertEquals(5, myArray.getAt(1));
        assertEquals(2, myArray.getAt(2));

    }

    @Test
    void deleteAt() {
        MyArray<Integer> myArray = new MyArray(4);
        myArray.setAt(0, 0);
        myArray.setAt(1, 1);
        myArray.setAt(2, 2);
        myArray.setAt(3, 3);

        myArray.deleteAt(2);

        assertEquals(3, myArray.getLength());
        assertEquals(3, myArray.getAt(2));
    }
}