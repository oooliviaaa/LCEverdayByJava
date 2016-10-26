package FirstAttempt;

public class AddBinary {

	// http://www.cnblogs.com/springfor/p/3889228.html
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
		
		StringBuffer res = new StringBuffer();
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
        	int p = 0;
        	int q = 0;
        	if (i >= 0) p = a.charAt(i) - '0';
        	if (j >= 0) q = b.charAt(j) - '0';
        	
        	int sum = p + q + carry;
        	carry = sum / 2;
        	res.insert(0, sum%2);
        	
        	i--;
        	j--;
        }
        
        if (carry > 0) res.insert(0, 1);
        return res.toString();
    }
	
	public static void main(String[] args) {
		String a = "101";
		String b = "11";
		AddBinary ab = new AddBinary();
		String c = ab.addBinary(a, b);
		System.out.println(c);
	}

	//////////////
	// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=207120&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3048%5D%5Bvalue%5D%3D2%26searchoption%5B3048%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
	public String solution2(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int aI = i >= 0 ? (a.charAt(i) - '0') : 0;
            int bI = j >= 0 ? (b.charAt(j) - '0') : 0;
            
            int curr = aI ^ bI ^ carry;
            carry = (aI & bI) | (aI & carry) | (bI & carry);
            i--;
            j--;
            res = res.append(curr);
        }
        
        if(carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
