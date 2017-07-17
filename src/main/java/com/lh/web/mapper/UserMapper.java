package com.lh.web.mapper;

import com.lh.web.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */
@Repository
public interface UserMapper {
    User findByName(String name);
}
