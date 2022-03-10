package com.zyc.arithmetic.leetcode.question03;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class StringCheck {
    public static void main(String[] args) {
        StringCheck stringCheck = new StringCheck();
        System.out.println(stringCheck.check5("abbbs"));
    }

    /**
     * abcabcbb
     * @param s
     */
    private int check(String s){
        String[] chars = s.split("");
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = 0;
            String tmp = chars[i];
            if(!"".equals(s) && i == chars.length -1 && result == 0){
                result = chars.length;
            }
            for (int j = i + 1; j < chars.length; j++) {
                num++;
                if(tmp.equals(chars[j])){
                    if(result < num){
                        result = num;
                    }
                    break;
                }
                if(j == chars.length - 1 && result < num + 1){
                    result = num + 1;
                }
            }
        }
        return result;
    }

    private int check2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    private int check3(String s){
        if (s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    private int check4(String s){
        int n = s.length();
        List<Character> characters = new ArrayList<>();
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < n; i++){
            if(characters.contains(s.charAt(i))){
                int rk = characters.indexOf(s.charAt(i));
                ans.add(new Integer(characters.size()));
                characters.clear();
                i = rk;
                continue;
            }
            characters.add(s.charAt(i));
            if(!(i + 1 < n)){
                ans.add(new Integer(characters.size()));
            }
        }
        List<Integer> collect = ans.stream().sorted().collect(Collectors.toList());
        return collect.size() > 0 ? collect.get(collect.size() - 1) : 0;
    }

    private int check5(String s) {
        int len = 0;
        int n = s.length();
        Queue<Character> queue = new ArrayBlockingQueue<>(n);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(queue.contains(c)){
                len = Math.max(len, queue.size());
                queue.poll();
                queue.offer(c);
            }else{
                queue.offer(c);
                len = Math.max(len, queue.size());
            }
        }
        return len;
    }

}
