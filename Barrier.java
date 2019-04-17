//package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	// add missing variables
	int counter;
	Semaphore sem;
	
	Barrier(int n) {
		// complete this constructor
		counter = n;
		size = n;
		released = true;
		sem = new Semaphore(n); // n threads can get in the critical section
	}
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete

		sem.acquire();
		
		if( counter > 0){
			counter -= 1; // decrement the counter
			while(counter > 0){
				/* Make the thread wait until all threads arrive. */
			}
		}
		sem.release();;
	}

}
