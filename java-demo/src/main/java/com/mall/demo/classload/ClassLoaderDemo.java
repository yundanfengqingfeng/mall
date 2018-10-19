package com.mall.demo.classload;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-16 11:14.
 * 类加载器与类的唯一性
 * 类加载器虽然只用于实现类的加载动作，但是对于任意一个类，都需要由加载它的类加载器和这个类本身共同确立其在Java虚拟机中的唯一性.
 * JVM中两个类是否“相等”，首先就必须是同一个类加载器加载的，否则，即使这两个类来源于同一个Class文件，被同一个虚拟机加载，只要类加载器不同，那么这两个类必定是不相等的.
 * 里的“相等”，包括代表类的Class对象的equals()方法、isAssignableFrom()方法、isInstance()方法的返回结果，也包括使用instanceof关键字做对象所属关系判定等情况
 *
 * 即使这两个类来源于同一个Class文件，被同一个虚拟机加载，只要类加载器不同，那么这两个类必定是不相等的
 *
 * 类加载器在类相等判断中的影响
 * instanceof关键字
 *
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        // 自定义类加载器
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                System.out.println("fileName = " + fileName);
                InputStream in = getClass().getResourceAsStream(fileName);
                if (null == in) {
                    return super.loadClass(name);
                }
                byte[] b = null;
                try {
                     b = new byte[in.available()];
                    in.read(b);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
                return defineClass(name,b,0,b.length);
            }
        };

        // 使用ClassLoaderTest的类加载器加载本类
       Object object =  ClassLoaderDemo.class.getClassLoader().loadClass("com.mall.demo.classload.ClassLoaderDemo").newInstance();
       System.out.println("默认类加载器 :" + object.getClass());
       System.out.println("默认类加载器 :" + (object instanceof ClassLoaderDemo));

        // 使用自定义类加载器加载本类
       Object object1 = classLoader.loadClass("com.mall.demo.classload.ClassLoaderDemo").newInstance();
       System.out.println("自定义的类加载 :" +  object1.getClass());
       System.out.println("自定义的类加载 :" + (object1 instanceof ClassLoaderDemo));

    }

}
