package LinkedList;

public class MiddleOfLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node middleNode(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        int mid = cnt/2 + 1;
        temp = head;
        while(temp != null){
            mid--;
            if(mid == 0){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void traverseLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.print("null");
    }
    public static void main(String args[]){
        Node head = new Node(2);
        head.next = new Node(9);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        traverseLL(head);
        System.out.println();
        System.out.println("The middle element of linked list is : " + middleNode(head).data);
    }
}
