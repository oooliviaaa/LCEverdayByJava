package LLLLLLLLL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
//import java.util.Scanner;

public class TextFile implements Iterable<String>{
    
    private BufferedReader br;
//    private Scanner scanner;

    public TextFile(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
//            scanner = new Scanner(new FileReader(fileName));
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {

		    public boolean hasNext() {
		        try {
		            br.mark(1);
		            if (br.read() < 0) {
		                return false;
		            }
		            br.reset();
		            return true;
		        } catch (IOException e) {
		            return false;
		        }
		    }
		
		    public String next() {
		        try {
		            return br.readLine();
		        } catch (IOException e) {
		            return null;
		        }
		    }
		    
		    public void remove() {
		        throw new UnsupportedOperationException();
		    }
        };
    }
}

