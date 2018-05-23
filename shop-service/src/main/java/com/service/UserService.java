package com.service;

import com.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    /**
     * @param id
     * @return
     */
    User selectUser(Integer id);

    /**
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * @return
     */
    PageInfo selectAll();

}
