package cn.springcloud.book.mapper;

import cn.springcloud.book.model.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {

    @Select({
        "select",
        "user.id as user_id, user.name as user_name, user.comment as user_comment",
        "from users user",
        "where user.id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column = "user_id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        @Result(column = "user_name", property = "name", jdbcType = JdbcType.VARCHAR),
        @Result(column = "user_comment", property = "comment", jdbcType = JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);

    @Results(id = "getUserList", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "comment", column = "comment")})
    @Select("<script> "
            + " select user.id, user.name, user.comment"
            + " from users user"
            + " </script> ")
    List<User> getUserList();
}
