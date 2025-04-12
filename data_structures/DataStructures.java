import DynamicArray.DynamicArray;

public class DataStructures {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
    
        int n = (int) Math.pow(10, 1);
        
        long startTime = System.currentTimeMillis(); 

        for (int idx = 0; idx < n; idx++) {
            arr.add(idx);
        }

        long endTime = System.currentTimeMillis();  

        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
