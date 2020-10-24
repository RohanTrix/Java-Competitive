# HashSet
This class implements the Set interface, backed by a hash table (actually a HashMap instance). Permits the null element. The class also offers constant time performance for the basic operations like add, remove, contains, and size functions.

## Important Points about the HastSet
1. HashSet doesn’t maintain any order, the elements would be returned in any random order.
2. Duplicates are not allowed. Adding a duplicate will just overwrite the old value;
3. Allows a null value to be present.
4. HashSet is non-synchronized, can be synchronized explicitly.
