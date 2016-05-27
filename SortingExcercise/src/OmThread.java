import java.util.Timer;
import java.util.TimerTask;

import javax.print.attribute.SetOfIntegerSyntax;

public class OmThread extends Thread {
	private int i = 0;
	private String name;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getThreadName() {
		return name;
	}

	public void setThreadName(String name) {
		this.name = name;
	}

	OmThread(String name){
		this.name = name;
	}
	
	public synchronized void run(){
		while(i<5){
			System.out.println(this.name);
			i++;
			//Thread.sleep(1000);
			//print();
		}
	}

	public synchronized void print(){
		System.out.println(this.name+"::"+i);
		i++;
		/*Timer timer = new Timer();
		String tname = this.getThreadName(); 
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
			}
		}, 100);*/
		
	}
}
