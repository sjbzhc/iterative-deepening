package edu.york;

public class Solution {
    boolean cutoff = false;
    boolean error = false;

    public Solution() {}

    public Solution(boolean cutoff, boolean error) {
        this.cutoff = cutoff;
        this.error = error;
    }

    public static Solution of(SearchNode node) {
        System.out.println("Here");
        return new Solution();
    }

    public static Solution cutoff(boolean error) {
        return new Solution(true, error);
    }


}
