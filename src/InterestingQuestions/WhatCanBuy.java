package InterestingQuestions;

import java.util.ArrayList;
import java.util.List;

public class WhatCanBuy {

	public static void main(String[] args) {
		int[] prices = new int[]{4,5,3,6};
		int money = 20;
		WhatCanBuy wb = new WhatCanBuy();
		List<ArrayList<Integer>> res = wb.findPlans(prices, money);
		
		for(List<Integer> r : res) {
			for(int i : r) {
				System.out.print(i + " ");
			}
			System.out.println("\n ~~~ ");
		}
	}
	
	
	// Method 1: DFS
	public List<ArrayList<Integer>> findPlans(int[] prices, int money) {
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (prices == null || prices.length < 1 || money <= 0) {
            return res;
        }
		
		helper(prices, money, new ArrayList<Integer>(), res);
		
		return res;
	}
	
	private void helper(int[] prices, int money, ArrayList<Integer> tmp, List<ArrayList<Integer>> res) {
		if(money == 0) {
			ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp);
			res.add(newTmp);
			return;
		} else if(money < 0) {
			return;
		}
		
		for(int i = 0; i < prices.length; i++) {
			int p = prices[i];
			if(p <= money) {
				tmp.add(i);
				helper(prices, money-p, tmp, res); 
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	// Method 2: Grab or go - Shuai
	// https://github.com/LuShuai/JavaEveryday/blob/master/src/someTest/PurchasePlans.java
	
	
}
