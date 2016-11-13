package LLLLLLLLL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 水塘抽样
public class ReservoirSampling<T> {

	List<T> res;
	int k;
	Random r;
	
  public ReservoirSampling(int k) {
	  res = new ArrayList<T>();
	  this.k = k;
	  this.r = new Random();
  }
 

  public void addSample(T next) {
	  int n = res.size();
	  
	  if (n < k) {
		  res.add(next);
	  } else {
		  int index = r.nextInt(n);
		  if (index < k) {
			  res.set(index, next);
		  }
	  }
  }
 

  public List<T> getResult() throws IllegalStateException {
	  if (res.size() < k) {
		  throw new IllegalStateException();
	  }
	  return res;
  }
}
