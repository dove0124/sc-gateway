package cn.springcloud.book.dataservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.springcloud.book.common.context.UserContextHolder;
import cn.springcloud.book.dataservice.config.DataConfig;

/**
 * @author: andy chu
 */
@RefreshScope
@RestController
public class DataController {

    @Autowired
    private DataConfig dataConfig;

    @GetMapping("/getContextUserId")
    public String getContextUserId() throws Exception {
        int millisecond = new Random().nextInt(10000);
        System.out.println("millisecond: " + millisecond);
        Thread.sleep(millisecond);
        //        Time.sleep(7000);
        return UserContextHolder.currentUser()
                                .getUserId() + " " + getAppInfo();
    }

    @GetMapping("/getDefaultUser")
    public String getDefaultUser() {
        return dataConfig.getDefaultUser() + " " + getAppInfo();
    }

    @GetMapping("/getProviderData")
    public List<String> getProviderData() {
        List<String> provider = new ArrayList<String>();
        provider.add("Beijing Company");
        provider.add("Shanghai Company");
        provider.add("Shenzhen Company");
        provider.add(getAppInfo());
        return provider;
    }

    private String getAppInfo() {
        return dataConfig.getApplicationName() + ": " + dataConfig.getPort();
    }
}
