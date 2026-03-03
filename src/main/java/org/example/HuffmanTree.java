package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    Node root;
    PriorityQueue<Node> pq = new PriorityQueue<>();

    // create a new pq with a given set of chars and their freq's.
    public HuffmanTree(Map<Character, Integer> map){
        map.forEach(((character, frequency) -> {
            Node newNode = new Node(character, frequency);
            pq.add(newNode);
        }));

        this.mergeNodes();
    }

    public void mergeNodes(){
        while(pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(left.getFrequency() + right.getFrequency(), left, right);
            pq.add(newNode);
        }
        // extract the last node left in the pq
        this.root = pq.poll();
    }

    private void generateCodes(Node node, String currentCode, Map<Character, String> huffmanCodes) {
        if(node == null){ return; }
        if(node.isLeaf()){
            huffmanCodes.put(node.getCharacter(), currentCode);
        } else {
            generateCodes(node.getLeft(), currentCode + "0", huffmanCodes);
            generateCodes(node.getRight(), currentCode + "1", huffmanCodes);
        }
    }

    public Map<Character, String> getCodes(){
        Map<Character, String> huffmanCodes = new HashMap<>();

        if(root != null && root.isLeaf()){
            huffmanCodes.put(root.getCharacter(), "0");
        } else {
            this.generateCodes(root, "", huffmanCodes);
        }

        return huffmanCodes;
    }

    public String decompress(String encodedText){
        StringBuilder decodedText = new StringBuilder();

        if (root != null && root.isLeaf()){
            for(int i = 0; i < encodedText.length(); i++){
                decodedText.append(root.getCharacter());
            }
            return decodedText.toString();
        }

        Node current = root;
        for (int i = 0; i < encodedText.length(); i++) {
            if (encodedText.charAt(i) == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isLeaf()) {
                decodedText.append(current.getCharacter());
                current = root;
            }
        }
        return decodedText.toString();
    }

}
