package Pointers;

public class RemoveElements_203 {
    public static void main(String[] args) {
//        ListNode1 head = new ListNode1(1,new ListNode1(2,new ListNode1(6,new ListNode1(3,new ListNode1(4, new ListNode1(5, new ListNode1(6,null)))))));
//        ListNode1 head = new ListNode1(1,new ListNode1(1,new ListNode1(1,new ListNode1(1,null))));
        ListNode1 head = null;
        System.out.println(removeElements(head, 6));
    }
    public static ListNode1 removeElements(ListNode1 head, int val) {
        ListNode1 dummy = new ListNode1(-1);
        dummy.next = head;
        ListNode1 temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                    continue;
                } else{
                    temp.next = null;
                    break;
                }
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val,ListNode1 next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode1{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


