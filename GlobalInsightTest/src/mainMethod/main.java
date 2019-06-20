package mainMethod;

import org.junit.runner.JUnitCore;

import TestRunner.Runner;
import cucumber.api.cli.Main;
import junit.textui.TestRunner;

public class main {

	public static void main(String[] args) throws Throwable {

		String [] argv = new String[]{ "-g","","Features/MyTest.feature"};
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		byte exitstatus = Main.run(argv, contextClassLoader);

     }
}
