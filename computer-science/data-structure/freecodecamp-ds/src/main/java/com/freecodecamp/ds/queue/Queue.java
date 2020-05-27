package com.freecodecamp.ds.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

  private LinkedList<T> list = new LinkedList<>();

  public Queue() {
  }

  //null check가 필요할수도...?
  public Queue(T firstElem) {
    list.offer(firstElem);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  //Queue의 가장 앞에 있는 요소를 보여줌
  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("Queue Empty");
    }
    return list.peekFirst();
  }

  //폴, 큐의 가장 앞에 있는 요소를 제거해서 리턴함
  public T poll() {
    if (isEmpty()) {
      throw new RuntimeException("Queue Empty");
    }
    return list.removeFirst();
  }

  //queue의 가장 마지막에 추가하는 메서드
  public void offer(T elem) {
    list.addLast(elem);
  }
  
  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
}
