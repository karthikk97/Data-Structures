package DynamicArray;
import java.util.*;

public class DynamicArray {

    private int[] dArray;
    private int size;

    public DynamicArray() {
        size = 0;
        dArray = new int[1];
    }
    public int get(int idx) {
        return dArray[idx];
    }
    public void add(int newElement){
         if (size == dArray.length){
             resize();
        }
        dArray[size] = newElement;
        size++;
    }
    public void set(int idx, int value){
        if (idx >= dArray.length){
            throw new IndexOutOfBoundsException("Index out of bounds for size "+dArray.length);
        }
        dArray[idx] = value;
    }
    private void resize(){
         int capacity =  2 * dArray.length;
         int[] tempArray = new int[capacity];
         for (int idx = 0; idx < size; idx++){
            tempArray[idx] = dArray[idx];
         }
         dArray = tempArray;
    }
    public int getSize(){
        return size;
    }
    public void removeLast(){
        dArray[size] = -1;
        size--;
    }
}

class DynamicArrayTester {

    private void runBasicTestCases(){
        DynamicArray dArr = new DynamicArray();
        List<Integer> testList = new ArrayList<>();

        dArr.add(50);
        testList.add(50);
        dArr.add(25);
        testList.add(25);
        dArr.add(15);
        testList.add(15);
        try {
            verifyEachElementInLists(dArr, testList);
        } catch(Exception err){
            System.out.println("Basic test cases error thrown : "+err);
        }        
        dArr.set(0,75);
        testList.set(0,75);
        dArr.set(1,50);
        testList.set(1,50);
        try {
            verifyEachElementInLists(dArr, testList);
        } catch(Exception err){
            System.out.println("Basic test cases error thrown : "+err);
        }      
    }   

    
    private void runRobustTestCases(){
        DynamicArray dArr = new DynamicArray();
        List<Integer> list = new ArrayList<>();
        int n = (int) Math.pow(10, 7);
        for (int idx = 0; idx < n; idx++) {
            dArr.add(idx);
            list.add(idx);
            if (idx > 1 && (idx + 1) < n){
                dArr.set(idx - 1,dArr.get(idx));
                list.set(idx - 1,list.get(idx));
            }
        }

        try {
            verifyEachElementInLists(dArr, list);
        } catch(Exception err){
            System.out.println("Robust test cases error thrown : "+err);
        }
    }

    private void runInterLeaveTestCases() {
        DynamicArray dArr = new DynamicArray();
        List<Integer> list = new ArrayList<>();
        String[] operations = new String[]{"add", "set"};
        int n = (int) Math.pow(10, 7);
        
        for (int idx = 0; idx < n; idx++) {
            int randomIndex = (int)(Math.random() * operations.length);
            int randomNumber = (int)(Math.random() * 999) + 1; 

            if (operations[randomIndex].equals("add")) { 
                dArr.add(randomNumber);
                list.add(randomNumber);
            }
            
            if (operations[randomIndex].equals("set")) { 
                if (dArr.getSize() > 0) { 
                    int randomIndexWithinList = (int)(Math.random() * dArr.getSize()); 
                    dArr.set(dArr.getSize() - 1, dArr.get(randomIndexWithinList));
                    list.set(list.size() - 1, list.get(randomIndexWithinList));
                }
            }
        }
        
        try {
            verifyEachElementInLists(dArr, list);
        } catch(Exception err){
            System.out.println("Interleave test cases error thrown : "+err);
        }
    
    }
    

    private void verifyEachElementInLists(DynamicArray arr, List<Integer> list) throws Exception{
        if (arr.getSize() != list.size()) throw new Exception("Size mismatch during comparision between List and DynamicArray");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != arr.get(i)){
                throw new Exception("Element mismatch during comparision between List and DynamicArray");
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
        DynamicArrayTester dArrayTest = new DynamicArrayTester();
        dArrayTest.runTests();
    }
}