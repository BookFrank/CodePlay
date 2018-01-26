package com.tazine.structure.tree.binary.search;

/**
 * SimpleBinTree
 *
 * @author frank
 * @since 1.0.0
 */
public class SimpBinSearchTree {

    private Node root;

    public boolean contains (int index){

        return false;
    }

    private boolean contains(int index, Node node){

        int data = node.data;

        if (node == null){
            return false;
        }

        if (index > data){
            return contains(index, node.right);
        } else if (index < data) {
            return contains(index, node.left);
        } else {
            return true;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this(data, null, null);
        }
    }
}
