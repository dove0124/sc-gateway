package cn.springcloud.book.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.springcloud.book.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 */
@Api(description = "测试源服务API接口")
@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 获取配置文件中系统默认用户
	 * @return
	 */
    @ApiOperation(value = "获取配置文件中系统默认用户", notes = "获取配置文件中系统默认用户")
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        return userService.getDefaultUser();
    }
    
    /**
     * 获取上下文用户
     * @return
     */
    @ApiOperation(value = "获取上下文用户", notes = "获取上下文用户")
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        return userService.getContextUserId();
    }
    
    /**
     * 获取供应商数据
     * @return
     */
    @ApiOperation(value = "获取供应商数据", notes = "获取供应商数据")
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }
}
