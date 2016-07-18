package FirstAttempt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// http://bookshadow.com/weblog/2016/06/11/leetcode-design-twitter/
// hashSet, hashMap, priorityQueue
public class DesignTwitter {

	int count;   // count all the msgs
	Map<Integer, Integer> msgCountMap;   // msgId <--> countMsg, to record the order of all the posted msgs
	Map<Integer, List<Integer>> ownerMsgsMap; // userId <--> list of his msgs
	Map<Integer, Integer>  msgOwnerMap;  // msgId <--> userId
	Map<Integer, List<Integer>> followeeMap;  // userId <--> list of followees
	
	
	/** Initialize your data structure here. */
    public DesignTwitter() {
    	count = 0;
    	msgCountMap =  new HashMap<Integer, Integer>();
        ownerMsgsMap = new HashMap<Integer, List<Integer>>();
        msgOwnerMap =  new HashMap<Integer, Integer>();
        followeeMap = new HashMap<Integer, List<Integer>>(); 
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	msgCountMap.put(tweetId, ++count);
    	msgOwnerMap.put(tweetId, userId);
        getTweetIdList(userId).add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return msgCountMap.get(o2) - msgCountMap.get(o1);
			}
        	
        });
        
        List<Integer> followee = followeeMap.get(userId);
        for (int f : followee) {
        	List<Integer> tweets = getTweetIdList(f);
        	
        	for (int t : tweets) {
        		pq.add(t);
        	}
        }
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    }
    
    
    
    private List<Integer> getTweetIdList(int userId) {
        List<Integer> tweetIdList = ownerMsgsMap.get(userId);
        if (tweetIdList == null) {
            tweetIdList = new ArrayList<Integer>();
            ownerMsgsMap.put(userId, tweetIdList);
        }
        return tweetIdList;
    }
    
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

