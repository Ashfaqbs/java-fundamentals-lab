package ChatGpt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimpleGame extends JPanel implements KeyListener, ActionListener {
    // Set the size of the game window
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    // Set the initial position and size of the player
    private int playerX = 100;
    private int playerY = 100;
    private int playerWidth = 20;
    private int playerHeight = 20;
    
    // Set the speed of the player's movement
    private int playerSpeed = 5;
    
    // Create a new JFrame window and add the game panel to it
    private JFrame window = new JFrame("Simple Game");
    
    public SimpleGame() {
        // Set the size of the game panel
        setSize(WIDTH, HEIGHT);
        
        // Set the background color of the game panel
        setBackground(Color.BLACK);
        
        // Add a key listener to the game panel
        addKeyListener(this);
        
        // Create the menu bar and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem startItem = new JMenuItem("Start Game");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        
        // Add action listeners to the menu items
        startItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);
        
        // Add the menu items to the menu bar
        fileMenu.add(startItem);
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        // Add the menu bar to the window
        window.setJMenuBar(menuBar);
        
        // Make the game panel focusable and request focus
        setFocusable(true);
        requestFocusInWindow();
        
        // Make the window visible and set its size
        window.add(this);
        window.setVisible(true);
        window.setSize(WIDTH, HEIGHT);
    }
    
    // Draw the player on the game panel
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }
    
    // Move the player when the arrow keys are pressed
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            playerX -= playerSpeed;
        }
        else if (key == KeyEvent.VK_RIGHT) {
            playerX += playerSpeed;
        }
        else if (key == KeyEvent.VK_UP) {
            playerY -= playerSpeed;
        }
        else if (key == KeyEvent.VK_DOWN) {
            playerY += playerSpeed;
        }
        
        // Repaint the game panel to update the player's position
        repaint();
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    // Handle menu item actions
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start Game")) {
            // Start the game
            JOptionPane.showMessageDialog(window, "Starting the game...");
        }
        else if (command.equals("Exit")) {
            // Exit the game
            System.exit(0);
        }
        else if (command.equals("About")) {
            // Show information about the game creator
            JOptionPane.showMessageDialog(window, "Simple Game\nCreated by John Doe");
        }
    }
    
    public static void main(String[] args) {
        // Create a new instance of the SimpleGame class
        SimpleGame game = new SimpleGame();
    }
}
