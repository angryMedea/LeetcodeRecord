package LinkedList;

/** 和206基本一样，注意以下问题：
 * 1.虚拟头结点到底是什么？
 * 2.什么时候终止移动指针？
 */
public class swapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        // 链表为空or只有一个节点的edge case
        if(head == null || head.next == null) return head;
        // 必须设置一个虚拟头结点，否则无法返回原有链表，不能直接返回head！！
        // 因为交换后，原来的head被换到后面去了，新的头结点变化了！！
        // 记牢！！dummy.next是动态的！！
        // head是链表的第一个元素，虚拟头结点是指向head的，是head前的元素！！
        ListNode dummy = new ListNode(0,head);

        // dummy本身用来返回不能动，要另外设置可以move的动态指针
        ListNode prev = dummy;
        ListNode curr = head;

        // 终止条件，后面的执行代码涉及到了.next和.next.next
        // 所以条件中必须保证节点本身和节点的next不为null
        // 也就是说判断终止条件是执行节点中前一个节点的非空判断！！
        while(curr != null && curr.next != null){
            ListNode temp = curr.next.next;
            prev.next = curr.next;
            // 这一步很诡异，说白了就是让自己的下一个节点反过来再指向自己
            curr.next.next = curr;
            curr.next = temp;
            // 这里注意是跳两步，prev指向的是要交换的节点的前一个节点
            prev = prev.next.next;
            curr = prev.next;
        }
        // 最后返回一定是动态的dummy.next
        return dummy.next;
    }

    private class ListNode{
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
}
