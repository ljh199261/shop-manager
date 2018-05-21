package com.service.impl;

import com.entity.Teacher;
import com.mapper.TeacherMapper;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,  rollbackFor = Exception.class)
    public int deleteById(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }


    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int updateById(Teacher teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
