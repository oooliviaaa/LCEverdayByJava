package FirstAttempt;

public class ExcelSheetColumnTitle {

	// http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
	public String convertToTitle(int n) {
        if (n <= 0) return "";
        
        StringBuffer res = new StringBuffer();
        while (n > 0) {
        	n -= 1;
        	char c = (char) (n % 26 + 'A');
        	n /= 26;
        	res.insert(0, c);
        }
        return res.toString();
    }
}
