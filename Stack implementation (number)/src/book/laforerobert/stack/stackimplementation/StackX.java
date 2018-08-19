package book.laforerobert.stack.stackimplementation;


public class StackX {

  //private int maxSize; // размер массива
    private final long[] stackArray;
    private int top; // вершина стека

    public StackX(long[] array) {
    //  maxSize = size; // определение размера массива
        stackArray = array; 
      //top = -1; // Пока нет не одного элемента
        top = stackArray.length-1; 
    }

//    public void push(long element) { //размещение элемента на вершине стека
//        stackArray[++top] = element; //вставка элемента, увилечение top
//    }

    public long pop() { // извлечение элемента с вершины стека
        return stackArray[top--]; //извлечение элемента
    }
    
    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty() { // true - если стек пуст 
        return (top == -1);
    }

//    public boolean isFull() { // true - if stack full
//        return (top == maxSize - 1);
//    }


}
