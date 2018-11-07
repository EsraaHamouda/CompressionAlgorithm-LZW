import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


public class LZWGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LZWGUI window = new LZWGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LZWGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCompressionUsingFile = new JButton("Input from File");
		btnCompressionUsingFile.setBounds(124, 57, 171, 44);
		frame.getContentPane().add(btnCompressionUsingFile);
		
		JButton btnInputText = new JButton("Input text");
		btnInputText.setBounds(124, 149, 171, 44);
		frame.getContentPane().add(btnInputText);
	}
}
