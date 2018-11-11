package com.mall.demo.thread.wait_and_notify;

/**
 * @author 超
 * Create by fengc on  2018/11/9 23:03
 * 模拟生产和消费数据实体类
 */
public class ProductData {

    /**
     * 表示被哪个生产者线程生产出来的编号
     */
    private int number;
    /**
     * 标志位  true = 代表已经消费，false = 代表未消费
     */
    private boolean flag = true;

    public synchronized void product(int number) {
        System.out.println("进入生产方法 number【" + number + "】");
        if (!flag) {
            try {
                //假如未消费，则等待
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        flag = false;
        this.number = number;
        System.out.println("ProductData【" +  number + "】 Product");
        notify();
    }

    public synchronized void consume() {
        System.out.println("进入消费方法 number【" + number + "】");
        if (flag) {
            try {
                //已经消费，等待生产
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        flag = true;
        System.out.println("ProductData【" +  number + "】 consume");
        notify();
    }

}
