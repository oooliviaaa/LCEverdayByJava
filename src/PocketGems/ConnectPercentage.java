package PocketGems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class ConnectPercentage {

	public double solution(String txtFile) throws IOException, ParseException {
		
		BufferedReader br = new BufferedReader(new FileReader(txtFile));
	    String line = br.readLine();
	    long runTime = 0; long connectedTime = 0;
	    Stack<String> s_run = new Stack<String>();
	    Stack<String> s_conn = new Stack<String>();
	    while(line != null) {
	        String action = line.split("::")[1].trim();
	        String time = line.split("::")[0].replaceAll("\\(", "");
	        time = time.replaceAll("\\)", "").trim();
	        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
	        long timestamp = sdf.parse(time).getTime();

	        if(action.equals("START")) {
	        	s_run.push(String.valueOf(timestamp));
	        }
	        else if(action.equals("END")) {
	        	if(s_run.isEmpty()) continue;
	        	else {
	        		long start = Long.parseLong(s_run.pop(), 10);
	        		runTime += (timestamp - start);
	        	}
	        }
	        else if(action.equals("CONNECTED")) {
	        	s_conn.push(String.valueOf(timestamp));
	        }
	        else if(action.equals("DISCONNECTED")) {
	        	if(s_conn.isEmpty()) continue;
	        	else {
	        		long conn = Long.parseLong(s_conn.pop(), 10);
	        		connectedTime += (timestamp - conn);
	        	}
	        }
	    	line = br.readLine();
	    }
	    br.close();
	    System.out.println(runTime + " === " + connectedTime);
	    if(runTime == 0) return 0;
	    else return (double) connectedTime/ (double)runTime * 100;
	}
	
	public static void main(String[] args) {
		ConnectPercentage cp = new ConnectPercentage();
		try {
			double res = cp.solution("log.txt");
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
