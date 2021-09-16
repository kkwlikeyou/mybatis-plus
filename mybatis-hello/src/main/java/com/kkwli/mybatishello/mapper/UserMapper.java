package com.kkwli.mybatishello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkwli.mybatishello.domain.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    List<User> findAll();
}
