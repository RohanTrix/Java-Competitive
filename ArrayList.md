# ArrayList
ArrayList is a part of collection framework and is present in java.util package. It provides us with dynamic arrays in Java. Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.

![](images/ArrayList.png)

## Imp Properties of ArrayList.

![](images/Array_List_Durga1.JPG)
![](images/Array_List_Durga2.JPG)

### To create ArrayList with capacity `initialCapacity`

![](images/Array_List_Durga3.JPG)

### To convert a `Collection` object into an ArrayList, it creates an ArrayList from the objects of the `Collection` c

![](images/Array_List_Durga4.JPG)

* `void add(int index, Object element)`
  > Inserts the specified element at the specified position in this ArrayList.

 * `boolean	add(Object o)`
  >      Appends the specified element to the end of this ArrayList.

 * `boolean	addAll(Collection c)`
  >          Appends all of the elements in the specified Collection to the end of this this ArrayList, in the order that they are returned by the specified Collection's Iterator.

* `boolean addAll(int index, Collection c)`
  > Inserts all of the elements in the specified Collection into this ArrayList, starting at the specified position.

* `void clear()`
  > Removes all of the elements from this ArrayList.
* `Object	clone()`
  > Returns a shallow copy of this ArrayList.
* `boolean	contains(Object elem)`
  > Returns true if this ArrayList contains the specified element.
* `Object	get(int index)`
  >          Returns the element at the specified position in this ArrayList.
* `int	indexOf(Object elem)`
          Searches for the first occurence of the given argument, testing for equality using the equals method.
 * `boolean	isEmpty()`
          Tests if this ArrayList has no components.
 * `int	lastIndexOf(Object elem)`
          Returns the index of the last occurrence of the specified object in this ArrayList.
 * `Object	remove(int index)`
          Removes the element at the specified position in this ArrayList.
 * `Object	set(int index, Object element)`
          Replaces the element at the specified position in this ArrayList with the specified element.
* `int size()`
          Returns the number of components in this ArrayList.