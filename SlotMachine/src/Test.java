import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Test {

	private JFrame frmSlotMachine;
	public static int[][] board = new int[3][3];
	public static List<JLabel> slot1 = new ArrayList<JLabel>(3);
	public static List<JLabel> slot2 = new ArrayList<JLabel>(3);
	public static List<JLabel> slot3 = new ArrayList<JLabel>(3);
	public static List<Image> images = new ArrayList<Image>(8);
	public static JLabel lblHitTheButton;
	public static boolean buttonAvailable;
	public static JLabel lblCongratesText;
//	private static JLabel label;
	
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
		
		buttonAvailable =true;	//Make the button available. 
		
		//The following 3 lines is for full screen. 
		frmSlotMachine.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSlotMachine.setUndecorated(true);
		frmSlotMachine.setVisible(true);
		
		// Setup images that needed to be used.
		Image background = new ImageIcon(this.getClass().getResource("./NewNewSlotMachineBackground.jpg")).getImage();
		Image img0 = new ImageIcon(this.getClass().getResource("./0.png")).getImage();
		Image img1 = new ImageIcon(this.getClass().getResource("./1.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("./2.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("./3.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("./4.png")).getImage();
		Image img5 = new ImageIcon(this.getClass().getResource("./5.png")).getImage();
		Image img6 = new ImageIcon(this.getClass().getResource("./6.png")).getImage();
//		Image img7 = new ImageIcon(this.getClass().getResource("./7.png")).getImage();

		//Add images into list. 
//		images.add(background);
		images.add(img0);
		images.add(img1);
		images.add(img2);
		images.add(img3);
		images.add(img4);
		images.add(img5);
		images.add(img6);
//		images.add(img7);
		
		//Put initial state of each slot into 2D array "board", so that "replace()" can get the present state of the slots. 
		//board[vertical slot][position in vertical slot]
		board[0][0] = 0;
		board[0][1] = 1;
		board[0][2] = 2;
		board[1][0] = 3;
		board[1][1] = 4;
		board[1][2] = 5;
		board[2][0] = 6;
		board[2][1] = 2;
		board[2][2] = 1;
		
		lblCongratesText = new JLabel("Congrates text");
		lblCongratesText.setBackground(new Color(192, 192, 192));
		lblCongratesText.setForeground(new Color(255, 255, 255));
		lblCongratesText.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratesText.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 99));
		lblCongratesText.setBounds(0, 299, 1366, 128);
		lblCongratesText.setVisible(false);
		frmSlotMachine.getContentPane().add(lblCongratesText);
		
		lblHitTheButton = new JLabel("Hit The Button!");
		lblHitTheButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblHitTheButton.setForeground(Color.WHITE);
		lblHitTheButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 63));
		lblHitTheButton.setBounds(0, 604, 1348, 79);
		frmSlotMachine.getContentPane().add(lblHitTheButton);
		
		Thread hitButtonThread = new Thread(new BannerSizeChanger(this));
		hitButtonThread.start();
		
		
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
		label_7.setIcon(new ImageIcon(images.get(2)));
		label_7.setBounds(1013, 308, 128, 128);
		frmSlotMachine.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		slot3.add(label_8);
		label_8.setIcon(new ImageIcon(images.get(1)));
		label_8.setBounds(1013, 458, 128, 128);
		frmSlotMachine.getContentPane().add(label_8);
		Image bt = new ImageIcon(this.getClass().getResource("./button.png")).getImage();
		
		
		//Random rand = new Random();

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
						if (buttonAvailable)
						{
							visibilityOfHitTheButton(false);
							spin();
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Background img
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(background));
		Background.setBounds(0, 0, 1366, 768);
		frmSlotMachine.getContentPane().add(Background);
		
		button.setIcon(new ImageIcon(bt));
		button.setBounds(747, 767, 245, 170);
		frmSlotMachine.getContentPane().add(button);
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
		if (resultType == 1)
		{
			resultType = 0;//All same. 10%
		}
		else if (resultType <= 7)
		{
			resultType = 1;//2 same. 50%
		}
		else
		{
			resultType = 2;//All diff. 20%
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
		
		Thread t1 = new Thread(new Spin(board, slot1Res, slot2Res, slot3Res, resultType));
		t1.start();
	}
	
	public void changeHitButtonLabelFont(int size)
	{
		lblHitTheButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, size));
	}
	
	public static void visibilityOfHitTheButton(boolean visibility)
	{
		lblHitTheButton.setVisible(visibility);
		buttonAvailable = visibility;
	}
	
	public static void changeStatusOfCongratesText(boolean visibility, String text)
	{
		lblCongratesText.setText(text);
		lblCongratesText.setVisible(visibility);
	}
}

