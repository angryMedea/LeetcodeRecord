package LinkedList;

/**
 * 分别用单链表和双链表实现
 */
public class DesignLinkedList_707 {
    class SingleList {
        int size;
        ListNode head;

        public SingleList(int size, ListNode head) {
            this.size = 0;
            this.head = new ListNode(-1);
        }

        public void addAtIndex(int index,int val){
            if(index < 0 || index > size) return;
            size++;
            ListNode prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            ListNode temp = new ListNode(val);
            temp.next = prev.next;
            prev.next = temp;
        }

        public void deleteAtIndex(int index){
            if(index < 0 || index >= size) return;
            size--;
            ListNode prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }

        public int get(int index){
            if(index < 0 || index >= size) return -1;
            ListNode cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        private class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }

            public ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }

    // 双链表在查找位置时更快，所以时间复杂度更优
    class DoubleList{
        int size;
        ListNode head;
        ListNode tail;

        public DoubleList(int size, ListNode head, ListNode tail) {
            this.size = 0;
            this.head = new ListNode(-1);
            this.tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        // i为下标为index的新节点的前驱节点，j为下标为index的旧节点
        public void addAtIndex(int index,int val){
            if(index < 0 || index > size) return;
            DoubleList.ListNode i,j;
            // 看index离head还是tail更近
            if(index < size - index){
                i = head;
                for (int k = 0; k < index; k++) {
                    i = i.next;
                }
                j = i.next;
            }else{
                j = tail;
                for (int k = 0; k < size - index; k++) {
                    j = j.prev;
                }
                i = j.prev;
            }
            size++;
            ListNode temp = new ListNode(val);
            temp.prev = i;
            temp.next = j;
            i.next = temp;
            j.prev = temp;
        }

        // i为要删除节点的前驱节点，j为后继结点
        public void deleteAtIndex(int index){
            if(index < 0 || index >= size) return;
            DoubleList.ListNode i,j;
            if(index < size - index){
                i = head;
                for (int k = 0; k < index; k++) {
                    i = i.next;
                }
                j = i.next.next;
            }else{
                j = tail;
                for (int k = 0; k < size - index - 1; k++) {
                    j = j.prev;
                }
                i = j.prev.prev;
            }
            size--;
            i.next = j;
            j.prev = i;
        }

        public int get(int index){
            if(index < 0 || index >= size) return -1;
            DoubleList.ListNode curr;
            // 说明index离head更近
            if(index + 1 < size - index){
                curr = head.next;
                for (int i = 0; i < index; i++) {
                    curr = curr.next;
                }
            }else{
                curr = tail.prev;
                for (int i = 0; i < size - index - 1; i++) {
                    curr = curr.prev;
                }
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }


        private class ListNode {
            int val;
            DoubleList.ListNode next;
            DoubleList.ListNode prev;

            public ListNode(int val) {
                this.val = val;
            }

        }
    }


}
