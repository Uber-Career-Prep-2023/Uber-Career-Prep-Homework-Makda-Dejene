//LinkedList fast slow pointers
//time complexity: O(N) space complexity: O(1)

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public void disconnectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return;
    }

   
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            break;
        }
    }

    
    if (slow != fast) {
        return;
    }

 
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    while (fast.next != slow) {
        fast = fast.next;
    }
    fast.next = null;
}
