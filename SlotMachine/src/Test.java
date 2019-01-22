import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test implements ActionListener, KeyListener{

	private JFrame frmSlotMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frmSlotMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlotMachine = new JFrame();
		frmSlotMachine.setTitle("Slot Machine");
		frmSlotMachine.setBounds(100, 100, 1280, 728);
		frmSlotMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlotMachine.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		Image cs = new ImageIcon(this.getClass().getResource("/cs.png")).getImage();
		label.setIcon(new ImageIcon(cs));
		label.setBounds(197, 250, 128, 128);
		frmSlotMachine.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image eng = new ImageIcon(this.getClass().getResource("/english.png")).getImage();
		label_1.setIcon(new ImageIcon(eng));
		label_1.setBounds(197, 400, 128, 128);
		frmSlotMachine.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image his = new ImageIcon(this.getClass().getResource("/history.png")).getImage();
		label_2.setIcon(new ImageIcon(his));
		label_2.setBounds(197, 100, 128, 128);
		frmSlotMachine.getContentPane().add(label_2);
		
		JLabel button = new JLabel("");
		Image bt = new ImageIcon(this.getClass().getResource("/button.gif")).getImage();
		button.setIcon(new ImageIcon(bt)); 
		button.setBounds(491, 514, 245, 186);
		frmSlotMachine.getContentPane().add(button);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			System.out.println("Hello");
		}
		Component frame = new JFrame();
		JOptionPane.showMessageDialog(frame , "You just hit the enter. ");		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	

}
