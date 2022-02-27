package org.datastructures.graphs.Problems.unidirected;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterIslandsTest {

    @Test
    void countIslands() {
        Character[][] waterIslands = new Character[][]{
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };

        int countIslands = WaterIslands.countIslands(waterIslands, 'W');
        Assertions.assertTrue(3 == countIslands);

        Character[][] waterIslandsSecond = new Character[][]{
                {'W', 'L', 'W', 'L', 'W'},
                {'L', 'L', 'W', 'L', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'L', 'W', 'L', 'W'},
                {'W', 'W', 'W', 'W', 'W'}
        };

        int countIslandsTwo = WaterIslands.countIslands(waterIslandsSecond, 'W');
        Assertions.assertTrue(4 == countIslandsTwo);

    }

    @Test
    void getSmallestIslandsSize() {

        Character[][] islandsInWater = new Character[][]{
                {'W', 'L', 'W', 'W', 'L','W'},
                {'L', 'L', 'W', 'W', 'L','W'},
                {'W', 'L', 'W', 'W', 'W','W'},
                {'W', 'W', 'W', 'L', 'L','W'},
                {'W', 'W', 'W', 'L', 'L','W'},
                {'W', 'W', 'W', 'L', 'W','W'}
        };

        int islandsSize = WaterIslands.getSmallestIslandsSize(islandsInWater, 'W');
        System.out.println(islandsSize);
        Assertions.assertTrue(2== islandsSize);
    }
}