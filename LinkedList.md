# LinkedList
Linked List is a part of the Collection framework present in `java.util package`. This class is an implementation of the LinkedList data structure which is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.

![](images/LinkedList_Durga5.png)

## Imp Properties of ArrayList.

![](images/LinkedList_Durga1.jpg)
![](images/LinkedList_Durga2.jpg)

# LinikedList Constructors

### To create empty LinkedList Object
![](images/LinkedList_Durga3.jpg)

### To create equivalent LinkedList Object for the given Collection
![](images/LinkedList_Durga4.jpg)

* ### `boolean add(Object o)`
  > Appends the specified element to the end of a list.
* ### `void add(int index, Object element)`
  > Inserts the specified element at the specified position index in a list.
  ```java
     LinkedList<String> ll = new LinkedList<>();  
    
     ll.add("Geeks");  
     ll.add("Geeks");  
     ll.add(1, "For");  
    
     System.out.println(ll);
  ```
* ### `void addFirst(Object o)`
  >Inserts the given element at the beginning of a list.
* ### `void addLast(Object o)`
  > Appends the given element to the end of a list.
* ### `int size()` : 
  > Returns the number of elements in a list
* ### `Object set(int index, Object element)`
  > Replaces any particular element in the linked list and returns the previous value from the linked list that is replaced with the new value.
* ### `boolean contains(Object o)` 
  > Return true if the list contains a specified element, else false.
* ### `boolean remove(Object o)` 
  > Removes the first occurence of the specified element in a list.
* ### `Object getFirst()` 
  >Returns the first element in a list.
* ### `Object getLast()`
  > Returns the last element in a list.
* ### `Object get(int index)`
  > Returns the element at given index
  ```java
     LinkedList<String> ll  
            = new LinkedList<>();  
    
     ll.add("Geeks");  
     ll.add("Geeks");  
     ll.add(1, "For");  

     for (int i = 0; i < ll.size(); i++)  

        System.out.print(ll.get(i) + " ");   

* ### `int indexOf(Object o)`
  > Returns the index in a list of the first occurrence of the specified element, or -1 if the list does not contain specified element.
* ### `lastIndexOf(Object o)`
  > Returns the index in a list of the last occurrence of the specified element, or -1 if the list does not contain specified element.
* ### `Iterator iterator()`
  > Returns an iterator over the elements in this list in proper sequence.
* ### `Object[] toArray()`
  > Returns an array containing all of the elements in this list in proper sequence.
* ### `List subList(int fromIndex, int toIndex)`
  > Returns a view of the portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive).

In Java LinkedList class, manipulation is fast because no shifting needs to be occurred. So essentially, all add and remove method provide very good performance O(1).

* add(E element) method is of O(1).
* get(int index) and add(int index, E element) methods are of O(n).
* remove(int index) method is of O(n).
* Iterator.remove() is O(1).
* ListIterator.add(E element) is O(1).

**LinkedList should be preferred there are no large number of random access of element while there are a large number of add/remove operations.**