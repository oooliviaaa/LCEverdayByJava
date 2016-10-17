package FirstAttempt;

public class ValidWordAbbreviation {

	
	public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) return false;
        
        int i = 0;
        int j = 0;
        while (i < abbr.length() && j < word.length()) {        	
        	char a = abbr.charAt(i);
        	char b = word.charAt(j);
        	if (!Character.isDigit(a)) {
        		if (a != b) return false;
        		i++;
        		j++;
        	} else {
        		if (a == '0') return false;
        		int num = 0;
        		while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
        			num = num * 10 + Character.getNumericValue(abbr.charAt(i));
        			i++;
        		}
        		j += num;
        	}
        }
        
        return i == abbr.length() && j == word.length();
    }
	
	public static void main(String[] args) {
		String[][] tests = {{"internationalization","i12iz4n", "true"}, {null, null, "false"}, {"a", "01", "false"}};
		
		ValidWordAbbreviation vw = new ValidWordAbbreviation();
		
		for (String[] test : tests) {
			String word = test[0];
			String abbr = test[1];
			String result = test[2];
			boolean res = vw.validWordAbbreviation(word, abbr);
			System.out.println("result expect:" + result + ", actually: " + res);
		}
		
		
	}
}
