package csd;

public class DoubleLinkedlList {

    static class Node {

        int infor;
        Node prev, next;

        Node() {
        }

        public Node(int infor, Node prev, Node next) {
            this.infor = infor;
            this.prev = prev;
            this.next = next;
        }

    }

    static class MyList {

        Node head, tail;

        MyList() {
            head = tail = null;
        }

        boolean isEmpty() {
            return head == null;
        }

        void clear() {
            head = tail = null;
        }

        public void add(int x) {
            if (isEmpty()) {
                head = tail = new Node(x, null, null);
            } else {
                Node q = new Node(x, tail, null);
                tail.next = q;
                tail = q;
            }
        }

        public void deleteFirstNode() {
            if (head == tail) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = head.next;
            }
        }

        public void deleteLastNode() {
            if (head == tail) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
        }

        public void deleteNode(int x) {
            Node p = head;
            while (p != null) {
                if (p.infor == x) {
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                } else {
                    p = p.next;
                }
            }
        }

        public void printList() {
            for (Node i = head; i != null; i = i.next) {
                if (i.next != null) {
                    System.out.print(i.infor + ", ");
                } else {
                    System.out.println(i.infor);
                }
            }
        }


        public static void main(String[] args) {
            MyList list = new MyList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            list.deleteNode(3);
            list.printList();
        }
    }
}

    
