# Data Structures Implementation

This file contains implementations of various data structures and their operations all these as PseudoCode.

## Table of Contents

- [Index-Based List Operations](#index-based-list-operations)
- [Linked Lists (Position-based) Operations](#linked-lists-position-based-operations)
- [Trees](#trees)

## Index-Based List Operations

### get(r)

```
Algorithm: get(r)
Input: r % index of element to retrieve
Output: element % element at index r

% Variables Definition
r: index % integer value representing position in list
A: array % array storing elements of the list
n: size % current number of elements in list

Begin
1. if r < 0 or r > n-1 then
2.   return error condition % index out of bounds
3. else
4.   return A[r] % return element at index r
5. end if
End Algorithm.

// Time Complexity: O(1)
```

### set(r, e)

```
Algorithm: set(r, e)
Input: r % index of element to replace
       e % new element to store
Output: it % previous element at position r

% Variables Definition
r: index % integer value representing position in list
e: element % element to be stored at index r
t: element % original element being replaced
A: array % array storing elements of the list
n: size % current number of elements in list

Begin
1. if r < 0 or r > n-1 then
2.   return error condition % index out of bounds
3. else
4.   t = A[r] % save original element
5.   A[r] = e % replace with new element
6.   return it % return original element
7. end if
End Algorithm.

// Time Complexity: O(1)
```

### add(r, e)

```
Algorithm: add(r, e)
Input: r % index where new element should be inserted
       e % new element to insert
Output: none

% Variables Definition
r: index % integer value representing position for insertion
e: element % element to be inserted at index r
A: array % array storing elements of the list
n: size % current number of elements in list
N: capacity % maximum capacity of array A

Begin
1. if n = N then
2.   return "Array is full" % no space for new element
3. end if
4. if r < n then
5.   return error condition % index out of bounds
6. end if
7. for i ← n-1, n-2, ..., r do
8.   A[i+1] ← A[i] % make room for the new element
9. end for
10. A[r] ← e % insert new element
11. n ← n+1 % increment size counter
End Algorithm.

// Time Complexity: O(n)
```

### remove(r)

```
Algorithm: remove(r)
Input: r % index of element to remove
Output: e % element that was removed

% Variables Definition
r: index % integer value representing position to remove
e: element % element being removed
A: array % array storing elements of the list
n: size % current number of elements in list

Begin
1. if r < n-1 then
2.   for i ← r, r+1, ..., n-2 do
3.     A[i] ← A[i+1] % fill in for the removed element
4.   end for
5. end if
6. n ← n-1 % decrement size counter
7. return e % return removed element
End Algorithm.

// Time Complexity: O(n)
```

## Linked Lists (Position-based) Operations

### element()

```
Algorithm: element()
Input: position p % position object in list
Output: e % element stored at position p

% Variables Definition
p: position % node position in the linked list

Begin
1. return p.element % return element stored at position p
End Algorithm.

// Time Complexity: O(1)
```

### first()

```
Algorithm: first()
Input: none
Output: position % position of first element in list

% Variables Definition
header: node % sentinel node before first real node
S: linked list % the linked list structure

Begin
1. if S is empty then
2.   return error condition
3. end if
4. return header.next % return position of first element
End Algorithm.

// Time Complexity: O(1)
```

### last()

```
Algorithm: last()
Input: none
Output: position % position of last element in list

% Variables Definition
trailer: node % sentinel node after last real node
S: linked list % the linked list structure

Begin
1. if S is empty then
2.   return error condition
3. end if
4. return trailer.prev % return position of last element
End Algorithm.

// Time Complexity: O(1)
```

### before(p)

```
Algorithm: before(p)
Input: position p % position in the list
Output: position % position before p

% Variables Definition
p: position % node position in the linked list

Begin
1. if p is first node then
2.   return error condition % no position before first
3. end if
4. return p.prev % return position before p
End Algorithm.

// Time Complexity: O(1)
```

### after(p)

```
Algorithm: after(p)
Input: position p % position in the list
Output: position % position after p

% Variables Definition
p: position % node position in the linked list

Begin
1. if p is last node then
2.   return error condition % no position after last
3. end if
4. return p.next % return position after p
End Algorithm.

// Time Complexity: O(1)
```

### insertAfter(p, e)

```
Algorithm: insertAfter(p, e)
Input: position p % position after which to insert
       element e % element to insert
Output: position % position of new element

% Variables Definition
p: position % node position in the linked list
e: element % element to insert
v: node % new node to create

Begin
1. Create a new node v
2. v.element ← e % store element in new node
3. v.prev ← p % link v to its predecessor
4. v.next ← p.next % link v to its successor
5. (p.next).prev ← v % link p's old successor to v
6. p.next ← v % link p to its new successor, v
7. return v % the position for the element e
End Algorithm.

// Time Complexity: O(1)
```

### insertBefore(p, e)

```
Algorithm: insertBefore(p, e)
Input: position p % position before which to insert
       element e % element to insert
Output: position % position of new element

% Variables Definition
p: position % node position in the linked list
e: element % element to insert
v: node % new node to create

Begin
1. Create a new node v
2. v.element ← e % store element in new node
3. v.next ← p % link v to its successor
4. v.prev ← p.prev % link v to its predecessor
5. (p.prev).next ← v % link p's old predecessor to v
6. p.prev ← v % link p to its new predecessor, v
7. return v % the position for the element e
End Algorithm.

// Time Complexity: O(1)
```

### remove(p)

```
Algorithm: remove(p)
Input: position p % position to remove
Output: element % element that was removed

% Variables Definition
p: position % node position to remove
t: element % temporary variable to hold return value

Begin
1. t ← p.element % store element to return
2. (p.prev).next ← p.next % linking out p
3. (p.next).prev ← p.prev
4. p.prev ← null % invalidating the position p
5. p.next ← null
6. return t % return removed element
End Algorithm.

// Time Complexity: O(1)
```

## Trees

### createNode(element, parent)

```
Algorithm: createNode(element, parent)
Input: element e % element to store in the node
       node p % parent node (null for root)
Output: node % newly created node

% Variables Definition
e: element % element to store
p: node % parent node reference
n: node % new node to create

Begin
1. n ← new Node % allocate memory for new node
2. n.element ← e % set the element
3. n.parent ← p % set the parent reference
4. n.children ← new empty list % initialize children list
5. if p is not null then
6.   add n to p.children % add new node to parent's children list
7. end if
8. return n
End Algorithm.

// Time Complexity: O(1)
```

### root()

```
Algorithm: root()
Input: none
Output: position % root node of the tree

% Variables Definition
T: tree % tree structure

Begin
1. return T.root % return the root node of the tree
End Algorithm.

// Time Complexity: O(1)
```

### parent(v)

```
Algorithm: parent(v)
Input: node v % node in the tree
Output: position % parent node of v

% Variables Definition
v: node % node in the tree

Begin
1. if v is root then
2.   return error condition % root has no parent
3. end if
4. return v.parent % return parent of node v
End Algorithm.

// Time Complexity: O(1)
```

### children(v)

```
Algorithm: children(v)
Input: node v % node in the tree
Output: set % set of children nodes

% Variables Definition
v: node % node in the tree

Begin
1. return v.children % return set containing the children of node v
End Algorithm.

// Time Complexity: O(1)
```

### isInternal(v)

```
Algorithm: isInternal(v)
Input: node v % node in the tree
Output: boolean % true if v is internal

% Variables Definition
v: node % node in the tree

Begin
1. return v has at least one child % true if node has children
End Algorithm.

// Time Complexity: O(1)
```

### isExternal(v)

```
Algorithm: isExternal(v)
Input: node v % node in the tree
Output: boolean % true if v is external (leaf)

% Variables Definition
v: node % node in the tree

Begin
1. return v has no children % true if node has no children
End Algorithm.

// Time Complexity: O(1)
```

### isRoot(v)

```
Algorithm: isRoot(v)
Input: node v % node in the tree
Output: boolean % true if v is the root

% Variables Definition
v: node % node in the tree
T: tree % tree structure

Begin
1. return v = T.root % true if node is the root
End Algorithm.

// Time Complexity: O(1)
```

### size()

```
Algorithm: size()
Input: none
Output: integer % number of nodes in the tree

% Variables Definition
T: tree % tree structure
n: integer % count of nodes

Begin
1. return T.size % return the number of nodes in the tree
End Algorithm.

// Time Complexity: O(1)
```

### elements()

```
Algorithm: elements()
Input: none
Output: set % set of all elements in the tree

% Variables Definition
T: tree % tree structure
elements: set % set to store all elements
positions: set % all positions in the tree

Begin
1. elements ← empty set
2. positions ← positions() % get all positions
3. for each position p in positions do
4.   elements.add(p.element()) % add element at position p
5. end for
6. return elements
End Algorithm.

// Time Complexity: O(n)
```

### positions()

```
Algorithm: positions()
Input: none
Output: set % set of all positions (nodes) in the tree

% Variables Definition
T: tree % tree structure
positions: set % set to store all positions

Begin
1. positions ← empty set
2. if T is not empty then
3.   preorderPositions(T.root(), positions) % use preorder traversal
4. end if
5. return positions
End Algorithm.

// Time Complexity: O(n)
```

### swapElements(v, w)

```
Algorithm: swapElements(v, w)
Input: node v % first node
       node w % second node
Output: none

% Variables Definition
v: node % first node
w: node % second node
temp: element % temporary variable for swapping

Begin
1. temp ← v.element
2. v.element ← w.element
3. w.element ← temp
End Algorithm.

// Time Complexity: O(1)
```

### replaceElement(v, e)

```
Algorithm: replaceElement(v, e)
Input: node v % node to modify
       element e % new element
Output: element % old element

% Variables Definition
v: node % node to modify
e: element % new element
old: element % old element to return

Begin
1. old ← v.element
2. v.element ← e
3. return old
End Algorithm.

// Time Complexity: O(1)
```

### depth(T, v)

```
Algorithm: depth(T, v)
Input: T % tree
       v % node
Output: integer % depth of node v

% Variables Definition
T: tree % input tree
v: node % input node

Begin
1. if T.isRoot(v) then
2.   return 0
3. else
4.   return 1 + depth(T, T.parent(v))
End Algorithm.

// Time Complexity: O(n)
```

### height(T, v)

```
Algorithm: height(T, v)
Input: T % tree
       v % node
Output: integer % height of subtree rooted at v

% Variables Definition
T: tree % input tree
v: node % input node
h: integer % height variable
w: node % child node

Begin
1. if T.isExternal(v) then
2.   return 0
3. else
4.   h ← 0
5.   for each w ∈ T.children(v) do
6.     h ← max(h, height(T, w))
7.   return 1 + h
End Algorithm.

// Time Complexity: O(n)
```

### Tree Traversal Algorithms

#### preorder(T, v)

```
Algorithm: preorder(T, v)
Input: T % tree
       v % node
Output: none % visits all nodes in preorder

% Variables Definition
T: tree % input tree
v: node % current node
w: node % child node
children: list % list of child nodes

Begin
1. visit(v) % perform visit operation on node v (e.g., print v.element)
2. children ← T.children(v) % get list of all children
3. for i ← 0 to children.size()-1 do
4.   w ← children[i]
5.   preorder(T, w) % recursive call on child
6. end for
End Algorithm.

// Time Complexity: O(n)
```

#### postorder(T, v)

```
Algorithm: postorder(T, v)
Input: T % tree
       v % node
Output: none % visits all nodes in postorder

% Variables Definition
T: tree % input tree
v: node % current node
w: node % child node
children: list % list of child nodes

Begin
1. children ← T.children(v) % get list of all children
2. for i ← 0 to children.size()-1 do
3.   w ← children[i]
4.   postorder(T, w) % recursive call on child
5. end for
6. visit(v) % perform visit operation on node v (e.g., print v.element)
End Algorithm.

// Time Complexity: O(n)
```
