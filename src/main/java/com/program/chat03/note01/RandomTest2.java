package com.program.chat03.note01;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest2 {
    public static void main(String[] args) {
        // 创建一个默认种子的随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        //输出10个在0~10之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
