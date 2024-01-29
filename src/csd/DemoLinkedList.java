package csd;

import java.util.Scanner;

public class DemoLinkedList {

    static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;

        }
    }

    static class SingleLinkedList<E> {

        private Node<E> head;
        private Node<E> tail;
        private int size;

        public SingleLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void addFirst(E data) {
            Node<E> newNode = new Node(data);
            if (size == 0) {
                head = tail = newNode;
            } else {

                newNode.next = head;
                head = newNode;

            }

        }

        public void addLast(E data) {
            Node<E> newNode = new Node(data);
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node<E> serach(E data) {
            for (Node<E> i = head; i != null; i = i.next) {
                if (i.data == data) {
                    return i;
                }

            }
            return null;
        }

//        Node<E> delete(int index) {
//            if (index < 0 || index >= size) {
//                throw new IndexOutOfBoundsException();
//            }
//            Node<E> x = head;
//            int pointer = 0;
//            for (Node<E> i = head; i != null; i = i.next) {
//                if (index == pointer) {
//                    return i;
//                }
//                pointer++;
//            }
//
//            return x;
//        }

        public void printList() {
            for (Node<E> i = head; i != null; i = i.next) {
                if (i.next != null) {
                    System.out.print(i.data + ", ");
                } else {
                    System.out.println(i.data);
                }
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> myList = new SingleLinkedList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            myList.addFirst(i);
        }
        myList.printList();
    }

}
//         System.out.println("Enter index");
//         int a = sc.nextInt();
//         myList.delete(a);