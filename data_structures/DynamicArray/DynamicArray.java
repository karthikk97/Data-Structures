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

    private boolean runBasicTestCases(){
        DynamicArray dArr = new DynamicArray();
        boolean isValid = true;
        List<Integer> testList = new ArrayList<>();

        dArr.add(50);
        testList.add(50);
        dArr.add(25);
        testList.add(25);
        dArr.add(15);
        testList.add(15);
        isValid = verifyEachElementInLists(dArr,testList);
        if (!isValid) return isValid;
        
        dArr.set(0,75);
        testList.set(0,75);
        dArr.set(1,50);
        testList.set(1,50);
        isValid = verifyEachElementInLists(dArr,testList);
        if (!isValid) return isValid;
      
        return isValid;
    }   

    
    private boolean runRobustTestCases(){
        boolean isValid = true;
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

        isValid = verifyEachElementInLists(dArr,list);
        return isValid;
    }

    private boolean runInterLeaveTestCases() {
        boolean isValid = true;
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
        
        isValid = verifyEachElementInLists(dArr, list);
        return isValid;
    }
    

    private boolean verifyEachElementInLists(DynamicArray arr, List<Integer> list){
        if (arr.getSize() != list.size()) return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != arr.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public static void main (String args[]){
        boolean isTestSuccess = true;
        DynamicArrayTester dArrayTest = new DynamicArrayTester();


        long startTime = System.currentTimeMillis(); 
        isTestSuccess = dArrayTest.runBasicTestCases();
        long endTime = System.currentTimeMillis();  
        System.out.println("Basic Test Case (Time taken) => " + (endTime - startTime) + " ms");
        System.out.println("Basic Test Case (Result) - Is Success ? => "+isTestSuccess);

        startTime = System.currentTimeMillis(); 
        isTestSuccess = dArrayTest.runRobustTestCases();
        endTime = System.currentTimeMillis();  
        System.out.println("Robust Test Case (Time taken) => " + (endTime - startTime) + " ms");
        System.out.println("Robust Test Case (Result) - Is Success ? => "+isTestSuccess);

        startTime = System.currentTimeMillis(); 
        isTestSuccess = dArrayTest.runInterLeaveTestCases();
        endTime = System.currentTimeMillis();  
        System.out.println("Run Inter Leave Test Cases (Time taken) => " + (endTime - startTime) + " ms");
        System.out.println("Run Inter Leave Test Cases (Result) - Is Success ? => "+isTestSuccess);


    }
}