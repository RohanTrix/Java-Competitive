# PriorityQueue
A PriorityQueue is used when the objects are supposed to be processed based on the priority. The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering

![](images/Queue-Deque-PriorityQueue-In-Java.png)

# Important points on Priority Queue

* PriorityQueue doesn’t permit null.
* We can’t create PriorityQueue of Objects that are non-comparable
* The head of this queue is the least element with respect to the specified ordering.
* It provides O(log(n)) time for add and poll methods.

# Constructors
 * ### PriorityQueue<E> pq = new PriorityQueue<E>();
 * ### PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity);
 * ### PriorityQueue<E> pq = new PriorityQueue<E>(Collection<E> c);

**NOTE** : By default, PriorityQueue implements MinHeap. To implement MaxHeap, send `Collections.reverseOrder()` ( Comparator) to the PriorityQueue constructor.

## Methods in PriorityQueue

<table>
<thead>
  <tr>
    <th>Method</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>public boolean add(E e)</td>
    <td>Inserts the specified element into this priority queue.</td>
  </tr>
  <tr>
    <td>public E peek()</td>
    <td>Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.</td>
  </tr>
  <tr>
    <td>public boolean contains(Object o)</td>
    <td>Returns true if this queue contains the specified element. <br>More formally, returns true if and only if this queue contains at least one element e <br>such that o.equals(e).</td>
  </tr>
  <tr>
    <td>public E poll()</td>
    <td>Retrieves and removes the head of this queue, or returns null if this queue is empty.</td>
  </tr>
  <tr>
    <td>public int size()</td>
    <td>Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.</td>
  </tr>
</tbody>
</table>