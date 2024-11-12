package LinkedList;

public class MiddleOfTheLinkedList_876 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * 朴素解法：需要两次遍历，链表如果很长会很耗时
         *
         * @param head
         * @return
         */
        public ListNode solution1(ListNode head) {
            ListNode counter = head;
            int l = 0;
            while (counter.next != null) {
                counter = counter.next;
                l++;
            }
            int j = (l + 1) / 2;
            for (int i = 0; i < j; i++) {
                head = head.next;
            }
            return head;
        }

        /**
         * 同向快慢指针：需要考虑出现两个中间点的情况
         * 链表长度为奇数： 当 fast 走到链表「尾节点」时，slow 正好走到「中间节点」。
         * 链表长度为偶数： 当 fast 走到「null」时（越过「尾节点」后），slow 正好走到「第二个中间节点」
         * @param head
         * @return
         */
        public ListNode solution2(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }
}
