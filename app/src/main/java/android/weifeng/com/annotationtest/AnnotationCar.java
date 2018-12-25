package android.weifeng.com.annotationtest;

import android.weifeng.com.annotationtest.annotation.CarInfo;

import java.lang.reflect.Field;

/**
 * @anthor weifeng
 * @time 2018/12/18 下午5:11
 */
public class AnnotationCar {
    private static AnnotationCar annotationCar;
    public static AnnotationCar instance(){
        synchronized (AnnotationCar.class){
            if(annotationCar == null){
                annotationCar = new AnnotationCar();
            }
            return annotationCar;
        }
    }

    public void inject(Object o){
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields) {
            if(field.getName().equals("car") && field.isAnnotationPresent(CarInfo.class)) {
                CarInfo annotation = field.getAnnotation(CarInfo.class);
                Class<?> type = field.getType();
                if(MainActivity.Car.class.equals(type)) {
                    try {
                        field.setAccessible(true);
                        field.set(o, new MainActivity.Car(annotation.name(), annotation.size()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
