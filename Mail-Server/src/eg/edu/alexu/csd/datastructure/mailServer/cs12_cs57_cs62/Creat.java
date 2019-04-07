package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Creat extends JFrame {
	static Creat frame = new Creat();;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblName;
	private JTextField textField_1;
	private JTextField textField_2;
	
	SearchFilter filter;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Creat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(29, 62, 95, 23);
		contentPane.add(lblName);
		
		JRadioButton rdbtnSubject = new JRadioButton("Subject");
		buttonGroup.add(rdbtnSubject);
		rdbtnSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSubject.setBounds(165, 145, 103, 21);
		rdbtnSubject.setEnabled(false);
		contentPane.add(rdbtnSubject);
		rdbtnSubject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (rdbtnSubject.isSelected()) {
					textField_1.setEditable(true);
					textField_2.setEditable(false);
				}
			}
		});
		
		
		JRadioButton rdbtnSender = new JRadioButton("Sender");
		buttonGroup.add(rdbtnSender);
		rdbtnSender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSender.setBounds(165, 218, 103, 21);
		rdbtnSender.setEnabled(false);
		contentPane.add(rdbtnSender);
		rdbtnSender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (rdbtnSender.isSelected()) {
					textField_2.setEditable(true);
					textField_1.setEditable(false);
				}
			}
			
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(300, 142, 159, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(300, 214, 159, 30);
		contentPane.add(textField_2);
		textField_2.setEditable(false);
		
		JCheckBox chckbxFilter = new JCheckBox("Filter by:");
		chckbxFilter.setFont(new Font("Arial Black", Font.PLAIN, 20));
		chckbxFilter.setBounds(18, 143, 121, 21);
		contentPane.add(chckbxFilter);
		chckbxFilter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (chckbxFilter.isSelected()) {
					rdbtnSubject.setEnabled(true);
					rdbtnSender.setEnabled(true);
				} else {
					rdbtnSubject.setEnabled(false);
					rdbtnSender.setEnabled(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
				}
			}
			
		});
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Folder x = new Folder();
				x.setContact(SignIn.account.currentContact);
				if (textField.getText() != null && textField.getText().length() > 0) {
					if (chckbxFilter.isSelected()) {
						filter = new SearchFilter();
						if (rdbtnSubject.isSelected()) {
							if (textField_1.getText() == null || textField_1.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "Choose your filter");
							} else {
								filter.type = "Subject";
								filter.searchFor = textField_1.getText();
								x.createNewFolder(textField.getText(), filter);
								TestNew.frame.setVisible(true);
								frame.setVisible(false);
							}
						} else if (rdbtnSender.isSelected()) {
							if (textField_2.getText() == null || textField_2.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "Choose your filter");
							} else {
								filter.type = "Sender";
								filter.searchFor = textField_2.getText();
								System.out.println(filter.type + filter.searchFor);
								x.createNewFolder(textField.getText(), filter);
								TestNew.frame.setVisible(true);
								frame.setVisible(false);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Choose your filter");
						}
					} else {
						x.createNewFolder(textField.getText(), null);
						TestNew.frame.setVisible(true);
						frame.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Enter Folder Name");
				}
				
			}
		});
		btnNewButton.setBounds(364, 289, 95, 36);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(165, 62, 178, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
}
