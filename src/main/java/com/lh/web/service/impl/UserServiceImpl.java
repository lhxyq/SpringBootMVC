package com.lh.web.service.impl;

import com.lh.web.dao.UserDao;
import com.lh.web.domain.User;
import com.lh.web.mapper.UserMapper;
import com.lh.web.service.UserService;
import com.lh.web.util.common.ResultEnum;
import com.lh.web.util.common.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by LH 2446059046@qq.com on 2017/7/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    @CachePut(value="user", key = "#create.name")
    @Override
    public User add(User create) {
        create.setId(UUID.randomUUID().toString());
        create.setPassword(passwordEncoder.encodePassword(create.getPassword(), ""));
        return userDao.save(create);
    }

    @Cacheable(value="user", key="#name")
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
//        return userMapper.findByName(name);
    }

    @Override
    public User create(User create) throws Exception{
        if (3 > create.getPassword().length())
            throw new WebException(ResultEnum.TOO_LITTLE);
        if (5 > create.getPassword().length())
            throw new WebException(ResultEnum.OSO_LITTLE);

        create.setId(UUID.randomUUID().toString());
        return create;
    }
}
