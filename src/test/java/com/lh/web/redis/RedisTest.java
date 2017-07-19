package com.lh.web.redis;

import com.lh.web.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> userRedisTemplate;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void addStringKey() {
        stringRedisTemplate.opsForValue().set("userId", "0");
        Assert.assertEquals("0", stringRedisTemplate.opsForValue().get("userId"));
    }

    @Test
    public void addUser() {
        User user = User.builder()
                .id("001")
                .name("jedis")
                .password("123")
                .email("jedis@qq.com")
                .build();

        User user2 = User.builder()
                .id("002")
                .name("redis")
                .password("123")
                .email("redis@qq.com")
                .build();

        userRedisTemplate.opsForValue().set(user.getId(), user);
        Assert.assertEquals("001", ((User)userRedisTemplate.opsForValue().get("001")).getId());

        userRedisTemplate.opsForValue().set(user2.getId(), user2);
        Assert.assertEquals("002", ((User)userRedisTemplate.opsForValue().get("002")).getId());
    }

    @Test
    public void cacheManagerType() {
        Cache cache = cacheManager.getCache("users~keys");
        User user = cache.get("xyq", User.class);
        Assert.assertEquals("xyq", user.getName());
    }
}
