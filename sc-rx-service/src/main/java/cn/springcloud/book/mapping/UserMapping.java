package cn.springcloud.book.mapping;

import cn.springcloud.book.model.dto.UserDto;
import cn.springcloud.book.model.entity.User;

import org.springframework.beans.BeanUtils;

/**
 * @author chujingnian
 */
public class UserMapping {

    public static User userDto2Entity(UserDto dto) {
        User user = new User();
        if (dto != null) {
            BeanUtils.copyProperties(dto, user);
        }
        return user;
    }

    public static UserDto userEntity2Dto(User user) {
        UserDto dto = new UserDto();
        if (user != null) {
            BeanUtils.copyProperties(user, dto);
        }
        return dto;
    }
}
