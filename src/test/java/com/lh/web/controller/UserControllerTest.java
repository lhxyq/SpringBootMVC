package com.lh.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.HashMap;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/user/create"))
                .param("name", "LH")
                .param("password", "123")
                .param("email", "ww"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":5,\"mag\":\"密码少于5位，还是太短了\",\"data\":null}"));
    }
}
