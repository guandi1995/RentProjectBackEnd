package com.dguan.project_rent.controller.residence;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dguan
 * @date 2/22/2021 3:36 PM
 */
@RestController
public class TestController {
//    @RequestMapping("/api/testSession")
//    @CrossOrigin(origins="http://localhost:8081",allowCredentials = "true")
//    public void test(HttpServletRequest request){
//        System.out.println("I'm in");
//        HttpSession session = request.getSession();
//        session.setAttribute("testSession", "im test session");
//    }

    @GetMapping("/set-session")
    public Object writeSession(String sessionVal, HttpSession httpSession) {
        System.out.println("Param 'sessionVal' = " + sessionVal);
        httpSession.setAttribute("residenceId", "123456");
        return sessionVal;
    }
}
