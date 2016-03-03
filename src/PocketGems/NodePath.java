package PocketGems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NodePath {

	
	public List<String> solution(String txtFile) throws IOException {
		List<String> res = new ArrayList<String>();
		HashMap<String, String[]> hm = new HashMap<String, String[]>();
		BufferedReader br = new BufferedReader(new FileReader(txtFile));
	    String line = br.readLine();
	    String start = line.split("\\s+")[0].trim();
	    String end = line.split("\\s+")[1].trim();
	    line = br.readLine();
	    while(line != null) {
	        String node = line.split(":")[0].trim();
	        String[] neighbors = line.split(":")[1].split("\\s+");
	        hm.put(node, neighbors);
	    	line = br.readLine();
	    }
	    br.close();
		helper(start, end, hm, res, "");
		return res;
	}
	
	private void helper(String node, String end, HashMap<String, String[]> hm, List<String> res, String tmp) {
		if(node == null || node.trim().length() == 0) return;
		node = node.trim();
		tmp += ("->" + node);
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
			helper(neighbor, end, hm, res, tmp);
		}
		
	}
	
	public static void main(String[] args) {
		String txtFile = "testcase.txt";
		NodePath np = new NodePath();
		try {
			List<String> res = np.solution(txtFile);
			for(String r : res) System.out.println(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashSet<String> hs;
		List<String> res = new ArrayList<String>();
		hs = new HashSet<String>().addAll(res);
	}
}
