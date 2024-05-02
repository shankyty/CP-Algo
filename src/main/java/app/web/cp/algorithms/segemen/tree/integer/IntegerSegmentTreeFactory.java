package app.web.cp.algorithms.segemen.tree.integer;

import app.web.cp.algorithms.segemen.tree.traversal.LevelOrderTraversal;

public class IntegerSegmentTreeFactory {

    public static IntegerSegmentTree getSumTree(){
        return new IntegerSegmentTree(Integer::sum,
                new LevelOrderTraversal());
    }

    public static IntegerSegmentTree getMaxTree(){
        return new IntegerSegmentTree(Math::max,
                new LevelOrderTraversal());
    }
}
