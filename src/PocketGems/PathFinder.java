package PocketGems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class PathFinder {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
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

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) {
        List<String> res = new ArrayList<String>();
        HashMap<String, String[]> hm = new HashMap<String, String[]>();
        HashSet<String> set = new HashSet<String>();
        String start = "";
        String end  = "";
        
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if(i == 0) {
                start = line.split("\\s+")[0].trim();
                end = line.split("\\s+")[1].trim();
            }
            else {
                String node = line.split(":")[0].trim();
                String[] neighbors = line.split(":")[1].split("\\s+");
                hm.put(node, neighbors);
            }
        
        }
        helper(start, end, hm, res, "", set);
        return res;
    }
    
    static void helper(String node, String end, HashMap<String, String[]> hm,
                       List<String> res, String tmp, HashSet set) {
        if(node == null || node.trim().length() == 0) return;
        set.add(node);
        node = node.trim();
        tmp += (node);
        if(node.equals(end)) {
            res.add(tmp.substring(2));
            return;
        }
        
        String[] neighbors = null;
        if(hm.containsKey(node)) {
            neighbors = hm.get(node);
        }
        else return;
        for(String neighbor : neighbors) {
            if(set.contains(neighbor)) continue;
            else {
                set.add(neighbor);
                helper(neighbor, end, hm, res, tmp, set);
                set.remove(neighbor);
            }
            
        }
    }
}