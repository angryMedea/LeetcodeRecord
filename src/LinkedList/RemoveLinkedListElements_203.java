package LinkedList;

public class RemoveLinkedListElements_203 {

    class ListNode{
        int val;
        ListNode next;
        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 设置虚拟头结点例题
     * @param head 头结点
     * @param val 节点的值
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(prev.next != null){
            // 注意，这里判断结点的值是否和目标值相等的时候
            // 如果当前节点的next是相等的，在把指针的next指向next.next之后
            // 不能移动指针了！！
            // 因为可能连续的两个节点都是和目标值相等的
            // 如果移动了指针，就可能错过判断当前的prev.next
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else // 这里一定要加else，不能一直移动prev这个指针，否则会错过连续相等的node
                prev = prev.next;
        }
        // 注意，不能返回head！！！head可能被删了已经
        return dummy.next;
    }
}
