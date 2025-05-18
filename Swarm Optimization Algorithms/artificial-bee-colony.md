# Artificial Bee Colony (ABC) Algorithm

Models honey bee foraging with employed, onlooker, and scout bees. Bees share information about food sources, intensify promising regions, and abandon depleted ones.

## Input:

- MCN % _Maximum Cycle Number_

## Output:

- best*solution % \_Best food source position found*

## Variables Definition:

- SN : number of food sources % _integer variable_
- D : problem dimension % _integer variable_
- xi,j : food source position % _real variable_
- vi,j : new food source position % _real variable_
- fiti : fitness value % _real variable_
- Pi : probability value % _real variable_
- limit : abandonment limit % _integer variable_
- trial : counter for abandonment % _integer variable_

## Algorithm:

**Begin**

1. Initialize the population of solutions xi,j
2. Evaluate the population
3. cycle = 1
4. repeat
5. Produce new solutions vi,j in neighborhood of xi,j for employed bees using vi,j = xi,j + Φi,j(xi,j - xk,j) where k is a neighbor of i and Φ is random in [-1,1]
6. Apply greedy selection between xi and vi
7. Calculate probability values Pi for solutions xi based on fitness values using:

   ![Probability Formula](https://drive.google.com/thumbnail?id=1vmq38cYDvDd0eAxZgedfDP_KOf5kJVjy&sz=w2000)

   In order to calculate the fitness values of solutions

   ![Fitness Formula](https://drive.google.com/thumbnail?id=11bVF5M4Enf7fO5h8gZ0xLTFAi1iV9LbA&sz=w2000)

   Normalize Pi values into [0,1]

8. Produce new solutions vi for onlookers from solutions xi selected based on Pi
9. Apply greedy selection for onlookers between xi and vi
10. Determine abandoned solutions and replace with new random solutions:

    xij = minj + rand(0,1) \* (maxj - minj)

11. Memorize the best food source position achieved so far
12. cycle = cycle + 1
13. until cycle = MCN

**End Algorithm.**

## Time Complexity Analysis of ABC Algorithm

### 1. Initialization Phase

- Generate SN solutions (food sources) with D dimensions each.
- **Complexity**: O(SN⋅D).

### 2. Employed Bee Phase

- For each of SN bees:
  - Generate a new solution vi (O(D) operations per bee).
  - Greedy selection (O(1) per bee).
- **Total**: O(SN⋅D).

### 3. Onlooker Bee Phase

- Calculate probabilities Pi (O(SN)).
- For SN onlookers:
  - Probabilistically select a solution (O(SN) with roulette wheel).
  - Generate vi and greedy selection (O(D)).
- **Total**: O(SN⋅D+SN²).

### 4. Scout Bee Phase

- Check abandonment for SN solutions (O(SN)).
- Replace abandoned solutions (O(D) per replacement).
- **Worst case**: O(SN⋅D) (if all solutions are abandoned).

### 5. Per-Cycle Complexity

- Dominated by **Onlooker Phase**: O(SN⋅D+SN²).
- If SN∝D (typical for large problems), simplifies to O(D²).

### 6. Overall Complexity for MCN Cycles

- **Worst case**: O(MCN⋅D²).
- **Best case**: O(MCN⋅D) (if onlooker selection is optimized).
