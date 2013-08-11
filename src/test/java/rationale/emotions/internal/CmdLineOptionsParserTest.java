package rationale.emotions.internal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

public class CmdLineOptionsParserTest {
    @Test(groups = "unit")
    public void testGetParamValue() {
        String[] args = { "#foo", "10" };
        CmdLineOptionsParser parser = new CmdLineOptionsParser(args);
        assertEquals(10, parser.getParamValue("#foo"));
    }

    @Test(groups = "unit", expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "foo doesn't begin with a '#' symbol.")
    public void testGetParamValueNoHashSymbol() {
        String[] args = { "#foo", "10" };
        new CmdLineOptionsParser(args).getParamValue("foo");
    }

    @Test(groups = "unit", expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "#bar was not provided at all.")
    public void testGetParamValueInvalidArg() {
        String[] args = { "#foo", "10" };
        new CmdLineOptionsParser(args).getParamValue("#bar");
    }

    @Test(groups = "unit", expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "#foo was specified but no value specified for it.")
    public void testGetParamValueArgNotPresent() {
        String[] args = { "#foo" };
        new CmdLineOptionsParser(args).getParamValue("#foo");
    }

    @Test(groups = "unit")
    public void testIsParamPresent() {
        String[] args = { "#foo" };
        assertTrue(new CmdLineOptionsParser(args).isParamPresent("#foo"));
    }

    @Test(groups = "unit")
    public void testIsParamPresentNegative() {
        String[] args = { "#foo" };
        assertFalse(new CmdLineOptionsParser(args).isParamPresent("#bar"));
    }
    
    @Test(groups = "unit", expectedExceptions = { IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "foo doesn't begin with a '#' symbol.")
    public void testIsParamPresentNoHashSymbol() {
        String[] args = { "#foo", "10" };
        new CmdLineOptionsParser(args).isParamPresent("foo");
    }
    
}
