package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("reflection.Doctor");
        Field field = aClass.getField("name");
        System.out.println(field);

        System.out.println("-------------------------");

        Field[] fields = aClass.getFields();
        for (Field field1 : fields) {
            System.out.println(field);
        }
        System.out.println("-----------");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("--------------------------");

        Method getNameMethod = aClass.getMethod("getName");
        Parameter[] parameters = getNameMethod.getParameters();
        System.out.println(Arrays.toString(parameters));

        Doctor doctor = (Doctor) aClass.newInstance();

        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        Doctor doctor1 = (Doctor) constructor.newInstance("Denis");
        Doctor doctor2 = new Doctor();

        String name = (String) getNameMethod.invoke(doctor1);
        System.out.println(name);
    }
}

