class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // If one of the lists is not exhausted, append the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // Example 1:
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        printList(mergedList1);  // Output: [1,1,2,3,4,4]

        // Example 2:
        ListNode list3 = null;
        ListNode list4 = null;

        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        printList(mergedList2);  // Output: []

        // Example 3:
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);

        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        printList(mergedList3);  // Output: [0]
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
