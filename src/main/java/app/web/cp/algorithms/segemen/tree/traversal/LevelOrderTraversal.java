package app.web.cp.algorithms.segemen.tree.traversal;

public class LevelOrderTraversal implements Traversal {
    @Override
    public int left(int parent, int left, int right) {
        return 2 * parent;
    }

    @Override
    public int right(int parent, int left, int right) {
        return 2 * parent + 1;
    }

    @Override
    public int total(int n) {
        return 4 * n;
    }
}
