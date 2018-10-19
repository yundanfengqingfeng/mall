package com.mall.demo.classload;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-18 16:12.
 *
 * 代码作用：
 * 1、对象可以再被GC时自我拯救
 * 2、这种拯救机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调一次
 */
public class FinalizeEscapeGC {

    public String name;
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public FinalizeEscapeGC(String name) {
        this.name = name;
    }

    public void isAlive() {
        System.out.println("yes , i am still alive :) ");
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method is executed !");
        System.out.println(this);
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    @Override
    public String toString() {
        return "FinalizeEscapeGC{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws InterruptedException{

        SAVE_HOOK = new FinalizeEscapeGC("sdsdsdsdsdsds");
        System.out.println(SAVE_HOOK);
        //对象第一拯救自己
        SAVE_HOOK = null;
        System.out.println(SAVE_HOOK);
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ， i am dead :( ");
        }
        //对象第二次拯救自己
        SAVE_HOOK = null;
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ， i am dead :( ");
        }
    }
}
