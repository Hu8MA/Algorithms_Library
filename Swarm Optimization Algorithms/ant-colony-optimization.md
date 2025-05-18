# Ant Colony Optimization Algorithm
 Simulates ant foraging behavior using pheromone trails. Ants probabilistically construct solutions, depositing pheromones on good paths to influence future iterations toward optimal solutions.
## Input:
- n  % *integer variable (number of towns)*
- m % *integer variable (number of ants)*
- τij(0) % *real variable (initial pheromone values)*
- α, β % *real variables (parameters for probability calculation)*
- ρ % *real variable (pheromone evaporation coefficient)*
- NCMAX % *integer variable (maximum cycle count)*

## Output:
- shortest_tour % *path representing optimal solution*
- shortest_tour_length % *real variable (length of best tour)*

## Variables Definition:
- t % *integer, time counter*
- NC % *integer, cycles counter*
- τij % *real, pheromone intensity on edge (i,j)*
- Δτij % *real, change in pheromone on edge (i,j)*
- tabuk % *list, stores visited towns for kth ant*
- s % *integer, tabu list index*

## Algorithm:

**Begin**

1. Initialize:
   - Set t := 0
   - Set NC := 0
   - For every edge (i,j) set initial value τij(0) := c for trail intensity and Δτij := 0
   - Place the m ants on the n nodes

2. Set s = 1
   - For k = 1 to m do
     - Place the starting town of the kth ant in tabuk(s)

*Repeat until tabu list is full (this step will be repeated (n−1) times)*   
3. While (s <= N-1>):
      - Set s = s + 1
      - For k = 1 to m do
        - Choose the town j to move to, with probability pk(j)
        - Insert town j in tabuk(s)

    4. For k= 1 to m do
      - Move the kth ant from tabuk(n) to tabuk(1)
      - Compute the length Lk of the tour described by the kth ant
      - Update the shortest tour found
      - For every edge (i,j) compute:
        - Δτij^k = { Q/L^k if (i,j) ∈ tour described by tabuk, 0 otherwise }

    5. For every edge (i,j) compute τij(t + n) according to equation τij(t + n) = ρ · τij(t)+Δτij
      - Set t = t + n
      - Set NC = NC + 1
      - For every edge (i,j) set Δτij := 0

    6. If (NC < NC_MAX) and (not stagnation behavior) then
      - Empty all tabu lists
      - Goto step 2
      else
      - Print shortest tour
      - Stop

**End Algorithm.**

## Step-by-Step Complexity Analysis of the Ant System (AS) Algorithm

### Assumption: 
The number of ants m scales linearly with the number of cities n (i.e., m = O(n)).

### Step 1: Initialize
- Initialize pheromone trails for all O(n²) edges.
- Place m = O(n) ants on n cities.
  Complexity: O(n² + n) = O(n²).

### Step 2: Set Starting Towns
- Assign a starting town to each of the m = O(n) ants.
  Complexity: O(n).

### Step 3: Build Tours (Repeat n-1 times)
- For each ant (m = O(n)):
  - Select the next city probabilistically using O(n) operations (checking unvisited cities and computing probabilities).
    Total per iteration: O(n · n) = O(n²).
- Repeat for n-1 steps (to build a full tour of n cities).
  Total for tour construction: O(n² · n) = O(n³).

### Step 4: Update Pheromones
1. Evaporate pheromones on all O(n²) edges: O(n²).
2. Add pheromones for edges in each ant's tour:
   - Each ant's tour has O(n) edges.
   - For m = O(n) ants: O(n · n) = O(n²).
     Total for pheromone update: O(n² + n²) = O(n²).

### Step 5: Cycle Iterations
- Repeat Steps 3--4 for NC cycles.

**Total complexity: O(NC · (n³ + n²)) = O(NC · n³).**

### Final Answer:
The worst-case complexity is: O(NC · n³)  
The best case is O(n²)