package Pointers;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        MergeTwoSortedLists_21 lists_21 = new MergeTwoSortedLists_21();
        ListNode list1 = new ListNode(1, new ListNode(6, new ListNode(7, new ListNode(9, null))));
        ListNode list2 = new ListNode(0, new ListNode(3, new ListNode(9, new ListNode(10, null))));
        System.out.println(lists_21.mergeTwoLists2(list1, list2));
    }


    /**
     * iteration: create a dummy head node to connect the sorted part
     * @param list1
     * @param list2
     * @return head.next
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();//this node is the first node
        /**
          the entry point into a linked list is called the head of the list.
          the head is not a separate node but the reference to the first node.
         */
        ListNode head = node;//and this is not a new node, cos we don't use new ListNode(), it's just a reference
        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        return head.next;
    }

    /**
     * recursion: don't need to care how the recursion works, remember to return the original part of the recursion
     * @param list1
     * @param list2
     * @return
     *
     * 递归的核心在于, 我只关注我这一层要干什么, 返回什么, 至于我的下一层(规模减1), 我不管, 我就是甩手掌柜.
     *
     * 好,现在我要merge L1,L2.我要怎么做?
     *
     * 显然,如果L1空或L2空,我直接返回L1或L2就行,这很好理解.
     * 如果L1第一个元素小于L2的? 那我得把L1的这个元素放到最前面,至于后面的那串长啥样 ,我不管. 我只要接过下级员工干完活后给我的包裹, 然后把我干的活附上去(令L1->next = 这个包裹)就行
     * 这个包裹是下级员工干的活,即merge(L1->next, L2)
     * 我该返回啥?
     *
     * 现在不管我的下一层干了什么,又返回了什么给我, 我只要知道,假设我的工具人们都完成了任务, 那我的任务也就完成了,可以返回最终结果了
     * 最终结果就是我一开始接手的L1头结点+下级员工给我的大包裹,要一并交上去, 这样我的boss才能根据我给它的L1头节点往下找,检查我完成的工作
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list2.next, list1);
            return list2;

        }
    }



    private static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
