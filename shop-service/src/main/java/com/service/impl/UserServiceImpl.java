package com.service.impl;

import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer id){
        User user=userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public PageInfo selectAll() {
        PageHelper.startPage(1,10);
        List<User> userList = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }


}
