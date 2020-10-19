# StringBuilder
StringBuilder objects are like String objects, except that they can be modified. Internally, these objects are treated like variable-length arrays that contain a sequence of characters. At any point, the length and content of the sequence can be changed through method invocations.

## Construc

|     Constructor |         Description                    |
|----------------------------|------------------------------------|
|     `StringBuilder()`	       |   Creates an empty string builder with a capacity of 16 (16 empty elements).     |
|  `StringBuilder(CharSequence cs)` |     Constructs a string builder containing the same characters as the specified CharSequence, plus an extra 16 empty elements trailing the CharSequence. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `StringBuilder(String s)`	|  Creates a string builder whose value is initialized by the specified string, plus an extra 16 empty elements trailing the string. |

## Various StringBuilder Methods


|     Method |          Description  |
|------------------|----------------------|
| 
StringBuilder append(boolean b) <br>
StringBuilder append(char c) <br>
StringBuilder append(char[] str) <br>
StringBuilder append(char[] str, int offset, int len) <br>
StringBuilder append(double d) <br>
StringBuilder append(float f) <br>
StringBuilder append(int i) <br>
StringBuilder append(long lng) <br>
StringBuilder append(Object obj) <br>
StringBuilder append(String s) <br|      ff  |
|  `StringBuilder(CharSequence cs)` |     Constructs a string builder containing the same characters as the specified CharSequence, plus an extra 16 empty elements trailing the CharSequence. |
|  `StringBuilder(int initCapacity)`	 |     Creates an empty string builder with the specified initial capacity. |
|  `StringBuilder(String s)`	|  Creates a string builder whose value is initialized by the specified string, plus an extra 16 empty elements trailing the string. |