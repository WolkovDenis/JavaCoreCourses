package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MainAnnotation {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee();
        employee.name = "r";
        Class<? extends Employee> aClass = employee.getClass();

        Field name = aClass.getDeclaredField("name");
        String firstName = null;
        Validation annotation = null;
        if (name.isAnnotationPresent(Validation.class)) {
            annotation = name.getAnnotation(Validation.class);
            firstName = (String) name.get(employee);
        }
        if (firstName.length() >= annotation.min() && firstName.length() <= annotation.max()) {
            System.out.println("Validation ");
        } else throw new NotValidException("Field not valid length" + firstName.length());

//        MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
//        System.out.println(annotation.value());

//        Annotation[] annotations = aClass.getAnnotations();
//        for (Annotation annotation : annotations) {
//            if (annotation.annotationType().isAnnotationPresent(MyAnnotation.class)) {
//           }
//        }
    }
}
