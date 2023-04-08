public class Node {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    //O(1)
    public Node insertAtFront(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    //O(1)
    public void insertAtBack(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    //O(1)
    public void insertAfter(Node head, int val, Node loc) {
        if (loc == null) {
            return;
        }
        Node newNode = new Node(val);
        newNode.next = loc.next;
        loc.next = newNode;
        newNode.prev = loc;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    //O(1)
    public Node deleteFront(Node head) {
        if (head == null) {
            return null;
        }
        Node next = head.next;
        if (next != null) {
            next.prev = null;
        }
        head.next = null;
        return next;
    }
    
    //O(1)
    public void deleteBack(Node head) {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node prev = curr.prev;
        if (prev != null) {
            prev.next = null;
        } else {
            head = null;
        }
        curr.prev = null;
    }
  
  
    //O(1)
    public Node deleteNode(Node head, Node loc) {
        if (loc == null) {
            return head;
        }
        if (loc.prev != null) {
            loc.prev.next = loc.next;
        } else {
            head = loc.next;
        }
        if (loc.next != null) {
            loc.next.prev = loc.prev;
        }
        loc.prev = null;
        loc.next = null;
        return head;
    }

    //O(N)
    public int length(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
  
  
    //O(N)
    public Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
  
  
    //O(N)
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return newHead;
    }
}
