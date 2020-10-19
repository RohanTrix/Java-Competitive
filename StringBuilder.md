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
    <td rowspan="10">Appends the argument to this string builder.<br> The data is converted to a string before the append operation takes place.</td>
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
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
</tbody>
</table>
