package com.larry.recursion;

import org.springframework.util.StopWatch;

/**
 * @description: 一只青蛙可以一次跳 1 级台阶或者一次跳 2 级台阶，例如：
 * 跳上第 1 级台阶只有一种跳法：直接跳 1 级即可。 跳上第 2 级台阶有两种跳法：每次跳 1 级，跳两次；或者一次跳 2 级。
 * 问要跳上第 n 级台阶有多少种跳法？
 * @date: 2023/3/5
 **/
public class Demo1 {

    public static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2);
    }

    public static int f1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result = 0;
        int pre = 1;
        int next = 2;

        for (int i = 3; i < n + 1; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int f = f(1000);
        stopWatch.stop();

        stopWatch.start();
        int f1 = f1(1000);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

}
