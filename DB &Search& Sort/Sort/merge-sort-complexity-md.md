# Derivation of Merge-Sort's Time Complexity O(n log n)

This walkthrough demonstrates the complete derivation of the merge-sort recurrence relation to show how we arrive at the O(n log n) time complexity.

## The Recurrence Relation

The worst-case running time t(n) of merge-sort on an input of size n is given by:

$$
t(n) = \begin{cases}
b & \text{if } n = 1 \\
2t\left(\frac{n}{2}\right) + cn & \text{if } n > 1
\end{cases}
$$

Where:

- $b$ is the constant time to solve a problem of size 1
- $c$ is the constant factor for the merge operation (which takes linear time)

## Step-by-Step Derivation

### 1. First Expansion

Initial recurrence relation:

$$
t(n) = 2t\left(\frac{n}{2}\right) + cn
$$

### 2. Second Expansion

Expand $t(n/2)$:

$$
t\left(\frac{n}{2}\right) = 2t\left(\frac{n}{4}\right) + c\frac{n}{2}
$$

Substitute back into the original equation:

$$
t(n) = 2\left[2t\left(\frac{n}{4}\right) + c\frac{n}{2}\right] + cn = 4t\left(\frac{n}{4}\right) + cn + cn = 2^2t\left(\frac{n}{2^2}\right) + 2cn
$$

### 3. Third Expansion

Expand $t(n/4)$:

$$
t\left(\frac{n}{4}\right) = 2t\left(\frac{n}{8}\right) + c\frac{n}{4}
$$

Substitute back:

$$
t(n) = 4\left[2t\left(\frac{n}{8}\right) + c\frac{n}{4}\right] + 2cn = 8t\left(\frac{n}{8}\right) + cn + 2cn = 2^3t\left(\frac{n}{2^3}\right) + 3cn
$$

### 4. Identifying the Pattern

After k expansions, the pattern becomes:

$$
t(n) = 2^kt\left(\frac{n}{2^k}\right) + kcn
$$

### 5. Base Case Condition

We know that $t(1) = b$. We want to find when $n/2^k = 1$, which occurs when:

$$
\frac{n}{2^k} = 1 \implies n = 2^k \implies k = \log_2 n
$$

### 6. Final Substitution

Substitute $k = \log_2 n$ into our general form:

$$
t(n) = 2^{\log_2 n}t\left(\frac{n}{2^{\log_2 n}}\right) + cn\log_2 n
$$

Simplify the terms:

- $2^{\log_2 n} = n$
- $\frac{n}{2^{\log_2 n}} = \frac{n}{n} = 1$
- $t(1) = b$

So we get:

$$
t(n) = n \cdot b + cn\log_2 n
$$

### 7. Asymptotic Analysis

For large n, the dominant term is $cn \log_2 n$. Therefore:

$$
t(n) = O(n \log n)
$$

## Why This Holds for All n

While derived for powers of 2, this asymptotic bound holds for all positive integers n. The recursion tree has depth $\Theta(\log n)$ levels, with each level contributing $O(n)$ work.

## Intuitive Understanding

Merge-sort works by:

1. Dividing the array into two halves (constant time)
2. Recursively sorting each half (2 × T(n/2))
3. Merging the two sorted halves (O(n) time)

Recursion tree characteristics:

- $\log_2 n$ levels (halving n each time)
- $2^k$ subproblems at level k, each of size $n/2^k$
- Work at each level: $2^k \cdot c(n/2^k) = cn$
- Total work: $cn \cdot \log_2 n$ levels = $O(n \log n)$

This derivation shows why merge-sort achieves the optimal O(n log n) time complexity for comparison-based sorting.
