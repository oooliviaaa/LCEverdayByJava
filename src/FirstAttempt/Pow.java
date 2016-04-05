package FirstAttempt;

public class Pow {

	// http://www.programcreek.com/2012/12/leetcode-powx-n/
	public double myPow(double x, int n) {
        if(n >= 0) return pow(x, n);
        else return 1/pow(x, -n);
    }
	
	private double pow(double x, int n) {
		if(n == 0) return 1;
		
		double v = pow(x, n/2);
		
		if(n % 2 == 0){
			return v * v;
		}
		else{
			return v * v * x;
		}
	}
}
