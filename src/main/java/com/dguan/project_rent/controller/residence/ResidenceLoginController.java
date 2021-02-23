package com.dguan.project_rent.controller.residence;

import com.dguan.project_rent.dto.*;
import com.dguan.project_rent.service.ResidenceLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * residence login and logout controller
 * @author dguan
 * @date 12/27/2020 9:05 PM
 */
@Controller
public class ResidenceLoginController {

    @Autowired
    private ResidenceLoginService residenceLoginService;

    /**
     * login service
     * @param map customer_username and customer_password from front-end params
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/residence/login", method = RequestMethod.POST)
    @ResponseBody
    public Message customerLogin(@RequestBody Map map, HttpServletRequest request){
        //handle the front-end params
        String username = (String) map.get("customer_username");
        String password = (String) map.get("customer_password");

        Message message = new Message();

        //create subject and token
        Subject currentResidence = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //use token to login
            currentResidence.login(token);
            //store the residence info into the session
            List<ResidenceLogin> residenceLogins = residenceLoginService.queryByUsername(username);
            String residence_id = residenceLogins.get(0).getResidence_id();
            List<ResidenceInfo> residenceInfos = residenceLoginService.queryResidenceInfoById(residence_id);
            HttpSession session = request.getSession();
            session.setAttribute("residence_info", residenceInfos.get(0));
            List<ApartmentInfo> aptInfo = residenceLoginService.findAptInfoById(residence_id);
            if (!aptInfo.isEmpty()){
                session.setAttribute("residence_apt_info", aptInfo.get(0));
            }
            message.setStatus(true);
            return message;
        }catch (UnknownAccountException e){
            message.setStatus(false);
            message.setMessage("Username does not exist!!");
            return message;
        }catch (LockedAccountException e){
            message.setStatus(false);
            message.setMessage("Username has been locked currently!!");
            return message;
        }catch (IncorrectCredentialsException e){
            message.setStatus(false);
            message.setMessage("Password is incorrect, please try again!!");
            return message;
        }
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Map unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("residence_info");
        session.removeAttribute("residence_apt_info");
        return "redirect:/residence/toLogin";
    }



}
