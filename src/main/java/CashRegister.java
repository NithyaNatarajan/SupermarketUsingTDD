import exception.PrinterConfigurationException;

public class CashRegister {
    public CashRegister(Printer printer) {
        throw new PrinterConfigurationException("No Printer found");
    }
}
