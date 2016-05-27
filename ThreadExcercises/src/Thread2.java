
public class Thread2 extends Thread {

	private Thread2 t1;

	Thread2(){	
		t1 = new Thread2();
	}
	
	public void run(){
		doSomething();
	}
	
	public synchronized void doSomething(){
		System.out.println("inside doSomething t2, calling  doOther t1");
		t1.doOther();
	}
	
	public synchronized void doOther(){
		System.out.println("inside doOther t2, calling  doSomething t1");
		t1.doSomething();
	}
}
