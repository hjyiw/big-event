package com.hjy.controller;

import com.hjy.pojo.Article;
import com.hjy.pojo.PageBean;
import com.hjy.pojo.Result;
import com.hjy.service.ArticleService;
import com.hjy.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: ArticleController
 * Package: com.hjy.controller
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/8 14:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 发布文章
     * @param article
     * @return
     */
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    /**
     * 分页查询文章
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param categoryId 文章分类ID
     * @param state 发布状态
     * @return
     */
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,Integer pageSize,
            @RequestParam(required = false) Integer categoryId,//该参数非必需
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pg = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pg);
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public Result<Article> findById(Integer id){
        Article ar = articleService.findById(id);
        return Result.success(ar);
    }

    /**
     * 更新文章信息
     * @param article
     * @return
     */
    @PutMapping
    public Result update(@RequestBody @Validated Article article){
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id){
        articleService.delete(id);
        return Result.success();
    }
}
