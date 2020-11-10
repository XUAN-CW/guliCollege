package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 在这里设置主键生成策略
    @TableId(type = IdType.NONE)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
