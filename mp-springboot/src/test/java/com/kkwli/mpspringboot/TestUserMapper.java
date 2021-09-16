package com.kkwli.mpspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kkwli.mpspringboot.mapper.UserMapper;
import com.kkwli.mpspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setEmail("1@kkwli.com");
        user.setAge(30);
        user.setUserName("曹操");
        user.setName("曹操");
        user.setPassword("123456");
        int result = this.userMapper.insert(user);
        System.out.println("result =>" + result);
        System.out.println("id =>" + user.getId());

    }

    @Test
    void testSelectById() {
        User user = this.userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(1L);
        user.setEmail("2@kkwli.com");
        user.setAge(19);
        int result = this.userMapper.updateById(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    void testUpdateByCondition() {
        User user = new User();
        user.setId(1L);
        user.setEmail("3@kkwli.com");
        user.setAge(19);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "zhangsan");
        int result = this.userMapper.update(user, wrapper);
        System.out.println(result);
    }

    @Test
    void testUpdateByCondition2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 12).set("email", "123@kkwli.com").eq("id", 3);
        int result = this.userMapper.update(null, wrapper);
        System.out.println(result);
    }

    @Test
    void testDelById() {
        int result = this.userMapper.deleteById(6);
        System.out.println(result);
    }

    @Test
    void testDelByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "zhangsan");
        map.put("password", "123456");
        int result = this.userMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    void testDel() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "sunqi").eq("password", "123456");
        int result = this.userMapper.delete(wrapper);
        System.out.println(result);
    }

    @Test
    void testDelBatchIds() {
        int result = this.userMapper.deleteBatchIds(Arrays.asList(3L, 4L));
        System.out.println(result);
    }

}
