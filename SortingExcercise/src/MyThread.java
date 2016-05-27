
public class MyThread extends Thread{

	private int i = 0;

	@Override
	public void run() {
		while(true){
			System.out.println("MyThread::"+i);
			i++;
		}
	}

}
