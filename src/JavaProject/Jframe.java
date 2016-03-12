package JavaProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.util.ArrayList;
import java.awt.List;
import java.io.IOException;

public class Jframe {
	private JFrame frame;
	private JTextField textField_1;
	public JPanel frame1;
	public JPanel frame2;
	static String groups;
	static String area;
	int a=0 ;
	ArrayList<String> str = new ArrayList<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe window = new Jframe();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jframe() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel frame1 = new JPanel();
		frame.getContentPane().add(frame1, "name_9084892390178");
		frame1.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(327, 35, 60, 36);
		frame1.add(formattedTextField);		
		
		JLabel New = new JLabel("How Big is Your Group-");
		New.setFont(new Font("Stencil", Font.PLAIN, 18));
		New.setBounds(10, 27, 242, 50);
		frame1.add(New);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				groups = formattedTextField.getText();
				if(Utility.numberOrNot(groups) != true)
				{
					JOptionPane.showMessageDialog(null, "Please Enter A Numeric Value!!!"); 
				}
				else
				{
					frame1.setVisible(false);
					
					final JPanel frame2 = new JPanel();
					frame.getContentPane().add(frame2, "name_9113232328555");
					frame2.setLayout(null);
					
					JLabel lblLocation = new JLabel("Location:-");
					lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblLocation.setBounds(39, 28, 103, 50);
					frame2.add(lblLocation);
					
					textField_1 = new JFormattedTextField();
					textField_1.setBounds(136, 42, 200, 31);
					frame2.add(textField_1);
					textField_1.setColumns(10);
					textField_1.setUI(new HintTextFieldUI("Write your area", true));
					
					JButton btnBack = new JButton("Back");
					btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame1.setVisible(true);
							frame2.setVisible(false);
						}
					});
					btnBack.setBounds(328, 227, 96, 23);
					frame2.add(btnBack);
										
					int i, loop = Integer.parseInt(groups);
					System.out.println(loop);
					List list = new List();
					list.setBounds(39, 95, 240, 124);
					frame2.add(list);
					
					for(i = 0; i < loop; ++i)	{
						JButton btnA = new JButton("ADD");
						btnA.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								a++;
								if(a <= loop)
								{
									area = textField_1.getText();
									str.add(area);
									list.add(area);
									textField_1.setText("");
									textField_1.setUI(new HintTextFieldUI("Write your area", true));
									System.out.println(area);
								}
								else
								{
									JOptionPane.showMessageDialog(frame,
										    "Only " + loop + " locations mentioned!",
										    "Input Error",
										    JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						btnA.setBounds(355, 46, 69, 23);
						frame2.add(btnA);
					}
					JButton btnNewButton_1 = new JButton("Locate On Map");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(a < loop)
							{
								JOptionPane.showMessageDialog(frame,
									    "Only " + a + " locations selected! Select " + (loop -1) + " more!",
									    "Location Error",
									    JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								AddressConverter obj = new AddressConverter();
									int i;
									for(i = 0; i < str.size(); i++)
										try {
											obj.fetchLatLong(str.get(i));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							}
						}
					});
					btnNewButton_1.setBounds(301, 150, 123, 36);
					frame2.add(btnNewButton_1);
					frame2.setVisible(true);
				}	
			}
		});
		btnNewButton.setBounds(209, 133, 89, 23);
		frame1.add(btnNewButton);
		
		
		//delete it after design
		final JPanel frame2 = new JPanel();
		frame.getContentPane().add(frame2, "name_9113232328555");
		frame2.setLayout(null);
		
		JLabel lblLocation = new JLabel("Location:-");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocation.setBounds(39, 28, 103, 50);
		frame2.add(lblLocation);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 42, 200, 31);
		frame2.add(textField_1);
		textField_1.setColumns(10); 
		
		JButton btnA = new JButton("ADD");
		btnA.setBounds(355, 46, 69, 23);
		frame2.add(btnA);
		
		JButton btnNewButton_1 = new JButton("Locate On Map");
		btnNewButton_1.setBounds(301, 150, 123, 36);
		frame2.add(btnNewButton_1);
		
		List list = new List();
		list.setBounds(39, 95, 240, 124);
		frame2.add(list);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setBounds(328, 227, 96, 23);
		frame2.add(btnBack);
		
		//till here
	}
}