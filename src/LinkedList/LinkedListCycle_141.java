package LinkedList;

/**
 * 环形链表模板题，快慢指针，相遇表示有环
 */
public class LinkedListCycle_141 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            // if(head == null) return false;
            ListNode runner = head;
            ListNode walker = head;
            //DP LinkedList Note the condition: only if the node is not null, then .next is valid
            //or NullPointerException occurs (指针可以指向null，但是指针本身为null不能操作.next)
            //when runner != null && runner.next != null,
            //runner.next and runner.next.next are valid
            while (runner != null && runner.next != null) {
                runner = runner.next.next;
                walker = walker.next;
                if (runner == walker) return true;
            }
            return false;
        }
    }
}
