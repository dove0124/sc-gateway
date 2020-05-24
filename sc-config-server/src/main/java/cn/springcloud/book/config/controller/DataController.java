package cn.springcloud.book.config.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DataController {

    @PostMapping("/actuator/bus-refresh-config")
    @ResponseBody
    public Object busRefresh2(HttpServletRequest request, @RequestBody(required = false) String s) {
        System.out.println(s);
        return new ModelAndView("/actuator/bus-refresh");
    }
}
