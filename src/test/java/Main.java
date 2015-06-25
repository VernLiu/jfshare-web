
public class Main {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		/*Long a = new Long(100L);
		Long b = new Long(100L);
		LongLock ll = new LongLock();
		Thread ta = new Thread(new MyRunner(a, ll), "Thread-a") ;
		Thread tb = new Thread(new MyRunner(b, ll), "Thread-b");
		ta.start();
		tb.start();
		
		long l = (-1L>>>13<<12);
		System.out.println(Long.bitCount(l) + "bianry text : " + Long.toBinaryString(l));
		System.out.println("long : " + l);*/
	}
	
	static class MyRunner implements Runnable {
		private Long l;
		private LongLock longLock;
		public MyRunner(Long l, LongLock longLock) {
			this.l = l;
			this.longLock = longLock;
		}
		
		public void run() {
			longLock.doLock(l);
		}
	}
	
	static class LongLock {
		public void doLock(Long l) {
			System.out.println(Thread.currentThread().getName() + " begin excute doLock();");
			synchronized(l) {
				try {
					System.out.println(Thread.currentThread().getName() + " sleeping;");
					Thread.sleep(20000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " end excute doLock();");
		}
	}
}
