package app.web.cp.algorithms.runner;

import app.web.cp.algorithms.segemen.tree.integer.IntegerSegmentTreeFactory;

public class Main {
    public static void main(String[] args) {
        IntegerSegmentTreeFactory.getSumTree();
        IntegerSegmentTreeFactory.getMaxTree();
        System.out.println("Hello world!");
    }
}