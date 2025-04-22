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

    private boolean verifyEachElementInLists(DynamicArray arr, List<Integer> list){
        if (arr.getSize() != list.size()) return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != arr.get(i)){
                return false;
            }
        }
        return true;
    }

    private boolean basicTestCase(DynamicArray dArr){
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

    private boolean robustTestCase(){
        boolean isValid = true;
        // To Implement
        
        return isValid;
    }

    private boolean randomInterleaveTestCase(){
        boolean isValid = true;
        // To Implement

        return isValid;
    }

    public static void main (String args[]){
        boolean isTestSuccess = true;
        DynamicArray dArr = new DynamicArray();
        long startTime = System.currentTimeMillis(); 
        isTestSuccess = dArr.basicTestCase(dArr);
        long endTime = System.currentTimeMillis();  
        System.out.println("Basic Test Case - Time taken: " + (endTime - startTime) + " ms");
        System.out.println("Basic Test Case - Result "+isTestSuccess);

    }
}