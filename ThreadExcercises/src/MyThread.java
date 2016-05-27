
public class MyThread extends Thread {
	
	MyThread(String name){
		this.setName(name);
	}
	
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

}
