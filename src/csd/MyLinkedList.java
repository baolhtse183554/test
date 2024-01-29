package csd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList {

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

        public void addLast(E data) {
            Node<E> newNode = new Node(data);
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void addFirst(E data) {
            Node<E> newNode = new Node(data);
            if (size == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        Node<E> search(E data) {
            for (Node<E> i = head; i != null; i = i.next) {
                if (i.data == data) {
                    return i;
                }

            }
            return null;

        }

        List<Node<E>> getListNode(E data) {
            List<Node<E>> list = new ArrayList<>();
            for (Node<E> i = head; i != null; i = i.next) {
                if (i.data == data) {
                    list.add(i);
                }
            }
            return list;
        }

        Node<E> get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node<E> x = head;
            int pointer = 0;
            for (Node<E> i = head; i != null; i = i.next) {
                if (index == pointer) {
                    return i;
                }
                pointer++;
            }

            return x;
        }

        //du lieu a = node cbi them vao
        //du lieu b = node da co san
        void addAfterrNodeFirst(E a, E b) {
            Node<E> newNode = new Node(a);
            if (size == 1 && head.data == b) {
                head.next = newNode;
            } else {
                Node q = search(b);
                if (q == null) {
                    System.out.println("Not found");
                    return;
                } else {
                    Node temp = q.next  ;
                    q.next = newNode;
                    newNode.next = temp;
                }
            }
//            size++;
        }

       void printList() {
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
        for (int i = 1; i <= 5; i++) {
            myList.addLast(i);
        }

        for (int i = 6; i <= 10; i++) {
            myList.addFirst(i);
        }
        myList.addLast(7);
        myList.addLast(7);
        myList.addLast(7);
        System.out.println("Nhập giá trị node p( chuẩn bị thêm vào ): ");
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt();
        System.out.println("Nhập giá trị của node q( đã trong danh sách ) :");
        Integer b = sc.nextInt();

        myList.addAfterrNodeFirst(a, b);

        myList.printList();
    }

}
