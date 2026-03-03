package org.example;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    private HuffmanTree ht;

    // compress text into bit-string
    public String compress (String text){
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            char current = text.charAt(i);
            int currentValue = charFrequencies.getOrDefault(current, 0);
            charFrequencies.put(current, currentValue + 1);
        }

        HuffmanTree ht = new HuffmanTree(charFrequencies);
        this.ht = ht;
        Map<Character, String> codes = ht.getCodes();
        StringBuilder encodedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            encodedText.append(codes.get(c));
        }

        return encodedText.toString();
    }

    public HuffmanTree getHuffmanTree(){
        return this.ht;
    }
}
