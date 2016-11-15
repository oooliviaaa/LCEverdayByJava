package FirstAttempt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	// http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
	// https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj
	/**
	 * 1 Use BFS to construct a graph. 
	 * 2. Use DFS to construct the paths from end to start
	 * */
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		
	}
	
	////////////////////////////
	
	public List<List<String>> findLadders_TLE(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (wordList == null || wordList.size() == 0) return res;
		wordList.add(endWord);   ///// !!!!!
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		Queue<LinkedList<String>> ladder = new LinkedList<LinkedList<String>>();
        ladder.add(new LinkedList<String>());
		
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		boolean isFound = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				LinkedList<String> currentLadder = ladder.remove();
				List<String> nexts = getNextStrings(cur, wordList);
				for (String next : nexts) {
					if (visited.contains(next)) continue;
					if (next.equals(endWord)) {
						currentLadder.addLast(cur);
						currentLadder.addLast(endWord);
						res.add(currentLadder);
						isFound = true;
					} else {
						queue.offer(next);
						LinkedList<String> nextLadder = new LinkedList<String>(currentLadder);
						nextLadder.addLast(cur);
                        ladder.add(nextLadder);
					}
				}
			}
			if (isFound) break;
		}
		return res;
    }
	
	private List<String> getNextStrings(String word, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		  for (int i = 0; i < word.length(); i++) {
              StringBuilder builder = new StringBuilder(word);
              for (char ch = 'a'; ch <= 'z'; ch++) {
                  builder.setCharAt(i, ch);
                  String new_word = builder.toString();
                  if (dict.contains(new_word)) {
                	  res.add(new_word);
                  }
              }
          }
		  return res;
	}
	
	public static void main(String[] args) {
		WordLadderII wd2 = new WordLadderII();
		
		Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dit");
        dict.add("cog");
        dict.add("lot");
        dict.add("dog");
        
        String[] words = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes",
        		"ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan",
        		"cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark",
        		"has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box",
        		"ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit",
        		"tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye",
        		"oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age",
        		"fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex",
        		"yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag",
        		"amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen",
        		"paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob",
        		"gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev",
        		"jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye",
        		"lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe",
        		"ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy",
        		"rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo",
        		"hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix",
        		"ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex",
        		"via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who",
        		"bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia",
        		"ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut",
        		"ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay",
        		"poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog",
        		"pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim",
        		"pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem",
        		"off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil",
        		"jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut",
        		"bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop",
        		"tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err",
        		"him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago",
        		"ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met",
        		"hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo",
        		"lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun",
        		"ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot",
        		"are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud",
        		"gee","pin","dun","pat","ten","mob"};
        
        List<List<String>> res = wd2.findLadders("hit", "cog", dict);
        for (List<String> re : res) {
        	for (String r : re) {
        		System.out.print(r + " ");
        	}
        	System.out.println();
        }
	}
}
