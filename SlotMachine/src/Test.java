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
import java.util.Random;

import javax.swing.JButton;

public class Test
{

	private JFrame frmSlotMachine;
	private int[][] board = new int[3][3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Test window = new Test();
					window.frmSlotMachine.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmSlotMachine = new JFrame();
		frmSlotMachine.setTitle("Slot Machine");
		frmSlotMachine.setBounds(100, 100, 1280, 728);
		frmSlotMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlotMachine.getContentPane().setLayout(null);
		
		//Setup images that needed to be used. 
		Image background = new ImageIcon(this.getClass().getResource("/NewSlotMachineBackground.jpg")).getImage();
		Image bio = new ImageIcon(this.getClass().getResource("/biology.png")).getImage();
		Image chem = new ImageIcon(this.getClass().getResource("/chemistry.png")).getImage();
		Image chinese = new ImageIcon(this.getClass().getResource("/chinese.png")).getImage();
		Image cs = new ImageIcon(this.getClass().getResource("/cs.png")).getImage();
		Image eng = new ImageIcon(this.getClass().getResource("/english.png")).getImage();
		Image his = new ImageIcon(this.getClass().getResource("/history.png")).getImage();
		Image math = new ImageIcon(this.getClass().getResource("/maths.png")).getImage();
		Image physics = new ImageIcon(this.getClass().getResource("/physics.png")).getImage();
		
		String[] picNames = new String[8];//The equivalent number of the picture. 
		picNames[0] = "bio";
		picNames[1] = "chem";
		picNames[2] = "chinese";
		picNames[3] = "cs";
		picNames[4] = "eng";
		picNames[5] = "his";
		picNames[6] = "math";
		picNames[7] = "physics";
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(cs));
		label.setBounds(205, 275, 128, 128);
		frmSlotMachine.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(eng));
		label_1.setBounds(205, 425, 128, 128);
		frmSlotMachine.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(his));
		label_2.setBounds(205, 125, 128, 128);
		frmSlotMachine.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(bio));
		label_3.setBounds(576, 125, 128, 128);
		frmSlotMachine.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(chem));
		label_4.setBounds(576, 275, 128, 128);
		frmSlotMachine.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(chinese));
		label_5.setBounds(576, 425, 128, 128);
		frmSlotMachine.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(physics));
		label_6.setBounds(949, 125, 128, 128);
		frmSlotMachine.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(math));
		label_7.setBounds(949, 275, 128, 128);
		frmSlotMachine.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(physics));
		label_8.setBounds(949, 425, 128, 128);
		frmSlotMachine.getContentPane().add(label_8);
		
		JButton button = new JButton("");
		button.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					label.setVisible(false);
					System.out.println("Key pressed! ");
				}
			}
		});
		Image bt = new ImageIcon(this.getClass().getResource("/button.gif")).getImage();
		button.setIcon(new ImageIcon(bt));
		button.setBounds(491, 514, 245, 186);
		frmSlotMachine.getContentPane().add(button);
		
		//Random rand = new Random();

		//Background img
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(background));
		Background.setBounds(0, 0, 1262, 681);
		frmSlotMachine.getContentPane().add(Background);
	}
	
	private static void spin()
	{
		
	}
}
