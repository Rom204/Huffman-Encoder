package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String testStr = "mission accomplished: the huffman tree is operational in the field";
        System.out.println("Original: " + testStr);

        HuffmanEncoder hfe = new HuffmanEncoder();
        String compressedText = hfe.compress(testStr);
        System.out.println("Compressed: " + compressedText);

        Map<Character, String> codes = hfe.getHuffmanTree().getCodes();
        System.out.println("\n--- Huffman Codes ---");
        codes.forEach((character, code) -> {
            // Tip: using ' ' for spaces makes it easier to read
            String displayChar = (character == ' ') ? "[space]" : character.toString();
            System.out.println(displayChar + ": " + code);
        });

        HuffmanTree ht = hfe.getHuffmanTree();
        String deCompressedText = ht.decompress(compressedText);
        System.out.println("Decompressed: " + deCompressedText);
    }
}
