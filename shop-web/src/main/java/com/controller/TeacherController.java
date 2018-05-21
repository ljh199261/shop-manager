package com.controller;


import com.entity.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping(value = "/updateTeacher")
    @ResponseBody
    public void updateTeacher(Teacher teacher){
        teacherService.updateById(teacher);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    public void deleteById(@RequestParam(value = "id",required = true) Integer id){
        teacherService.deleteById(id);
    }

}
