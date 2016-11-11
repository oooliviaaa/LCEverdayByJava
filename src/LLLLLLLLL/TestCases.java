package LLLLLLLLL;

public class TestCases {

	public static void main(String[] args) {
		MyHashtable<Character, Integer> ht = new MyHashtable<Character, Integer>(10);
		
		ht.put('a', 1);
		ht.put('a', 2);
		ht.put('b', 3);
		
		Integer v1 = ht.get('a');
		Integer v2 = ht.get('n');   // 为null，所以要用Integer来接
		Integer v3 = ht.get('b');
		System.out.println(v1 + " " + v2 + " " + v3);
	}
}
