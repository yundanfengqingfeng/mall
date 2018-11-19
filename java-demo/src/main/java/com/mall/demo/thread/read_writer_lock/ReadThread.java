package com.mall.demo.thread.read_writer_lock;

/**
 * @author 超
 * Create by fengc on  2018/11/19 22:06
 */
public class ReadThread extends Thread {

    private ReadWriterTool tool;

    public ReadThread(ReadWriterTool tool) {
        this.tool = tool;
    }

    @Override
    public void run() {
        tool.read();
    }
}
