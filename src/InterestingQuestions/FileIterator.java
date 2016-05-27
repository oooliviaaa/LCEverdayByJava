package InterestingQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterable<String> {

	private BufferedReader r;

    public FileIterator(BufferedReader r) {
        this.r = r;
    }
    
	public Iterator<String> iterator() {
		return new Iterator<String>() {

            public boolean hasNext() {
                try {
                    r.mark(1);
                    if (r.read() < 0) {
                        return false;
                    }
                    r.reset();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }

            public String next() {
                try {
                    return r.readLine();
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
