package dllsss;

public class ArithmeticOperations {
    
    public native int add(int a, int b);
    public native int subtract(int a, int b);
    public native int mul(int a, int b);
    public native int divide(int a, int b);

    static {
        System.loadLibrary("ArithmeticOperations");
    }

    public static void main(String[] args) {
        ArithmeticOperations ops = new ArithmeticOperations();
        int a = 10, b = 20;

        System.out.println("Addition --> " + ops.add(a, b));
        System.out.println("Subtraction --> " + ops.subtract(a, b));
        System.out.println("Mul---> " + ops.mul(a, b));
        System.out.println("Divide --> " + ops.divide(a, b));
    }

}
