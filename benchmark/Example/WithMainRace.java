package edu.thu.sse.defu.test;

public class WithMainRace extends Thread{
	private int id;
	public static int cnt; // shared state
	public static boolean flag = true; // shared state
	
	public WithMainRace(int id) {
		this.id = id;
	}
	
	public void run() {
		if(this.id == 1) {
			cnt = 1;
			flag = false;
		}
		if(this.id == 2) {
			if(flag) {
				cnt = 2;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WithMainRace thread1 = new WithMainRace(1);
		WithMainRace thread2 = new WithMainRace(2);
		thread1.start();
		thread2.start();
	}

}