class Spin implements Runnable
{
	private int slot1Res;
	private int slot2Res;
	private int slot3Res;
	private int resultType;
	
	public Spin(int[][] b,int slt1Res,int slt2Res,int slt3Res, int rstType)
	{
//		board[0][0] = 0;
//		board[0][1] = 1;
//		board[0][2] = 2;
//		board[1][0] = 3;
//		board[1][1] = 4;
//		board[1][2] = 5;
//		board[2][0] = 6;
//		board[2][1] = 7;
//		board[2][2] = 1;
		slot1Res = slt1Res;
		slot2Res = slt2Res;
		slot3Res = slt3Res;
		resultType = rstType;
	}

	public void run()
	{
		Random rand = new Random();
		boolean slot1Stop = false;
		boolean slot2Stop = false;
		boolean slot3Stop = false;
		int spinCount = 0;	//If spin count is too small, keep spinning. 

		//Roll up
		while (!slot1Stop || !slot2Stop || !slot3Stop)
		{
			int temp1 = rand.nextInt(7);
			int temp2 = rand.nextInt(7);
			int temp3 = rand.nextInt(7);
//			while (temp1 == Test.board[0][0] || temp1 == Test.board[0][1])
//			{
//				temp1 = rand.nextInt(7);
//			}
//			while (temp2 == Test.board[1][0] || temp1 == Test.board[1][1])
//			{
//				temp2 = rand.nextInt(7);
//			}

//			while (temp3 == Test.board[2][0] || temp1 == Test.board[2][1])
//			{
//				temp3 = rand.nextInt(7);
//			}
				
			if (!slot1Stop)
			{
				replace(Test.slot1.get(0), Test.board[0][1]);
				replace(Test.slot1.get(1), Test.board[0][2]);
				replace(Test.slot1.get(2), temp1);
			}	
			if (!slot2Stop)
			{
				replace(Test.slot2.get(0), Test.board[1][1]);
				replace(Test.slot2.get(1), Test.board[1][2]);
				replace(Test.slot2.get(2), temp2);
			}
			if (!slot3Stop)
			{
				replace(Test.slot3.get(0), Test.board[2][1]);
				replace(Test.slot3.get(1), Test.board[2][2]);
				replace(Test.slot3.get(2), temp3);
			}
			
			updateboard(temp1, temp2, temp3, slot1Stop, slot2Stop, slot3Stop);
			spinCount++;

			if (slot1Stop == false && Test.board[0][1] == slot1Res)
			{
				if (rand.nextInt(10)<=8 && spinCount>5)
				{
					slot1Stop = true;
					spinCount = 0;
				}
			}
			if (slot2Stop == false && Test.board[1][1] == slot2Res && slot1Stop == true)
			{
				if (rand.nextInt(10)<=9 && spinCount>8)
				{
					slot2Stop = true;
					spinCount = 0;
				}
			}
			if (slot3Stop == false && Test.board[2][1] == slot3Res && slot2Stop == true)
			{
				if (rand.nextInt(10)<=7 && spinCount>10)
				{
					slot3Stop = true;
					spinCount = 0;
				}
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		//All slots stopped
		Test.visibilityOfHitTheButton(true);
		//Show congrates message. 
	}

	private void updateboard(int new1,int new2,int new3,boolean slot1,boolean slot2,boolean slot3)
	{
		if (!slot1)
		{
			Test.board[0][0] = Test.board[0][1];
			Test.board[0][1] = Test.board[0][2];
			Test.board[0][2] = new1;
		}
		if (!slot2)
		{
			Test.board[1][0] = Test.board[1][1];
			Test.board[1][1] = Test.board[1][2];
			Test.board[1][2] = new2;
		}
		if (!slot3)
		{
			Test.board[2][0] = Test.board[2][1];
			Test.board[2][1] = Test.board[2][2];
			Test.board[2][2] = new3;
		}
	}
	
	private void replace(JLabel label,int pic)
	{
		label.setIcon(new ImageIcon(Test.images.get(pic)));
	}

}

class BannerSizeChanger implements Runnable
{
	private Test t1;
	
	public BannerSizeChanger(Test tIn)
	{
		t1 = tIn;
	}
	
	@Override
	public void run() 
	{
		for (int size=60;size<=100;size++)
		{
			if (size == 100)
			{
				for (;size>=60;size--)
				{
					t1.changeHitButtonLabelFont(size);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			t1.changeHitButtonLabelFont(size);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}