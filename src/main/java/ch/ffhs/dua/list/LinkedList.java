package ch.ffhs.dua.list;

import java.util.Iterator;
import java.util.List;

public class LinkedList<E> extends ListBasic<E> implements List<E> {
   private static final int EMPTY = -1;
   private int size = EMPTY;
   private Node<E> head;
   private Node<E> tail;

   @Override
   public int size() {
      return size + 1;
   }

   @Override
   public boolean isEmpty() {
      return size == EMPTY;
   }

   @Override
   public E get(int index) {
      return getNodeAtPosition(index).element;
   }

   @Override
   public E set(int index, E element) {
      Node<E> node = getNodeAtPosition(index);
      node.element = element;
      return node.element;
   }

   @Override
   public boolean add(E element) {
      Node<E> newNode = new Node(element);

      if (size == EMPTY) {
         addToEmptyList(newNode);
      } else {
         addLast(newNode);
      }

      size++;

      return true;
   }

   @Override
   public void add(int index, E element) {
      Node<E> newNode = new Node(element);

      if (size == EMPTY) {
         addToEmptyList(newNode);
      } else if (index == size()) {
         addLast(newNode);
      } else if (index == 0) {
         addFirst(newNode);
      } else {
         addOn(index, newNode);
      }

      size++;
   }

   private void addToEmptyList(Node<E> newNode) {
      head = newNode;
      tail = newNode;
   }

   public boolean contains(Object obj) {
      Node<E> node = head;

      for (int i = 0; i < size(); i++) {
         if (node.element == obj) {
            return true;
         }
         if (node.next != null) {
            node = node.next;
         }
      }

      return false;
   }

   @Override
   public E remove(int index) {
      if (size == EMPTY) {
         throw new IndexOutOfBoundsException("");
      }

      if (index == 0) {
         return removeFirst();
      } else if (index == size) {
         return removeLast();
      } else {
         return removeOn(index);
      }
   }

   @Override
   public boolean remove(Object o) {
      Node<E> node = head;
      for (int i = 0; i < size; i++) {
         if (node.element.equals(o)) {
            removeOn(i);
            return true;
         }
         node = node.next;
      }
      return false;
   }

   @Override
   public void clear() {
      LinkedList.Node next;
      for (LinkedList.Node current = head; current != null; current = next) {
         next = current.next;
         current.element = null;
         current.previous = null;
         current.next = null;
      }

      size = 0;
   }

   private Node<E> getNodeAtPosition(int index) {
      if (index > size || index < 0) {
         throw new IndexOutOfBoundsException();
      }

      Node<E> node = head;
      for (int i = 0; i < index; i++) {
         node = node.next;
      }

      return node;
   }

   private E removeOn(int index) {
      Node<E> node = getNodeAtPosition(index);
      Node<E> previousNode = node.previous;
      Node<E> nextNode = node.next;
      previousNode.next = nextNode;
      nextNode.previous = previousNode;
      size--;
      return node.element;
   }

   private E removeLast() {
      Node<E> node = tail;
      tail = node.previous;
      tail.next = null;
      size--;
      return node.element;
   }

   private E removeFirst() {
      Node<E> node = head;
      head = head.next;
      head.previous = null;

      if (size == 0) {
         tail = head;
      }
      size--;
      return node.element;
   }

   private void addOn(int index, Node<E> newNode) {
      Node<E> nextNode = getNodeAtPosition(index);
      Node<E> previousNode = nextNode.previous;
      newNode.next = nextNode;
      newNode.previous = previousNode;
      previousNode.next = newNode;
      nextNode.previous = newNode;
   }

   private void addFirst(Node<E> newNode) {
      Node<E> nextNode = this.head;
      this.head = newNode;
      this.head.next = nextNode;
      nextNode.previous = head;
   }

   private void addLast(Node<E> newNode) {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
   }

   @Override
   public Iterator<E> iterator() {
      return new LinkedListIterator();
   }

   private class LinkedListIterator implements Iterator<E> {
      private Node<E> current = null;

      @Override
      public boolean hasNext() {
         if (current == null) {
            return head.next != null;
         }
         return current.next != null;
      }

      @Override
      public E next() {
         if (hasNext()) {
            if (current == null) {
               current = head;
            } else {
               current = current.next;
            }
            return current.element;
         }
         return null;
      }

      @Override
      public void remove() {
         Node<E> previousNode = current.previous;
         Node<E> nextNode = current.next;
         previousNode.next = nextNode;
         nextNode.previous = previousNode;
         size--;
         current = current.previous;
      }
   }


   private class Node<E> {
      E element;
      Node<E> next;
      Node<E> previous;

      public Node(E element) {
         this.element = element;
         this.next = null;
         this.previous = null;
      }
   }
}
