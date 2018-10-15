package com.mall.demo.thread;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-11 16:20.
 * 需求： java 实现死锁
 *
 * 死锁定义：两个或两个以上的线程或进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象。
 *
 * 实现：线程1执行过程中，先锁定了对象a，然后需要再锁定b才能继续执行代码；而线程2正巧相反，先锁定了b，需要再锁定a才能继续执行代码。
 *       这时，两个线程都等着对方解锁，才能继续执行，这时，两个线程就进入等待状态，最终不会有线程执行。这就变成了死锁。
 */
public class THreadDead {

    public static void main(String[] args) {

        new Thread(new DeadLocakZero(false)).start();
        new Thread(new DeadLocakZero(true)).start();

       /* new Thread(new DeadLock(false),"false").start();
        new Thread(new DeadLock(true),"true").start();*/

    }

}

/**
 * 线程1和线程2同步执行的时候，假如线程1 执行到了锁住对象a ，那么还没有往下锁住对象b时候，线程2也执行到了锁住对象b。
 * 那么线程1 想继续往下执行的时候，必须要拿到对象 b，而由于线程2锁住了对象b，线程1只有在等待，等待过程是不会把对象锁a 释放的，
 * 线程2 要往下执行，也只有拿到线程a，但是线程1 也把对象a锁住了，所以线程2 也在等待对象 a,等待过程中，线程2也不会把对象锁b释放的。
 * 两个线程互相等待对象锁的时候，则形成了死锁。
 */
class DeadLocakZero implements Runnable {

    boolean flag;
    static Object a = new Object();
    static Object b = new Object();

    public DeadLocakZero(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",开始执行.....................");
        if (flag) {
            synchronized(a) {
                System.out.println("lock a1.................");
                synchronized (b) {
                    System.out.println("lock b1.................");
                }
            }
        } else {
            synchronized(b) {
                System.out.println("lock b2.................");
                synchronized (a) {
                    System.out.println("lock a2.................");
                }
            }
        }

    }
}




class DeadLock implements Runnable {

    boolean flag ;
    static Object o1 = new Object();
    static Object o2 = new Object();

    public DeadLock(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        System.out.println("o1 = " + o1);
        System.out.println("o2 = " + o2);
        System.out.println("线程:" + Thread.currentThread().getName() + ",开始执行............");
        if (flag) {
            synchronized (o1) {
                try{
                    System.out.println("o1 ........进行睡眠.............................");
                    Thread.sleep(50);
                    System.out.println("o1 ........睡眠结束............................");
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            synchronized (o2) {
                System.out.println("执行线程o1 .....................................");
            }
        } else {
            synchronized (o2) {
                try {
                    System.out.println("o2 ........进行睡眠.............................");
                    Thread.sleep(50);
                    System.out.println("o2 ........睡眠结束.............................");
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            synchronized (o1) {
                System.out.println("执行线程o2........................................");
            }
        }
    }
}
