package cn.springcloud.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springcloud.book.dao.UserRepository;
import cn.springcloud.book.mapper.UserMapper;
import cn.springcloud.book.model.document.UserPO;
import cn.springcloud.book.model.dto.UserDto;
import cn.springcloud.book.model.entity.User;
import cn.springcloud.book.service.UserService;
import reactor.core.publisher.Flux;

/**
 * @author chujingnian
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PageInfo<User> getUserList(Integer page, Integer size) {

        //        Page page1 = new Page();
        //        page1.setCurrentPage(page);
        //        if (size != null) {
        //            page1.setPageNumber(size);
        //        }
        //        Map<String, Object> map = new HashMap<>();
        //        map.put("page", page1);
        //        map.put("tenantId", tenantId);
        //
        //        PageResult<RuleDomain> result = new PageResult<RuleDomain>(page1, ruleMapper.getRuleByPage(map));
        PageHelper.startPage(page, size);
        List<User> users = userMapper.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    @Override
    public User getUserDetail(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long saveUser(UserDto dto) {
        return null;
    }

    @Override
    public Flux<UserPO> findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
