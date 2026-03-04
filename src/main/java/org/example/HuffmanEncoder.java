package org.example;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    private HuffmanTree ht;

    // compress text into bit-string
    public String compress (String text){
        Map<Character, Integer> charFrequencies = buildFrequenciesMap(text);
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

    public Map<Character, Integer> buildFrequenciesMap(String text){
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (char c : text.toCharArray()){
            int currentValue = charFrequencies.getOrDefault(c, 0);
            charFrequencies.put(c, currentValue + 1);
        }
        return charFrequencies;
    }
    public HuffmanTree getHuffmanTree(){
        return this.ht;
    }
}
