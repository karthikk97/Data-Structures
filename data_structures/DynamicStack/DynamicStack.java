package DynamicStack;
import DynamicArray.DynamicArray;
import java.util.Stack;

public class DynamicStack {
    private DynamicArray stack;

    public DynamicStack(){
        stack = new DynamicArray();
    }

    public void push(int element){
        stack.add(element);
    }

    public int pop(){
        int size = stack.getSize() - 1;
        int element = stack.get(size);
        stack.removeLast();
        return element;
    }

    public int size(){
       return stack.getSize();
    }

    public int peek(){
        int size = stack.getSize();
        int element = stack.get(size - 1);
        return element;
    }

}

class StackTester {

    private void runBasicTestCases(){
        DynamicStack dStack = new DynamicStack();
        Stack<Integer> stack = new Stack<>();

        dStack.push(50);
        stack.push(50);
        dStack.push(25);
        stack.push(25);
        dStack.pop();
        stack.pop();
        dStack.push(15);
        stack.push(15);

        try {
            verifyEachElementInStacks(dStack, stack);
        } catch(Exception err){
            System.out.println("Basic test cases error thrown : "+err);
        }
    }   

    
    private void runRobustTestCases(){
        DynamicStack dStack = new DynamicStack();
        Stack<Integer> stack = new Stack<>();

        int n = (int) Math.pow(10, 7);
        for (int idx = 0; idx < n; idx++) {
            dStack.push(idx);
            stack.push(idx);
            if (idx > 1 && (idx + 1) < n){
                dStack.pop();
                stack.pop();
            }
        }

        try {
            verifyEachElementInStacks(dStack, stack);
        } catch(Exception err){
            System.out.println("Robust test cases error thrown : "+err);
        }
    }

    private void runInterLeaveTestCases() {
        DynamicStack dStack = new DynamicStack();
        Stack<Integer> stack = new Stack<>();

        String[] operations = new String[]{"push", "pop"};
        int n = (int) Math.pow(10, 7);
        
        for (int idx = 0; idx < n; idx++) {
            int randomIndex = (int)(Math.random() * operations.length);
            int randomNumber = (int)(Math.random() * 999) + 1; 

            if (operations[randomIndex].equals("push")) { 
                dStack.push(randomNumber);
                stack.push(randomNumber);
            }
            
            if (operations[randomIndex].equals("pop")) {
                if (dStack.size() > 0) { 
                    dStack.pop();
                    stack.pop();
                }
            }
        }
        
        try {
            verifyEachElementInStacks(dStack, stack);
        } catch(Exception err){
            System.out.println("Interleave test cases error thrown : "+err);
        }
    
    }
    

    private void verifyEachElementInStacks(DynamicStack dStack, Stack<Integer> stack) throws Exception{
        if (dStack.size() != stack.size()) throw new Exception("Size mismatch during comparision between Stack and Dynamic Stack");
        while (dStack.size() > 0){
           int elem1 =  dStack.pop();
           int elem2 =  stack.pop();
           if (elem1 != elem2){
                throw new Exception("Element mismatch during comparision between Stack and Dynamic Stack");
            }
        }
    }
    
    private void runTests(){
        long startTime = System.currentTimeMillis(); 
        runBasicTestCases();
        long endTime = System.currentTimeMillis();  
        System.out.println("Basic Test Case (Time taken) => " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis(); 
        runRobustTestCases();
        endTime = System.currentTimeMillis();  
        System.out.println("Robust Test Case (Time taken) => " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis(); 
        runInterLeaveTestCases();
        endTime = System.currentTimeMillis();  
        System.out.println("Run Inter Leave Test Cases (Time taken) => " + (endTime - startTime) + " ms");
    }

    public static void main (String args[]){
        StackTester stackTest = new StackTester();
        stackTest.runTests();
    }
}