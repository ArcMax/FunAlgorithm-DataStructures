package LeetCode;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class MergeKList {
    static ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }

    public static void main(String[] args){

    }
}
