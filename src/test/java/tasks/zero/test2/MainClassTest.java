package tasks.zero.test2;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassNumber()
    {
        Assert.assertTrue("20 <= 45", getClassNumber() > 45);
    }
}
