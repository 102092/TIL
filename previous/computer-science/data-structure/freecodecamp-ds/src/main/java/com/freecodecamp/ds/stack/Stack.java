package com.freecodecamp.ds.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/*
Stack : FILO
 */

public class Stack<T> implements Iterable<T> {

  private LinkedList<T> list = new LinkedList<>();

  //stack 생성
  public Stack() {
  }

  //하나의 인자를 받아서, stack을 생성
  public Stack(T firstElem) {
    push(firstElem);
  }

  //stack의 사이즈를 반환
  public int size() {
    return list.size();
  }

  //stack push() 기능
  public void push(T firstElem) {
    list.addLast(firstElem);
  }

  //stack pop() 기능
  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return list.removeLast();
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return list.peekLast();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
}
