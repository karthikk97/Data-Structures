package DynamicArray;

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
         int capacity =  2 * dArray.length; // dArray.length + 100;
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