package reger.threadpool;

import java.util.*;

/**
 * Java Thread Pool
 *
 */
public class ThreadPool {
 /**
  * The threads in the pool.
  */
 protected Thread threads[] = null;
 /**
  * The backlog of assignments, which are waiting
  * for the thread pool.
  */
 Collection assignments = new ArrayList(3);
 /**
  * A Done object that is used to track when the
  * thread pool is done, that is has no more work
  * to perform.
  */
 protected Done done = new Done();

 /**
  * The constructor.
  *
  * @param size  How many threads in the thread pool.
  */
 public ThreadPool(int size)
 {
  threads = new WorkerThread[size];
  for (int i=0;i<threads.length;i++) {
   threads[i] = new WorkerThread(this);
   threads[i].start();
  }
 }

 /**
  * Add a task to the thread pool. Any class
  * which implements the Runnable interface
  * may be assienged. When this task runs, its
  * run method will be called.
  *
  * @param r   An object that implements the Runnable interface
  */
 public synchronized void assign(Runnable r)
 {
  done.workerBegin();
  assignments.add(r);
  notify();
 }

 /**
  * Get a new work assignment.
  *
  * @return A new assignment
  */
 public synchronized Runnable getAssignment()
 {
  try {
   while ( !assignments.iterator().hasNext() )
    wait();

   Runnable r = (Runnable)assignments.iterator().next();
   assignments.remove(r);
   return r;
  } catch (InterruptedException e) {
   done.workerEnd();
   return null;
  }
 }

 /**
  * Called to block the current thread until
  * the thread pool has no more work.
  */
 public void complete()
 {
  done.waitBegin();
  done.waitDone();
 }


 protected void finalize()
 {
  done.reset();
  for (int i=0;i<threads.length;i++) {
   threads[i].interrupt();
   done.workerBegin();
   threads[i].destroy();
  }
  done.waitDone();
 }
}


