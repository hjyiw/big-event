package com.hjy.service.impl;

import com.hjy.mapper.CategoryMapper;
import com.hjy.pojo.Category;
import com.hjy.pojo.Result;
import com.hjy.service.CategoryService;
import com.hjy.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.hjy.service.impl
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 21:25
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer u_id = (Integer) map.get("id");
        category.setCreateUser(u_id);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer u_id = (Integer) map.get("id");
        return categoryMapper.list(u_id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    @Override
    public void deleteById(Integer id) {

        categoryMapper.delete(id);
    }
}
