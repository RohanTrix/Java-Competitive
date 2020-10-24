# HashSet
This class implements the Set interface, backed by a hash table (actually a HashMap instance). Permits the null element. The class also offers constant time performance for the basic operations like add, remove, contains, and size functions.

## Important Points about the HastSet
1. HashSet doesn’t maintain any order, the elements would be returned in any random order.
2. Duplicates are not allowed.
3. Allows a null value to be present.
4. HashSet is non-synchronized, can be synchronized explicitly.

![](images/11.png)

## Constructor

|     Constructor |         Description                    |
|----------------------------|------------------------------------|
|     `HashSet<E> hs = new HashSet<E>();` |   Constructs an empty array deque with an initial capacity sufficient to hold 16 elements. |
|  `ArrayDeque(Collection<? extends E> c)` |     Constructs a deque containing the elements of the specified collection, in the order they are returned by the collection's iterator. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `ArrayDeque(int numElements)`	|  Constructs an empty array deque with an initial capacity sufficient to hold the specified number of elements. |