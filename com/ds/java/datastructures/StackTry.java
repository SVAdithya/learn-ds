package com.ds.java.datastructures;

public class StackTry {
    public static void main(String[] args) {
        int[] stack = new int[10];
        int size=10, top=0;
        top = push(stack, size, top, 10);
        top = push(stack, size, top, 20);
        top = push(stack, size, top, 30);
        top = push(stack, size, top, 60);
        top = pop(stack, top);
        top = push(stack, size, top, 30);


    }

    static int push(int[] arr, int size, int top, int data){
        if(top==size){
            System.out.println("Stack is full");
        }else{
            arr[top++]=data;
        }
        printStack(arr, top);
        return top;
    }
    static int pop(int[] arr,int top){
        arr[top--]=0;
        printStack(arr, top);
        return top;
    }
    static void printStack(int[] arr, int top){
        for(int i=0;i<top;i++)
            System.out.print(arr[i] +" ");
        System.out.println();
    }
}
