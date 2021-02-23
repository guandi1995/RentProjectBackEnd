package com.dguan.project_rent;

import org.junit.Test;

import java.util.Random;

/**
 * @author dguan
 * @date 2/21/2021 11:36 AM
 */
public class GenerateCode {
    @Test
    public void generateCode(){
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int rn = random.nextInt(10);
            code.append(rn);
        }
        System.out.println(code);
    }
}
