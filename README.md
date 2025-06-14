# Algorithms_Library
Welcome to the Algorithms_Library repository! This library is a comprehensive collection of algorithms across various domains, meticulously implemented in Java. Each algorithm is designed to be flexible, modifiable, and educational, making it an excellent resource for students, developers, and researchers alike. Below is a detailed breakdown of the algorithms included in this repository:

## 1. Swarm Optimization Algorithms
Bio-inspired algorithms that mimic the collective intelligence found in nature for solving complex optimization problems.

- **Whale Optimization Algorithm (WOA)**: Optimization technique mimicking humpback whale hunting behavior through bubble-net feeding. Features three phases: encircling prey (exploitation), bubble-net attacking (exploitation via spiral movement), and search for prey (exploration). Uses probability threshold to switch between spiral movement and encircling behavior. Has O(n·d·Max_iterations) linear complexity.

- **Bat Swarm Algorithm**: Optimization technique mimicking bat echolocation behavior with frequency tuning, position updates, and loudness/pulse rate adjustments. Features O(n²) worst-case complexity.

- **Ant Colony Optimization**: Simulates ant foraging behavior using pheromone trails for solution construction. Ants probabilistically build paths and deposit pheromones to guide future iterations. Has O(NC·n³) worst-case complexity.

- **Artificial Bee Colony**: Models honey bee foraging through employed, onlooker, and scout bees. Bees share information about food sources (solutions), intensify promising regions, and abandon depleted sources. Features O(MCN·D²) worst-case complexity.

- **Cuckoo Search via Lévy Flights**: Inspired by cuckoo breeding behavior, this algorithm uses Lévy flights for exploration, abandons worst nests, and employs elitism to retain best solutions. Has O(T·(N·d + N log N)) complexity.

## 2. DB & Search & Sort
### 2.1 Data Structures with Operations
This section includes fundamental data structures and their associated operations, which are the building blocks of many algorithms.
- **Array**: Basic array operations and manipulations.
- **Binary Tree**: Implementation of binary trees with standard operations.
- **Doubly Linked List**: Operations on doubly linked lists.
- **Singly Linked List**: Operations on singly linked lists.
- **Queue (Array-based)**: Queue operations using arrays.
- **Queue (Linked List-based)**: Queue operations using linked lists.
- **Stack (Array-based)**: Stack operations using arrays.
- **Stack (Linked List-based)**: Stack operations using linked lists.

### 2.2 Search and Sort
Algorithms for searching and sorting, fundamental for efficient data processing.
- **Binary Tree Search**: Efficient searching within a binary tree.
- **Bubble Sort**: Classic sorting algorithm for small datasets.
- **Insertion Sort**: Simple and efficient for small or partially sorted datasets.
- **Linear Search**: Basic search technique for unsorted datasets.
- **Selection Sort**: Another simple sorting algorithm for educational purposes.

## 3. Information Security (Encryption)
This section focuses on encryption algorithms, crucial for information security.
- **Affine Cipher**: A type of monoalphabetic substitution cipher.
- **Caesar Algorithm**: A well-known substitution cipher.
- **Decimation**: An encryption algorithm using mathematical decimation.
- **Geometric Patterns**: Using geometric patterns for encryption.
- **Hill Cipher**: A polygraphic substitution cipher.
- **Playfair Cipher**: A digraph substitution cipher.
- **Vigenère Cipher**: A method of encrypting alphabetic text using a simple form of polyalphabetic substitution.

## 4. Managing Processes in Memory
### 4.1 Deadlock Management
Algorithms to detect and handle deadlocks in system processes.
- **Deadlock Detection**: Identifying deadlocks in a system.
- **Resource Request Safety**: Ensuring resource requests do not lead to deadlocks.
- **Safe State**: Maintaining a system in a safe state to avoid deadlocks.

### 4.2 Memory Management
Techniques for efficient memory allocation.
- **Best Fit**: Allocating the smallest sufficient memory block.
- **First Fit**: Allocating the first sufficient memory block.
- **Next Fit**: Allocating the next sufficient memory block after the last allocated block.

## 5. Operations Management in the System
Scheduling algorithms to manage processes in an operating system.
- **First-Come, First-Served (FCFS)**: Scheduling processes in the order they arrive.
- **Priority Scheduling**: Scheduling processes based on priority.
- **Round Robin (RR)**: Time-sharing scheduling algorithm.
- **Shortest Job First (SJF)**: Scheduling the shortest processes first.

## 6. Solving Big Problems
Algorithms for tackling complex problems.
- **Back Propagation**: A key algorithm for training neural networks.
- **Knapsack Problem**: A dynamic programming solution to the classic optimization problem.
 
## Contributions
I welcome contributions to this repository and aim to develop it into a scientific resource for researchers and specialists in developing algorithms in Java 🥇 and C# 💡.
