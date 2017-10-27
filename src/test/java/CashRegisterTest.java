import exception.PrinterConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class CashRegisterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCheckIfCashRegisterHasPrinter() {
        exception.expect(PrinterConfigurationException.class);
        exception.expectMessage("No Printer found");
        new CashRegister(null);
    }
}
