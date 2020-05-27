package com.freecodecamp.ds.stack;

/*
  배열을 통해 stack 구현하기
 */

public class IntStack {

  private int[] arr;
  private int pos = 0;

  public IntStack(int maxSize) {
    arr = new int[maxSize];
  }

  public int size() {
    return pos;
  }

  public boolean isEmpty() {
    return pos == 0;
  }

  public int peek() {
    return arr[pos - 1];
  }

  public void push(int value) {
    arr[pos++] = value;
  }

  public int pop() {
    return arr[--pos];
  }

  public static void main(String[] args) {

    IntStack s = new IntStack(5);

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    System.out.println(s.pop()); // 5
    System.out.println(s.pop()); // 4
    System.out.println(s.pop()); // 3

    s.push(3);
    s.push(4);
    s.push(5);

    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }

    benchMarkTest();
  }

  private static void benchMarkTest() {

    int n = 10000000;
    IntStack intStack = new IntStack(n);

    // IntStack times at around 0.0324 seconds
    long start = System.nanoTime();
    for (int i = 0; i < n; i++) {
      intStack.push(i);
    }
    for (int i = 0; i < n; i++) {
      intStack.pop();
    }
    long end = System.nanoTime();
    System.out.println("IntStack Time: " + (end - start) / 1e9);

    // ArrayDeque times at around 1.438 seconds
    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
    // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n);
    // strangely the ArrayQueue is slower when you give it an initial capacity.
    start = System.nanoTime();
    for (int i = 0; i < n; i++) {
      arrayDeque.push(i);
    }
    for (int i = 0; i < n; i++) {
      arrayDeque.pop();
    }
    end = System.nanoTime();
    System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
  }
}
