package hanoi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
	
	public static void main(String[] args){
//        int n;
//        BufferedReader buf;
//        buf = new BufferedReader(new InputStreamReader(System.in));
//        
//        System.out.println("Please input the number of disk ");
//        n = Integer.parseInt(buf.readLine());
        int n = 3;
        //solution hanoi = new solution();
        move(n,'A','B','C');
    }
	
	public static void move(int n, char a, char b, char c){
		
		
		if(n == 1){
			System.out.println("Disk " + n + " from " + a + " to " + c);
		}
		else{
			move(n - 1, a, c, b); //move the top n-1 disks to the temporary disk - b
			System.out.println("Disk " + n + " from " + a + " to " + c); //then move the most heavy one - n to the final disk - c
			move(n - 1, b, a, c); //finally move the rest n-1 disks to the final disk - c
		}
	}

}
