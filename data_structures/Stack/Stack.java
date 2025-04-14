package Stack;
import DynamicArray.DynamicArray;

public class Stack {
    private DynamicArray stack;

    public Stack(){
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