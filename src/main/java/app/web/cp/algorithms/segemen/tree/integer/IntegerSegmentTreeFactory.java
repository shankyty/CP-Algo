package app.web.cp.algorithms.segemen.tree.integer;

import app.web.cp.algorithms.segemen.tree.AbstractSegmentTree;
import app.web.cp.algorithms.segemen.tree.traversal.LevelOrderTraversal;
import app.web.cp.algorithms.segemen.tree.traversal.PreOrderTraversal;

public class IntegerSegmentTreeFactory {

    public static IntegerSegmentTree getSumTree(){
        return new IntegerSegmentTree(Integer::sum,
                new PreOrderTraversal());
    }

    public static IntegerSegmentTree getMaxTree(){
        return new IntegerSegmentTree(Math::max,
                new PreOrderTraversal());
    }

    public static AbstractSegmentTree getMaxFreqTree(){
        return new AbstractSegmentTree<Pair<Integer, Integer>>(
                (a,b) -> {
                    if (a.getFirst() > b.getFirst()) {
                        return a;
                    }
                    if (b.getFirst() > a.getFirst()) {
                        return b;
                    }
                    return new Pair<>(a.getFirst(), a.getSecond() + b.getSecond());
                },
                new PreOrderTraversal()
        ) {
            @Override
            public Pair<Integer, Integer> query(int left, int right) {
                return null;
            }
        };
    }
}
