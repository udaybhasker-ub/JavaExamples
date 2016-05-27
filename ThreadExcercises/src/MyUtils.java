
public class MyUtils {
 synchronized public static void print(int seed){
		for(int i=0; i<5; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i*seed);
		}
	}
}
