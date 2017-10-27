import exception.NoOrderException;
import exception.PrinterConfigurationException;

public class CashRegister {
    private Printer printer;

    public CashRegister(Printer printer) {
        if (printer == null) {
            throw new PrinterConfigurationException("No Printer found");
        }
        this.printer = printer;
    }

    public void process(Order order) {
        if (order == null) {
            throw new NoOrderException("No order found to print");
        }
        printer.print("Meow");
    }
}
