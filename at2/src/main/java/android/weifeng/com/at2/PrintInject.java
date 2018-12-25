package android.weifeng.com.at2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @anthor weifeng
 * @time 2018/12/18 下午6:03
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})  //声明此类可以注解的对象
@Retention(RetentionPolicy.CLASS)                                   //编译时运行
public @interface PrintInject {                                     //@interface声明
    int value();                                                    //定义有一个int参数
}