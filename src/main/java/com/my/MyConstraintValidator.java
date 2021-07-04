package com.my;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
@Override
public void initialize(MyConstraint myConstraint) {
//初始化的时候
System.out.println("my validator init");
}
 
@Override
public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
//这里写判断逻辑
System.out.println(o);
//我这里直接方法false，就是要提示错误，如果返回true就表示验证通过
return false;
}}
