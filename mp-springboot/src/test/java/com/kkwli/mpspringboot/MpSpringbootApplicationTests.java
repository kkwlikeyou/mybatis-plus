package com.kkwli.mpspringboot;

import com.kkwli.mpspringboot.mapper.UserMapper;
import com.kkwli.mpspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpSpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelectList() {
        List<User> userList = this.userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
