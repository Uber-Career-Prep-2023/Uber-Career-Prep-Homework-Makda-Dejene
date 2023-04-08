
public class Node {
    public int val;
    public Node next;
    
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}


//O(1)
public static Node insertAtFront(Node head, int val) {
    Node newNode = new Node(val, head);
    return newNode;
}

//O(N)
public static void insertAtBack(Node head, int val) {
    Node newNode = new Node(val, null);
    if (head == null) {
        head = newNode;
    } else {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }
}

//O(1)
public static void insertAfter(Node head, int val, Node loc) {
    Node newNode = new Node(val, loc.next);
    loc.next = newNode;
}

//O(1)
public static Node deleteFront(Node head) {
    if (head == null) {
        return null;
    }
    Node newHead = head.next;
    head.next = null;
    return newHead;
}

//O(N)
public static void deleteBack(Node head) {
    if (head == null) {
        return;
    }
    if (head.next == null) {
        head = null;
        return;
    }
    Node curr = head;
    while (curr.next.next != null) {
        curr = curr.next;
    }
    curr.next = null;
}

//O(N)
public static Node deleteNode(Node head, Node loc) {
    if (head == null) {
        return null;
    }
    if (head == loc) {
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }
    Node prev = head;
    Node curr = head.next;
    while (curr != null) {
        if (curr == loc) {
            prev.next = curr.next;
            curr.next = null;
            return head;
        }
        prev = curr;
        curr = curr.next;
    }
    return head;
}

//O(N)
public static int length(Node head) {
    int len = 0;
    Node curr = head;
    while (curr != null) {
        len++;
        curr = curr.next;
    }
    return len;
}

//O(N)
public static Node reverseIterative(Node head) {
    Node prev = null;
    Node curr = head;
    while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

//O(N)
public static Node reverseRecursive(Node head) {
    if (head == null || head.next == null) {
        return head;
    }
    Node newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}

