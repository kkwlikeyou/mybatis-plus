package com.kkwli.mpspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkwli.mpspringboot.mapper.UserMapper;
import com.kkwli.mpspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @Test
    void testSelectBatchByIds() {
        List<User> userList = this.userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    void testSelectOne() {
        User user = new User();
        user.setId(1L);
        user.setPassword("123456");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void testSelectCount() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20);
        Long count = this.userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    void testSelectList() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20);
        List<User> userList = this.userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 有问题
     */
    @Test
    void testSelectPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.gt("age", 20); //年龄大于20岁
        Page<User> page = new Page<>(1, 1);
        //根据条件查询数据
        IPage<User> iPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数：" + iPage.getTotal());
        System.out.println("总页数：" + iPage.getPages());
        List<User> users = iPage.getRecords();
        for (User user : users) {
            System.out.println("user = " + user);
        }


    }
}
