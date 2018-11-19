package com.mall.demo.thread.read_writer_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 00:16
 */
public class ReadWriterTool {
    //定义读写锁
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private int num = 0 ;
    //读方法
    public void read() {
        int cnt = 0 ;
        while (cnt++ < 3) {
            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getId() + ",start read.........");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId() + "reading...........," + num);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }
     }
     //写方法
    public void write() {
        int cnt = 0 ;
        while (cnt++ < 3) {
            try {
                writeLock.lock();
                System.out.println(Thread.currentThread().getId() + ",start write.........");
                num = (int)(Math.random() * 10);
                System.out.println(Thread.currentThread().getId() + ",writing....num = " + num);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }
    }

}
