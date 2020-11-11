package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.commonutils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-11
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //1、查询讲师表所有数据
    //http://localhost:8001/eduservice/teacher/findAll
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher() {
        //调用service的方法实现查询所有的操作
        List<EduTeacher> list = teacherService.list(null);
        return list;
    }

    //2 逻辑删除讲师的方法
    //http://localhost:8001/eduservice/teacher/1
    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable String id){
        return teacherService.removeById(id);
    }


    //1 查询讲师表所有数据
    //http://localhost:8001/eduservice/teacher/R_findAll
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("R_findAll")
    public R R_findAllTeacher() {
        //调用service的方法实现查询所有的操作
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    //2 逻辑删除讲师的方法
    //http://localhost:8001/eduservice/teacher/R/1
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("R/{id}")
    public R R_removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

