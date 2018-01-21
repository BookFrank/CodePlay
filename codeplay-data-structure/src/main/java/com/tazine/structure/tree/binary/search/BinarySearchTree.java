package com.tazine.structure.tree.binary.search;

import java.util.Comparator;

/**
 * BinarySearchTree
 *
 * @author frank
 * @since 1.0.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;
    private Comparator<? super T> cmp;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Comparator<? super T> cmp) {
        this.cmp = cmp;
        this.root = null;
    }

    public boolean contains (T x){
        return contains(x, root);
    }

    /**
     * Internal Method to find an item in an subtree
     * @param x is the item to search for
     * @param node the node that roots the subtree
     * @return true if the item is found; false otherwise.
     */
    private boolean contains (T x, BinaryNode<T> node){

        if (null == node){
            return false;
        }

        int compareResult = myCompare(x, node.element);
        if (compareResult < 0){
            return contains(x, node.left);
        }else if (compareResult > 0){
            return contains(x, node.right);
        }else {
            return true;
        }
    }

    private int myCompare(T x, T element) {
        if (cmp != null){
            return cmp.compare(x, element);
        }else {
            return ((Comparable) x).compareTo(element);
        }
    }
    
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
