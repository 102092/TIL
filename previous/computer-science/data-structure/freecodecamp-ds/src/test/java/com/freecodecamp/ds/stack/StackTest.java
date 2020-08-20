package com.freecodecamp.ds.stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StackTest {

  Stack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new Stack<>();
  }

  @Test
  void empty_stack() {
    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  void pop_on_empty() {
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  @Test
  void peek_on_empty() {
    assertThrows(EmptyStackException.class, () -> stack.peek());
  }

  @Test
  void push() {
    stack.push(2);
    assertThat(stack.size()).isEqualTo(1);
  }

  @Test
  void peek() {
    stack.push(2);
    assertThat(stack.peek()).isEqualTo(2);
    assertThat(stack.size()).isEqualTo(1);
  }

  @Test
  void pop() {
    stack.push(2);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  void exhaustively() {
    assertThat(stack.isEmpty()).isTrue();
    stack.push(1);
    assertThat(stack.isEmpty()).isFalse();
    stack.push(2);
    assertThat(stack.size()).isEqualTo(2);
    assertThat(stack.peek()).isEqualTo(2);
    assertThat(stack.size()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(2);

    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(1);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(1);

    assertThat(stack.size()).isEqualTo(0);
    assertThat(stack.isEmpty()).isTrue();
  }


}
