package ChatGpt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Automation_script {
	public static void main(String[] args) throws AWTException {
	    Robot robot = new Robot();

	    // Open web browser
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_T);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    // Wait for web browser to load
	    robot.delay(5000);

	    // Navigate to website
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_L);
	    robot.keyRelease(KeyEvent.VK_L);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.delay(1000);
	    robot.keyPress(KeyEvent.VK_H);
	    robot.keyPress(KeyEvent.VK_T);
	    robot.keyPress(KeyEvent.VK_T);
	    robot.keyPress(KeyEvent.VK_P);
	    robot.keyPress(KeyEvent.VK_S);
	    robot.keyPress(KeyEvent.VK_COLON);
	    robot.keyPress(KeyEvent.VK_SLASH);
	    robot.keyPress(KeyEvent.VK_SLASH);
	    robot.keyPress(KeyEvent.VK_W);
	    robot.keyPress(KeyEvent.VK_W);
	    robot.keyPress(KeyEvent.VK_W);
	  //  robot.keyPress(KeyEvent.VK_DOT);
	    robot.keyPress(KeyEvent.VK_E);
	    robot.keyPress(KeyEvent.VK_X);
	    robot.keyPress(KeyEvent.VK_A);
	    robot.keyPress(KeyEvent.VK_M);
	    robot.keyPress(KeyEvent.VK_P);
	    robot.keyPress(KeyEvent.VK_L);
	    robot.keyPress(KeyEvent.VK_E);
	    //robot.keyPress(KeyEvent.VK_DOT);
	    robot.keyPress(KeyEvent.VK_C);
	    robot.keyPress(KeyEvent.VK_O);
	    robot.keyPress(KeyEvent.VK_M);
	    robot.keyPress(KeyEvent.VK_ENTER);
	  }

}
