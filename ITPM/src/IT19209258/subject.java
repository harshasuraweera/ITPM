package IT19209258;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;


import database.DBConnect;
import it19208718.AddSomething;
import it19208718.HomeWindow;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class subject extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField scode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subject frame = new subject();
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
	public subject() {
		
		//do these for each and every JFrame
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				setSize(1280, 720);
				setResizable(false);
				setLocationRelativeTo(null);
				setTitle("Forza Timetable Management System");
				
				//set Icon to the window
				ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
				setIconImage(img.getImage());
				
				//inner contentPane
				contentPane = new JPanel();
				contentPane.setBackground(new Color(153, 204, 255));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(153, 255, 153));
				panel.setBounds(10, 0, 1274, 70);
				contentPane.add(panel);
				panel.setLayout(null);
				
				//end default
				
				//navigation buttons
				JButton btnNewButton = new JButton("  Home");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						try {
							HomeWindow homewindow = new HomeWindow();
							dispose();
							homewindow.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							
						
						
					}
				});
				btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
				btnNewButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton.setBounds(33, 10, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				JButton btnManageSubjectDetails = new JButton(" Manage Subject Details");
				btnManageSubjectDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Smanage Smanage = new Smanage();
						dispose();
						Smanage.setVisible(true);
						
							
						
						
					}
				});
				btnManageSubjectDetails.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnManageSubjectDetails.setIcon(new ImageIcon(getClass().getClassLoader().getResource("subject1.png")));
				btnManageSubjectDetails.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnManageSubjectDetails.setBounds(952, 10, 287, 50);
				btnManageSubjectDetails.setFocusable(false);
				panel.add(btnManageSubjectDetails);
				
				JTextPane txtpnOfferedYear = new JTextPane();
				txtpnOfferedYear.setEditable(false);
				txtpnOfferedYear.setBackground(new Color(153, 204, 255));
				txtpnOfferedYear.setText("Offered Year");
				txtpnOfferedYear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnOfferedYear.setBounds(100, 193, 168, 31);
				contentPane.add(txtpnOfferedYear);
				
				JTextPane txtpnOfferedSemester = new JTextPane();
				txtpnOfferedSemester.setEditable(false);
				txtpnOfferedSemester.setBackground(new Color(153, 204, 255));
				txtpnOfferedSemester.setText("Offered Semester");
				txtpnOfferedSemester.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnOfferedSemester.setBounds(100, 272, 168, 31);
				contentPane.add(txtpnOfferedSemester);
				
				JTextPane txtpnSubjectName = new JTextPane();
				txtpnSubjectName.setBackground(new Color(153, 204, 255));
				txtpnSubjectName.setEditable(false);
				txtpnSubjectName.setText("Subject Name");
				txtpnSubjectName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnSubjectName.setBounds(100, 354, 168, 31);
				contentPane.add(txtpnSubjectName);
				
				JTextPane txtpnSubjectCode = new JTextPane();
				txtpnSubjectCode.setBackground(new Color(153, 204, 255));
				txtpnSubjectCode.setEditable(false);
				txtpnSubjectCode.setText("Subject Code");
				txtpnSubjectCode.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnSubjectCode.setBounds(100, 433, 168, 31);
				contentPane.add(txtpnSubjectCode);
				
				sname = new JTextField();
				sname.setBounds(389, 354, 155, 31);
				contentPane.add(sname);
				sname.setColumns(10);
				
				scode = new JTextField();
				scode.setColumns(10);
				scode.setBounds(389, 433, 155, 31);
				contentPane.add(scode);
				
				JTextPane txtpnNumberOfLecture = new JTextPane();
				txtpnNumberOfLecture.setBackground(new Color(153, 204, 255));
				txtpnNumberOfLecture.setEditable(false);
				txtpnNumberOfLecture.setText("Number of Lecture Hours");
				txtpnNumberOfLecture.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnNumberOfLecture.setBounds(656, 194, 256, 31);
				contentPane.add(txtpnNumberOfLecture);
				
				JTextPane txtpnNumberOfLab = new JTextPane();
				txtpnNumberOfLab.setBackground(new Color(153, 204, 255));
				txtpnNumberOfLab.setEditable(false);
				txtpnNumberOfLab.setText("Number of Lab Hours");
				txtpnNumberOfLab.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnNumberOfLab.setBounds(656, 273, 256, 31);
				contentPane.add(txtpnNumberOfLab);
				
				JTextPane txtpnNumberOfTutorial = new JTextPane();
				txtpnNumberOfTutorial.setBackground(new Color(153, 204, 255));
				txtpnNumberOfTutorial.setEditable(false);
				txtpnNumberOfTutorial.setText("Number of Tutorial Hours");
				txtpnNumberOfTutorial.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnNumberOfTutorial.setBounds(656, 355, 256, 31);
				contentPane.add(txtpnNumberOfTutorial);
				
				JTextPane txtpnNumberOfEvaluation = new JTextPane();
				txtpnNumberOfEvaluation.setBackground(new Color(153, 204, 255));
				txtpnNumberOfEvaluation.setEditable(false);
				txtpnNumberOfEvaluation.setText("Number of Evaluation Hours");
				txtpnNumberOfEvaluation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnNumberOfEvaluation.setBounds(656, 434, 268, 31);
				contentPane.add(txtpnNumberOfEvaluation);
				
				JButton btnDone = new JButton("Done");	
				
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(904, 584, 250, 50);
				contentPane.add(btnDone);
				
				JSpinner offyear = new JSpinner();
				offyear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				offyear.setBounds(389, 193, 196, 46);
				contentPane.add(offyear);
				
				JSpinner offsem = new JSpinner();
				offsem.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				offsem.setBounds(389, 264, 196, 46);
				contentPane.add(offsem);
				
				JSpinner nlhours = new JSpinner();
				nlhours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nlhours.setBounds(1002, 194, 196, 46);
				contentPane.add(nlhours);
				
				JSpinner nlbhours = new JSpinner();
				nlbhours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nlbhours.setBounds(1002, 273, 196, 46);
				contentPane.add(nlbhours);
				
				JSpinner nthours = new JSpinner();
				nthours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nthours.setBounds(1002, 360, 196, 46);
				contentPane.add(nthours);
				
				JSpinner nehours = new JSpinner();
				nehours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nehours.setBounds(1002, 434, 196, 46);
				contentPane.add(nehours);
				
				JTextPane txtpnAddNewSubject = new JTextPane();
				txtpnAddNewSubject.setFont(new Font("Kristen ITC", txtpnAddNewSubject.getFont().getStyle() | Font.BOLD, txtpnAddNewSubject.getFont().getSize() + 30));
				txtpnAddNewSubject.setText("Add New Subject");
				txtpnAddNewSubject.setEditable(false);
				txtpnAddNewSubject.setBackground(new Color(153, 204, 255));
				txtpnAddNewSubject.setBounds(421, 93, 432, 90);
				contentPane.add(txtpnAddNewSubject);
				
				//end navignation button 01
				btnDone.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						if(offyear.getValue().equals("")||offsem.getValue().equals("")||sname.getText().equals("")||scode.getText().equals("")||nlhours.getValue().equals("")
								||nlbhours.getValue().equals("")||nthours.getValue().equals("")||nehours.getValue().equals("")) {
							
							JOptionPane.showMessageDialog(null,"Please fill the Informations");
							
						}
						else {
							boolean isSuccess = addsubject(
								Integer.parseInt(offyear.getValue().toString()),
								Integer.parseInt(offsem.getValue().toString()),
								sname.getText().toString(), 
								scode.getText().toString(),
								Integer.parseInt(nlhours.getValue().toString()),
								Integer.parseInt(nlbhours.getValue().toString()),
								Integer.parseInt(nthours.getValue().toString()),
								Integer.parseInt(nehours.getValue().toString()));
							
							if(isSuccess) {
								
								JOptionPane.showMessageDialog(null, "added successfully");
							}else {
							
								JOptionPane.showMessageDialog(null, "error");
							}
						}
					}
				});
	}
	
		public boolean addsubject (int offyear, int offsem, String sname, String scode, int nlhours, int nlbhours, int nthours, int nehours) {
			
			boolean isSuccess = false;
			java.sql.Connection conn = DBConnect.getConnection();
			
			try {
				
				String sql = "INSERT INTO Subjects (offyear, offsem, sname, scode, nlhours, nlbhours, nthours, nehours)"
						+ "VALUES ('"+offyear+"', '"+offsem+"', '"+sname+"', '"+scode+"', '"+nlhours+"', '"+nlbhours+"', '"+nthours+"', '"+nehours+"')";
				
				Statement st = conn.createStatement();
				int rs = st.executeUpdate(sql);
				
				st.close();
				isSuccess = true;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				isSuccess = false;
			}
			
			return isSuccess;
		}
}


//boolean isSuccess = false;
//java.sql.Connection conn = DBConnect.getConnection();

//try {
	
//	String sql = "INSERT INTO Subjects (offyear, offsem, sname, scode, nlhours, nlbhours, nthours, nehours)"
	//		+ "VALUES ('"+offyear+"', '"+offsem+"', '"+sname+"', '"+scode+"', '"+nlhours+"', '"+nlbhours+"', '"+nthours+"', '"+nehours+"')";
	
	//Statement st = conn.createStatement();
	//int rs = st.executeUpdate(sql);
	
	//st.close();
	//isSuccess = true;
	
//}catch(Exception e1) {
	//System.out.println(e1.getMessage());
	//isSuccess = false;
//}
