package app.web.cp.algorithms.segemen.tree;

public interface Traversal {
    int left(int parent, int left, int right);
    int right(int parent, int left, int right);
    int total(int n);
}
