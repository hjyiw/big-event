package com.hjy.anno;

import com.hjy.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * ClassName: State
 * Package: com.hjy.anno
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 11:24
 * @Version 1.0
 */
@Documented //元注解：State注解可以抽取到帮助文档
@Target(ElementType.FIELD)//元注解：标注State注解可以用在那些地方，这里只用在属性上
@Retention(RetentionPolicy.RUNTIME) //元注解 ：State注解会在那个阶段保留，这里是运行时
@Constraint(validatedBy = {StateValidation.class}) // 指定那个类提供校验规则
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的值只能是 已发布 或者 草稿";

    //指定分组
    Class<?>[] groups() default {};

    //负载    获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
