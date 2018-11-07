import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class fileInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtFilePath;
	final Main m = new Main();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fileInput frame = new fileInput();
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
	public fileInput() {
		setTitle("File input");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterFilePath = new JLabel("Enter file path");
		lblEnterFilePath.setBounds(10, 24, 74, 14);
		contentPane.add(lblEnterFilePath);
		
		txtFilePath = new JTextField();
		txtFilePath.setBounds(81, 21, 281, 20);
		contentPane.add(txtFilePath);
		txtFilePath.setColumns(10);
		
		JButton btnCompress = new JButton("Compress");
		btnCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line = "";
				String path = txtFilePath.getText();
				String xx= "";
				File file1 = new File(path);
				String g = "";
				
				if(!file1.exists())
		        {
		            JOptionPane.showMessageDialog(null, "wrong file");
		        }
		        BufferedReader read; 
		        try
		        {
		            read = new BufferedReader(new FileReader(file1));
		            //String line;
		            while((line = read.readLine()) != null)
		            { 
		            	g+=line;
		            }
		            read.close();
		        }
		        catch(IOException e)
		        {
		        	
		        }
				
				System.out.println("line = "+g);
				System.out.println("size = "+ g.length());
				Vector<Integer> vec = new Vector<Integer>();
				
				vec  = m.compress(g);
				String rr = vec.toString();
				
				try (PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter("result.txt", false)))) {
					out.print(rr);
					
				} catch (IOException e) {
					
				}
				//System.out.println(vec.toString());
				
			}
		});
		btnCompress.setBounds(93, 55, 102, 23);
		contentPane.add(btnCompress);
		
		JButton btnDecompress = new JButton("Decompress");
		btnDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line = "";
				String path = txtFilePath.getText();
				String xx= "";
				File file1 = new File(path);
				String g = "";
				Vector<String> numbers = new Vector<String>(); 
				Vector<Integer> nums = new Vector<Integer>();
				if(!file1.exists())
		        {
		            JOptionPane.showMessageDialog(null, "wrong file");
		        }
		        BufferedReader read; 
		        try
		        {
		            read = new BufferedReader(new FileReader(file1));
		            //String line;
		            
		            while((line = read.readLine()) != null)
		            { 
		            	numbers.add(line);
		            }
		            read.close();
		            for (int i = 0; i < numbers.size(); i++) {
		            	
						nums.add(Integer.parseInt(numbers.get(i)));
					}
		            String decomResult = m.decompress(nums);
		            try (PrintWriter out = new PrintWriter(new BufferedWriter(
							new FileWriter("Decompresult.txt", false)))) {
						out.print(decomResult);
						
					} catch (IOException e) {
						
					}
		            
		        }
		        catch(IOException e)
		        {
		        	
		        }
		        System.out.println(numbers.toString());
				
			}
		});
		btnDecompress.setBounds(216, 52, 101, 23);
		contentPane.add(btnDecompress);
	}
}
