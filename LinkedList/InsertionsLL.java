package LinkedList;

public class InsertionsLL {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node insertHead(Node head,int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
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

    public static Node insertTail(Node head,int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    // Insert at kth position
    public static Node insertKPosition(Node head,int k,int val){
        if(head == null){
            if(k==1){
                return new Node(val);
            }else{
                return head;
            }
        }
        if(k==1){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k-1){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(9);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        traverseLL(head);
        // head = insertHead(head, 8);
        // head = insertTail(head, 76);
        head = insertKPosition(head, 5, 999);
        System.out.println();
        traverseLL(head);
    }
}
