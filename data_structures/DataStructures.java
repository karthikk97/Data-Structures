import DynamicArray.DynamicArray;
import DynamicStack.DynamicStack;

public class DataStructures {
    public static void main(String[] args) {
        TestCases test = new TestCases();
        // test.stackTest();
        test.dynamicArrayTest();
    }
  
}
class TestCases {
    public void dynamicArrayTest(){
        DynamicArray arr = new DynamicArray();
    
        int n = (int) Math.pow(10, 1);
        
        long startTime = System.currentTimeMillis(); 

        for (int idx = 0; idx < n; idx++) {
            arr.add(idx);
        }

        arr.set(9,987);

        System.out.println("Array value of index 9 => "+arr.get(9));

        long endTime = System.currentTimeMillis();  

        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    } 
    public void stackTest(){
        DynamicStack stack = new DynamicStack();
            
        long startTime = System.currentTimeMillis(); 

        stack.push(2);
        stack.push(23);
        stack.push(45);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());

        long endTime = System.currentTimeMillis();  

        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}