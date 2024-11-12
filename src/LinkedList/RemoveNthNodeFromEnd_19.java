package LinkedList;

/**
 * 1. 两次遍历，先算出所有节点数量，找出倒数第n个节点的前一个节点
 * 2. 一次遍历，快慢指针直接找到
 */
public class RemoveNthNodeFromEnd_19 {
    private class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode solution1(ListNode head, int n){
        int count = 0;
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        // 为了让prev走到最后一个节点就停止，不能再往后走了
        // 终止条件不能是 prev != null
        while(prev.next != null){
            prev = prev.next;
            count++;
        }
        if(count == 1) return null;
        ListNode prevv = dummy;
        for(int i = 0; i < count - n; i++){
            prevv = prevv.next;
        }
        ListNode temp = prevv.next.next;
        prevv.next = temp;
        return dummy.next;
    }

    /**
     * 快慢指针，一次遍历！一定要画图，很容易找错！！
     * 快指针先走n步，之后再一起走，这样快慢指针之间就形成了一个长度为n-1的窗口（间隔n-1个节点）
     * 之后快慢指针同步相当于保持窗口长度不变，这样当快指针到达最后一个节点时，慢指针正好指向被删除的前一个节点
     * @param head 链表的第一个节点
     * @param n 倒数第n个
     * @return 删除后的链表
     */
    public ListNode solution2(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        // 这里找到的是删除节点的前一个节点！
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next.next;
        slow.next = temp;
        return dummy.next;
    }
}
