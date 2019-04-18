/** Barrier class to make n-1 number of threads
  * to wait until the nth thread arrives at the Barrier.
  * This is accomplished using semaphores.
  *
  * @Athor: Songeziwe S. Soboois
  * @Created:  April 16, 2019
  * @Modified: April 18, 2019
  */
//package BarrierS;

import java.util.concurrent.Semaphore;

public class Barrier {
	
	Semaphore sem;
   Semaphore mutex;
   int barrierSize;
   int numThreads;
   
	Barrier( int n ) {
      sem = new Semaphore( 0 );     // locker for the barrier i.e for making the threads wait
      barrierSize = n;              // n is the size of the barrier 
      mutex = new Semaphore( 1 );   // allowing only one thread to execute the critical section
      numThreads = 0;               // No threads arrived yet
	}
	
   /** Every thread will have a copy of this method */
	public void b_wait() throws InterruptedException{
		
      mutex.acquire();   // acquire the lock
      numThreads++;      // read, update, and store counter in memory ( critical section )
      mutex.release();   // release the lock for the otyher thread to update the counter

      if( numThreads < barrierSize ){ // reading from memory i.e no update on counter
         
         sem.acquire();               // make n-1 threads wait i.e close the barrier
      }
      sem.release();                  // release the key for the barrie i.e open the barrier
	}

}
