package InterestingQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
public class NamePairing
{
    public static void main(String[] args)
    {
    	List<String> fNames = new ArrayList<String>();
    	fNames.add("John");
        fNames.add("Bob");
        fNames.add("Susan");
//        fNames.add("Arnold");
//        fNames.add("Julia");
        
        List<String> copy = new ArrayList<String>(fNames);
        Random generator = new Random();
                   
        for(int i = 0, remaining = copy.size(); i < fNames.size(); i++, remaining--) {
        	int offset = generator.nextInt(remaining);
        	
        	// If we accidentally pick ourselves, get the next person
        	if(fNames.get(i).equals(copy.get(offset))) {
        		offset = (offset + 1) % remaining; 
        	}
        	          	
        	System.out.println(fNames.get(i) +
        			" <--> " + copy.remove(offset));
        }
    }
}