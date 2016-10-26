package FirstAttempt;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

	// http://www.programcreek.com/2014/08/leetcode-shuffle-an-array-java/
	
	int[] original;
	int[] shuffle;
	Random r;
	
	public ShuffleAnArray(int[] nums) {
        original = nums;
        shuffle = Arrays.copyOf(nums, nums.length);
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffle = Arrays.copyOf(original, original.length);
        return shuffle;
    }
    
    /** Returns a random shuffling of the array. */
    // 水塘抽样 https://zh.wikipedia.org/wiki/水塘抽樣
    // 我们遍历数组每个位置，每次都随机生成一个坐标位置，然后交换当前遍历位置和随机生成的坐标位置的数字，
    // 这样如果数组有n个数字，那么我们也随机交换了n组位置，从而达到了洗牌的目的
    public int[] shuffle() {
    	int len = shuffle.length;
        for (int i = 0; i < len; i++) {
        	int random = r.nextInt(len - i);
        	int tmp = shuffle[i];
        	shuffle[i] = shuffle[random+i];
        	shuffle[random+i] = tmp;
        }
        return shuffle;
    }
	
}
