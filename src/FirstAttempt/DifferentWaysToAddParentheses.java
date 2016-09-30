package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	
	// http://blog.csdn.net/foreverling/article/details/49742089
	/**
	 * 对于输入字符串，若其中有运算符，则将其分为两部分，分别递归计算其值，
	 * 然后将左值集合与右值集合进行交叉运算，将运算结果放入结果集中；
	 * 若没有运算符，则直接将字符串转化为整型数放入结果集中。
	 * */
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < input.length(); i++) {
        	char c = input.charAt(i);
        	
        	if (c == '+' || c == '-' || c == '*') {
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1));
        		
        		for (int l : left) {
        			for (int r : right) {
        				switch (c) {
        				case '+':
        					res.add(l+r);
        					break;
        				case '-':
        					res.add(l-r);
        					break;
        				case '*':
        					res.add(l*r);
        					break;
        				}
        			}
        		}
        	}
        }
        if (res.size() == 0) {   ////////////// 说明string input只剩一个数字了
    		res.add(Integer.parseInt(input));
    	}
        return res;
    }
}
