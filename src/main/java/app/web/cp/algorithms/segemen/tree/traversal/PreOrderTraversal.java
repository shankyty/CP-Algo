package app.web.cp.algorithms.segemen.tree.traversal;

public class PreOrderTraversal implements Traversal {
    @Override
    public int left(int parent, int left, int right) {
        return  parent  + 1;
    }

    @Override
    public int right(int parent, int left, int right) {
        int mid = left + (right - left) /2;
        return parent + 2 * (mid - left + 1);
    }

    @Override
    public int total(int n) {
        return 2 * n;
    }
}
