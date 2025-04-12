package DynamicArray;

public class DynamicArray {
    private int capacity;
    private int[] dArray;
    private int size;

    public DynamicArray() {
        this.capacity = 1;
        this.size = 1;
        dArray = new int[1];
    }
    public int get(int idx) {
        return dArray[idx];
    }
    public void add(int newElement){
        if (size == capacity){
            dArray = resize();
            dArray[size - 1] = newElement;
        }
        else{
            dArray[size - 1] = newElement;
        }
        size = size + 1;
    }
    private int[] resize(){
         capacity =  2 * capacity; // capacity + 100;
         int[] tempArray = new int[capacity];
         for (int idx = 0; idx < size; idx++){
            tempArray[idx] = dArray[idx];
         }
         return tempArray;
    }
}