import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingThread extends Thread {

	private LinkedList<String> list;
	private boolean isAddType;
	Lock lock = new ReentrantLock();
	Condition notfull = lock.newCondition(); 
	Condition notempty = lock.newCondition(); 

	LockingThread(String name, LinkedList<String> list, boolean isAddType) {
		this.setName(name);
		this.list = list;
		this.isAddType = isAddType;
	}

	public void run() {
		try {
			if (this.isAddType) {
				writeToList();
			} else
				removeFromList();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToList() throws InterruptedException {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			try {
				list.addLast(this.getName() + "::" + i);
				System.out.println(this.getName() + "::" + i + " is added!");
				//Thread.sleep(1000);
				if(i == 9){
					notfull.await();
				}else notempty.signal();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				lock.unlock();
			}
		}
	}

	public void removeFromList() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("remove item isEmpty="+list.isEmpty());
					if(list.isEmpty()){
						notempty.await();
					}else{
						String rem = list.removeLast();
						notfull.signal();
						System.out.println(rem + " is removed!");
						//Thread.sleep(1000);
					}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}

	}

	public void printList() {
		System.out.println("printing " + this.getName() + " list...");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String args[]) throws InterruptedException {
		LinkedList<String> list = new LinkedList<String>();
		LockingThread lt1 = new LockingThread("LT1", list, true);
		LockingThread lt2 = new LockingThread("LT2", list, false);
		lt1.start();
		lt2.start();
	}
}
