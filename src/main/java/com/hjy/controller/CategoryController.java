package com.hjy.controller;

import com.hjy.pojo.Category;
import com.hjy.pojo.Result;
import com.hjy.service.CategoryService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.hjy.controller
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 21:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 添加分类
     * @param category
     * @return
     */
    @PostMapping
                                            //确定校验组
    public Result add(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 查询当前用户创建的分类
     * @return
     */
    @GetMapping
    public Result<List<Category>> list(){
        List<Category> categories = categoryService.list();
        return Result.success(categories);
    }

    /**
     * 根据id查询分类的详细信息
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public Result<Category> findById(Integer id){
        return Result.success(categoryService.findById(id));
    }


    /**
     * 更新分类信息
     * @param category
     * @return
     */
    @PutMapping
                                        //确定校验组
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        categoryService.update(category);
        return Result.success();
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    public Result deleteById(@NotNull Integer id){
        categoryService.deleteById(id);
        return Result.success();
    }
}
