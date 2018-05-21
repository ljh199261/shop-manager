package com.service;

import com.entity.Teacher;

public interface TeacherService {
    /**
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * @param teacher
     * @return
     */
    int updateById(Teacher teacher);

}
