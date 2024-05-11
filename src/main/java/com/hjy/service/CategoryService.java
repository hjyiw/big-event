package com.hjy.service;

import com.hjy.pojo.Category;
import com.hjy.pojo.Result;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.hjy.service
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 21:25
 * @Version 1.0
 */
public interface CategoryService {
    //添加分类
    void add(Category category);

    //查询当前用户创建的分类
    List<Category> list();

    //获取某一分类的详细信息
    Category findById(Integer id);

    //根据id更新分类信息
    void update(Category category);

    //根据id删除分类
    void deleteById(Integer id);
}
