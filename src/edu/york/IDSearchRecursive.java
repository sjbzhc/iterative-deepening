package edu.york;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IDSearchRecursive {

    public Optional<Solution> iterativeDeepening(int[][] grid, int limit) {
        Problem problem = initProblem(grid);
        return depthLimitedSearch(problem.initialState, problem, limit);
    }

    public Optional<Solution> depthLimitedSearch(SearchNode node, Problem problem, int limit) {
        List<SearchNode> frontier = new ArrayList<>();
        List<SearchNode> explored = new ArrayList<>();
        boolean cutoff = false;

        if (problem.goalState == node) return Optional.of(Solution.of(node));

        else if (limit == 0) return Optional.of(Solution.cutoff(false));

        else {
            boolean cutoffOccurred = false;
            for (SearchNode child : node.neighbours()) {
                Optional<Solution> result = depthLimitedSearch(child, problem, limit - 1);
                if (result.isPresent() && result.get().cutoff) cutoffOccurred = true;
                else if (result.isPresent() && !result.get().error) return result;
            }
            if (cutoffOccurred) return Optional.of(Solution.cutoff(false));
            else return Optional.of(Solution.cutoff(true));
        }
    }

    private Problem initProblem(int[][] grid) {
        SearchNode initialNode = SearchNode.empty();
        SearchNode goalNode = SearchNode.empty();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) initialNode = new SearchNode(i, j, 0);
                if (grid[i][j] == 3) goalNode = new SearchNode(i, j, 0);
            }
        }
        return new Problem(initialNode, goalNode, grid);
    }

    public static void main(String[] args) {
        // write your code here
        int[][] grid1 = new int [][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

//        IDSearchRecursive idSearchRecursive = new IDSearchRecursive();
//
//        Optional<Solution> solution = idSearchRecursive.iterativeDeepening(grid1, 11);
//
//        System.out.println(solution.get());

        SearchNode s1 = new SearchNode(1,1, 0);
        SearchNode s2 = new SearchNode(1,1, 1);

        List<SearchNode> list = List.of(s1);

        System.out.println(list.contains(s2));

    }
}
