package com.ssh.leetcode.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 无重复字符的最长子串
 * @author: ssh
 * @Date: 2020/10/20 15:32
 */
public class Solution03 {
    public static void main(String[] args) {
        int count = lengthOfLongestSubstring("abcabcbb");
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            max = Math.max(max,i-left+1);
            map.put(c,i);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
