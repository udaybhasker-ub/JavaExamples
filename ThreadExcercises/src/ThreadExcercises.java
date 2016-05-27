import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExcercises {

	public static void main(String[] args) {
		/*MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		try {
			t1.join(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();*/
		/*ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++){
			poolExecutor.execute(new MyThread("t"+i));
		}
		poolExecutor.shutdown();*/
		/*Thread t1 = new Thread(){
			public void run(){
				synchronized("uday"){
					System.out.println("t1 thread: uday");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized("bhasker"){
						System.out.println("t1 thread: bhasker");
					}
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				synchronized("bhasker"){
					System.out.println("t2 thread: uday");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized("uday"){
						System.out.println("t2 thread: bhasker");
					}
				}
			}
		};*/
		Thread1 t1= new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}

}
