package org.example;

public class Node implements Comparable<Node>{
    private int frequency;
    private char character;
    private Node left;
    private Node right;


    // for a new internal node
    public Node(int frequency, Node left, Node right){
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    // for a new leaf node
    public Node(char character, int frequency){
        this.frequency = frequency;
        this.character = character;

    }

    // check if current node is a leaf of a combination of internal nodes
    // a node is a leaf iff both its children are null
    public boolean isLeaf(){
        return (this.left == null) && (this.right == null);
    }

    @Override
    public int compareTo(Node otherNode) {
        return Integer.compare(this.frequency, otherNode.frequency);
    }

    // getters

    public int getFrequency(){
        return this.frequency;
    }

    public char getCharacter(){
        return this.character;
    }
    public Node getLeft(){ return this.left;}
    public Node getRight(){ return this.right;}
}
