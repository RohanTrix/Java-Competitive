# StringBuilder
StringBuilder objects are like String objects, except that they can be modified. Internally, these objects are treated like variable-length arrays that contain a sequence of characters. At any point, the length and content of the sequence can be changed through method invocations.

## Constructors

|     Constructor |    Description         |
|-----------------|----------------------|
|     `StringBuilder()`	       |   Creates an empty string builder with a capacity of 16 (16 empty elements).     |
|  `StringBuilder(CharSequence cs)` |     Constructs a string builder containing the same characters as the specified CharSequence, plus an extra 16 empty elements trailing the CharSequence. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `StringBuilder(String s)`	|  Creates a string builder whose value is initialized by the specified string, plus an extra 16 empty elements trailing the string. |

---

## Various StringBuilder Methods

|     Constructor |    Description         |
|-----------------|----------------------|
| * StringBuilder append(boolean b) 
* StringBuilder append(char c) |
* StringBuilder append(char[] str) |
* StringBuilder append(char[] str, int offset, int len) |
* StringBuilder append(double d) |
* StringBuilder append(float f) |
* StringBuilder append(int i) |
* StringBuilder append(long lng) |
* StringBuilder append(Object obj) |
* StringBuilder append(String s)|   Creates an empty string builder with a capacity of 16 (16 empty elements).     |
|  `StringBuilder(CharSequence cs)` |     Constructs a string builder containing the same characters as the specified CharSequence, plus an extra 16 empty elements trailing the CharSequence. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `StringBuilder(String s)`	|  Creates a string builder whose value is initialized by the specified string, plus an extra 16 empty elements trailing the string. |
