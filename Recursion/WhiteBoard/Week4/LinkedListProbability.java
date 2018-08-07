package Recursion.WhiteBoard.Week4;

import java.security.PublicKey;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedListProbability {
    public static void main(String args[]) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(9);

        System.out.println(findElement(head));
        System.out.println(findElementOnePass(head));
    }

    /*head->5->4->6->7->3->null
            print random numbers

    */
    /*
     * 2 pass approach
     * */
    static int findElement(Node head) {
        int count = 0;
        int idx = (int) Math.random() % findLength(head);
        while (count != idx) {
            head = head.next;
            count++;
        }
        return head.data;
    }

    static int findLength(Node head) {
        int lenght = 0;
        while (head != null) {
            head = head.next;
            lenght++;
        }
        return lenght;
    }

    /*1 Pass approach*/
    static int findElementOnePass(Node head){
        int length = findLength(head);
        int choosen = 0;
        while (head!=null){
            if((int)Math.random()%length == 0){
                choosen = head.data;
            }
            head = head.next;
        }
        return choosen;
    }
}
