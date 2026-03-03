# Huffman Compression Engine

A Java-based implementation of the Huffman Coding algorithm, a greedy approach used for lossless data compression. This project demonstrates proficiency in data structures (Trees, Priority Queues, HashMaps) and algorithmic complexity.

## 🚀 Overview
This engine analyzes character frequencies in a given text to build an optimal prefix-free binary tree. Characters that appear more frequently are assigned shorter binary codes, while rare characters receive longer codes, significantly reducing the overall footprint of the data.

### Key Features:
* **Frequency Analysis:** $O(N)$ frequency mapping using `HashMap`.
* **Greedy Tree Construction:** $O(N \log N)$ tree building using a `PriorityQueue`.
* **Recursive Code Generation:** Depth-First Search (DFS) traversal to generate bit-tables.
* **Efficient Encoding/Decoding:** Pointer-based tree traversal for $O(N)$ decompression.
* **Edge Case Handling:** Robust support for single-unique-character strings.

---

## 🏗️ Architecture & Logic

### 1. Frequency Mapping
The input string is scanned to determine the weight of each character.
### 2. The Huffman Tree
Using a min-heap (Priority Queue), we repeatedly merge the two nodes with the lowest frequencies. This ensures that the most frequent characters remain closest to the root, resulting in shorter bit-paths.



### 3. Bit-Table Generation
A recursive DFS traversal assigns a `0` for every left turn and a `1` for every right turn. The resulting codes satisfy the **Prefix Property**, meaning no code is a prefix of another, allowing for unambiguous decoding without delimiters.

---

## 📊 Performance Analysis
* **Building the Tree:** $O(n \log n)$, where $n$ is the number of unique characters (alphabet size).
* **Encoding/Decoding:** $O(N)$, where $N$ is the length of the message.
* **Space Complexity:** $O(n)$ to store the tree and the bit-mapping.

---

## 🛠️ How to Run
1. Ensure you have **Maven** and **JDK 17+** installed.
2. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/huffman-java.git](https://github.com/your-username/huffman-java.git)