package com.tazine.structure.map;

import java.util.Set;

/**
 * MyHashMap
 *
 * @author frank
 * @since 1.0.0
 */
public class MyHashMap<K, V> {

    private static final int INIT_CAPACITY = 16;

    private float loadFactor = 0.75f;

    private Set<Entry<K, V>> entrySet;

    private int currentNodes;

    /**
     * 元素数量达到 threhold 时需要扩容
     */
    private int threhold;


    private Node<K, V>[] slots;

    public static void main(String[] args) {
    }

    public boolean containsKey(K key) {
        return getNode(hash(key), key);
    }

    private boolean getNode(int hash, K key) {
        int index = (slots.length - 1) & hash;
        Node<K, V> head = slots[index];

        return false;
    }

    public void put(K k, V v) {
        // 组装数据
        int hash = hash(k);
        Entry<K, V> entry = new Entry<>(k, v);
        Node<K, V> node = new Node<>(hash, entry);

        // 计算槽数
        int index = hash & (slots.length - 1);
        // 取出链表头结点
        Node<K, V> head = slots[index];
        Node<K, V> tmpNode = head;
        while (null != tmpNode && (hash != tmpNode.getHash()) && !k.equals(tmpNode.getEntry().getKey())) {
            tmpNode = tmpNode.next();
        }
        tmpNode.setNext(node);
        currentNodes++;
    }

    private int hash(K k) {
        int h;
        return (h = k.hashCode()) & h >>> 16;
    }

}

class Node<K, V> {

    private int hash;
    private Entry<K, V> entry;
    private Node<K, V> next;

    public Node(int hash, Entry<K, V> entry) {
        this.hash = hash;
        this.entry = entry;
    }

    public Node(int hash, Entry<K, V> entry, Node<K, V> next) {
        this.hash = hash;
        this.entry = entry;
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public Entry<K, V> getEntry() {
        return entry;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public Node<K, V> next() {
        return next;
    }
}

class Entry<K, V> {
    private K key;
    private V v;

    public Entry(K key, V v) {
        this.key = key;
        this.v = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
