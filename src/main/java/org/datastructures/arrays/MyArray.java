package org.datastructures.arrays;

import java.util.Arrays;

/**
 * Customized implementation of array data structure
 * This is not the optimized solution , it is just to demonstrate the working of the array data structures.
 */
public class MyArray<E> {

    private int size;
    private E[] data;

    public int getLength() {
        return this.data.length;
    }

    public MyArray(int size) {
        this.size = size;
        this.data = (E[]) new Object[size];
    }

    /**
     * O(1)
     * Access is constant time in case of arrays.
     *
     * @param index
     * @return int
     */
    public E getAt(int index) {
        return this.data[index];
    }

    /**
     * O(N)
     *
     * @param index
     * @param element
     */
    public void addAt(int index, E element) {

        E[] temp = (E[]) new Object[this.data.length + 1];

        //Copy elements before index
        for (int preIndx = 0; preIndx < index; preIndx++) {
            temp[preIndx] = this.data[preIndx];
        }

        //Shift elements to the right
        for (int indx = index; indx < this.data.length; indx++) {
            temp[indx + 1] = this.data[indx];
        }

        temp[index] = element;

        this.data = temp;

    }

    public void setAt(int index, E element) {
        this.data[index] = element;
    }


    /**
     * O(n)
     * Adds element at the end of the array.
     * To store new element , new structure has to be created and all existing elements has to be copied in the new array.
     *
     * @param item
     */
    public void add(E item) {

        E[] temp = (E[]) new Object[this.data.length + 1];

        // copy all elements of existing array into the new size array.
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }

        temp[this.data.length] = item;
        this.data = temp;
        this.size = temp.length;

    }

    /**
     * O(N)
     *
     * @param index
     */
    public void deleteAt(int index) {

        E[] temp = (E[]) new Object[this.data.length - 1];

        //shift elements to the left
        for (int indx = index; indx < this.data.length - 1; indx++) {
            temp[indx] = this.data[indx + 1];
        }

        this.data = temp;

    }

    @Override
    public String toString() {
        return "MyArray{" + "size=" + size + ", data=" + Arrays.toString(data) + '}';
    }
}
