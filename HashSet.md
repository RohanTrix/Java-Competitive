# HashSet
This class implements the Set interface, backed by a hash table (actually a HashMap instance). Permits the null element. **The class also offers constant time performance for the basic operations like add, remove, contains, and size functions.**

## Important Points about the HastSet
1. HashSet doesn’t maintain any order, the elements would be returned in any random order.
2. Duplicates are not allowed.
3. Allows a null value to be present.
4. HashSet is non-synchronized, can be synchronized explicitly.

![](images/11.png)

## Constructor

|     Constructor |         Description                    |
|----------------------------|------------------------------------|
|  `Set<E> hs = new HashSet<E>();` | Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75) |
|  `Set<E> hs = new HashSet<E>(Collection C);` |     Constructs a new set containing the elements in the specified collection. |
|  `Set<E> hs = new HashSet<E>(int initialCapacity);` |     Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75). |

## Methods

<table>
<thead>
  <tr>
    <th>Constructor</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>public boolean add(E e)</td>
    <td>Adds the specified element to this set if it is not already present.</td>
  </tr>
  <tr>
    <td>public boolean remove(Object o)</td>
    <td>Removes the specified element from this set if it is present.</td>
  </tr>
  <tr>
    <td>public boolean contains(Object o)</td>
    <td>Returns true if this set contains the specified element.</td>
  </tr>
  <tr>
    <td>public boolean isEmpty()</td>
    <td>Returns true if this set contains no elements.</td>
  </tr>
  <tr>
    <td>public int size()</td>
    <td>Returns the number of elements in this set (its cardinality).</td>
  </tr>
</tbody>
</table>