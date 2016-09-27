package random;

public class RegularExpressionMatch_Wei {
	public static boolean regex(String content, String pattern) {
        char[] patternChars = pattern.toCharArray();
        char[] contentChars = content.toCharArray();
        int contentArrayLength = contentChars.length;
        int contentArrayIndex = 0;
        char precedent = '\u0000';
        for (char c : patternChars) {
            if (contentArrayIndex >= contentArrayLength) {
                return false;
            }
            switch (c) {
                case '.':
                    contentArrayIndex++;
                    break;
                case '*':
                    if (precedent == '\u0000'){
                        return false;
                    }
                    if (precedent == '*') {
                        return false;
                    }
                    if (precedent == '.') {
                        contentArrayIndex--;
                    }
                    while (contentArrayIndex < contentArrayLength && (contentChars[contentArrayIndex] == precedent || precedent == '.')) {
                        contentArrayIndex++;
                    }
                    break;
                default:
                    if (contentChars[contentArrayIndex] == c) {
                        contentArrayIndex++;
                    } else {
                        return false;
                    }
                    break;

            }
            precedent = c;
        }
        if (contentArrayIndex == contentArrayLength) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	
    	System.out.println("expect " + true + ", actual " + regex("abc", "a.*c"));
        System.out.println("expect " + true + ", actual " + regex("abc", "abc"));
        System.out.println("expect " + true + ", actual " + regex("abc", "a.."));
        System.out.println("expect " + true + ", actual " + regex("abc", "..."));
        System.out.println("expect " + true + ", actual " + regex("aaa", "a*"));
        System.out.println("expect " + true + ", actual " + regex("aaa", ".*"));
        System.out.println("expect " + true + ", actual " + regex("aaa", "a.*"));

        System.out.println("expect " + false + ", actual " + regex("aaa", ".*a"));
        System.out.println("expect " + false + ", actual " + regex("cba", "abc"));
        System.out.println("expect " + false + ", actual " + regex("cba", ".ca"));
        System.out.println("expect " + false + ", actual " + regex("cba", "*"));
        System.out.println("expect " + false + ", actual " + regex("cba", ".c*"));
        System.out.println("expect " + false + ", actual " + regex("cba", ".**"));
        System.out.println("expect " + false + ", actual " + regex("cba", ".*."));
        System.out.println("expect " + false + ", actual " + regex("cba", "*.."));
    }
}
