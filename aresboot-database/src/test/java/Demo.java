/**
 * @author xy
 * @date 2021-8-31
 */
public class Demo {
    private String name = "44";
    public Demo(){
        System.out.println("nnnn");
    }
    public Demo(String name){
        this.name = name;
        System.out.println("yyy" + this.name);
    }
}

class TEST1 {
    public static void main(String[] args) {
        Demo demo = new Demo("433");
        Demo demo3 = new Demo("111");
        System.out.println(Demo.class);

    }
}