package com.program.chat03.note01;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        // 创建一个默认种子的随机数生成器
        Random random = new Random();
        //输出10个在0~10之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
