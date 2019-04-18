//package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	Semaphore sem;
   Semaphore mutex;
   int barrierSize;
   int numThreads;
   
	Barrier( int n ) {
      sem = new Semaphore( 0 ); 
      barrierSize = n;              // n is the size of the barrier 
      mutex = new Semaphore( 1 );   // allowing only one thread to execute the critical section
      numThreads = 0;               // No threads arrived yet
	}
	
   // Every thread will have a copy of this method
	public void b_wait() throws InterruptedException{
		
      mutex.acquire();   // acquire the lock
      numThreads++;      // read, update, and store counter in memory
      mutex.release();   // release the lock for the otyher thread to update the counter

      if( numThreads < barrierSize ){ // reading from memory i.e no update on counter
         
         sem.acquire();
      }
      sem.release();
	}

}
