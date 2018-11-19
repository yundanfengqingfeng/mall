package com.mall.demo.thread.read_writer_lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 22:08
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriterTool tool = new ReadWriterTool();
        for (int i = 0 ; i < 3 ; i++) {
            new ReadThread(tool).start();
            new WriteThread(tool).start();
        }
    }

}
