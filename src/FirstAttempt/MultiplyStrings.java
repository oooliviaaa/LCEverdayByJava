package FirstAttempt;

public class MultiplyStrings {

	// http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
	public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
		
		// reverse two String
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        // multiply each digit and sum at the corresponding positions
        int[] d = new int[s1.length() + s2.length()];
        for(int i = 0; i < s1.length(); i++) {
        	for(int j = 0; j < s2.length(); j++) {
        		d[i+j] += (s1.charAt(i)-'0') * (s2.charAt(j)-'0');
        	}
        }
        
        // calculate each digit
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < d.length; i++) {
        	int sum = d[i] + carry;
        	carry = sum / 10;
        	sum %= 10;
        	sb.insert(0, sum);  ////// insert from the front
        }
        
        if(carry > 0) sb.insert(0, carry);
        
        //remove front 0's, eg. "0 * 0 = 00"
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "99";
		MultiplyStrings ms = new MultiplyStrings();
		String res = ms.multiply(num1, num2);
		System.out.println(res);
	}
}
