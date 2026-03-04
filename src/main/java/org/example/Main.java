package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        System.out.println("Original: " + userInput);

        HuffmanEncoder hfe = new HuffmanEncoder();
        String compressedText = hfe.compress(userInput);
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
