package app.web.cp.algorithms.segemen.tree;

import app.web.cp.algorithms.segemen.tree.traversal.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

abstract public class AbstractSegmentTree<T> {
    List<T> t;
    protected int n;
    protected final BinaryOperator<T> merge;
    protected final Traversal traversal;


    protected AbstractSegmentTree(BinaryOperator<T> merge,
                               Traversal traversal) {
        this.merge = merge;
        this.traversal = traversal;
    }

    public void build(List<T> a) {
        this.n = a.size();
        this.t = new ArrayList<>(traversal.total(n));
        _build(Collections.unmodifiableList(a),
                0,
                0,
                n - 1);
    }


    private void _build(List<T> a,
                        int v,
                        int tl,
                        int tr) {
        if (tl == tr) {
            t.set(v, a.get(tl));
        } else {
            int tm = tl + (tr - tl) / 2;
            _build(a,
                    traversal.left(v, tl, tr),
                    tl,
                    tm);
            _build(a,
                    traversal.right(v, tl, tr),
                    tm + 1,
                    tr);
            t.set(v, merge.apply(t.get(traversal.left(v, tl, tr)),
                    t.get(traversal.right(v, tl, tr))));
        }
    }

    public void update(int idx, T val) {
        _update(0,
                0,
                n - 1,
                idx,
                val);
    }

    private void _update(int v,
                         int tl,
                         int tr,
                         int pos,
                         T newVal) {
        if (tl == tr) {
            t.set(v, newVal);
        } else {
            int tm = tl + (tr - tl) / 2;
            if (pos <= tm) {
                _update(traversal.left(v, tl, tr),
                        tl,
                        tm,
                        pos,
                        newVal);
            } else {
                _update(traversal.right(v, tl, tr),
                        tm + 1,
                        tr,
                        pos,
                        newVal);
            }
            t.set(v, merge.apply(t.get(traversal.left(v, tl, tr)),
                    t.get(traversal.right(v, tl, tr))));
        }
    }

    public abstract T query(int left,
                            int right);
}
