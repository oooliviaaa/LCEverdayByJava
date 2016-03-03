package PocketGems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.text.ParseException;

public class LogParser {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_2_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    static String parseLines(String[] lines) {
        if(lines == null || lines.length == 0) return "0%";
        
        long runTime = 0; long connectTime = 0;
        long start = 0; long end = 0;
        Stack<String> s = new Stack<String>();
        
        for(String line : lines) {
            String action = line.split("::")[1].trim();
            String time = line.split("::")[0].replaceAll("\\(", "");
            time = time.replaceAll("\\)", "").trim();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
            long timestamp = 0;
            try{
                timestamp = sdf.parse(time).getTime();
            } catch(ParseException e) {
                e.printStackTrace();
            }
            if(action.equals("START")) start = timestamp;
            else if(action.equals("SHUTDOWN")) {
                end = timestamp;
                runTime = end - start;
                System.out.println(end + " 111 " + start);
                break;
            }
            else if(action.equals("CONNECTED")) s.push(String.valueOf(timestamp));
            else if(action.equals("DISCONNECTED")) {
                if(s.isEmpty()) continue;
                long conn = Long.parseLong(s.pop(), 10);
                connectTime += (timestamp - conn);
            }
        }
        if(!s.isEmpty()) {  // could be CONNECTED --> SHUTDOWN
        	long conn = Long.parseLong(s.pop(), 10);
            connectTime += (end - conn);
        }
        
        System.out.println(runTime + "   " + connectTime);
        if(runTime == 0) return "0%";
        else{
            int resInt = (int)((double)connectTime / (double)runTime * 100);
            return Integer.toString(resInt) + "%";
        }
    }
}

