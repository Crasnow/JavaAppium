package tasks.zero.test3;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    public String word = "Hello";
    public String word_2 = "hello";

    @Test
    public void testGetClassString()
    {
        Assert.assertTrue("String does not contain 'Hello' or 'hello'", getClassString().contains(word) || getClassString().contains(word_2));
    }
}
