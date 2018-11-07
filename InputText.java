import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class InputText extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtcompressionoutput;
	private JLabel lblResult;
	private JButton btnDecompress;
	private JTextField txtDecompressionOutput;
	private JLabel lblResultOfDecompression;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputText frame = new InputText();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputText() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInput = new JTextField();
		txtInput.setBounds(22, 36, 402, 58);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JLabel lblEnterText = new JLabel("Enter text to compress");
		lblEnterText.setBounds(22, 11, 126, 14);
		contentPane.add(lblEnterText);
		
		JButton btnCompress = new JButton("Compress");
		btnCompress.setBounds(22, 102, 89, 23);
		contentPane.add(btnCompress);
		
		txtcompressionoutput = new JTextField();
		txtcompressionoutput.setColumns(10);
		txtcompressionoutput.setBounds(22, 151, 402, 58);
		contentPane.add(txtcompressionoutput);
		
		lblResult = new JLabel("Result Of compression");
		lblResult.setBounds(22, 136, 126, 14);
		contentPane.add(lblResult);
		
		btnDecompress = new JButton("Decompress");
		btnDecompress.setBounds(22, 216, 105, 23);
		contentPane.add(btnDecompress);
		
		txtDecompressionOutput = new JTextField();
		txtDecompressionOutput.setColumns(10);
		txtDecompressionOutput.setBounds(22, 269, 402, 58);
		contentPane.add(txtDecompressionOutput);
		
		lblResultOfDecompression = new JLabel("Result Of decompression");
		lblResultOfDecompression.setBounds(22, 244, 126, 14);
		contentPane.add(lblResultOfDecompression);
	}

}
