package LinkedList;

public class DeletionsLL {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node deleteHead(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteK(Node head,int k){
        if(head == null){
            return head;
        }
        if(k==1){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
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
        System.out.println();
        // System.out.println(deleteHead(head).data);
        // head = deleteHead(head);
        // traverseLL(head);
        // head = deleteTail(head);
        // traverseLL(head);
        head = deleteK(head, 3);
        traverseLL(head);
    }
}