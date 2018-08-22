package com.example.demo.web.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BaseModle {

    @TableField("creator")
    private String creator;
    
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    @TableField("updator")
    private String updator;
    
    @TableField("update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    
    @TableField("state")
    private int state;
}
