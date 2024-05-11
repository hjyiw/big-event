package com.hjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hjy.mapper.ArticleMapper;
import com.hjy.pojo.Article;
import com.hjy.pojo.PageBean;
import com.hjy.service.ArticleService;
import com.hjy.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ArticleServiceImpl
 * Package: com.hjy.service.impl
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 10:39
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String , Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1. 创建pageBean对象
        PageBean<Article> pg = new PageBean<>();
        //2. 开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //3. 调用mapper
        Map<String , Object> map = ThreadLocalUtil.get();
        Integer u_id = (Integer) map.get("id");
        List<Article> res =  articleMapper.list(u_id,categoryId,state);
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录数和当前页数
        Page<Article> p = (Page<Article>) res;
        pg.setTotal(p.getTotal());
        pg.setItems(p.getResult());
        return pg;
    }

    @Override
    public Article findById(Integer id) {
        Article ar = articleMapper.findById(id);
        return ar;
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
