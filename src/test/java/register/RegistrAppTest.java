package register;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Test
public class RegistrAppTest{
    /*public void testCase0() throws Exception {
        generic(0);
    }
*/
    @Test(invocationCount = 100, threadPoolSize = 100)
    public void testCase1() throws Exception {
        generic(0);
    }

    @Test(expectedExceptions = InvalidInformationException.class)
    public void testCase2() throws Exception{
        generic(1);
    }

    private void generic(int i) throws Exception {
        List<String> input = readInput(i);
        String output = readOutput(i);
        RegistrApp register = new RegistrApp();
        String response = register.validation(input);
        Assert.assertEquals(response, output);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}