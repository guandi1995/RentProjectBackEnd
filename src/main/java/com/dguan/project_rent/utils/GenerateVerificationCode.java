package com.dguan.project_rent.utils;

import java.util.Random;

/**
 * @author dguan
 * @date 2/21/2021 11:43 AM
 */
public class GenerateVerificationCode {
    
    public StringBuffer generateCode(){
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int rn = random.nextInt(10);
            code.append(rn);
        }
        return code;
    }

}
