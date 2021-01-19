package edu.york;

import java.util.List;

public class Problem {
    SearchNode initialState;
    SearchNode goalState;
    String[] actions = {"left", "right", "up", "down"};
    int[][] grid;

    public Problem(SearchNode initialState, SearchNode goalState, int[][] grid) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.grid = grid;
    }
}
