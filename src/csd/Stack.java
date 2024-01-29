package csd;

import java.util.EmptyStackException;

public class Stack {

    static class Node {

        public Object info;
        public Node next;

        public Node(Object x, Node p) {
            info = x;
            next = p;
        }

        public Node(Object x) {
            this(x, null);
        }
    }

    static class LinkedStack {

        protected Node head;

        public LinkedStack() {
            head = null;
        }

        public boolean isEmpty() {
            return (head == null);
        }

        public void push(Object x) {
            head = new Node(x, head);
        }

        Object top() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return (head.info);
        }

        public Object pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            Object x = head.info;
            head = head.next;
            return (x);
        }

        public void delete(Object x) throws EmptyStackException {
            LinkedStack temp = new LinkedStack();
            while (head != null) {
                if (head.info != x) {
                    Object obj = this.pop();
                    temp.push(x);
                }else{
                    this.pop();
                    break;
                }while(temp.head!= null){
//                    Object obj = temp.pop(x);
                    this.push(x);
                }
            }
        }
    }

}
