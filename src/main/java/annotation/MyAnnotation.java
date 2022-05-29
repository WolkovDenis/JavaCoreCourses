package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface MyAnnotation {
    String value() default "Инфо";
}
