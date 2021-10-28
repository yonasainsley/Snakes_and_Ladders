package finalProject;

public class titleThread extends Thread {
	public titleThread(){
		start();
	}
	public void run(){
		for(int i=0;i<5;i++){
            try{
                 Thread.sleep(30);
            } catch(InterruptedException e) {}
        }
	}
}
