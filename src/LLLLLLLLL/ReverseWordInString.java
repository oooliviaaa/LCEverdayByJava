package LLLLLLLLL;

public class ReverseWordInString {
	public String reverse(String s) {
		if (s == null || s.trim().length() == 0) return s;
		
		char[] array = s.trim().toCharArray();
		reverseArray(array, 0, array.length-1);
		int p = 0;
		int q = 0;
		while (q < array.length) {
			while (q < array.length && array[q] != ' ') q++;
			reverseArray(array, p, q-1);
			p = q+1;
			while (p < array.length && array[p] == ' ') p++;
			q = p;
		}
		reverseArray(array, p, q-1);
		return new String(array);
	}
	
	private void reverseArray(char[] array, int i, int j) {
		while (i < j) {
			char tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		ReverseWordInString rw = new ReverseWordInString();
		String s = "  i love pineapple    pen apple   ";
		String res = rw.reverse(s);
		System.out.println(res);
	}
}
