package LinkedQuestion.SelectionSort;

import LinkedQuestion.Node.Node;

/**
 * 单链表的选择排序
 * <p>
 * 给定一个无序单链表的头节点head，实现单链表的选择排序。
 * 要求：额外空间复杂度为O(1)。
 */
public class Solution {
    public Node selectionSort(Node head) {
        Node tail = null;       //排序部分尾部
        Node cur = head;        //未排序部分头部
        Node smallPre = null;   //最小节点的前一个节点
        Node small = null;      //最小的节点
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    //得到未排序部分的最小节点的前一个节点
    public Node getSmallestPreNode(Node head) {
        Node smallestPre = null;
        Node smallest = head;
        Node pre = new Node(0);
        Node cur = head;
        pre.next = cur;
        while (cur != null) {
            if (cur.value < smallest.value) {
                smallest = cur;
                smallestPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallestPre;
    }
}
