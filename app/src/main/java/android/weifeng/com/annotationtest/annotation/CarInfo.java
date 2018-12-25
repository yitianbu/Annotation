package android.weifeng.com.annotationtest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @anthor weifeng
 * @time 2018/12/18 下午5:09
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CarInfo {
    String name () default "" ;

    int size () default 0 ;

}
