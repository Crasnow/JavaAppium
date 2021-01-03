package tasks.zero.test1;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber() {
        Assert.assertTrue("14 != 14", getLocalNumber() == 14);
    }
}
