package FirstAttempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
	
	// https://segmentfault.com/a/1190000003894693
	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
        // find all the 1 point
		List<Integer> ipos = new ArrayList<Integer>();
		List<Integer> jpos = new ArrayList<Integer>();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					ipos.add(i);
					jpos.add(j);
				}
			}
		}
		
		// find the mid point
		int imid = ipos.get(ipos.size() / 2);
		int jmid = jpos.get(jpos.size() / 2);
		int sum = 0;
		
		// no need to sort ipos, because it's input by sorted i
		for (int i : ipos) {
			sum += Math.abs(i - imid);
		}
		
		// need to sort jpos !!!!!
		Collections.sort(jpos);
		for (int j : jpos) {
			sum += Math.abs(j - jmid);
		}
		return sum;
    }
	
	
	public int solution(int[][] grid) {
		List<Integer> ipos = new ArrayList<Integer>();
        List<Integer> jpos = new ArrayList<Integer>();
        // 统计出有哪些横纵坐标
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ipos.add(i);
                    jpos.add(j);
                }
            }
        }
        int sum = 0;
        // 计算纵坐标到纵坐标中点的距离，这里不需要排序，因为之前统计时是按照i的顺序
        for(Integer pos : ipos){
            sum += Math.abs(pos - ipos.get(ipos.size() / 2));
        }
        // 计算横坐标到横坐标中点的距离，这里需要排序，因为统计不是按照j的顺序
        Collections.sort(jpos);
        for(Integer pos : jpos){
            sum += Math.abs(pos - jpos.get(jpos.size() / 2));
        }
        return sum;
	}
}
