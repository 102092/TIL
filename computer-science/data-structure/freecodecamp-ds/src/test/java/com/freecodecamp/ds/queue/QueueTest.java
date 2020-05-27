package com.freecodecamp.ds.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

  Queue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new Queue<>();
  }

  @Test
  public void empty_queue() {
    assertTrue(queue.isEmpty());
    assertEquals(queue.size(), 0);
  }

  @Test
  public void poll_on_empty() {
    assertThrows(Exception.class, () -> queue.poll());
  }

  @Test
  public void peek_on_empty() {
    assertThrows(Exception.class, () -> queue.peek());
  }

  @Test
  public void offer() {
    queue.offer(2);
    assertEquals(queue.size(), 1);
  }

  @Test
  public void peek() {
    queue.offer(2);
    assertEquals(2, (int) queue.peek());
    assertEquals(queue.size(), 1);
  }

  @Test
  public void poll() {
    queue.offer(2);
    assertEquals(2, (int) queue.poll());
    assertEquals(queue.size(), 0);
  }

  @Test
  public void exhaustively() {
    assertTrue(queue.isEmpty());
    queue.offer(1);
    assertFalse(queue.isEmpty());
    queue.offer(2);
    assertEquals(queue.size(), 2);
    assertEquals(1, (int) queue.peek());
    assertEquals(queue.size(), 2);
    assertEquals(1, (int) queue.poll());
    assertEquals(queue.size(), 1);
    assertEquals(2, (int) queue.peek());
    assertEquals(queue.size(), 1);
    assertEquals(2, (int) queue.poll());
    assertEquals(queue.size(), 0);
    assertTrue(queue.isEmpty());
  }
}
