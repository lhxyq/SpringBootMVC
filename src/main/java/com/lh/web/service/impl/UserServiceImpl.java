package com.lh.web.service.impl;

import com.lh.web.dao.UserDao;
import com.lh.web.domain.User;
import com.lh.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public User add(User create) {
        create.setId(UUID.randomUUID().toString());
        return userDao.save(create);
    }
}
