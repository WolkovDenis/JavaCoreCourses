package annotation;
@MyAnnotation("Employee info")
public class Employee {

   @Validation
    String name;
    public void info(){
        System.out.println("info");
    }
}
