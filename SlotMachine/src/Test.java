import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

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
		Image cs = new ImageIcon(this.getClass().getResource("/cs.png").getImage());
		label.setBounds(197, 259, 128, 128);
		frmSlotMachine.getContentPane().add(label);
	}
}
