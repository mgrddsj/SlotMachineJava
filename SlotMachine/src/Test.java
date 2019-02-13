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
	private static List<JLabel> slot1 = new ArrayList<JLabel>(3);
	private static List<JLabel> slot2 = new ArrayList<JLabel>(3);
	private static List<JLabel> slot3 = new ArrayList<JLabel>(3);
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
		
		//The following 3 lines is for full screen. 
//		frmSlotMachine.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frmSlotMachine.setUndecorated(true);
//		frmSlotMachine.setVisible(true);
		
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
//		images.add(background);
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
		
		//Put initial state of each slot into 2D array "board", so that "replace()" can get the present state of the slots. 
		//board[vertical slot][position in vertical slot]
		board[0][0] = 0;
		board[0][1] = 1;
		board[0][2] = 2;
		board[1][0] = 3;
		board[1][1] = 4;
		board[1][2] = 5;
		board[2][0] = 6;
		board[2][1] = 7;
		board[2][2] = 1;
		
		
		JLabel label = new JLabel("");
		slot1.add(label);
		label.setIcon(new ImageIcon(images.get(0)));
		label.setBounds(228, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		slot1.add(label_1);
		label_1.setIcon(new ImageIcon(images.get(1)));
		label_1.setBounds(228, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		slot1.add(label_2);
		label_2.setIcon(new ImageIcon(images.get(2)));
		label_2.setBounds(228, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		slot2.add(label_3);
		label_3.setIcon(new ImageIcon(images.get(3)));
		label_3.setBounds(623, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		slot2.add(label_4);
		label_4.setIcon(new ImageIcon(images.get(4)));
		label_4.setBounds(623, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		slot2.add(label_5);
		label_5.setIcon(new ImageIcon(images.get(5)));
		label_5.setBounds(623, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		slot3.add(label_6);
		label_6.setIcon(new ImageIcon(images.get(6)));
		label_6.setBounds(1013, 158, 128, 128);
		frmSlotMachine.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		slot3.add(label_7);
		label_7.setIcon(new ImageIcon(images.get(7)));
		label_7.setBounds(1013, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		slot3.add(label_8);
		label_8.setIcon(new ImageIcon(images.get(1)));
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
					try {
						spin();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		Background.setBounds(0, 0, 1366, 768);
		frmSlotMachine.getContentPane().add(Background);
	}
	
	private void spin() throws InterruptedException
	{
		Random rand = new Random();
		int resultType;
		int slot1Res;
		int slot2Res;
		int slot3Res;
		
		//Decide result type (All 3 same/2 are same/all different)
		resultType = rand.nextInt(10);
		if (resultType <= 2)
		{
			resultType = 0;//All same. 20%
		}
		else if (resultType <= 5)
		{
			resultType = 1;//2 same. 30%
		}
		else
		{
			resultType = 2;//All diff. 50%
		}

		slot1Res = rand.nextInt(7);//slot 1 result
		//slot 2 result
		if (resultType <= 1)
		{
			slot2Res = slot1Res;
		}
		else
		{
			slot2Res = rand.nextInt(7);
		}
		//slot 3 result
		if (resultType == 0)
		{
			slot3Res = slot1Res;
		}
		else 
		{
			slot3Res = rand.nextInt(7);
		}
		
		rollUntil(slot1Res,slot2Res,slot3Res);
	}
	
	private void rollUntil(int slot1Res,int slot2Res,int slot3Res) throws InterruptedException
	{
		Random rand = new Random();
		boolean slot1Stop = false;
		boolean slot2Stop = false;
		boolean slot3Stop = false;

		//Roll up
		while (!slot1Stop || !slot2Stop || !slot3Stop)
		{
			int temp1 = rand.nextInt(7);
			int temp2 = rand.nextInt(7);
			int temp3 = rand.nextInt(7);

			if (!slot1Stop)
			{
				replace(slot1.get(0), board[0][1]);
				replace(slot1.get(1), board[0][2]);
				replace(slot1.get(2), temp1);
			}	
			if (!slot2Stop)
			{
				replace(slot2.get(0), board[1][1]);
				replace(slot2.get(1), board[1][2]);
				replace(slot2.get(2), temp2);
			}
			if (!slot3Stop)
			{
				replace(slot3.get(0), board[2][1]);
				replace(slot3.get(1), board[2][2]);
				replace(slot3.get(2), temp3);
			}
			
			updateBoard(temp1, temp2, temp3, slot1Stop, slot2Stop, slot3Stop);

			if (board[0][1] == slot1Res)
			{
				slot1Stop = true;
			}
			if (board[1][1] == slot2Res && slot1Stop == true)
			{
				slot2Stop = true;
			}
			if (board[2][1] == slot3Res && slot2Stop == true)
			{
				slot3Stop = true;
			}

//			Thread.sleep(100);

		}
	}

	private void updateBoard(int new1,int new2,int new3,boolean slot1,boolean slot2,boolean slot3)
	{
		if (!slot1)
		{
			board[0][0] = board[0][1];
			board[0][1] = board[0][2];
			board[0][2] = new1;
		}
		if (!slot2)
		{
			board[1][0] = board[1][1];
			board[1][1] = board[1][2];
			board[1][2] = new2;
		}
		if (!slot3)
		{
			board[2][0] = board[2][1];
			board[2][1] = board[2][2];
			board[2][2] = new3;
		}
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

class Spin extends Thread
{
	
}