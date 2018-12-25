package android.weifeng.com.at2;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/**
 * @anthor weifeng
 * @time 2018/12/18 下午6:41
 */
@SupportedAnnotationTypes("com.example.PrintInject")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class PrintInjectProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();

        Iterator iterator = annotations.iterator();
        while (iterator.hasNext()) {
            TypeElement te = (TypeElement) iterator.next();
            for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + e.toString());
            }
        }
        return true;
    }
}
