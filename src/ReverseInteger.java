
public class ReverseInteger {

	public int reverse(int x) {
	        long answer = 0;
	        while(x != 0) {
	            answer = 10 * answer + x % 10;
	            x /= 10;
	        }
	        return (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) ? 0 : (int) answer;
    }
}
