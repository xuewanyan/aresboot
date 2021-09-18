/**
 * @author xy
 * @date 2021-9-6
 */
public class Person {
    public Person(){
        System.out.println("this is a person");
    }
}

class Teacher extends Person{
    private String name = "tom";
    public Teacher(){
        super();
        System.out.println("teacher");
    }

    public static void main(String[] args) {

    }
}