import java.util.*; 
  
public class BasicArrayList { 
  
    // main method 
    public static void main(String[] args) { 
          
        // Instantiate an ArrayList Object 
        // Integer is a wrapper class for  
        // the basic datatype int 
        ArrayList<Integer> intArr = new ArrayList<Integer>(); 
          
        // Add elements using add() method 
        intArr.add(10); 
        intArr.add(12); 
        intArr.add(25); 
        intArr.add(19); 
        intArr.add(11); 
        intArr.add(3); 
          
        // Print the ArrayList on the console 
        System.out.println(intArr); 
          
        // Remove elements at index 1 and 4 
        intArr.remove(1); 
        intArr.remove(4); 
          
        // Print the ArrayList on the console 
        System.out.println(intArr); 
          
        // Check if intArr contains the element 25 
        if(intArr.contains(25)) 
        { 
            System.out.println("The ArrayList contains 25"); 
        } 
        else
        { 
            System.out.println("No such element exists"); 
        } 
          
        // Use get method to get the element at index 1 
        int elementAt1 = intArr.get(1); 
        System.out.println("The Element at index 1 now is " + elementAt1); 
          
    } 
  
} 