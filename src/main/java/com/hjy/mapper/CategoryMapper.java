package com.hjy.mapper;

import com.hjy.pojo.Category;
import com.hjy.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: CategoryMapper
 * Package: com.hjy.mapper
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 21:26
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper {
    //添加分类
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time)" +
            " values(#{categoryName}, #{categoryAlias},#{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    //查询当前用户创建的分类
    @Select("select * from category where create_user = #{u_id}")
    List<Category> list(Integer u_id);

    //获取某一分类的详细信息
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    //根据id更新分类信息
    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}," +
            "update_time = #{updateTime} where id = #{id}")
    void update(Category category);

    //根据id删除分类
    @Delete("delete from category where id = #{id}")
    void delete(Integer id);
}
