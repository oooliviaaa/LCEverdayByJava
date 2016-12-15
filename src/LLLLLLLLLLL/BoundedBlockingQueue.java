package LLLLLLLLLLL;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BoundedBlockingQueue {
	
	int cap;
	Queue<Object> queue;
	Lock readLock;
	Lock writeLock;
	Condition emptyCond;
	Condition fullCond;
	
	public void init(int capacity) throws Exception {
		this.cap = capacity;
		queue = new LinkedList<Object>();
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();
		emptyCond = readLock.newCondition();
		fullCond = writeLock.newCondition();
	}
	 
	  
	public Object get() throws Exception {
		readLock.lock();
		try {
			while (queue.size() == 0) {
				emptyCond.wait();
			}
			Object obj = queue.poll();
			fullCond.signal();
			return obj;
		} finally {
			readLock.unlock();
		}
	}
	 
	  
	public void put(Object obj) throws Exception {
		writeLock.lock();
		readLock.lock();
		try {
			while (queue.size() == cap) {
				fullCond.wait();
			}
			queue.offer(obj);
			emptyCond.signal();
		} finally {
			readLock.unlock();
			writeLock.unlock();
		}
	}


	public void multiput(List<Object> objs) throws Exception {
		writeLock.lock();
		readLock.lock();
		try {
			for (Object obj : objs) {
				put(obj);
			}
		} finally {
			readLock.unlock();
			writeLock.unlock();
		}
	}
	  
}
