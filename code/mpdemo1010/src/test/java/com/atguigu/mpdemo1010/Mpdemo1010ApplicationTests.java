package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @author XUAN
 * @date 2020/11/10 - 17:59
 * @checkPoint 运行 findAll() 可见数据库中 user 表所有数据
 */
@SpringBootTest
public class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询user表所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //添加操作
    @Test
    public void addUser() {

        // MyBatis-Plus 可自动生成一个十九位的 ID
        // MyBatis-Plus 默认的主键策略：ID_WORKER
        // ID_WORKER : p自带策略，生成19位值，数字类型使用这种策略，比如long

        User user = new User();
        user.setName("lucy2");
        user.setAge(70);
        user.setEmail("lucy@qq.com");

        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
    }

    //修改操作
    @Test
    public void updateUser() {

        User user = new User();
        user.setId(2L);
        user.setAge(120);

        int row = userMapper.updateById(user);
        System.out.println(row);
    }

}
