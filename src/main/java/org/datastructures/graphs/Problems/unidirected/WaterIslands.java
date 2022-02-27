package org.datastructures.graphs.Problems.unidirected;

import java.util.HashSet;
import java.util.Set;

public class WaterIslands {

    public static <T> int countIslands(T[][] grid, T excluionNode) {

        int count = 0;
        Set<String> traversedNodes = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (explore(grid, row, column, traversedNodes, excluionNode)) {
                    count++;
                }

            }
        }

        return count;
    }

    /**
     * Depth First Search
     *
     * @param grid
     * @param row
     * @param column
     * @param traversedNodes
     * @param exclusionIdentifier
     * @param <T>
     * @return
     */
    private static <T> boolean explore(T[][] grid, int row, int column, Set<String> traversedNodes, T exclusionIdentifier) {

        boolean rowInbounds = row >= 0 && row < grid.length;
        if (!rowInbounds) return false;
        boolean columnInbounds = column >= 0 && column < grid[row].length;
        if (!columnInbounds) return false;
        if (grid[row][column] == exclusionIdentifier) return false;

        String nodeAddress = row + "," + column;
        if (traversedNodes.contains(nodeAddress)) return false;

        //Add node
        traversedNodes.add(nodeAddress);

        explore(grid, row - 1, column, traversedNodes, exclusionIdentifier);
        explore(grid, row + 1, column, traversedNodes, exclusionIdentifier);
        explore(grid, row, column - 1, traversedNodes, exclusionIdentifier);
        explore(grid, row, column + 1, traversedNodes, exclusionIdentifier);

        return true;


    }
}
