package FirstAttempt;

public class ReadNCharactersGivenRead4II_CallMultipleTimes {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	// http://blog.csdn.net/u013325815/article/details/41892619
	char[] tmp = new char[4];
	int offset = 0; 
	int preLen = 0;
     
    public int read(char[] buf, int n) {
        int count = 0;
    	
    	while (count < n) {
    		if (offset != 0) {
    			while (count < n && offset < preLen) {
    				buf[count++] = tmp[offset++];
    			}
    			if (offset == preLen) offset = 0;   /////// !!!!!
    			else offset %= 4;
    		} else {
    			preLen = read4(tmp);
    			
    			int i = 0;
    			while (count < n && i < preLen) {
    				buf[count++] = tmp[i++];
    			}
    			offset = i % 4;
    			
    			if (preLen < 4) {
    				break;
    			}
    		}
    	}
    	
    	return count;
    }
    
    int read4(char[] buf) {
    	return 4;
    }
}
