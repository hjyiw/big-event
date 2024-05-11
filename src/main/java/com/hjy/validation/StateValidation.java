package com.hjy.validation;

import com.hjy.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName: StateValidation
 * Package: com.hjy.validation
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 11:35
 * @Version 1.0
 */
                        //<给那个注解提供校验规则，校验的数据类型>
public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param s 将来要校验的数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return false;
        }
        if(s.equals("已发布") || s.equals("草稿")){
            return true;
        }
        return false;
    }
}
