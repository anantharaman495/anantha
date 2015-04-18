import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JPanel;

public class notepad
{

	private JFrame frame;
	TextArea textArea;
	String filename=null;
	JPanel pan;
	JDialog jd;


	Component c=new Component()
	{

		private static final long serialVersionUID = 1L;
	};
	Toolkit t=c.getToolkit();
	 Clipboard clip=t.getSystemClipboard();

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
					notepad window = new notepad();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public notepad()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Nature\\1.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		 textArea = new TextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.setTitle("Notepad");
		JMenu mnFile = new JMenu("File");
		//mnFile.setMnemonic('F');
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		//mntmNew.setMnemonic('N');
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		//mntmSave.setMnemonic('S');
		mnFile.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke("Alt f4"));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
	//	mnEdit.setMnemonic('E');
	//	mnEdit.setAccelerator(KeyStroke.getKeyStroke("E"));
		menuBar.add(mnEdit);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		mnEdit.add(mntmCopy);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		mnEdit.add(mntmCut);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		//mntmPaste.setMnemonic('P');
		mnEdit.add(mntmPaste);
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));

		JMenu mnHelp = new JMenu("Help");
	 //	mnHelp.setAccelerator(KeyStroke.getKeyStroke("F2"));
		menuBar.add(mnHelp);

		JMenuItem mntmCheckForUpdate = new JMenuItem("Check for Update");
		//mntmCheckForUpdate.setMnemonic('U');
		mntmCheckForUpdate.setAccelerator(KeyStroke.getKeyStroke("F12"));
		mnHelp.add(mntmCheckForUpdate);

		JMenuItem mntmReport = new JMenuItem("Report");
		mntmReport.setAccelerator(KeyStroke.getKeyStroke("F9"));
		mnHelp.add(mntmReport);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke("F1"));
		mnHelp.add(mntmAbout);
		mntmNew.addActionListener(new New());
		mntmOpen.addActionListener(new Open());
		mntmSave.addActionListener(new Save());
		mntmExit.addActionListener(new Exit());
		mntmCopy.addActionListener(new Copy());
		mntmCut.addActionListener(new Cut());
		mntmPaste.addActionListener(new Paste());
		mntmAbout.addActionListener(new About());
		mntmCheckForUpdate.addActionListener(new Update());
		mntmReport.addActionListener(new Report());


	}
	class New implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			 textArea.setText(" ");
		}

	}
	class Open implements ActionListener
	{

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e)
		{
			FileDialog fd=new FileDialog(frame);
			fd.show();
			String filepath=fd.getDirectory()+fd.getFile();
					frame.setTitle(filepath);
					if(frame.getTitle().equalsIgnoreCase("nullnull"))
						frame.setTitle("Notepad");
					FileInputStream input=null;
					try
					{
						input = new FileInputStream(filepath);
					} catch (FileNotFoundException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					BufferedReader read=new BufferedReader(new InputStreamReader(input));
					String output=null;
					try
					{
						output = read.readLine();
					} catch (IOException e2)
					{
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					while(output!=null)
					{
						textArea.setText(textArea.getText()+"\n"+output);
						try
						{
							output=read.readLine();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
		}

	}
	class Exit implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(textArea.getText().equals(""))
			System.exit(0);
			else
			{
			JOptionPane.showMessageDialog(frame, "Save the file", "Save", JOptionPane.PLAIN_MESSAGE);
			}
		}

	}
	class Save implements ActionListener
	{

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			FileDialog fd=new FileDialog(frame,filename,FileDialog.SAVE);
			fd.show();
			 if (fd.getFile()!=null)
             {
             filename = fd.getDirectory() + fd.getFile();
            //s setTitle(filename);
             try
                 {
                 DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                 String line = textArea.getText();
                 BufferedReader br = new BufferedReader(new StringReader(line));
                 while((line = br.readLine())!=null)
                     {
                     d.writeBytes(line + "\r\n");
                     d.close();
                 }
             }
             catch(Exception ex)
                 {
                 System.out.println("File not found");
             }
             textArea.requestFocus();
         }
		}

	}
	class Copy implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			{
	             String sel = textArea.getSelectedText();
	             StringSelection clipString = new StringSelection(sel);
	             clip.setContents(clipString,clipString);
	         }

		}

	}
	class Cut implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
        {
        String sel = textArea.getSelectedText();
        StringSelection ss = new StringSelection(sel);
        clip.setContents(ss,ss);
        textArea.replaceRange(" ",textArea.getSelectionStart(),textArea.getSelectionEnd());
    }
}
	class Paste implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
        {
        Transferable cliptran = clip.getContents(notepad.this);
        try
            {
            String sel = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(sel,textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
        catch(Exception exc)
            {
            System.out.println("not string flavour");
        }
    }
}
	class About implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(frame, "Notepad-- \n Version 0.1.0 \n", "About", JOptionPane.PLAIN_MESSAGE);
		}

	}
	class Update implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			// JOptionPane j=new JOptionPane();
			 JOptionPane.showMessageDialog(frame,  "There is no updates available","Check for updates",1);
		}

	}
	class Report implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(frame, "Error \n mailto:anantha.495@gmail.com", "Report",2);

		}

	}


	}

