package GQuestions;

public class RearrageArrayWithOneExtraSpace {
	
	public void reverseMapping(String[] str, int[] map) {
        for(int i = 0; i < map.length; i++){
            int j = i;
            while(map[j] != i){
                swap(str, j, map[j]);
                int temp = map[j];
                map[j] = j;
                j = temp;
            }
            map[j] = j;   ///// !!!!!
        }
    }
    
    private void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
	
	public static void main(String[] args) {
		String[] words = new String[]{"cat", "rabbit", "dog", "mouse"};
		int[] index = new int[]{2, 0, 3, 1};
		
		RearrageArrayWithOneExtraSpace ra = new RearrageArrayWithOneExtraSpace();
		ra.reverseMapping(words, index);
		for (String s : words) {
			System.out.println(s);
		}
	}
}
