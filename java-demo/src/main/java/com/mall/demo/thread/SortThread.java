package com.mall.demo.thread;

import org.apache.tools.ant.types.resources.Sort;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-09 16:08.
 */
public class SortThread implements Runnable{

    private int num;

    public SortThread(int num) {
        this.num = num;
    }


    public static void main(String[] args) {
        int[] nums = {2,6,4,11,3,998,5455,1,5,152,15,990};
        for (int i = 0 ; i < nums.length ;i++) {
            new Thread(new SortThread(nums[i])).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(num);
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

