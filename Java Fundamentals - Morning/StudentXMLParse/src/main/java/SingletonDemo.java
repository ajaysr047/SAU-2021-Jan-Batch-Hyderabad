class Printer
{
    private static Printer singletonPrinter = new Printer();

    private Printer(){}

    public static  Printer getInstance(){
        return singletonPrinter;
    }

    protected static void printData(String data){
        System.out.println(data);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Printer printer = Printer.getInstance();
        printer.printData("Data printed from Printer Singleton!");
    }
}
