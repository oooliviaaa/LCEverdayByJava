package FirstAttempt.FirstBadVersion;

public class FirstBadVersion extends VersionControl {

	public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
        	int mid = left + (right - left) / 2;   ////// 当数字特别大时，直接写成(left+right)/2会exceed limit，所以要这样分开写
        	if (isBadVersion(mid)) {
        		right = mid;
        	} else {
        		left = mid+1;
        	}
        }
        return left;
    }

	@Override
	boolean isBadVersion(int version) {
		if (version >= 1702766719) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		FirstBadVersion fb = new FirstBadVersion();
		int res = fb.firstBadVersion(2126753390);
		System.out.print(res);
	}
}
