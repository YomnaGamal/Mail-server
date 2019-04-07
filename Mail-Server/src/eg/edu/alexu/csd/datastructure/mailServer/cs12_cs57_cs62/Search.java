package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class Search extends JFrame {

	String sersub = null;
	String serdato = null;
	String serdatf = null;
	String serdatt = null;
	String serwrd = null;
	String sersnd = null;
	boolean attach = false;
	LinkedBased Q = new LinkedBased();
	static Filter filt = new Filter();
	static Search frame = new Search();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(231, 27, 219, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(231, 78, 219, 22);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(231, 127, 219, 22);
		contentPane.add(textField_2);

		JLabel lblTo = new JLabel("To:");
		lblTo.setEnabled(false);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(153, 316, 50, 21);
		contentPane.add(lblTo);

		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(231, 232, 62, 21);
		contentPane.add(comboBox);
		for (int i = 1950; i < 2019; i++) {
			comboBox.addItem(i);
		}

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(321, 232, 71, 21);
		contentPane.add(comboBox_1);
		for (int i = 1; i < 13; i++) {
			comboBox_1.addItem(i);
		}

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_2.setBounds(416, 232, 61, 21);
		contentPane.add(comboBox_2);
		for (int i = 1; i < 31; i++) {
			comboBox_2.addItem(i);
		}

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setEnabled(false);
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_3.setBounds(231, 286, 62, 21);
		contentPane.add(comboBox_3);
		for (int i = 1950; i < 2019; i++) {
			comboBox_3.addItem(i);
		}

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setEnabled(false);
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_4.setBounds(321, 286, 71, 21);
		contentPane.add(comboBox_4);
		for (int i = 1; i < 13; i++) {
			comboBox_4.addItem(i);
		}

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setEnabled(false);
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_5.setBounds(416, 286, 61, 21);
		contentPane.add(comboBox_5);
		for (int i = 1; i < 31; i++) {
			comboBox_5.addItem(i);
		}

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setEnabled(false);
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_6.setBounds(231, 317, 62, 21);
		contentPane.add(comboBox_6);
		for (int i = 1950; i < 2019; i++) {
			comboBox_6.addItem(i);
		}

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setEnabled(false);
		comboBox_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_7.setBounds(321, 317, 71, 21);
		contentPane.add(comboBox_7);
		for (int i = 1; i < 13; i++) {
			comboBox_7.addItem(i);
		}

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setEnabled(false);
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_8.setBounds(416, 317, 61, 21);
		contentPane.add(comboBox_8);
		for (int i = 1; i < 31; i++) {
			comboBox_8.addItem(i);
		}

		JCheckBox chckbxDate = new JCheckBox("Date");
		chckbxDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxDate.setBounds(30, 230, 97, 23);
		contentPane.add(chckbxDate);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Include the words");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(30, 125, 195, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxSubject = new JCheckBox("Subject");
		chckbxSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxSubject.setBounds(30, 76, 97, 23);
		contentPane.add(chckbxSubject);

		JCheckBox chckbxSender = new JCheckBox("Sender");
		chckbxSender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxSender.setBounds(30, 27, 97, 23);
		contentPane.add(chckbxSender);
		// chckbxSender.addActionListener(arg0);

		JCheckBox chckbxHasAttachments = new JCheckBox("Has attachments");
		chckbxHasAttachments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxHasAttachments.setBounds(30, 179, 148, 40);
		contentPane.add(chckbxHasAttachments);		

		ActionListener actionListenerSender = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// abstractButton.setText(newLabel);
				if (chckbxSender.isSelected()) {
					textField.setEnabled(true);
					textField.setEditable(true);
				} else {
					textField.setEnabled(false);
					textField.setEditable(false);
				}
			}
		};
		chckbxSender.addActionListener(actionListenerSender);

		ActionListener actionListenerSubject = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// abstractButton.setText(newLabel);
				if (chckbxSubject.isSelected()) {
					textField_1.setEnabled(true);
					textField_1.setEditable(true);
				} else {
					textField_1.setEnabled(false);
					textField_1.setEditable(false);
				}

			}
		};
		chckbxSubject.addActionListener(actionListenerSubject);

		ActionListener actionListenerInclude = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// abstractButton.setText(newLabel);
				if (chckbxNewCheckBox.isSelected()) {
					textField_2.setEnabled(true);
					textField_2.setEditable(true);
				} else {
					textField_2.setEnabled(false);
					textField_2.setEditable(false);
				}
			}

		};
		chckbxNewCheckBox.addActionListener(actionListenerInclude);

		JRadioButton rdbtnOn = new JRadioButton("On");
		rdbtnOn.setEnabled(false);
		buttonGroup.add(rdbtnOn);
		rdbtnOn.setBounds(141, 232, 62, 23);
		contentPane.add(rdbtnOn);

		JRadioButton rdbtnFrom = new JRadioButton("From");
		rdbtnFrom.setEnabled(false);
		buttonGroup.add(rdbtnFrom);
		rdbtnFrom.setBounds(141, 286, 79, 23);
		contentPane.add(rdbtnFrom);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSearch.setBounds(231, 364, 133, 34);
		contentPane.add(btnSearch);
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		rdbtnTrue.setEnabled(false);
		buttonGroup_1.add(rdbtnTrue);
		rdbtnTrue.setBounds(231, 179, 109, 34);
		contentPane.add(rdbtnTrue);
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		rdbtnFalse.setEnabled(false);
		buttonGroup_1.add(rdbtnFalse);
		rdbtnFalse.setBounds(342, 184, 119, 29);
		contentPane.add(rdbtnFalse);

		ActionListener actionListenerser = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				if (chckbxDate.isSelected()) {
					if (rdbtnOn.isSelected()) {
						serdato = Integer.toString(comboBox.getSelectedIndex() + 1950) + "/" +
								Integer.toString(comboBox_1.getSelectedIndex() + 1) + "/" +
								Integer.toString(comboBox_2.getSelectedIndex() + 1);
						SearchFilter item = new SearchFilter();
						item.searchFor = serdato;
						item.type = "Date";
						Q.enqueue(item);
					} else {
						serdatf = Integer.toString(comboBox_3.getSelectedIndex() + 1950) + "/" +
								Integer.toString(comboBox_4.getSelectedIndex() + 1) + "/" +
								Integer.toString(comboBox_5.getSelectedIndex() + 1);
						serdatt = Integer.toString(comboBox_6.getSelectedIndex() + 1950) + "/" +
								Integer.toString(comboBox_7.getSelectedIndex() + 1) + "/" +
								Integer.toString(comboBox_8.getSelectedIndex() + 1);
						filt.setDateInterval(true);
						SearchFilter item = new SearchFilter();
						item.start = serdatf;
						item.end = serdatt;
						item.type = "Date";
						Q.enqueue(item);
					}
				}
				if (chckbxNewCheckBox.isSelected()) {
					serwrd = textField_2.getText();
					SearchFilter item = new SearchFilter();
					item.searchFor = serwrd;
					item.type = "Body";
					Q.enqueue(item);
				}
				if (chckbxSubject.isSelected()) {
					sersub = textField_1.getText();
					SearchFilter item = new SearchFilter();
					item.searchFor = sersub;
					item.type = "Subject";
					Q.enqueue(item);
				}
				if (chckbxSender.isSelected()) {
					sersnd = textField.getText();
					SearchFilter item = new SearchFilter();
					item.searchFor = sersnd;
					item.type = "Body";
					Q.enqueue(item);
				}
				if (chckbxHasAttachments.isSelected()) {
					if (rdbtnTrue.isSelected()) {
						SearchFilter item = new SearchFilter();
						item.type = "AttachmentsTrue";
						Q.enqueue(item);	
					} else {
						SearchFilter item = new SearchFilter();
						item.type = "AttachmentsFalse";
						Q.enqueue(item);
					}	
				}
				filt.setSearchIn(SignIn.account.currentFolder);
				filt.setQ(Q); 
				frame.setVisible(false);
			}
		};
		btnSearch.addActionListener(actionListenerser);

		ActionListener actionListeneron = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if (rdbtnOn.isSelected()) {
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);
					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox_2.setEnabled(true);
				} else {
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					comboBox_6.setEnabled(true);
					comboBox_7.setEnabled(true);
					comboBox_8.setEnabled(true);
					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
				}
			}
		};
		rdbtnOn.addActionListener(actionListeneron);

		ActionListener actionListenerfrom = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if (rdbtnFrom.isSelected()) {
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					comboBox_6.setEnabled(true);
					comboBox_7.setEnabled(true);
					comboBox_8.setEnabled(true);
					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
				} else {
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);
					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox_2.setEnabled(true);
				}
			}
		};
		
		ActionListener actionListenerattach = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// abstractButton.setText(newLabel);
				if (chckbxHasAttachments.isSelected()) {
					rdbtnFalse.setEnabled(true);
					rdbtnTrue.setEnabled(true);
				} else {
					rdbtnFalse.setEnabled(false);
					rdbtnTrue.setEnabled(false);
				}
			}
		};
		chckbxHasAttachments.addActionListener(actionListenerattach);
		
		rdbtnFrom.addActionListener(actionListenerfrom);
		ActionListener actionListenerDate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if (chckbxDate.isSelected()) {
					rdbtnOn.setEnabled(true);
					rdbtnFrom.setEnabled(true);
					lblTo.setEnabled(true);
				} else {
					rdbtnOn.setEnabled(false);
					rdbtnFrom.setEnabled(false);
					lblTo.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);
					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
				}
			}
		};
		chckbxDate.addActionListener(actionListenerDate);
	}
}
