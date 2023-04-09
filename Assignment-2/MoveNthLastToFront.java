//LinkedList fast-slow two pointer
//time complexity: O(N) and space complexity: O(1)

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public ListNode moveNthLastToFront(ListNode head, int n) {
    if (head == null || head.next == null) {
        return head;
    }

 
    ListNode slow = head;
    ListNode fast = head;

  
    for (int i = 0; i < n; i++) {
        if (fast.next == null) {
            return head;
        }
        fast = fast.next;
    }


    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }

 
    ListNode prev = null;
    ListNode curr = head;
    while (curr != slow) {
        prev = curr;
        curr = curr.next;
    }
    prev.next = prev.next.next;
    curr.next = head;
    head = curr;

    return head;
}

