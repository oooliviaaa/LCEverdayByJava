package FirstAttempt;

public class CompareVersionNumbers {

	// http://www.cnblogs.com/anne-vista/p/4827951.html
	public int compareVersion(String version1, String version2) {
		String delimiter = "\\.";
		String[] v1 = version1.split(delimiter);
        String[] v2 = version2.split(delimiter);
                
        int i = 0;
        for (; i < v1.length && i < v2.length; i++) {
        	int a = Integer.parseInt(v1[i]);
        	int b = Integer.parseInt(v2[i]);
        	if (a > b) return 1;
        	if (a < b) return -1;
        }
        
        while (i < v1.length) {
        	if (Integer.parseInt(v1[i]) > 0) {
        		return 1;
        	}
        	i++;
        }
        
        while (i < v2.length) {
        	if (Integer.parseInt(v2[i]) > 0) {
        		return -1;
        	}
        	i++;
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		String version1 = "1.0.1";
		String version2 = "1";
		
		CompareVersionNumbers cv = new CompareVersionNumbers();
		int res = cv.compareVersion(version1, version2);
		System.out.println(res);
	}
}
