package cn.springcloud.book.controller;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.springcloud.book.mapping.UserMapping;
import cn.springcloud.book.model.dto.UserDto;
import cn.springcloud.book.model.entity.User;
import cn.springcloud.book.service.UserService;
import cn.springcloud.book.util.result.DataPageInfoWrapper;
import cn.springcloud.book.util.result.DataWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "User Management V1 Service", tags = {"用户管理Restful API列表V1"})
@RestController
@RequestMapping("/v1")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "第几页", dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页多少条", dataType = "long", paramType = "query")})
    @GetMapping("/users")
    public ResponseEntity<DataPageInfoWrapper> getUserList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageInfo<User> result = userService.getUserList(page, size);
        //        return ResponseEntity.ok(new DataPageWrapper(result));
        return ResponseEntity.ok(new DataPageInfoWrapper(result));
    }

    @ApiOperation(value = "根据用户ID返回用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户id", dataType = "long", paramType = "path")})
    @GetMapping("/user/{id}")
    public ResponseEntity<DataWrapper> getUserDetail(@PathVariable("id") Long id) {
        User user = userService.getUserDetail(id);
        UserDto dto = UserMapping.userEntity2Dto(user);
        return ResponseEntity.ok(new DataWrapper(dto));
    }

    @ApiOperation(value = "保存用户")
    @PostMapping(path = "/user")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<DataWrapper> saveUser(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(new DataWrapper(null));
    }
}
