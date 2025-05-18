# Cuckoo Search via Lévy Flights Algorithm

Inspired by cuckoo breeding behavior. Uses Lévy flights for exploration, abandons worst nests, and keeps best solutions through generations to find global optima.

## Input:

- N % _Number of host nests (population size, integer)_
- pa % _Probability of discovering alien eggs (0 ≤ pa ≤ 1, real variable)_
- α % _Step size scaling factor (real variable)_
- λ % _Lévy flight exponent (1 < λ ≤ 3, real variable)_
- MaxGeneration % _Maximum iterations (integer)_
- f(x) % _Objective function to minimize (function)_

## Output:

- x* % *Best solution vector found (real vector)\*
- f(x*) % *Fitness value of the best solution (real number)\*

## Variables Definition:

- xi: Position vector of nest i (candidate solution) % _real vector_
- Fi: Fitness value of nest i, where Fi = f(xi) % _real number_
- x*: Global best position vector across all nests % *real vector\*
- f(x*): Global best fitness value % *real number\*
- Lévy(λ): Step length sampled from Lévy distribution % _real vector_

## Algorithm:

**Begin**

1. Initialize population:

   - Generate N host nests with random positions xi
   - Evaluate fitness Fi = f(xi) for all nests
   - Set x* = best nest and f(x*) = corresponding fitness

2. While t < MaxGeneration do:

   - Generate a new cuckoo via Lévy flight:

     - Randomly select a nest i
     - Update its position: xnew = xi(t) + α ⊗ Lévy(λ) where ⊗ denotes element-wise multiplication
     - Compute Fnew = f(xnew)

   - Greedy replacement:

     - Randomly select a nest j
     - If Fnew < Fj(t):
       - Replace nest j with xnew
       - Update Fj(t) = Fnew

   - Abandon worst nests:

     - Rank all nests by fitness
     - Discard a fraction pa of the worst nests
     - Replace them with new random solutions

   - Update global best:

     - Find the current best nest xcurrent-best
     - If f(xcurrent-best) < f(x\*):
       - Update x\* = xcurrent-best
       - Update f(x\*) = f(xcurrent-best)

   - t = t + 1

3. Return x* and f(x*)

**End Algorithm.**

## Key Notes

1. Lévy Flights:

   - Implemented using [Mantegna's algorithm](https://journals.aps.org/pre/abstract/10.1103/PhysRevE.49.4677) for efficient sampling.
   - Step lengths follow **Lévy(λ) ~ u = t^-λ^** enabling long jumps for exploration.

2. Parameter Sensitivity:

   - Defaults (N = 15, pα = 0.25) work well for most problems.
   - λ = 1.5 balances exploration and exploitation.

3. Mechanisms:
   - Exploration: Lévy flights and random nest replacement.
   - Exploitation: Greedy selection and elitism (retaining the best solution).

## Time Complexity Analysis

- Population initialization: O(N · d)
- Lévy flight generation: O(N · d)
- Fitness evaluation: O(N)
- Greedy replacement: O(1) per nest
- Abandonment (sorting + replacement): O(N log N)
- Global best update: O(N)
- Total per iteration: O(N · d + N log N)
- **Overall (T iterations): O(T · (N · d + N log N))**

_Where d = problem dimensionality; T = iterations._
