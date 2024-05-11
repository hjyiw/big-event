package com.hjy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    //指定校验组
    @NotNull(groups = Update.class) //不能不传
    private Integer id;//主键ID
    @NotEmpty/*(groups = {Add.class,Update.class})*///不能不传并且是字符串的话还不能为空字符串
    private String categoryName;//分类名称
    //默认属于Default校验组
    @NotEmpty/*(groups = {Add.class,Update.class})*/
    private String categoryAlias;//分类别名
    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间

    // 如果说某个校验项没有指定分组，默认属于Default分组
    // 分组之间可以继承，A extends B     那么A中拥有B中的所有校验项

    //给参数校验提供分组（用接口表示一个接口）
    //添加组
    public interface Add extends Default {

    }
    //更新组
    public interface Update extends Default{

    }

}
