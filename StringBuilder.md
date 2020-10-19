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
<table>
<thead>
  <tr>
    <th>Abbreviation</th>
    <th>Meaning</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>StringBuilder append(boolean b)<br></td>
    <td rowspan="10">Appends the argument to this string builder. <br>The data is converted to a string before the append operation takes place.<br></td>
  </tr>
  <tr>
    <td>StringBuilder append(char c)</td>
  </tr>
  <tr>
    <td>StringBuilder append(char[] str)</td>
  </tr>
  <tr>
    <td>StringBuilder append(char[] str, int offset, int len)</td>
  </tr>
  <tr>
    <td>StringBuilder append(double d)</td>
  </tr>
  <tr>
    <td>StringBuilder append(float f)</td>
  </tr>
  <tr>
    <td>StringBuilder append(int i)</td>
  </tr>
  <tr>
    <td>StringBuilder append(long lng)</td>
  </tr>
  <tr>
    <td>StringBuilder append(Object obj)</td>
  </tr>
  <tr>
    <td>StringBuilder append(String s)</td>
  </tr>
  <tr>
    <td>StringBuilder delete(int start, int end)</td>
    <td rowspan="2">The first method deletes the subsequence from start to end-1 (inclusive) in the StringBuilder's char sequence. <br>The second method deletes the character located at index.</td>
  </tr>
  <tr>
    <td>StringBuilder deleteCharAt(int index)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, boolean b)</td>
    <td rowspan="10">Inserts the second argument into the string builder. <br> The first integer argument indicates the index before which the data is to be inserted.<br> The data is converted to a string before the insert operation takes place.</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, char c)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, char[] str)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int index, char[] str, int offset, int len)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, double d)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, float f)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, int i)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, long lng)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, Object obj)</td>
  </tr>
  <tr>
    <td>StringBuilder insert(int offset, String s)</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>StringBuilder replace(int start, int end, String s)</td>
    <td>Replaces the specified character(s) in this string builder.</td>
  </tr>
  <tr>
    <td>void setCharAt(int index, char c)</td>
    <td></td>
  </tr>
  <tr>
    <td>StringBuilder reverse()</td>
    <td>Reverses the sequence of characters in this string builder.</td>
  </tr>
  <tr>
    <td>String toString()</td>
    <td>Returns a string that contains the character sequence in the builder.</td>
  </tr>
  <tr>
    <td>int length()</td>
    <td>Returns the length of the characters in the String</td>
  </tr>
</tbody>
</table>

### **Note**: 
You can use any String method on a StringBuilder object by first converting the string builder to a string with the `toString()` method of the StringBuilder class. Then convert the string back into a string builder using the `StringBuilder(String str)` constructor.