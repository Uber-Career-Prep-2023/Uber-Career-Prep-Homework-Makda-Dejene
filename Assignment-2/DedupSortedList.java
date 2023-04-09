//LinkedList traversal
//time complexity: O(N) and space complexity: O(1)

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public ListNode removeDuplicates(ListNode head) {
    if (head == null) {
        return head;
    }
    
    ListNode curr = head;
    
    while (curr.next != null) {
        if (curr.val == curr.next.val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }
    
    return head;
}
