package com.freecodecamp.ds.priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

  private int heapSize = 0;
  private int heapCapacity = 0;
  private List<T> heap = null;

  public BinaryHeap() {
    this(1);
  }

  public BinaryHeap(int size) {
    heap = new ArrayList<>(size);
  }

  public BinaryHeap(T[] elems) {
    heapSize = heapCapacity = elems.length;
    heap = new ArrayList<>(heapCapacity);

    for (int i = 0; i < heapSize; i++) {
      heap.add(elems[i]);
    }

    //heapify O(n)
    for (int i = Math.max(0, (heapSize / 2 - 1)); i >= 0; i--) {
      sink(i);
    }
  }

  //pq 생성자, O(nlog(n))
  public BinaryHeap(Collection<T> elems) {
    this(elems.size());
    for (T elem : elems) {
      add(elem);
    }
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public void clear() {
    for (int i = 0; i < heapCapacity; i++) {
      heap.set(i, null);
    }
    heapSize = 0;
  }

  public int size() {
    return heapSize;
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return heap.get(0);
  }

  public T poll() {
    return removeAt(0);
  }

  public boolean contains(T elem) {
    for (int i = 0; i < heapSize; i++) {
      if (heap.get(i).equals(elem)) {
        return true;
      }
    }
    return false;
  }

  public void add(T elem) {
    if (elem == null) {
      throw new IllegalArgumentException();
    }
    if (heapSize < heapCapacity) {
      heap.set(heapSize, elem);
    } else {
      heap.add(elem);
      heapCapacity++;
    }
    swim(heapSize);
    heapSize++;
  }

  public boolean remove(T element) {
    if (element == null) {
      return false;
    }

    for (int i = 0; i < heapSize; i++) {
      if (element.equals(heap.get(i))) {
        removeAt(i);
        return true;
      }
    }
    return false;
  }

  public boolean isMinHeap(int k) {
    if (k >= heapSize) {
      return true;
    }

    int left = 2 * k + 1;
    int right = 2 * k + 2;

    if (left < heapSize && !less(k, left)) {
      return false;
    }
    if (right < heapSize && !less(k, right)) {
      return false;
    }

    return isMinHeap(left) && isMinHeap(right);
  }

  @Override
  public String toString() {
    return heap.toString();
  }

  private boolean less(int i, int j) {
    T node1 = heap.get(i);
    T node2 = heap.get(j);
    return node1.compareTo(node2) <= 0;
  }

  private void swim(int k) {
    int parent = (k - 1) / 2;

    while (k > 0 && less(k, parent)) {
      swap(parent, k);
      k = parent;
      parent = (k - 1) / 2;
    }
  }

  private void swap(int i, int j) {
    T i_elem = heap.get(i);
    T j_elem = heap.get(j);

    heap.set(i, j_elem);
    heap.set(j, i_elem);

  }


  private T removeAt(int i) {
    if (isEmpty()) {
      return null;
    }

    heapSize--;
    T removed_data = heap.get(i);
    swap(i, heapSize);
    heap.set(heapSize, null);

    if (i == heapSize) {
      return removed_data;
    }

    T elem = heap.get(i);

    sink(i);

    if (heap.get(i).equals(elem)) {
      swim(i);
    }
    return removed_data;
  }


  //top --> down , O(log(n))
  private void sink(int k) {

    while (true) {
      int left = 2 * k + 1;
      int right = 2 * k + 2;
      int smallest = left;


      //왼쪽 오른쪽 노드 중에서 가장 작은 노드를 차즌ㄴ다
      if (right < heapSize && less(right, left)) {
        smallest = right;
      }

      if (left >= heapSize || less(k, smallest)) {
        break;
      }

      swap(smallest, k);
      k = smallest;
    }
  }
}
