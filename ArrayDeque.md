# ArrayDeque
Resizable-array implementation of the `Deque` interface. Null elements are prohibited. This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.

![](images/java-arraydeque-class.png)

## Constructor

|     Constructor |         Description                    |
|----------------------------|------------------------------------|
|     `ArrayDeque()`	       |   Constructs an empty array deque with an initial capacity sufficient to hold 16 elements.  |
|  `ArrayDeque(Collection<? extends E> c)` |     Constructs a deque containing the elements of the specified collection, in the order they are returned by the collection's iterator. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `ArrayDeque(int numElements)`	|  Constructs an empty array deque with an initial capacity sufficient to hold the specified number of elements. |


## Methods in ArrayDeque class
<table>
<thead>
  <tr>
    <th>Method</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>public boolean offerFirst(E e)</td>
    <td>Inserts the specified element at the front of this deque.</td>
  </tr>
  <tr>
    <td>public boolean offerLast(E e)</td>
    <td>Inserts the specified element at the end of this deque.</td>
  </tr>
  <tr>
    <td>public E pollFirst()</td>
    <td>Retrieves and removes the first element of this deque, or returns null if this deque is empty.</td>
  </tr>
  <tr>
    <td>public E pollLast()</td>
    <td>Retrieves and removes the last element of this deque, or returns null if this deque is empty.</td>
  </tr>
  <tr>
    <td>public E peekFirst()</td>
    <td>Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.</td>
  </tr>
  <tr>
    <td>public E peekLast()</td>
    <td>Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.</td>
  </tr>
  <tr>
    <td>public int size()</td>
    <td>Returns the number of elements in this deque.</td>
  </tr>
  <tr>
    <td>public boolean isEmpty()</td>
    <td>Returns true if this deque contains no elements.</td>
  </tr>
  <tr>
    <td>public void clear()</td>
    <td>Removes all of the elements from this deque. The deque will be empty after this call returns.</td>
  </tr>
</tbody>
</table>