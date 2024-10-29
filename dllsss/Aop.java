package dllsss;

public class Aop {
    public native int add(int a, int b);
    public native int sub(int a, int b);
    public native int mul(int a, int b);
    public native int div(int a, int b);

    static {
        System.loadLibrary("Aop");
    }

    public static void main(String[] args) {
        Aop aop = new Aop();

        int a = 10, b = 100;
        System.out.println("ADD-> " + aop.add(a, b));
        System.out.println("ADD-> " + aop.sub(a, b)); 
        System.out.println("ADD-> " + aop.mul(a, b)); 
        System.out.println("ADD-> " + aop.div(a, b)); 
    }
}
