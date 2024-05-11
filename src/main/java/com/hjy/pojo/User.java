package com.hjy.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

//lombok 在编译阶段，为实体类自动生成setter getter toString
//使用：在pom文件中引入依赖    在实体类上添加注解
@Data
public class User {
    //使用validatied下的注解进行参数校验
    @NotNull //不能为null
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore // 让springmvc把当前对象转换成json字符串的时候，忽略password
    private String password;//密码

    @NotEmpty //不能为null 或 空字符
    @Pattern(regexp = "^\\S{1,10}$") //1-10个非空字符
    private String nickname;//昵称

    @NotEmpty
    @Email
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
