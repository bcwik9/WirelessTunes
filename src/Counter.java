

public class Counter implements Runnable{
	
	private String base;
	
	public Counter(String base, boolean isError){
		this.base = base;
		
	}
	
	public void run() {
		int i = 1;
		while(true){
			NewJFrame.setConsoleText(base + i, false);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
