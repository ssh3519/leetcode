package com.ssh.leetcode.day01;

/**
 * @description 两数相加
 * @author: ssh
 * @Date: 2020/10/20 14:34
 */
public class Solution02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        StringBuilder res = new StringBuilder();
        while (listNode!=null){
            res.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        System.out.println(res.toString().substring(0,res.length()-2));
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null){
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

class ListNode {
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
}
