package com.larry.recursion;

import org.springframework.util.StopWatch;

/**
 * @description: 细胞分裂 有一个细胞 每一个小时分裂一次，一次分裂一个子细胞，第三个小时后会死亡(也会分裂一次)。那么n个小时候有多少细胞？
 * @date: 2023/3/5
 **/
public class Demo2 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        allCells(32);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    public static int allCells(int n) {
        return aCell(n) + bCell(n) + cCell(n);
    }

    /**
     * 第 n 小时 a 状态的细胞数，细胞初始态
     * 为第 n-1 小时 a、b、c 状态的总和，自顶向下分析
     */
    public static int aCell(int n) {
        if (n == 1) {
            return 1;
        } else {
            return aCell(n - 1) + bCell(n - 1) + cCell(n - 1);
        }
    }

    /**
     * 第 n 小时 b 状态的细胞数，细胞分裂一次
     * 为 n-1 小时 a 状态的总和
     */
    public static int bCell(int n) {
        if (n == 1) {
            return 0;
        } else {
            return aCell(n - 1);
        }
    }

    /**
     * 第 n 小时 c 状态的细胞数，细胞分裂两次
     * 为 n-1 小时 b 状态的总和
     */
    public static int cCell(int n) {
        if (n == 1 || n == 2) {
            return 0;
        } else {
            return bCell(n - 1);
        }
    }
}
