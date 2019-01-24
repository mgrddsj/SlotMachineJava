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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

public class Test {

	private JFrame frmSlotMachine;
	private int[][] board = new int[3][3];
	private static List<JLabel> slots = new ArrayList<JLabel>(3);
	private static List<Image> images = new ArrayList<Image>(8);
	private static JLabel label;
	
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
		frmSlotMachine.setBounds(100, 100, 1366, 768);
		frmSlotMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlotMachine.getContentPane().setLayout(null);
		
		// Setup images that needed to be used.
		Image background = new ImageIcon(this.getClass().getResource("/NewNewSlotMachineBackground.jpg")).getImage();
		Image bio = new ImageIcon(this.getClass().getResource("/biology.png")).getImage();
		Image chem = new ImageIcon(this.getClass().getResource("/chemistry.png")).getImage();
		Image chinese = new ImageIcon(this.getClass().getResource("/chinese.png")).getImage();
		Image cs = new ImageIcon(this.getClass().getResource("/cs.png")).getImage();
		Image eng = new ImageIcon(this.getClass().getResource("/english.png")).getImage();
		Image his = new ImageIcon(this.getClass().getResource("/history.png")).getImage();
		Image math = new ImageIcon(this.getClass().getResource("/maths.png")).getImage();
		Image physics = new ImageIcon(this.getClass().getResource("/physics.png")).getImage();

		//Add images into list. 
		images.add(background);
		images.add(bio);
		images.add(chem);
		images.add(chinese);
		images.add(cs);
		images.add(eng);
		images.add(his);
		images.add(math);
		images.add(physics);
		
		/*
		String[] picNames = new String[8];//The equivalent number of the picture. 
		picNames[0] = "bio";
		picNames[1] = "chem";
		picNames[2] = "chinese";
		picNames[3] = "cs";
		picNames[4] = "eng";
		picNames[5] = "his";
		picNames[6] = "math";
		picNames[7] = "physics";
		*/
		
		JLabel label = new JLabel("");
		slots.add(label);
		label.setIcon(new ImageIcon(images.get(4)));
		label.setBounds(228, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		slots.add(label_1);
		label_1.setIcon(new ImageIcon(eng));
		label_1.setBounds(228, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		slots.add(label_2);
		label_2.setIcon(new ImageIcon(his));
		label_2.setBounds(228, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(bio));
		label_3.setBounds(623, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(chem));
		label_4.setBounds(623, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(chinese));
		label_5.setBounds(623, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(physics));
		label_6.setBounds(1013, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(math));
		label_7.setBounds(1013, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(physics));
		label_8.setBounds(1013, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_8);
		
		JButton button = new JButton("");
		button.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
//					label.setVisible(false);
//					replace(label, 1);
					System.out.println("Key pressed! ");
					rollUntil(1, 1, 1);
				}
			}
		});
		Image bt = new ImageIcon(this.getClass().getResource("/button.gif")).getImage();
		button.setIcon(new ImageIcon(bt));
		button.setBounds(533, 576, 245, 170);
		frmSlotMachine.getContentPane().add(button);
		
		//Random rand = new Random();

		//Background img
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(background));
		Background.setBounds(0, 0, 1366, 746);
		frmSlotMachine.getContentPane().add(Background);
	}
	
	private static void spin()
	{
		
	}
	
	private void rollUntil(int slot1,int slot2,int slot3)
	{
		Random rand = new Random();
		
		//Add images into list. 
//		images.add(background);
//		images.add(bio);
//		images.add(chem);
//		images.add(chinese);
//		images.add(cs);
//		images.add(eng);
//		images.add(his);
//		images.add(math);
//		images.add(physics);
		
		replace(slots.get(1),1);
	}
	
	private void replace(JLabel label,int pic)
	{
		// Setup images that needed to be used.
		Image background = new ImageIcon(this.getClass().getResource("/NewNewSlotMachineBackground.jpg")).getImage();
		Image bio = new ImageIcon(this.getClass().getResource("/biology.png")).getImage();
		Image chem = new ImageIcon(this.getClass().getResource("/chemistry.png")).getImage();
		Image chinese = new ImageIcon(this.getClass().getResource("/chinese.png")).getImage();
		Image cs = new ImageIcon(this.getClass().getResource("/cs.png")).getImage();
		Image eng = new ImageIcon(this.getClass().getResource("/english.png")).getImage();
		Image his = new ImageIcon(this.getClass().getResource("/history.png")).getImage();
		Image math = new ImageIcon(this.getClass().getResource("/maths.png")).getImage();
		Image physics = new ImageIcon(this.getClass().getResource("/physics.png")).getImage();
		
		//Add images into list. 
		images.add(background);
		images.add(bio);
		images.add(chem);
		images.add(chinese);
		images.add(cs);
		images.add(eng);
		images.add(his);
		images.add(math);
		images.add(physics);
		
		label.setIcon(new ImageIcon(images.get(pic)));
	}
}
