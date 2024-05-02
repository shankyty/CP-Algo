package app.web.cp.algorithms.segemen.tree.integer;

import app.web.cp.algorithms.segemen.tree.AbstractSegmentTree;
import app.web.cp.algorithms.segemen.tree.traversal.Traversal;

import java.util.function.BinaryOperator;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class IntegerSegmentTree extends AbstractSegmentTree<Integer> {

    protected IntegerSegmentTree(BinaryOperator<Integer> merge,
                                 Traversal traversal) {
        super(merge, traversal);
    }

    @Override
    public Integer query(int left, int right) {
        return _query(0,
                0,
                n - 1,
                left,
                right);
    }

    Integer _query(int v,
                   int tl,
                   int tr,
                   int l,
                   int r) {
        if (l > r)
            return null;
        if (l == tl && r == tr) {
            return t.get(v);
        }
        int tm = (tl + tr) / 2;
        return merge.apply(_query(v*2, tl, tm, l, min(r, tm)),
                _query(v*2+1, tm+1, tr, max(l, tm+1), r));
    }
}
