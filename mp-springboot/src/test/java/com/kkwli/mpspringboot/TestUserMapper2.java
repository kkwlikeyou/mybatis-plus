package com.kkwli.mpspringboot;

import com.kkwli.mpspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestUserMapper2 {

    @Test
    void testSelectById() {
        User user = new User();
        user.setId(2L);
        User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setUserName("jiba");
        user.setPassword("654321");
        user.setEmail("654321@kkwli.com");
        user.setAge(17);
        boolean b = user.insert();
        System.out.println(b);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(6L);
        user.setUserName("jiba");
        user.setPassword("654321");
        user.setEmail("654321@kkwli.com");
        user.setAge(17);
        user.setName("jiba");
        boolean b = user.updateById();
        System.out.println(b);
    }

    @Test
    void testDeleteById() {
        User user = new User();
        user.setId(6L);
        boolean b = user.deleteById();
        System.out.println(b);
    }
}
