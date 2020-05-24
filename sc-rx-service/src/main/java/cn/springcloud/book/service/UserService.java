package cn.springcloud.book.service;

import com.github.pagehelper.PageInfo;

import cn.springcloud.book.model.document.UserPO;
import cn.springcloud.book.model.dto.UserDto;
import cn.springcloud.book.model.entity.User;
import reactor.core.publisher.Flux;

public interface UserService {

    PageInfo<User> getUserList(Integer page, Integer size);

    User getUserDetail(Long id);

    Long saveUser(UserDto dto);

    Flux<UserPO> findUserByName(String name);
}
