package LinkedList;

import java.util.List;

/**
 * Look for the node where the cycle begins
 * 解法关键点：相遇点到环的起点和头结点到环的起点距离是一样的
 * 为什么？看笔记
 */
public class LinkedListCycle_142 {
    private class ListNode {
        int val;
        LinkedListCycle_142.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode hasCycle(LinkedListCycle_142.ListNode head) {
            LinkedListCycle_142.ListNode runner = head;
            LinkedListCycle_142.ListNode walker = head;

            while (runner != null && runner.next != null) {
                runner = runner.next.next;
                walker = walker.next;
                if (runner == walker){
                    ListNode m = runner;
                    ListNode n = head;
                    while(m != n){
                        m = m.next;
                        n = n.next;
                    }
                    return m;
                }
            }
            return null;
        }
    }
}
