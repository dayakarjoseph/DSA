package LinkedList;

import java.util.Stack;

public class ReverseLL {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // BRUTE FORCE APPROACH
    public static Node reverse(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

     public static void traverseLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(9);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        traverseLL(head);
        head = reverse(head);
        System.out.println();
        traverseLL(head);
    }
}
