package com.mall.demo.thread.read_writer_lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 22:07
 */
public class WriteThread extends Thread {

    ReadWriterTool tool;

    public WriteThread(ReadWriterTool tool) {
        this.tool = tool;
    }

    @Override
    public void run() {
        tool.write();
    }
}
