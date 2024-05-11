package com.hjy.mapper;

import com.hjy.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ArticleMapper
 * Package: com.hjy.mapper
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 10:38
 * @Version 1.0
 */
@Mapper
public interface ArticleMapper {
    //添加文章
    @Insert("insert into article(title, content, state,cover_img, category_id," +
            " create_user, create_time, update_time) " +
            "values (#{title}, #{content},#{state}," +
            "#{coverImg},  #{categoryId}," +
            " #{createUser}, #{createTime}," +
            " #{updateTime})" )
    void add(Article article);

    //分页查询
    List<Article> list(Integer uId, Integer categoryId, String state);

    //根据id查询文章
    @Select("select * from article where id = #{id}")
    Article findById(Integer id);

    //更新文章
    @Update("update article set title = #{title}," +
            "content = #{content},cover_img = #{coverImg}," +
            "state = #{state},category_id = #{categoryId}," +
            "update_time = #{updateTime} where id = #{id}")
    void update(Article article);

    //删除文章
    @Delete("delete from article where id = #{id}")
    void delete(Integer id);
}
