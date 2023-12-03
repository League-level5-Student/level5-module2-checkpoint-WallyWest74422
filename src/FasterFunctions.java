//1. Go to Run > Run Configurations
// *      2. Click on the tab that reads "(x)= Arguments"
// *      3. In the box labeled "VM arguments:", add this: -Xss64m 
// * 
public class FasterFunctions {
	public static void main(String[] args) {
	float totalTime = 0;
		long startTime = System.currentTimeMillis();

		//Your Code Here
		Thread uno = new Thread(() -> {
			SlowFunctions.slowSortLargeArray();
			System.out.println("slowSortLargeArray() Complete.");
		});
		Thread dos = new Thread(() -> {
			System.out.println("ackermann(3, 14): " + SlowFunctions.ackermann(3, 14));
			System.out.println("ackermann(3, 14) Complete.");		
		});
		Thread tres = new Thread(() -> {
			SlowFunctions.millionsOfSqrts();
			System.out.println("millionsOfSqrts() Complete.");
		});
		try {
			uno.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tres.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uno.start();
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("slowSortLargeArray() Time: " + endTime + "\n\n");
		startTime = System.currentTimeMillis();
		dos.start();
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("ackerman(3, 14) Time: " + endTime + "\n\n");
		tres.start();
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		
		System.out.println("Total Time: " + totalTime + "\n\n");
	}
}
