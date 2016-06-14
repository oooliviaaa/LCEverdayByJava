package random;

public class TimeConvertor {

	public static void main(String[] args) {
		int time = 2;
		String res = timeConvert(time);
		System.out.println(res);
	}
	
	public static String timeConvert(int time) { 
		return time/24/60 + ":" + time/60%24 + ':' + time%60;
	}
}
