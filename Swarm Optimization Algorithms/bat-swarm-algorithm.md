# Bat Swarm Algorithm

Bio-inspired optimization mimicking bats' echolocation. Bats adjust frequency, position, and loudness to balance exploration/exploitation while searching for prey (optimal solutions) in the search space.

## Input:

- n % _integer variable for population size_
- fmin, fmax % _real variables for frequency range_
- α, γ % _real variables for loudness and pulse rate control_
- Max_iterations % _integer variable for maximum iterations_

## Output:

- x* % *real variable vector representing optimal solution\*
- f(x*) % *real variable representing optimal fitness value\*

## Variables Definition:

- xi : position vector of bat i % _real variable vector_
- vi : velocity vector of bat i % _real variable vector_
- fi : frequency of bat i % _real variable_
- ri : pulse rate of bat i % _real variable_
- Ai : loudness of bat i % _real variable_
- f(x) : objective function % _real variable_
- x* : current best solution % *real variable vector\*
- β : random vector in range [0,1] % _real variable_
- ε : random number in range [-1,1] % _real variable_

## Algorithm:

**Begin**

1. Initialize the bat population xi (i = 1, 2, ..., n) and vi
2. Define pulse frequency fi at xi
3. Initialize pulse rates ri and the loudness Ai
4. WHILE (t < Max number of iterations)
5. fi = fmin + (fmax - fmin).β
6. vi^t = vi^(t-1) + (xi^t - x\*)fi
   xi^t = xi^(t-1) + vi^t
7. IF (rand > ri)
8. Select a solution among the best solutions
9. Generate a local solution around the selected best solution by :
   Xnew = xold + ε.A^t
10. END IF
11. Generate a new solution by flying randomly _(change the position)_
12. IF (rand < Ai & f(xi) < f(x\*))
13. Accept the new solutions _(modify bat to new position)_
14. Ai^(t+1) = α.Ai^t
    ri^(t+1) = ri^0[1 - exp(-γ^t)]
15. END IF
16. Rank the bats and find the current best x\*
17. END WHILE
18. Postprocess results and visualization

**End Algorithm.**

## Note:

### The variables and constants:

- **Objective function: f(x,y) = x² + y²**
- **Global minimum: (0,0) with f(0,0) = 0**
- **Frequency range: fmin = 0, fmax = 100**
- **Constants: α = 0.9, γ = 0.9**

### For steps 5-6:

- **Frequency equation: fi = fmin + (fmax - fmin)β where β is a random value in [0,1]**
- **Velocity update: vi^t = vi^(t-1) + (xi^t - x\*)fi**
- **Position update: xi^t = xi^(t-1) + vi^t**

### For the local search in step 9:

- **Xnew = xold + ε.A^t where ε is a random number in [-1,1] and A^t is the average loudness**

### For steps Global search 13,14:

- **Loudness update: Ai^(t+1) = α.Ai^t where α is typically 0.9**
- **Pulse rate update: ri^(t+1) = ri^0[1 - exp(-γ^t)] where γ is typically 0.9**

## Steps analysis

1. 1 primitive
2. 4 primitive
3. n primitive (Tmax are fixed constant, e.g., 100-1000)
4. T(1 of init, n primitive (i.e. n=2), n-1 of increment)
5. 3n primitive
6. kn primitive
7. n primitive
8. k·n primitive
9. (END IF - no operations)
10. k·n primitive
11. 2n primitive
12. n primitive
13. k·n primitive
14. (END IF - no operations)
15. (END FOR - no operations)
16. n primitive, depends on sorting algorithm
17. (END WHILE - no operations)

Best case: O(Tn)

Worst case O(Tn);

But **if T∝n**, complexity becomes **O(n²)\*k** (dimensionality d==k) is typically a constant
