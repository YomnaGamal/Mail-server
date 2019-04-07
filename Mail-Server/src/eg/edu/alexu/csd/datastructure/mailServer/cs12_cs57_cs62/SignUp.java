package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class SignUp extends JFrame {

	static SignUp frame = new SignUp();
	
	private Contact newContact = new Contact();
	
	private JPanel contentPane;
	
	private String mail;
	private String password;
	private String confirmPassword;
	private String phoneNum;
	private String firstName;
	private String secondName;
	private String birthday;
	private int day;
	private int month;
	private int year;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtXxxxxmailcom;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtxxxxxxxxxx;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setLocationRelativeTo(null);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAsXxxxxmailcom = new JLabel("AS xxxxx@mail.com");
		lblAsXxxxxmailcom.setBounds(415, 103, 129, 14);
		contentPane.add(lblAsXxxxxmailcom);
		
		JLabel lblFromTo = new JLabel("from 6 to 15 character");
		lblFromTo.setBounds(416, 169, 143, 14);
		contentPane.add(lblFromTo);
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(10, 10, 86, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name ");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(296, 10, 86, 20);
		contentPane.add(lblLastName);
		
		JLabel lblEmail_1 = new JLabel("E-mail");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_1.setBounds(10, 114, 86, 20);
		contentPane.add(lblEmail_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 164, 86, 20);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(10, 214, 134, 20);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthday.setBounds(10, 258, 86, 23);
		contentPane.add(lblBirthday);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(10, 305, 101, 23);
		contentPane.add(lblPhoneNumber);
	
		JLabel lblinvalidEmail = new JLabel("*invalid email");
		lblinvalidEmail.setForeground(Color.RED);
		lblinvalidEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblinvalidEmail.setBounds(154, 92, 114, 13);
		lblinvalidEmail.setVisible(false);
		contentPane.add(lblinvalidEmail);
		
		JLabel lbltooShortPassword = new JLabel("*too short password");
		lbltooShortPassword.setForeground(Color.RED);
		lbltooShortPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltooShortPassword.setBounds(155, 148, 129, 13);
		lbltooShortPassword.setVisible(false);
		contentPane.add(lbltooShortPassword);
		
		JLabel lbltooLongPassword = new JLabel("*too long password");
		lbltooLongPassword.setForeground(Color.RED);
		lbltooLongPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltooLongPassword.setBounds(155, 148, 129, 14);
		lbltooLongPassword.setVisible(false);
		contentPane.add(lbltooLongPassword);
		
		JLabel lblnotMatching = new JLabel("*not matching");
		lblnotMatching.setForeground(Color.RED);
		lblnotMatching.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblnotMatching.setBounds(155, 197, 129, 13);
		lblnotMatching.setVisible(false);
		contentPane.add(lblnotMatching);

		JLabel lblinvalidPhoneNumber = new JLabel("*invalid phone number");
		lblinvalidPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblinvalidPhoneNumber.setForeground(Color.RED);
		lblinvalidPhoneNumber.setBounds(154, 297, 146, 14);
		lblinvalidPhoneNumber.setVisible(false);
		contentPane.add(lblinvalidPhoneNumber);

		JLabel lblrequired = new JLabel("*required");
		lblrequired.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblrequired.setForeground(Color.RED);
		lblrequired.setBounds(10, 36, 62, 13);
		lblrequired.setVisible(false);
		contentPane.add(lblrequired);
		
		JLabel label = new JLabel("*required");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(286, 37, 62, 13);
		label.setVisible(false);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*required");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(154, 93, 62, 13);
		label_1.setVisible(false);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*required");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(154, 149, 62, 13);
		label_2.setVisible(false);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("*required");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(154, 198, 62, 13);
		label_3.setVisible(false);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*required");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setForeground(Color.RED);
		label_4.setBounds(154, 246, 62, 13);
		label_4.setVisible(false);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("*required");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(149, 297, 62, 13);
		label_5.setVisible(false);
		contentPane.add(label_5);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(10, 49, 145, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				lblrequired.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (textField.getText().length() != 0) {
					firstName = textField.getText();
				} else {
					firstName = null;
				}
			}
			
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(286, 51, 145, 23);
		contentPane.add(textField_1);
		textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				label.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (textField_1.getText().length() != 0) {
					secondName = textField_1.getText();
				} else {
					secondName = null;
				}
			}
			
		});
		
		txtXxxxxmailcom = new JTextField();
		txtXxxxxmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtXxxxxmailcom.setForeground(Color.BLACK);
		txtXxxxxmailcom.setColumns(10);
		txtXxxxxmailcom.setBounds(155, 115, 145, 23);
		contentPane.add(txtXxxxxmailcom);
		txtXxxxxmailcom.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				label_1.setVisible(false);
				lblinvalidEmail.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (txtXxxxxmailcom.getText().length() != 0) {
					if (newContact.checkMailValidity(txtXxxxxmailcom.getText())) {
						mail = txtXxxxxmailcom.getText();
					} else {
						mail = null;
						lblinvalidEmail.setVisible(true);
					}
				} else {
					mail = null;
				}
			}
			
		});
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(155, 167, 145, 20);
		contentPane.add(passwordField);
		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				lbltooShortPassword.setVisible(false);
				lbltooLongPassword.setVisible(false);
				label_2.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				char[] temp = passwordField.getPassword();
				String p = "";
				for (int i = 0; i < temp.length; i++) {
					p += temp[i];
				} 
				if (p.length() != 0) {
					if (p.length() < 6) {
						lbltooShortPassword.setVisible(true);
						password = null;
					} else if (p.length() > 20) {
						lbltooLongPassword.setVisible(true);
						password = null;
					} else {
						password = p;
					}
				} else {
					password = null;
				}
			}
			
		});
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_1.setBounds(155, 214, 145, 22);
		contentPane.add(passwordField_1);
		passwordField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				lblnotMatching.setVisible(false);
				label_3.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				char[] temp = passwordField.getPassword();
				String p = "";
				for (int i = 0; i < temp.length; i++) {
					p += temp[i];
				}
				if (password != null) {
					if (p.length() != 0) {
						if (p.equals(password)) {
							confirmPassword = p;
						} else {
							confirmPassword = null;
							lblnotMatching.setVisible(true);
						}
					} else {
						confirmPassword = null;
					}
				}
			}
			
		});
		
		txtxxxxxxxxxx = new JTextField();
		txtxxxxxxxxxx.setForeground(Color.BLACK);
		txtxxxxxxxxxx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtxxxxxxxxxx.setBounds(154, 309, 151, 20);
		contentPane.add(txtxxxxxxxxxx);
		txtxxxxxxxxxx.setColumns(10);
		txtxxxxxxxxxx.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				label_5.setVisible(false);
				lblinvalidPhoneNumber.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (txtxxxxxxxxxx.getText().length() != 0) {
					if (newContact.checkPhoneValidity(txtxxxxxxxxxx.getText())) {
						phoneNum = txtxxxxxxxxxx.getText();
					} else {
						phoneNum = null;
						lblinvalidPhoneNumber.setVisible(true);
					}
				} else {
					phoneNum = null;
				}
			}
			
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(154, 261, 62, 21);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (comboBox.getSelectedIndex() >= 1) {
					day = comboBox.getSelectedIndex();
				}
			}
			
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(241, 261, 71, 21);
		contentPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (comboBox_1.getSelectedIndex() >= 1) {
					month = comboBox_1.getSelectedIndex();
				}
			}
			
		});
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Year", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		comboBox_2.setBounds(336, 261, 61, 21);
		contentPane.add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (comboBox_2.getSelectedIndex() >= 1) {
					year = 1949 + comboBox_2.getSelectedIndex();
				}
			}
			
		});
		
		JButton btnCreate = new JButton("Sign Up");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = true;
				if (firstName == null) {
					lblrequired.setVisible(true);
					check = false;
				}
				if (secondName == null) {
					label.setVisible(true);
					check = false;
				}
				if (mail == null) {
					label_1.setVisible(true);
					check = false;
				}
				if (password == null) {
					label_2.setVisible(true);
					check = false;
				}
				if (confirmPassword == null) {
					label_3.setVisible(true);
					check = false;
				}
				if (day == 0 || year == 0 || month == 0) {
					label_4.setVisible(true);
					check = false;
				} else {
					birthday = Integer.toString(day) + '/' + Integer.toString(month) + '/' + Integer.toString(year);
				}
				if (phoneNum == null) {
					label_5.setVisible(true);
					check = false;
				}
				if (check) {
					newContact.setEmail(mail);
					newContact.setPassword(password);
					String n = firstName + ' ' + secondName;
					newContact.setName(n);
					newContact.setPhoneNumber(phoneNum);
					newContact.setBirthday(birthday);
					newContact.creatFolder();
					SignIn.account.signin(mail, password);
					frame.setVisible(false);
					SignIn.frame.setVisible(true);
				}
			}
		});
		btnCreate.setBounds(474, 380, 85, 21);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SignIn.frame.setVisible(true);
			}
		});
		btnBack.setBounds(377, 380, 85, 21);
		contentPane.add(btnBack);
	}
}
