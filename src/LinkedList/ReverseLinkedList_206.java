package LinkedList;

/**
 * 双指针法：
 * 1. 双指针什么时候停止移动？怎么移动？
 * 2. 如何指向没有连接的节点？

 * 递归法：算了 好难理解
 */
public class ReverseLinkedList_206 {
    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode solution1(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        // 要考虑清楚这个终止的条件
        // 直接从头结点开始往后移动
        while(cur != null){
            // 用临时节点保存没有连接的点
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode solution2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode res = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
