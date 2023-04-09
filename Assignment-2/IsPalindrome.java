//LinkedList forward backward two pointer
//time complexity: O(N) space complexity: O(1)

public class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int x) { val = x; }
}

public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
        return true;
    }


    ListNode left = head;
    ListNode right = head;
    while (right.next != null) {
        right = right.next;
    }


    while (left != right && right.next != left) {
        if (left.val != right.val) {
            return false;
        }
        left = left.next;
        right = right.prev;
    }

    return true;
}
