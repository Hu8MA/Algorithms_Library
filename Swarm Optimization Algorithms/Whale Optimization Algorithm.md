# Whale Optimization Algorithm (WOA)

## Input

- **n**: Population size (number of whales, integer)
- **Max_iterations**: Maximum iterations (integer)
- **b**: Spiral shape constant (real, default = 1)
- **a**: Control parameter for exploration/exploitation (decreases linearly from 2 to 0)

## Output

- **X***: Best solution (real vector)
- f(X*): Best fitness value (real)

## Variables Definition

- **Xi**: Position vector of whale i (real vector)
- **X***: Current best position (real vector)
- **Xrand**: Random whale position (real vector)
- **A, C**: Coefficient vectors (real vectors)
- **p**: Probability threshold for spiral/encircling (real, ∈ [0,1])
- **l**: Random number ∈ [-1,1] (real)
- **f(X)**: Objective function to minimize

## Algorithm Steps

**Begin**

1. Initialize the whales population Xi (i = 1, 2, ..., n)
2. Calculate the fitness of each search agent
3. X* = the best search agent
4. **while** (t < maximum number of iterations)
5. **for** each search agent
6. Update a, A, C, l, and p
7. **if1** (p < 0.5)
8. **if2** (|A| < 1)
9. Update the position of the current search agent by:
   ```
   D = |C·X*(t) - X(t)|
   ```
10. **else if2** (|A| ≥ 1)
11. Select a random search agent (Xrand)
12. Update the position of the current search agent by:
    ```
    X(t+1) = Xrand - A·D
    ```
    **end if2**
13. **else if1** (p ≥ 0.5)
14. Update the position of the current search agent by:
    ```
    X(t+1) = D'·e^(b·l)·cos(2π·l) + X*(t)
    where D' = |X*(t) - X(t)|
    ```
    **end if1**
    
    **end for**
15. Check if any search agent goes beyond the search space and amend it
16. Calculate the fitness of each search agent
17. Update X* if there is a better solution
18. t = t + 1
19. **end while**
20. **return** X*

## Complexity Analysis

- **Initialization**: O(n·d) where d = dimensions
- **Main loop**:
  - **Per iteration**: O(n·d) for position updates and fitness evaluations
  - **Total**: O(Max_iterations · n · d)
- **Best/Worst case**: O(n·d·Max_iterations) - linear in population and iterations