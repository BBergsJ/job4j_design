package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
//        while (row < data.length) {
//            for (int i = column; i < data[row].length; i++) {
//                if (data[row][i] != 0) {
//                    column = i;
//                    return true;
//                }
//            }
//            row++;
//            column = 0;
//        }
//        return false;

//        while (row < data.length && column == data[row].length) {
//            row++;
//            column = 0;
//        }
//
//        if (row >= data.length) {
//            return false;
//        }
//
//        return data[row].length != 0;

        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }

        return data.length > row && data[row].length > column;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}