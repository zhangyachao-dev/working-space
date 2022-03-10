package com.zyc.arithmetic.leetcode.question02;

/**
 * 1 -> 2 > 3
 * 4 -> 8 > 6
 *
 * 5 -> 0 -> 0 -> 1
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4))));
        ListNode result = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 注意事项：
        // 1、链表为空判断，2个为空，1个为空
        // 2、进位处理
        // 3、2个链表同时结束，进位大于0，则需要新增节点

        ListNode result = new ListNode(0);
        ListNode p = result;
        // 表示进位
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0){
            int sum = (l1 == null ? 0 : l1.val) + (l2== null ? 0 : l2.val) + carry;

            int tmp = sum % 10;

            carry = sum / 10;
            p.next = new ListNode(tmp);
            p = p.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return result.next;
    }

}
