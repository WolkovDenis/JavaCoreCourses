package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {

            String methodName = reader.readLine();
            String firstArgs = reader.readLine();
            String secondArgs = reader.readLine();
            Calculator calculator = new Calculator();

            Class<?> aClass = Class.forName("reflection.Calculator");
            Method[] methods = aClass.getMethods();
            Method realMethod = null;
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    realMethod = method;
                }
            }
            realMethod.invoke(calculator, Integer.parseInt(firstArgs), Integer.parseInt(secondArgs));
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
