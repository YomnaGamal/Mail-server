package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class TestNew extends JFrame {
	static TestNew frame = new TestNew();
	private JPanel contentPane;
	private final JRadioButton checkbox = new JRadioButton("Selecte ALL", false);
	static int noPag = 1;
	static int max = 1;
	static int noMails;
	static int inbox = 0;
	static int sent = 0;
	static int trash = 0;
	static int draft = 0;
	static int stare = 0;
	static int creat = 0;
	static String nameOfCreate;
	static SLinkedList names;
	static int flage = 0;
	static String currFolder;
	JButton buttonD;
	JButton buttonM;
	private Folder folder;
	private Sort sort;
	private Filter filter;
	private Mail[] mails;
	Action action = new Action();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_15;
	private JTextField textField_25;
	private JLabel lblNewLabel_1;
	JPopupMenu m2;
    JMenuItem item2;
    ActionListener menuListener2;
    JButton[] arrBtn = new JButton[11];
	
	/**
	 * Launch the application.
	 */
	public static void main(String arg[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Toolkit toolkit = frame.getToolkit();
					Dimension size = toolkit.getScreenSize();
					frame.setSize(size.width, size.height);
					frame.setLocationRelativeTo(null);
					//frame.setLocation(size.width/2 - frame.getWidth()/2 , size.height/2 - frame.getHeight()/2);
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
	public TestNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		action.setContact(SignIn.account.currentContact);

		JButton b = new JButton("New button");
		b.setBounds(1250, 5, 90, 69);
        JPopupMenu m = new JPopupMenu();
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Sign_Out")) {
            	frame.setVisible(false);
				SignIn.frame.setVisible(true);
            } else if (event.getActionCommand().equals("Change passowrd")) {
            	frame.setVisible(true);
            	Change_Password.frame.setVisible(true);
            }
            }
          };
        JMenuItem item;
        m.add(item = new JMenuItem("Change passowrd"));
        item.setHorizontalTextPosition(JMenuItem.RIGHT);
        item.addActionListener(menuListener);
        m.add(item = new JMenuItem("Sign_Out"));
        item.setHorizontalTextPosition(JMenuItem.RIGHT);
        item.addActionListener(menuListener);
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.show(b, b.getWidth()/2, b.getHeight()/2);
        	}
        });
        contentPane.setLayout(null);
        getContentPane().add(b);
		 b.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/me.jpg")), b.getWidth(), b.getHeight()));

		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(850, 32, 121, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					Search.frame.setVisible(true);
					filter = Search.filt;
					SignIn.account.setViewingOptions(folder, filter, sort);
					mails = (Mail[]) SignIn.account.listEmails(noPag);
	        	}
	        });
		
		JButton btnNewButton_2 = new JButton("Creat");	
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				Creat.frame.setVisible(true);
			}
		});	
		btnNewButton_2.setBounds(664, 28, 89, 23);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(20, 5, 146, 69);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/LogoMakr2.png")), btnNewButton_3.getWidth(), btnNewButton_3.getHeight()));

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(5, 5, 1500, 72);
		scrollPane.setBackground(Color.PINK);
		contentPane.add(scrollPane);
		
		JButton buttonR = new JButton("Refresh");
		buttonR.setBounds(400, 83, 90, 22);
		contentPane.add(buttonR);
		
		JButton btnNewButton_1 = new JButton("COMPOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				Compose.frame.setVisible(true);
				}
		});
		btnNewButton_1.setBounds(20, 83, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JButton sortb = new JButton("Sort");
		sortb.setBounds(900, 83, 89, 23);
		JPopupMenu m3 = new JPopupMenu();
        ActionListener menuListener3 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	flage = 1;
            if (event.getActionCommand().equals("default")) {
            	sort = new Sort();
				sort.setCriteria("default");
            } else if (event.getActionCommand().equals("priority")) {
            	sort = new Sort();
            	sort.setCriteria("priority");
            } else if (event.getActionCommand().equals("status")) {
            	sort = new Sort();
            		sort.setCriteria("status");
            } else if (event.getActionCommand().equals("starred")) {
            	sort = new Sort();
            	sort.setCriteria("starred");
            }
            }
          };
        JMenuItem item3;
        m3.add(item3 = new JMenuItem("default"));
        item3.setHorizontalTextPosition(JMenuItem.RIGHT);
        item3.addActionListener(menuListener3);
        m3.add(item3 = new JMenuItem("priority"));
        item3.setHorizontalTextPosition(JMenuItem.RIGHT);
        item3.addActionListener(menuListener3);
        m3.add(item3 = new JMenuItem("status"));
        item3.setHorizontalTextPosition(JMenuItem.RIGHT);
        item3.addActionListener(menuListener3);
        m3.add(item3 = new JMenuItem("starred"));
        item3.setHorizontalTextPosition(JMenuItem.RIGHT);
        item3.addActionListener(menuListener3);
        sortb.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m3.show(sortb, sortb.getWidth()/2, sortb.getHeight()/2);
        	}
        });
        contentPane.setLayout(null);
        getContentPane().add(sortb);
		
		JButton btnNewButtonN = new JButton("Next");
		btnNewButtonN.setBounds(1150, 83, 89, 23);
		contentPane.add(btnNewButtonN);
		
		JButton btnNewButtonP = new JButton("Previous");
		btnNewButtonP.setBounds(1000, 83, 89, 23);
		contentPane.add(btnNewButtonP);
		/**
		 * action of button go to get number of page.
		 */
		btnNewButtonN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (noPag < max) {
				noPag++;
				System.out.println(noPag);}
			}
		});
		
		btnNewButtonP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (noPag > 1) {
				noPag--;
				System.out.println(noPag);
				}
			}
		});
		
		JPanel panelInbox = new JPanel();
		panelInbox.setBounds(199, 117, 1027, 500);
		panelInbox.setVisible(false);
		contentPane.add(panelInbox);
		panelInbox.setLayout(null);
		
		JPanel panelD = new JPanel();
		panelD.setBounds(119, 117, 1400, 500);
		contentPane.add(panelD);
		panelD.setLayout(null);
		panelD.setVisible(false);
		
		JPanel panelE = new JPanel();
		panelE.setBounds(119, 117, 1400, 500);
		contentPane.add(panelE);
		panelE.setLayout(null);
		panelE.setVisible(false);
		
		JButton b1 = new JButton();
		b1.setBounds(30, 440, 10, 22); 
		panelE.add(b1);
		b1.setVisible(false);
		
		JButton b2 = new JButton();
		b2.setBounds(30, 440, 10, 22);
		panelE.add(b2);
		b2.setVisible(false);
		
		JButton b3 = new JButton();
		b3.setBounds(30, 440, 10, 22);
		panelE.add(b3);
		b3.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(22, 21, 972, 36);
		panel_1.setVisible(false);
		panelInbox.add(panel_1);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(6, 6, 21, 21);
		panel_1.add(radioButton_1);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox.setBounds(48, 6, 59, 21);
		panel_1.add(checkBox);
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox.isSelected()) {
					action.star(mails[0].getName(), folder);
				} else if (!checkBox.isSelected()) {
					action.unstar(mails[0].getName());
				}
			}
			
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(113, 4, 276, 29);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(399, 4, 219, 29);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(640, 4, 172, 29);
		panel_1.add(textField_3);
		
		JButton button = new JButton("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[0].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[0].getName(), x);
						
						Mail x1 = mails[0];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[0].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[0].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
					
					}}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(826, 2, 101, 31);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(22, 68, 972, 36);
		panel_2.setVisible(false);
		panelInbox.add(panel_2);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(6, 6, 21, 21);
		panel_2.add(radioButton_2);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_1.setBounds(48, 6, 59, 21);
		panel_2.add(checkBox_1);
		checkBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_1.isSelected()) {
					action.star(mails[1].getName(), folder);
				} else if (!checkBox_1.isSelected()) {
					action.unstar(mails[1].getName());
				}
			}
			
		});
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(113, 4, 276, 29);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(399, 4, 219, 29);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(640, 4, 172, 29);
		panel_2.add(textField_6);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[1].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						}  else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[1].getName(), x);
						
						Mail x1 = mails[1];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[1].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[1].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						
					} }
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(826, 2, 101, 31);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(22, 119, 972, 36);
		panel_3.setVisible(false);
		panelInbox.add(panel_3);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(6, 6, 21, 21);
		panel_3.add(radioButton_3);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_2.setBounds(48, 6, 59, 21);
		panel_3.add(checkBox_2);
		checkBox_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_2.isSelected()) {
					action.star(mails[2].getName(), folder);
				} else if (!checkBox_2.isSelected()) {
					action.unstar(mails[2].getName());
				}
			}
			
		});
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(113, 4, 276, 29);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(399, 4, 219, 29);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(640, 4, 172, 29);
		panel_3.add(textField_9);
		
		JButton button_2 = new JButton("View");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[2].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[2].getName(), x);
						
						Mail x1 = mails[2];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[2].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[2].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						
					}}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(826, 2, 101, 31);
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(22, 165, 972, 36);
		panel_4.setVisible(false);
		panelInbox.add(panel_4);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(6, 6, 21, 21);
		panel_4.add(radioButton_4);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_3.setBounds(48, 6, 59, 21);
		panel_4.add(checkBox_3);
		checkBox_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_3.isSelected()) {
					action.star(mails[3].getName(), folder);
				} else if (!checkBox_3.isSelected()) {
					action.unstar(mails[3].getName());
				}
			}
			
		});
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(113, 4, 276, 29);
		panel_4.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(399, 4, 219, 29);
		panel_4.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(640, 4, 172, 29);
		panel_4.add(textField_12);
		
		JButton button_3 = new JButton("View");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[3].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[3].getName(), x);
						
						Mail x1 = mails[3];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[3].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[3].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						
					}}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBounds(826, 2, 101, 31);
		panel_4.add(button_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(22, 216, 972, 36);
		panel_5.setVisible(false);
		panelInbox.add(panel_5);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(6, 6, 21, 21);
		panel_5.add(radioButton_5);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_4.setBounds(48, 6, 59, 21);
		panel_5.add(checkBox_4);
		checkBox_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_4.isSelected()) {
					action.star(mails[4].getName(), folder);
				} else if (!checkBox_4.isSelected()) {
					action.unstar(mails[4].getName());
				}
			}
			
		});
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(113, 4, 276, 29);
		panel_5.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(399, 4, 219, 29);
		panel_5.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(640, 4, 172, 29);
		panel_5.add(textField_15);
		
		JButton button_4 = new JButton("View");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[4].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[4].getName(), x);
						
						Mail x1 = mails[4];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[4].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[4].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						}
					}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_4.setBounds(826, 2, 101, 31);
		panel_5.add(button_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(22, 263, 972, 36);
		panel_6.setVisible(false);
		panelInbox.add(panel_6);
		
		JRadioButton radioButton_6 = new JRadioButton("");
		radioButton_6.setBounds(6, 6, 21, 21);
		panel_6.add(radioButton_6);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_5.setBounds(48, 6, 59, 21);
		panel_6.add(checkBox_5);
		checkBox_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_5.isSelected()) {
					action.star(mails[5].getName(), folder);
				} else if (!checkBox_5.isSelected()) {
					action.unstar(mails[5].getName());
				}
			}
			
		});
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(113, 4, 276, 29);
		panel_6.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(399, 4, 219, 29);
		panel_6.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(640, 4, 172, 29);
		panel_6.add(textField_18);
		
		JButton button_5 = new JButton("View");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[5].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[5].getName(), x);
						
						Mail x1 = mails[5];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[5].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[5].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						
					}}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_5.setBounds(826, 2, 101, 31);
		panel_6.add(button_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(22, 309, 972, 36);
		panel_7.setVisible(false);
		panelInbox.add(panel_7);
		
		JRadioButton radioButton_7 = new JRadioButton("");
		radioButton_7.setBounds(6, 6, 21, 21);
		panel_7.add(radioButton_7);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_6.setBounds(48, 6, 59, 21);
		panel_7.add(checkBox_6);
		checkBox_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_6.isSelected()) {
					action.star(mails[6].getName(), folder);
				} else if (!checkBox_6.isSelected()) {
					action.unstar(mails[6].getName());
				}
			}
			
		});
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(113, 4, 276, 29);
		panel_7.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(399, 4, 219, 29);
		panel_7.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBounds(640, 4, 172, 29);
		panel_7.add(textField_21);
		
		JButton button_6 = new JButton("View");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[6].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[6].getName(), x);
						
						Mail x1 = mails[6];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[6].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[6].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						}
					}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_6.setBounds(826, 2, 101, 31);
		panel_7.add(button_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(22, 360, 972, 36);
		panel_8.setVisible(false);
		panelInbox.add(panel_8);
		
		JRadioButton radioButton_8 = new JRadioButton("");
		radioButton_8.setBounds(6, 6, 21, 21);
		panel_8.add(radioButton_8);
		
		JCheckBox checkBox_7 = new JCheckBox("");
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_7.setBounds(48, 6, 59, 21);
		panel_8.add(checkBox_7);
		checkBox_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_7.isSelected()) {
					action.star(mails[7].getName(), folder);
				} else if (!checkBox_7.isSelected()) {
					action.unstar(mails[7].getName());
				}
			}
			
		});
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(113, 4, 276, 29);
		panel_8.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(399, 4, 219, 29);
		panel_8.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(640, 4, 172, 29);
		panel_8.add(textField_24);
		
		JButton button_7 = new JButton("View");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[7].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[7].getName(), x);
						
						Mail x1 = mails[7];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[7].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[7].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						}
					}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_7.setBounds(826, 2, 101, 31);
		panel_8.add(button_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(22, 407, 972, 36);
		panel_9.setVisible(false);
		panelInbox.add(panel_9);
		
		JRadioButton radioButton_9 = new JRadioButton("");
		radioButton_9.setBounds(6, 6, 21, 21);
		panel_9.add(radioButton_9);
		
		JCheckBox checkBox_8 = new JCheckBox("");
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_8.setBounds(48, 6, 59, 21);
		panel_9.add(checkBox_8);
		checkBox_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_8.isSelected()) {
					action.star(mails[8].getName(), folder);
				} else if (!checkBox_8.isSelected()) {
					action.unstar(mails[8].getName());
				}
			}
			
		});
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBounds(113, 4, 276, 29);
		panel_9.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_26.setEditable(false);
		textField_26.setColumns(10);
		textField_26.setBounds(399, 4, 219, 29);
		panel_9.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_27.setEditable(false);
		textField_27.setColumns(10);
		textField_27.setBounds(640, 4, 172, 29);
		panel_9.add(textField_27);
		
		JButton button_8 = new JButton("View");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[8].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[8].getName(), x);
						
						Mail x1 = mails[8];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[8].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[8].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						}
					}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_8.setBounds(826, 2, 101, 31);
		panel_9.add(button_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(22, 453, 972, 36);
		panel_10.setVisible(false);
		panelInbox.add(panel_10);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(6, 6, 21, 21);
		panel_10.add(radioButton);
		
		JCheckBox checkBox_9 = new JCheckBox("");
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_9.setBounds(48, 6, 59, 21);
		panel_10.add(checkBox_9);
		checkBox_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkBox_9.isSelected()) {
					action.star(mails[9].getName(), folder);
				} else if (!checkBox_9.isSelected()) {
					action.unstar(mails[9].getName());
				}
			}
			
		});
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBounds(113, 4, 276, 29);
		panel_10.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_29.setEditable(false);
		textField_29.setColumns(10);
		textField_29.setBounds(399, 4, 219, 29);
		panel_10.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_30.setEditable(false);
		textField_30.setColumns(10);
		textField_30.setBounds(640, 4, 172, 29);
		panel_10.add(textField_30);
		
		JButton button_9 = new JButton("View");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				action.status(mails[9].getName(), folder);	
						panelInbox.setVisible(false);
						panelE.removeAll();
						panelE.setVisible(true);
						if (draft == 1) {
							Compose.frame.setVisible(true);
						} else {
						String f = null;
						if (inbox == 1) {
							f = "Inbox";
						} else if (sent == 1) {
							f = "Sent";
						} else if (trash == 1) {
							f = "Trash";
						} else if (stare == 1) {
							f = "Starred";
						} else {
							f = currFolder;
						}
						
						Folder x = new Folder();
						x.setFolder(f);
						Sort y = new Sort();
						y.setCriteria("default");
						SignIn.account.setViewingOptions(x, null, y);
						
						Action action = new Action();
						action.status(mails[9].getName(), x);
						
						Mail x1 = mails[9];
						x1.setFolder(f);
						String s = null;
						
						JLabel lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setBounds(30, 10, 50, 30);
						panelE.add(lblNewLabel_4);
						
						if(x1.getFolder().equals("Sent")) {
							LinkedBased r = new LinkedBased();
							r = x1.getReceivers();
							if (!r.isEmpty()) {
								 s = (String) r.dequeue();
							} else {
								s = "";
							}
							while (!r.isEmpty()) {
								s += "," + r.dequeue();
							}
							lblNewLabel_4.setText("To");
						} else {
							 s = x1.getSender();
								lblNewLabel_4.setText("From");
						}
						
						JLabel lblNewLabel_5 = new JLabel("Subject");
						lblNewLabel_5.setBounds(30, 50, 50, 30);
						panelE.add(lblNewLabel_5);
						
						JLabel lblNewLabel = new JLabel("email is");
						lblNewLabel.setBounds(30, 90, 50, 30);
						panelE.add(lblNewLabel);
						
						JTextField textField_4 = new JTextField();
						textField_4.setText(s);
						textField_4.setBounds(100, 10, 100, 30);
						panelE.add(textField_4);
						textField_4.setColumns(10);
						
						JTextField textField_5 = new JTextField();
						textField_5.setText(mails[9].getSubject());
						textField_5.setBounds(100, 50, 100, 30);
						panelE.add(textField_5);
						textField_5.setColumns(10);
						
						
						JTextArea textField_3 = new JTextArea();
						File body = mails[9].getBody();
						try {
							BufferedReader bw = new BufferedReader(new FileReader(body));
							try {
								textField_3.read(bw, null);
								bw.close();
			                    textField_3.requestFocus();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField_3.setBounds(30, 130, 1200, 300);
						panelE.add(textField_3);
						textField_3.setColumns(10);
						}
					}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_9.setBounds(826, 2, 101, 31);
		panel_10.add(button_9);
		/**
		 * for select all.
		 */
		if (checkbox.isSelected()) {
			checkbox.setSelected(false);
			}
		
			JLabel lblSelecte = new JLabel("Selecte");
			lblSelecte.setOpaque(true);
			lblSelecte.setBackground(Color.PINK);
			lblSelecte.setBounds(22, 0, 46, 24);
			panelInbox.add(lblSelecte);
			
			JLabel lblNewLabel = new JLabel("Stare");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.PINK);
			lblNewLabel.setBounds(74, 0, 46, 24);
			panelInbox.add(lblNewLabel);
			
			/**
			 * may be from or to.
			 */
			lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(Color.PINK);
			lblNewLabel_1.setBounds(300 - 119, 117 - 117, 46, 24);
			panelInbox.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Subject");
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(Color.PINK);
			lblNewLabel_2.setBounds(600 - 119, 117 - 117, 46, 24);
			panelInbox.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Date");
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(Color.PINK);
			lblNewLabel_3.setBounds(900 - 119, 117 - 117, 46, 24);
			panelInbox.add(lblNewLabel_3);
			
		JButton btnNewButton_4 = new JButton("Inbox");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				inbox = 1;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 0;
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder("Inbox");
				if (flage == 0) {
					sort = new Sort();
					sort.setCriteria("default");
					SignIn.account.setViewingOptions(folder, null, sort);
			        mails = (Mail[]) SignIn.account.listEmails(noPag);
				} else {
	   			 SignIn.account.setViewingOptions(folder, null,sort);
		        mails = (Mail[]) SignIn.account.listEmails(noPag);
				}
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				flage = 0;
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		btnNewButton_4.setBounds(20, 118, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sent");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				inbox = 0;
				sent = 1;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 0;
				buttonM.setEnabled(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("TO");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder("Sent");
				if (flage == 0) {
					sort = new Sort();
					sort.setCriteria("default");
					SignIn.account.setViewingOptions(folder, null, sort);
			        mails = (Mail[]) SignIn.account.listEmails(noPag);
				} else {
	   			 SignIn.account.setViewingOptions(folder, filter,sort);
		        mails = (Mail[]) SignIn.account.listEmails(noPag);
				}
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				flage = 0;
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					LinkedBased r = new LinkedBased();
					r = x.getReceivers();
					String s;
					if (!r.isEmpty()) {
						 s = (String) r.dequeue();
					} else {
						s = "";
					}
					while (!r.isEmpty()) {
						s += "," + r.dequeue();
					}
					switch (i) {
					case 0:
						textField_1.setText(s);
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						
						textField_4.setText(s);
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(s);
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(s);
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(s);
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(s);
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(s);
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(s);
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(s);
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(s);
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		btnNewButton_5.setBounds(20, 145, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Drafts");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 1;
				stare = 0;
				creat = 0;
				buttonD.setEnabled(false);
				buttonM.setEnabled(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("TO");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder("Drafts");
				if (flage == 0) {
					sort = new Sort();
					sort.setCriteria("default");
					SignIn.account.setViewingOptions(folder, null, sort);
			        mails = (Mail[]) SignIn.account.listEmails(noPag);
				} else {
	   			 SignIn.account.setViewingOptions(folder, filter,sort);
		        mails = (Mail[]) SignIn.account.listEmails(noPag);
				}
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				flage = 0;
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					LinkedBased r = new LinkedBased();
					r = x.getReceivers();
					String s;
					if (!r.isEmpty()) {
						 s = (String) r.dequeue();
					} else {
						s = "";
					}
					while (!r.isEmpty()) {
						s += "," + r.dequeue();
					}
					switch (i) {
					case 0:
						textField_1.setText(s);
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						
						textField_4.setText(s);
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(s);
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(s);
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(s);
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(s);
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(s);
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(s);
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(s);
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(s);
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		btnNewButton_6.setBounds(20, 172, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Trash");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				inbox = 0;
				sent = 0;
				trash = 1;
				draft = 0;
				stare = 0;
				creat = 0;
				buttonD.setEnabled(false);
				buttonM.setEnabled(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				lblNewLabel.setVisible(false);

				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);

				folder = new Folder();
				folder.setFolder("Trash");
				if (flage == 0) {
					sort = new Sort();
					sort.setCriteria("default");
					SignIn.account.setViewingOptions(folder, null, sort);
			        mails = (Mail[]) SignIn.account.listEmails(noPag);
				} else {
	   			 SignIn.account.setViewingOptions(folder, filter,sort);
		        mails = (Mail[]) SignIn.account.listEmails(noPag);
				}
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				flage = 0;
				
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					String s = null;
					if(x.getFolder().equals("Sent")) {
						LinkedBased r = new LinkedBased();
						r = x.getReceivers();
						 s = (String) r.dequeue();
						while (!r.isEmpty()) {
							s += "," + r.dequeue();
						}
					} else if (x.getFolder().equals("Inbox")) {
						 s = x.getSender();
					}
					switch (i) {
					case 0:
						textField_1.setText(s);
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(s);
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(s);
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(s);
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(s);
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(s);
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(s);
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(s);
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(s);
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(s);
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						panel_10.setVisible(true);
						break;
					}
				}
				checkBox.setVisible(false);
				checkBox_1.setVisible(false);
				checkBox_2.setVisible(false);
				checkBox_3.setVisible(false);
				checkBox_4.setVisible(false);
				checkBox_5.setVisible(false);
				checkBox_6.setVisible(false);
				checkBox_7.setVisible(false);
				checkBox_8.setVisible(false);
				checkBox_9.setVisible(false);
			}
		});
		btnNewButton_7.setBounds(20, 200, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Starred");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 1;
				creat = 0;
				buttonD.setEnabled(false);
				buttonM.setEnabled(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder("Starred");
				if (flage == 0) {
					sort = new Sort();
					sort.setCriteria("default");
					SignIn.account.setViewingOptions(folder, null, sort);
			        mails = (Mail[]) SignIn.account.listEmails(noPag);
				} else {
	   			 SignIn.account.setViewingOptions(folder, filter,sort);
		        mails = (Mail[]) SignIn.account.listEmails(noPag);
				}
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				flage = 0;
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					String s = null;
					if(x.getFolder().equals("Sent")) {
						LinkedBased r = new LinkedBased();
						r = x.getReceivers();
						 s = (String) r.dequeue();
						while (!r.isEmpty()) {
							s += "," + r.dequeue();
						}
					} else if (x.getFolder().equals("Inbox")) {
						 s = x.getSender();
					}
					switch (i) {
					case 0:
						textField_1.setText(s);
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						checkBox.setSelected(true);
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(s);
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						checkBox_1.setSelected(true);
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(s);
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						checkBox_2.setSelected(true);
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(s);
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
							checkBox_3.setSelected(true);
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(s);
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(s);
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
							checkBox_5.setSelected(true);
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(s);
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
							checkBox_6.setSelected(true);
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(s);
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
							checkBox_7.setSelected(true);
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(s);
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
							checkBox_8.setSelected(true);
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(s);
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
							checkBox_9.setSelected(true);
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		btnNewButton_8.setBounds(20, 228, 89, 23);
		contentPane.add(btnNewButton_8);
		
		 buttonD = new JButton("Delete");
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SLinkedList delete = new SLinkedList();
				if (radioButton_1.isSelected()) {
					delete.add(mails[0]);
				}
				if (radioButton_2.isSelected()) {
					delete.add(mails[1]);
				}
				if (radioButton_3.isSelected()) {
					delete.add(mails[2]);
				}
				if (radioButton_4.isSelected()) {
					delete.add(mails[3]);
				}
				if (radioButton_5.isSelected()) {
					delete.add(mails[4]);
				}
				if (radioButton_6.isSelected()) {
					delete.add(mails[5]);
				}
				if (radioButton_7.isSelected()) {
					delete.add(mails[6]);
				}
				if (radioButton_8.isSelected()) {
					delete.add(mails[7]);
				}
				if (radioButton_9.isSelected()) {
					delete.add(mails[8]);
				}
				if (radioButton.isSelected()) {
					delete.add(mails[9]);
				}
				SignIn.account.deleteEmails(delete);
			}
		});
		buttonD.setBounds(600, 83, 90, 22);
		contentPane.add(buttonD);
		
		 buttonM = new JButton("Move To");
		 m2 = new JPopupMenu();
        menuListener2 = new ActionListener() {
           @SuppressWarnings("null")
		public void actionPerformed(ActionEvent event) {
           	IFolder move = new Folder();
           	SLinkedList mailM = new SLinkedList();
           	if (radioButton_1.isSelected()) {
           		mailM.add(mails[0]);
			}
			if (radioButton_2.isSelected()) {
				mailM.add(mails[1]);
			}
			if (radioButton_3.isSelected()) {
				mailM.add(mails[2]);
			}
			if (radioButton_4.isSelected()) {
				mailM.add(mails[3]);
			}
			if (radioButton_5.isSelected()) {
				mailM.add(mails[4]);
			}
			if (radioButton_6.isSelected()) {
				mailM.add(mails[5]);
			}
			if (radioButton_7.isSelected()) {
				mailM.add(mails[6]);
			}
			if (radioButton_8.isSelected()) {
				mailM.add(mails[7]);
			}
			if (radioButton_9.isSelected()) {
				mailM.add(mails[8]);
			}
			if (radioButton.isSelected()) {
				mailM.add(mails[9]);
			}
           if (event.getActionCommand().equals("Inbox")) {
           	((Folder) move).setFolder("Inbox");
           	SignIn.account.moveEmails(mailM, move);
           	System.out.println("Inbox");
           } else if (event.getActionCommand().equals("Trash")) {
        	   buttonD.doClick();
           } else if (event.getActionCommand().equals("Creat new file")) {
        	   frame.setVisible(false);
        	   Creat.frame.setVisible(true);
           } else {
           	names = SignIn.account.ckeck();
      		 for (int y = 0; y < names.size(); y++) {
      			 nameOfCreate = (String) names.get(y);
      			if(event.getActionCommand().equals(nameOfCreate)) {
      				((Folder) move).setFolder(nameOfCreate);
      	           	SignIn.account.moveEmails(mailM, move);
      			}
      		 }
           }
           }
         };
       m2.add(item2 = new JMenuItem("Inbox"));
       item2.setHorizontalTextPosition(JMenuItem.RIGHT);
       item2.addActionListener(menuListener2);
       m2.add(item2 = new JMenuItem("Trash"));
       item2.setHorizontalTextPosition(JMenuItem.RIGHT);
       item2.addActionListener(menuListener2);
		function2();
		 m2.add(item2 = new JMenuItem("Creat new file"));
	     item2.setHorizontalTextPosition(JMenuItem.RIGHT);
	     item2.addActionListener(menuListener2);
       buttonM.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		m2.show(buttonM, buttonM.getWidth()/2, buttonM.getHeight()/2);
       	}
       });
		buttonM.setBounds(500, 83, 90, 22);
		contentPane.add(buttonM);
			
		/**
		 * action of select all.
		 */
		checkbox.setBounds(238, 83, 146, 23);
		checkbox.setBackground(new Color(255, 204, 204));
		contentPane.add(checkbox);
		checkbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (checkbox.isSelected()) {
					for (int i = 0; i < mails.length; i++) {
						switch (i) {
						case 0:
							if (!radioButton_1.isSelected())
								radioButton_1.setSelected(true);
							else 
								radioButton_1.setSelected(false);
							break;
						case 1:
							if (!radioButton_2.isSelected())
								radioButton_2.setSelected(true);
							else 
								radioButton_2.setSelected(false);
							break;
						case 2:
							if (!radioButton_3.isSelected())
								radioButton_3.setSelected(true);
							else 
								radioButton_3.setSelected(false);
							break;
						case 3:
							if (!radioButton_4.isSelected())
								radioButton_4.setSelected(true);
							else 
								radioButton_4.setSelected(false);
							break;
						case 4:
							if (!radioButton_5.isSelected())
								radioButton_5.setSelected(true);
							else 
								radioButton_5.setSelected(false);
							break;
						case 5:
							if (!radioButton_6.isSelected())
								radioButton_6.setSelected(true);
							else 
								radioButton_6.setSelected(false);
							break;
						case 6:
							if (!radioButton_7.isSelected())
								radioButton_7.setSelected(true);
							else 
								radioButton_7.setSelected(false);
							break;
						case 7:
							if (!radioButton_8.isSelected())
								radioButton_8.setSelected(true);
							else 
								radioButton_8.setSelected(false);
							break;
						case 8:
							if (!radioButton_9.isSelected())
								radioButton_9.setSelected(true);
							else 
								radioButton_9.setSelected(false);
							break;
						case 9:
							if (!radioButton.isSelected())
								radioButton.setSelected(true);
							else 
								radioButton.setSelected(false);
							break;
						}
					}
				}
				
				if (!checkbox.isSelected()) {
					for (int i = 0; i < mails.length; i++) {
						switch (i) {
						case 0:
							radioButton_1.setSelected(false);
							break;
						case 1:
							radioButton_2.setSelected(false);
							break;
						case 2:
							radioButton_3.setSelected(false);
							break;
						case 3:
							radioButton_4.setSelected(false);
							break;
						case 4:
							radioButton_5.setSelected(false);
							break;
						case 5:
							radioButton_6.setSelected(false);
							break;
						case 6:
							radioButton_7.setSelected(false);
							break;
						case 7:
							radioButton_8.setSelected(false);
							break;
						case 8:
							radioButton_9.setSelected(false);
							break;
						case 9:
							radioButton.setSelected(false);
							break;
						}
					}
				}
			}
			
		});
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(5, 80, 1692, 34);
		scrollPane_1.setBackground(Color.PINK);
		contentPane.add(scrollPane_1);

		arrBtn[0] = new JButton("New button");
		arrBtn[0].setBounds(20, 256, 89, 23);
		arrBtn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[0].getText();
				panelE.setVisible(false);

				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[0].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[0].setVisible(false);
		contentPane.add(arrBtn[0]);
		
		arrBtn[1] = new JButton("New button");
		arrBtn[1].setBounds(20, 284, 89, 23);
		arrBtn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[1].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[1].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[1].setVisible(false);
		contentPane.add(arrBtn[1]);
		
		arrBtn[2] = new JButton("New button");
		arrBtn[2].setBounds(20, 312, 89, 23);
		arrBtn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[2].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[2].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[2].setVisible(false);
		contentPane.add(arrBtn[2]);
		
		arrBtn[3] = new JButton("New button");
		arrBtn[3].setBounds(20, 340, 89, 23);
		arrBtn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[3].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[3].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[3].setVisible(false);
		contentPane.add(arrBtn[3]);
		
		arrBtn[4] = new JButton("New button");
		arrBtn[4].setBounds(20, 368, 89, 23);
		arrBtn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[4].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[4].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[4].setVisible(false);
		contentPane.add(arrBtn[4]);
		
		arrBtn[5] = new JButton("New button");
		arrBtn[5].setBounds(20, 396, 89, 23);
		arrBtn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[5].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[5].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[5].setVisible(false);
		contentPane.add(arrBtn[5]);
		
		arrBtn[6] = new JButton("New button");
		arrBtn[6].setBounds(20, 424, 89, 23);
		arrBtn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[6].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[6].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[6].setVisible(false);
		contentPane.add(arrBtn[6]);
		
		arrBtn[7] = new JButton("New button");
		arrBtn[7].setBounds(20, 452, 89, 23);
		arrBtn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[7].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[7].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[7].setVisible(false);
		contentPane.add(arrBtn[7]);

		arrBtn[8] = new JButton("New button");
		arrBtn[8].setBounds(20, 480, 89, 23);
		arrBtn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[8].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[8].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[8].setVisible(false);
		contentPane.add(arrBtn[8]);
		
		arrBtn[9] = new JButton("New button");
		arrBtn[9].setBounds(20, 508, 89, 23);
		arrBtn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[9].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[9].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[9].setVisible(false);
		contentPane.add(arrBtn[9]);
		
		arrBtn[10] = new JButton("New button");
		arrBtn[10].setBounds(20, 536, 89, 23);
		arrBtn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inbox = 0;
				sent = 0;
				trash = 0;
				draft = 0;
				stare = 0;
				creat = 1;
				currFolder = arrBtn[10].getText();
				panelE.setVisible(false);
				
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(false);
				panel_10.setVisible(false);
				panelInbox.setVisible(true);
				checkBox.setVisible(true);
				checkBox_1.setVisible(true);
				checkBox_2.setVisible(true);
				checkBox_3.setVisible(true);
				checkBox_4.setVisible(true);
				checkBox_5.setVisible(true);
				checkBox_6.setVisible(true);
				checkBox_7.setVisible(true);
				checkBox_8.setVisible(true);
				checkBox_9.setVisible(true);
				lblNewLabel.setVisible(true);
				
				lblNewLabel_1.setText("From");
				
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
				radioButton_7.setSelected(false);
				radioButton_8.setSelected(false);
				radioButton_9.setSelected(false);
				radioButton.setSelected(false);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
				checkBox_6.setSelected(false);
				checkBox_7.setSelected(false);
				checkBox_8.setSelected(false);
				checkBox_9.setSelected(false);
				
				folder = new Folder();
				folder.setFolder(arrBtn[10].getText());
				sort = new Sort();
				sort.setCriteria("default");
				SignIn.account.setViewingOptions(folder, null, sort);
				
				System.out.println(SignIn.account.mails.size());
				noMails = SignIn.account.mails.size();
				max = maxPage(noMails);
				System.out.println(max);
				
				mails = (Mail[]) SignIn.account.listEmails(noPag);
				for (int i = 0; i < mails.length; i++) {
					Mail x = mails[i];
					switch (i) {
					case 0:
						textField_1.setText(x.getSender());
						textField_2.setText(x.getSubject());
						textField_3.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox.setSelected(true);
						}
						panel_1.setVisible(true);
						break;
					case 1:
						textField_4.setText(x.getSender());
						textField_5.setText(x.getSubject());
						textField_6.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_1.setSelected(true);
						}
						panel_2.setVisible(true);
						break;
					case 2:
						textField_7.setText(x.getSender());
						textField_8.setText(x.getSubject());
						textField_9.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_2.setSelected(true);
						}
						panel_3.setVisible(true);
						break;
					case 3:
						textField_10.setText(x.getSender());
						textField_11.setText(x.getSubject());
						textField_12.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_3.setSelected(true);
						}
						panel_4.setVisible(true);
						break;
					case 4:
						textField_13.setText(x.getSender());
						textField_14.setText(x.getSubject());
						textField_15.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_4.setSelected(true);
						}
						panel_5.setVisible(true);
						break;
					case 5:
						textField_16.setText(x.getSender());
						textField_17.setText(x.getSubject());
						textField_18.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_5.setSelected(true);
						}
						panel_6.setVisible(true);
						break;
					case 6:
						textField_19.setText(x.getSender());
						textField_20.setText(x.getSubject());
						textField_21.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_6.setSelected(true);
						}
						panel_7.setVisible(true);
						break;
					case 7:
						textField_22.setText(x.getSender());
						textField_23.setText(x.getSubject());
						textField_24.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_7.setSelected(true);
						}
						panel_8.setVisible(true);
						break;
					case 8:
						textField_25.setText(x.getSender());
						textField_26.setText(x.getSubject());
						textField_27.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_8.setSelected(true);
						}
						panel_9.setVisible(true);
						break;
					case 9:
						textField_28.setText(x.getSender());
						textField_29.setText(x.getSubject());
						textField_30.setText(x.getDate());
						if (x.getStarred().equals("True")) {
							checkBox_9.setSelected(true);
						}
						panel_10.setVisible(true);
						break;
					}
				}
			}
		});
		arrBtn[10].setVisible(false);
		contentPane.add(arrBtn[10]);
		
		function();

		buttonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inbox == 1) {
				btnNewButton_4.doClick();
				} else if (sent == 1) {
					btnNewButton_5.doClick();
				} else if (trash == 1) {
					btnNewButton_7.doClick();
				} else if (draft == 1) {
					btnNewButton_6.doClick();
				} else if (stare == 1) {
					btnNewButton_8.doClick();
				} else if (creat == 1) {
					currFolder = arrBtn[0].getText();
					panelE.setVisible(false);
					for (int y = 0; y < arrBtn.length; y++) {
						if (currFolder.equals(arrBtn[y].getText())) {
							arrBtn[y].doClick();
							break;
						}
					}
				}
				TestNew.frame.function();
				TestNew.frame.function2();
				}
		});
		
	}
	
	private void function() {
			 names = SignIn.account.ckeck(); 
			 for (int y = 0; y < names.size(); y++) {
				 nameOfCreate = (String) names.get(y);
				 arrBtn[y].setText(nameOfCreate);
				 arrBtn[y].setVisible(true);
			 }
		}
	
	private void function2() {
		names = SignIn.account.ckeck();
		 for (int y = 0; y < names.size(); y++) {
			 nameOfCreate = (String) names.get(y);
			int f = getPopupMenuItem(m2,nameOfCreate);
			if (f == -1) {
			 m2.add(item2 = new JMenuItem(nameOfCreate));
		     item2.setHorizontalTextPosition(JMenuItem.RIGHT);
		     item2.addActionListener(menuListener2);
			}
		 }
	}
	
 	class CheckboxAction extends AbstractAction {
	    Mail current;
	    Folder x;
	    public CheckboxAction(String text, Mail curr, Folder f) {
	        super(text);
	        current = curr;
	        x = f;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JCheckBox cbLog = (JCheckBox) e.getSource();
	        if (cbLog.isSelected()) {
				 Action action = new Action();
				action.star(current.getName(), x);
			 } else {
				 Action action = new Action();
				 action.unstar(current.getName());
			 }
	    }
	}
	
	public static String readFileAsString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
	
	private Icon resizeIcon(Icon icon, int width, int height) {
		// TODO Auto-generated method stub
		Image img = ((ImageIcon) icon).getImage();  
	    Image resizedImage = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	
	private int maxPage (int noMails) {
		int m;
		if(noMails % 10 == 0) {
			m = noMails / 10;
		} else {
			m = noMails / 10 + 1;
		}
		return m;
	}
	
	/**
	 * Returns the index of an item in a popup menu.
	 * 
	 * @param menu  the menu.
	 * @param text  the label.
	 * 
	 * @return The item index.
	 */
	private int getPopupMenuItem(JPopupMenu menu, String text) {
	    int index = -1;
	    for (int i = 0; (index == -1) && (i < menu.getComponentCount()); i++) {
	        Component comp = menu.getComponent(i);
	        if (comp instanceof JMenuItem) {
	            JMenuItem item = (JMenuItem) comp;
	            if (text.equals(item.getText())) {
	                index = i;
	            }
	        }
	   }
	   return index;
	}
}
