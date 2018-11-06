//package PACKAGE_NAME;
//
///**
// * @author pc-fengc
// * created by pc-fengc on 2018-11-02 17:25.
// */
//import com.mall.demo.designpatterns.proxy.Person;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//public final class $Proxy0 extends Proxy implements Person {
//    private static Method m1;
//    private static Method m2;
//    private static Method m3;
//    private static Method m0;
//
//    public $Proxy0(InvocationHandler var1){
//        super(var1);
//    }
//
//    public final boolean equals(Object var1) {
//        try {
//            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
//        } catch (RuntimeException | Error var3) {
//            throw var3;
//        } catch (Throwable var4) {
//            throw new UndeclaredThrowableException(var4);
//        }
//    }
//
//    public final String toString() {
//        try {
//            return (String)super.h.invoke(this, m2, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final void giveMoney(){
//        try {
//            super.h.invoke(this, m3, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final int hashCode(){
//        try {
//            return (Integer)super.h.invoke(this, m0, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    static {
//        try {
//            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//            m2 = Class.forName("java.lang.Object").getMethod("toString");
//            m3 = Class.forName("com.mall.demo.designpatterns.proxy.Person").getMethod("giveMoney");
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
//        } catch (NoSuchMethodException var2) {
//            throw new NoSuchMethodError(var2.getMessage());
//        } catch (ClassNotFoundException var3) {
//            throw new NoClassDefFoundError(var3.getMessage());
//        }
//    }
//}
//
