package FirstAttempt;

public class ReadNCharactersGivenRead4 {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	
	// https://segmentfault.com/a/1190000003794420
	// http://blog.csdn.net/u013325815/article/details/41892135
    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i+=4) {
        	char[] tmp = new char[4];
        	int len = read4(tmp);
        	for (int j = 0; j < len && i+j < n; j++) {  // 因为有可能取出来4个，但是取多了，i+4>n了，一共只需要n个
        		buf[i+j] = tmp[j];
        	}
        	
        	if (len < 4) {
        		return Math.min(i+len, n);  // 因为有可能取出来4个，但是取多了，i+4>n了，一共只需要n个
        	}
        }
        return n;
    }
    
    
    int read4(char[] buf) {
    	return 4;
    }
}
