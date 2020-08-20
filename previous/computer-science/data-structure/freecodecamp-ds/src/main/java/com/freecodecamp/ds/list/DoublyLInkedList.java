package com.freecodecamp.ds.list;

import java.util.Iterator;

//FIFO

public class DoublyLInkedList<T> implements Iterable<T> {

  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  private class Node<T> {

    T data;
    Node<T> prev, next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  //LinkedList를 비우는 메소드
  public void clear() {
    Node<T> trav = head; // head node가 맨 처음
    while (trav != null) {
      Node<T> next = trav.next; // head의 그다음 노드를 배정한 다음에
      trav.data = null; // 현재 노드의 데이터를 null로 할당하여 비우고
      trav = next; // 다음으로 넘어감
    }
    head = tail = trav = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void add(T elem) {
    addLast(elem);
  }

  public void addFirst(T elem) {

    if (isEmpty()) {
      head = tail = new Node<T>(elem, null, null); // 현재 링크드리스트가 비어있으면, elem를 기반으로 새로운 노드를 생성한다
    } else {
      head.prev = new Node<T>(elem, null, head); // 어떤 노드가 있으면, head 전에 노드를 추가한다.
      head = head.prev;
    }
    size++;
  }

  public void addLast(T elem) {
    if (isEmpty()) {
      head = tail = new Node<T>(elem, null, null); // 현재 링크드리스트가 비어있으면, elem를 기반으로 새로운 노드를 생성한다
    } else {
      tail.next = new Node<T>(elem, tail, null); // 어떤 노드가 있으면, tail.next 에 노드를 추가한다.
      tail = tail.next;
    }
    size++;
  }

  public T peekFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return head.data;
  }

  public T peekLas() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }
    return tail.data;
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = head.data; //head의 데이터를 추출해서
    head = head.next; // head pointer을 그 다음으로 이동하고
    --size;
    if (isEmpty()) {
      tail = null; //리스트가 비어있으면, 아까 추출했던 데이터가 마지막 데이터라는 의미니까, 할당되었된 tail도 null로 변환하고
    } else {
      head.prev = null; //그렇지 않아면 뭔가 데이터가 리스트에 남아있다는 이야기니까, 삭제할 노드를 null로 할당한다.
    }
    return data;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = tail.data; //tail의 데이터를 추출해서
    tail = tail.prev; // head pointer을 그 다음으로 이동하고
    --size;
    if (isEmpty()) {
      head = null; //리스트가 비어있으면, 아까 추출했던 데이터가 마지막 데이터라는 의미
    } else {
      tail.next = null; //그렇지 않아면 뭔가 데이터가 리스트에 남아있다는 이야기니까, 삭제할 노드를 null로 할당한다.
    }
    return data;
  }

  private T remove(Node<T> node) {
    if (node.prev == null) {
      return removeFirst();
    }
    if (node.next == null) {
      return removeLast();
    }

    //위치 재조정?
    node.next.prev = node.prev;
    node.prev.next = node.next;

    T data = node.data;
    node.data = null;
    node = node.prev = node.next = null;
    --size;
    return data;
  }

  public T removeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }
    int i;
    Node<T> trav;

    //리스트의 앞에서부터 찾기
    if (index < size / 2) {
      for (i = 0, trav = head; i != index; i++) {
        trav = trav.next;
      }
    }
    //리스트 뒤에서 부터 찾기
    else {
      for (i = size - 1, trav = tail; i != index; i--) {
        trav = trav.prev;
      }
    }
    return remove(trav);
  }

  public boolean remove(Object obj) {

    Node<T> trav = head;

    if (obj == null) {
      for (trav = head; trav != null; trav = trav.next) {
        if (trav.data == null) {
          remove(trav);
          return true;
        }
      }
    } else {
      for (trav = head; trav != null; trav = trav.next) {
        if (obj.equals(trav.data)) {
          remove(trav);
          return true;
        }
      }
    }
    return false;
  }

  public int indexOf(Object obj) {

    int index = 0;
    Node<T> trav = head;

    if (obj == null) {
      for (trav = head; trav != null; trav = trav.next, index++) {
        if (trav.data == null) {
          return index;
        }
      }
    } else {
      for (trav = head; trav != null; trav = trav.next, index++) {
        if (obj.equals(trav.data)) {
          return index;
        }
      }
    }
    return -1;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }
    };
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
      sb.append(trav.data + ", ");
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }
}
