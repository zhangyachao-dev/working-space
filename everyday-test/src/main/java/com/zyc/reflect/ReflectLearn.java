package com.zyc.reflect;

import cn.hutool.log.Log;
import com.zyc.reflect.pojo.Student;

import java.lang.reflect.Constructor;

/**
 * 反射：JAVA反射机制是在运行状态中，对于任意一个类，
 * 都能够知道这个类的所有属性和方法；对于任意一个对象，
 * 都能够调用它的任意一个方法，这种动态获取、调用对象
 * 方法的功能称为java语言的反射机制
 */
public class ReflectLearn {

    private static final Log log = Log.get("com.zyc.reflect.ReflectLearn");

    public static void main(String[] args) {
        try {
            /*
             * 反射获取字节码的方式
             * Class<?> clazz1 = Class.forName("com.zyc.reflect.pojo.Student");
             * Class<Student> clazz2 = Student.class;
             * Class<? extends Student> clazz3 = new Student().getClass();
             */
            Class<Student> clazz2 = Student.class;
            /**
             * 1.getConstructors()
             * 获取所有public构造方法
             * 返回值：数组
             */
            /*Constructor<?>[] constructors = clazz2.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }*/

            /**
             * 2.getDeclaredConstructors()
             * 获取所有类型的构造方法
             */
            /*Constructor<?>[] declaredConstructors = clazz2.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }*/

            /**
             * 3.getConstructor()
             * 根据参数的类型返回public构造器
             * clazz2.getConstructor(null)
             */
            /*Constructor<Student> constructor0 = clazz2.getConstructor(null);
            System.out.println(constructor0);*/
            /*Constructor<Student> constructor1 = clazz2.getConstructor(String.class,int.class);
            System.out.println(constructor1);*/
            //this.getClass().getResourceAsStream();
            //Thread.currentThread().getContextClassLoader().getResourceAsStream()
        } catch (Exception e) {
            log.error("error:{}",e);
        }

    }

}