package com.dguan.project_rent.controller.pagejump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * page jumper location page
 * @author dguan
 * @date 12/28/2020 11:23 PM
 */
@Controller
@RequestMapping("/locations")
public class CustomerLocationPageJump {
    @RequestMapping("/san-diego")
    public String toSanDiego(){
        return "/customer/locations/san-diego/san-diego";
    }

    @RequestMapping("/san-diego/la-jolla-palms")
    public String toOLaJollaPalms(){
        return "/customer/locations/san-diego/la-jolla-palms/overview";
    }

    @RequestMapping("/san-diego/la-jolla-palms/availability")
    public String toOLaJollaPalmsAvailability(){
        return "/customer/locations/san-diego/la-jolla-palms/availability";
    }

    @RequestMapping("/san-diego/solazzo")
    public String toSolazzo(){
        return "/customer/locations/san-diego/solazzo";
    }

    @RequestMapping("/san-diego/vor")
    public String toVOR(){
        return "/customer/locations/san-diego/vor";
    }

    @RequestMapping("/orange")
    public String toOrange(){
        return "/customer/locations/orange/orange";
    }

    @RequestMapping("/orange/pelican-hills")
    public String toPalicanHills(){
        return "/customer/locations/orange/pelican-hills";
    }

    @RequestMapping("/orange/turtle-ridge")
    public String toTurtleRidge(){
        return "/customer/locations/orange/turtle-ridge";
    }

    @RequestMapping("/orange/irvine-spectrum-vita")
    public String toIrvineSpecturmVita(){
        return "/customer/locations/orange/irvine-spectrum-vita";
    }
}
