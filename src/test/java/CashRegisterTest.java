import exception.NoOrderException;
import exception.PrinterConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;

public class CashRegisterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCheckIfCashRegisterHasPrinter() {
        exception.expect(PrinterConfigurationException.class);
        exception.expectMessage("No Printer found");
        new CashRegister(null);
    }

    @Test
    public void shouldNotPrintWhenNoPurchase() {
        DummyPrinter printer = new DummyPrinter();
        CashRegister cashRegister = new CashRegister(printer);
        exception.expect(NoOrderException.class);
        exception.expectMessage("No order found to print");

        cashRegister.process(null);

        assertFalse(printer.wasPrintCalled());
    }

    class DummyPrinter extends Printer {
        private boolean wasCalled = false;

        public void print(String printThis) {
            wasCalled = true;
        }

        public boolean wasPrintCalled() {
            return wasCalled;
        }
    }
}
