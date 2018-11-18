package com.mall.demo.thread.read_writer_lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 00:16
 */
public class ReadWriterTool {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

}
