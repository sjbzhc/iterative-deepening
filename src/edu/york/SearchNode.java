package edu.york;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchNode {
    int x;
    int y;
    int depth;

    public SearchNode(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public static SearchNode empty() {
        return new SearchNode(0,0,0);
    }

    public List<SearchNode> neighbours() {
        List<SearchNode> neighbors = new ArrayList<>();
        if (x - 1 >= 0) neighbors.add(new SearchNode(x-1, y, depth +1));
        if (x + 1 <= 12) neighbors.add(new SearchNode(x+1, y, depth +1));
        if (y - 1 >= 0) neighbors.add(new SearchNode(x, y-1, depth +1));
        if (y + 1 <= 12) neighbors.add(new SearchNode(x, y+1, depth +1));
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchNode that = (SearchNode) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + depth + ")";
    }
}
