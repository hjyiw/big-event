package com.hjy;

import org.junit.jupiter.api.Test;

/**
 * ClassName: ThreadLocalTest
 * Package: com.hjy
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 16:06
 * @Version 1.0
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        //提供一个ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();

        //开启两个线程
        //两个参数：线程任务 线程名字
        new Thread(()->{
            tl.set("王小枝");
            System.out.println(tl.get());
            System.out.println(tl.get());
            System.out.println(tl.get());
        },"粉色").start();
        new Thread(()->{
            tl.set("黄嘉宇");
            System.out.println(tl.get());
            System.out.println(tl.get());
            System.out.println(tl.get());
        },"蓝色").start();
    }
}
