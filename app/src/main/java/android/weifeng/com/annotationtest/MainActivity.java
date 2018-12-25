package android.weifeng.com.annotationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.weifeng.com.annotationtest.annotation.CarInfo;


public class MainActivity extends AppCompatActivity {

    @CarInfo(name = "BMW",size = 100)
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //这里我们要首先注册一下这个类
        AnnotationCar.instance().inject(this);
        //当程序运行的时候这里将会输出该类Car的属性值。
        Log.e("WANG","Car is "+car.toString());
    }


    public static class Car {
        private String name;
        private int size;

        public Car(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }

}
