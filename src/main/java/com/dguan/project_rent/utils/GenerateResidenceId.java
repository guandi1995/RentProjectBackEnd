package com.dguan.project_rent.utils;

import java.util.Random;

/**
 * @author dguan
 * @date 12/30/2020 12:12 PM
 */
public class GenerateResidenceId {
    public static String getResidenceId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String id = millis + String.format("%02d", end2);
        return id;
    }
}
