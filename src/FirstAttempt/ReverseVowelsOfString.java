package FirstAttempt;

public class ReverseVowelsOfString {

	
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        
        int i = 0;
        int j = s.length()-1;
        
        char[] arr = s.toCharArray();
        while (i < j) {							  ///// String里面找char时，不能用contains(), 只能用indexOf()； 
        	if (vowels.indexOf(arr[i]) == -1) {   //// 且最好不用while，会out of bound，否则还要check
        		i++;
        	} else if (vowels.indexOf(arr[j]) == -1) {
        		j--;
        	} else {
        		char t = arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
        	    j--;
        	}
        }
        return new String(arr);
    }
}
