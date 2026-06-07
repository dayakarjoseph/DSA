package LinkedList;

public class ConvertArrToLL {

    public static class Node {
        private int data;
        private Node next;
        public Node(int data1){
            this.data = data1;
            this.next = null;
        }
    }

    public static Node arrToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; // or mover.next
        }
        return head;
    }

    public static int lengthOfLL(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public static boolean checkIfPresent(Node head,int val){
        Node temp = head;
        while(temp!=null){
            if(temp.data == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    } 

    public static void main(String[] args) {
        int arr[] = {12,3,2,1,4,5,9,98};
        Node head = arrToLL(arr);
        // System.out.println("The head of the linked list is : " + head.data);
        // Traverse the Linked list
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("The length of the linked list is : " + lengthOfLL(head));
        System.out.println("The value is present : " + checkIfPresent(head, 98));
    }
}
