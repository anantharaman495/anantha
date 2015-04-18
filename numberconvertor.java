
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class anantha_number extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bittext;
	private JTextField octtext;
	private JTextField dectext;
	private JTextField hextext;
	
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
					anantha_number frame = new anantha_number();
					frame.setVisible(true);
					frame.setTitle("Number Conversion");
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public anantha_number()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBinary = new JLabel("Binary");
		lblBinary.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBinary.setBounds(575, 209, 187, 26);
		contentPane.add(lblBinary);
		
		bittext = new JTextField();
		bittext.setBounds(762, 209, 154, 26);
		contentPane.add(bittext);
		bittext.setColumns(10);
		
		JLabel lblOctal = new JLabel("Octal");
		lblOctal.setBounds(575, 243, 187, 26);
		contentPane.add(lblOctal);
		
		JLabel lblDecimal = new JLabel("Decimal");
		lblDecimal.setBounds(575, 273, 187, 26);
		contentPane.add(lblDecimal);
		
		octtext = new JTextField();
		octtext.setBounds(763, 243, 153, 26);
		contentPane.add(octtext);
		octtext.setColumns(10);
		
		dectext = new JTextField();
		dectext.setBounds(764, 273, 152, 26);
		contentPane.add(dectext);
		dectext.setColumns(10);
		
		JLabel lblHexadecimal = new JLabel("Hexadecimal");
		lblHexadecimal.setBounds(575, 303, 187, 26);
		contentPane.add(lblHexadecimal);
		
		hextext = new JTextField();
		hextext.setBounds(764, 303, 154, 26);
		contentPane.add(hextext);
		hextext.setColumns(10);
		bittext.setEnabled(true);
		octtext.setEditable(true); 
		dectext.setEnabled(true);
		hextext.setEnabled(true);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(620, 367, 89, 23);
		 ActionListener l1=new anantha(); 
		 ActionListener l2=new reset();
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(l1);
		btnCalculate.setMnemonic('C');

		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(743, 367, 89, 23);
		contentPane.add(btnReset);
		btnReset.addActionListener(l2);
		
			
	}
	class anantha implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equalsIgnoreCase("calculate"))
			{
			 int tmp;
			  if(!bittext.getText().equals("") && octtext.getText().equals("") && dectext.getText().equals("") && hextext.getText().equals(""))
				{
					
					tmp=Integer.parseInt(bittext.getText(), 2);
					octtext.setText(Integer.toOctalString(tmp));
					dectext.setText(Integer.toString(tmp));
					hextext.setText(Integer.toHexString(tmp));
				}
				else if(bittext.getText().equals("") && !octtext.getText().equals("") && dectext.getText().equals("") && hextext.getText().equals(""))
				{
					
					tmp=Integer.parseInt(octtext.getText(),8);
					dectext.setText(Integer.toString(tmp));
					hextext.setText(Integer.toHexString(tmp));
					bittext.setText(Integer.toBinaryString(tmp));
				}
				else if(bittext.getText().equals("") && octtext.getText().equals("") && !dectext.getText().equals("") && hextext.getText().equals(""))
				{
					
					tmp=Integer.parseInt(dectext.getText(),10);
					octtext.setText(Integer.toOctalString(tmp));
					hextext.setText(Integer.toHexString(tmp));
					bittext.setText(Integer.toBinaryString(tmp));
				}
				else if(bittext.getText().equals("") && octtext.getText().equals("") && dectext.getText().equals("") && !hextext.getText().equals(""))
				{
					
					tmp=Integer.parseInt(hextext.getText(),16);
					octtext.setText(Integer.toOctalString(tmp));
					dectext.setText(Integer.toString(tmp));
					bittext.setText(Integer.toBinaryString(tmp));
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,"Enter only one value","Error",0);
					{
						bittext.setText("");
						octtext.setText("");
						dectext.setText("");
						hextext.setText("");
					
					}
				}
			}
			
			
		}
		
	}
	class reset implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getActionCommand().equalsIgnoreCase("reset"))
			{
				{
					bittext.setText("");
					octtext.setText("");
					dectext.setText("");
					hextext.setText("");
				
				}
			}
			
		}
		
	}
}
