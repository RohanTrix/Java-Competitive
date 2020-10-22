# StringBuilder
StringBuilder objects are like String objects, except that they can be modified. Internally, these objects are treated like variable-length arrays that contain a sequence of characters. At any point, the length and content of the sequence can be changed through method invocations.

## Constructor

|     Constructor |         Description                    |
|----------------------------|------------------------------------|
|     `StringBuilder()`	       |   Creates an empty string builder with a capacity of 16 (16 empty elements).     |
|  `StringBuilder(CharSequence cs)` |     Constructs a string builder containing the same characters as the specified CharSequence, plus an extra 16 empty elements trailing the CharSequence. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `StringBuilder(String s)`	|  Creates a string builder whose value is initialized by the specified string, plus an extra 16 empty elements trailing the string. |

## Various ArrayDeque Methods

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
</tbody>
</table>