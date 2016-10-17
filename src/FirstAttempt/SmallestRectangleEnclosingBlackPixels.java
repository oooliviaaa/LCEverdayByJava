package FirstAttempt;

public class SmallestRectangleEnclosingBlackPixels {

	/** http://www.cnblogs.com/yrbbest/p/5050022.html
	 * 
	 * 找到包含所有black pixel的最小矩形。这里我们用二分查找。
	 * 因为给定black pixel点(x，y)，并且所有black pixel都是联通的，以row search为例， 
	 * 所有含有black pixel的column，映射到row x上时，必定是连续的。
	 * 这样我们可以使用binary search，在0到y里面搜索最左边含有black pixel的一列。
	 * 接下来可以继续搜索上下和右边界。搜索右边界和下边界的时候，其实我们要找的是第一个'0'，所以要传入一个boolean变量searchLo来判断。
	 * 
	 * Time Complexity - O(mlogn + nlogm)， Space Complexity - O(1)
	 * 
	 * top = search row [0...x], find first row contain 1,
	 * bottom = search row[x+1, row], find first row contian all 0
	 * left = search col[0...y], find first col contain 1,
	 * right = search col[y+1, col], find first col contain all 0
	 * 
	 * */
	public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        int row = image.length;
        int col = image[0].length;
        
        int left = horizontalBinarySearch(image, 0, y, 0, row, true);    // 找第一个1
        int right = horizontalBinarySearch(image, y, col, 0, row, false);   // 找右边第一个0
        int top = verticalBinarySearch(image, 0, x, left, right, true);   // 找上面第一个1
        int bottom = verticalBinarySearch(image, x+1, row, left, right, false); // 找下面第一个0
        
        return (right - left) * (bottom - top);
    }
	
	private int horizontalBinarySearch(char[][] image, int i, int j, int lowx, int highx, boolean isMin) {
		while (i < j) {
			int mid = (i+j) / 2;
			boolean hasPixel = false;
			for (int x = lowx; x < highx; x++) {
				if (image[x][mid] == '1') {
					hasPixel = true;
					break;
				}
			}
			
			if (hasPixel == isMin) {
				j = mid;
			} else {
				i = mid+1;
			}
		}
		return i;
	}

	
	private int verticalBinarySearch(char[][] image, int i, int j, int lowy, int highy, boolean isMin) {
		while (i < j) {
			int mid = (i + j) / 2;
			boolean hasPixel = false;
			for (int y = lowy; y < highy; y++) {
				if (image[mid][y] == '1') {
					hasPixel = true;
				}
			}
			
			if (hasPixel == isMin) {
				j = mid;
			} else {
				i = mid+1;
			}
		}
		return i;
	}
}
