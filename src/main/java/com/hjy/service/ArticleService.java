package com.hjy.service;

import com.hjy.pojo.Article;
import com.hjy.pojo.PageBean;

/**
 * ClassName: ArticleService
 * Package: com.hjy.service
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 10:38
 * @Version 1.0
 */
public interface ArticleService {

    //添加文章
    void add(Article article);

    //分页查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //根据id查询文章
    Article findById(Integer id);

    //更新文章
    void update(Article article);

    //删除文章
    void delete(Integer id);
}
