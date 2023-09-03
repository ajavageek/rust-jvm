package ch.frankel.blog.rust;

public class Main {

    private int state;

    static {
        System.loadLibrary("dummymath");
    }

    public Main(int state) {
        this.state = state;
    }

    public Main() {
        this(-1);
    }

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "double";
        args[1] = "2";
        if (args.length == 0) {
            throw new IllegalArgumentException("You must provide a method and its parameters");
        }
        var arg = args[0];
        switch (arg) {
            case "double":
                double_(args);
                break;
            case "times":
                times(args);
                break;
        }
    }

    public static void double_(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("You must provide an int parameter");
        }
        try {
            var arg = Integer.parseInt(args[1]);
            var result = new Main().doubleRust(arg);
            System.out.println(arg + "x2 = " + result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Argument must be an int");
        }
    }

    public static void times(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("You must provide two int parameters");
        }
        try {
            var arg1 = Integer.parseInt(args[1]);
            var arg2 = Integer.parseInt(args[2]);
            var result = new Main(arg1).timesRust(arg2);
            System.out.println(arg1 + "x" + arg2 + " = " + result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments must be ints");
        }
    }

    public native int doubleRust(int input);
    public native int timesRust(int input);
}
