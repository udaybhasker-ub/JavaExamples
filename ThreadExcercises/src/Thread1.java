
public class Thread1 extends Thread {
	Thread2 t2;
	Thread1(){
		t2 = new Thread2();
	}
	
	public void run(){
		doSomething();
	}
	
	public synchronized void doSomething(){
		System.out.println("inside doSomething t1, calling  doOther t2");
		t2.doOther();
	}
	
	public synchronized void doOther(){
		System.out.println("inside doOther t1, calling  doSomething t2");
		t2.doSomething();
	}
}
