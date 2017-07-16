package com.lh.web.dao;

import com.lh.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LH 2446059046@qq.com on 2017/7/16.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
