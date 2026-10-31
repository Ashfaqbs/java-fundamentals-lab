package ChatGpt;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Keylogger2 implements KeyListener{
	 public static void main(String[] args) {
		 Keylogger2 keylogger = new Keylogger2();
	        keylogger.start();
	    }

	    public void start() {
	        // add a key listener to the current frame
	    	
	        //addKeyListener(this);
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	        // do something when a key is pressed
	        System.out.println("Key pressed: " + e.getKeyChar());
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	        // do something when a key is released
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	        // do something when a key is typed
	    }

}
