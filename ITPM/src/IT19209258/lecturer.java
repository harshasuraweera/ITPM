package IT19209258;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnect;
import it19208718.AddSomething;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class lecturer extends JFrame {

	private JPanel contentPane;
	private JTextField rank;
	private JTextField lname;
	private JTextField lid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lecturer frame = new lecturer();
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
	public lecturer() {
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
				panel.setBounds(0, 0, 1274, 70);
				contentPane.add(panel);
				panel.setLayout(null);
				
				//end default
				
				//navigation buttons
				JButton btnNewButton = new JButton("Home");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						try {
							AddSomething addSomething = new AddSomething();
							dispose();
							addSomething.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							
						
						
					}
				});
				btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addNew2.png")));
				btnNewButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton.setBounds(33, 10, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				JButton btnManageLecturerDetails = new JButton(" Manage Lecturer Details");
				btnManageLecturerDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Lmanage Lmanage = new Lmanage();
						dispose();
						Lmanage.setVisible(true);
						
							
						
						
					}
				});
				btnManageLecturerDetails.setBackground(Color.WHITE);
				btnManageLecturerDetails.setForeground(Color.BLACK);
				btnManageLecturerDetails.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnManageLecturerDetails.setFocusable(false);
				btnManageLecturerDetails.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnManageLecturerDetails.setBounds(1000, 10, 250, 50);
				panel.add(btnManageLecturerDetails);
				
				JTextPane txtpnLectureName = new JTextPane();
				txtpnLectureName.setText(" Lecture Name");
				txtpnLectureName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureName.setBounds(75, 240, 171, 35);
				contentPane.add(txtpnLectureName);
				
				JTextPane txtpnLectureId = new JTextPane();
				txtpnLectureId.setEditable(false);
				txtpnLectureId.setText(" Lecture ID");
				txtpnLectureId.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureId.setBounds(75, 149, 171, 35);
				contentPane.add(txtpnLectureId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setText("Faculty");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnFaculty.setBounds(75, 323, 171, 35);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setText("Department");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnDepartment.setBounds(75, 405, 171, 35);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnAvailableDays = new JTextPane();
				txtpnAvailableDays.setText("Available Days");
				txtpnAvailableDays.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnAvailableDays.setBounds(75, 488, 171, 35);
				contentPane.add(txtpnAvailableDays);
				
				JTextPane txtpnAvailableHours = new JTextPane();
				txtpnAvailableHours.setText("Available Hours");
				txtpnAvailableHours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnAvailableHours.setBounds(75, 593, 171, 35);
				contentPane.add(txtpnAvailableHours);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setText("Center");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnCenter.setBounds(740, 149, 171, 35);
				contentPane.add(txtpnCenter);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setText("Building");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnBuilding.setBounds(740, 240, 171, 35);
				contentPane.add(txtpnBuilding);
				
				JTextPane txtpnLevel = new JTextPane();
				txtpnLevel.setText("Level");
				txtpnLevel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLevel.setBounds(740, 323, 171, 35);
				contentPane.add(txtpnLevel);
				
				JTextPane txtpnRank = new JTextPane();
				txtpnRank.setText("Rank");
				txtpnRank.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnRank.setBounds(740, 405, 171, 35);
				contentPane.add(txtpnRank);
				
				rank = new JTextField();
				rank.setEditable(false);
				rank.setBounds(977, 405, 275, 35);
				contentPane.add(rank);
				rank.setColumns(10);
				
				lname = new JTextField();
				lname.setColumns(10);
				lname.setBounds(397, 240, 275, 35);
				contentPane.add(lname);
				
				lid = new JTextField();
				lid.setColumns(10);
				lid.setBounds(397, 149, 275, 35);
				contentPane.add(lid);
				
				String array1 [] = {"A", "B", "C", "D"};
				JComboBox faculty = new JComboBox(array1);
				faculty.setBounds(397, 323, 275, 35);
				contentPane.add(faculty);
				
				String array3 [] = {"AA", "BB", "CC", "DD"};
				JComboBox department = new JComboBox(array3);
				department.setBounds(397, 405, 275, 35);
				contentPane.add(department);
				
				String array4 [] = {"E", "F", "G", "H"};
				JComboBox center = new JComboBox(array4);
				center.setBounds(977, 149, 275, 35);
				contentPane.add(center);
				
				String array5 [] = {"W", "X", "Y", "Z"};
				JComboBox building = new JComboBox(array5);
				building.setBounds(977, 240, 275, 35);
				contentPane.add(building);
				
				JSpinner ahours = new JSpinner();
				ahours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				ahours.setBounds(397, 593, 196, 46);
				contentPane.add(ahours);
				
				JSpinner level = new JSpinner();
				level.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				level.setBounds(977, 323, 196, 46);
				contentPane.add(level);
				
				JSpinner adays = new JSpinner();
				adays.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				adays.setBounds(397, 488, 196, 46);
				contentPane.add(adays);
				
				JButton btnDone = new JButton("Done");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(977, 613, 250, 50);
				contentPane.add(btnDone);
				
				JButton btnGenerate = new JButton("generate");
				btnGenerate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String generatedRank = level.getValue().toString() + "." + lid.getText().toString();
						rank.setText(generatedRank);
						
					}
				});
				btnGenerate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnGenerate.setFocusable(false);
				btnGenerate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnGenerate.setBounds(847, 488, 250, 50);
				contentPane.add(btnGenerate);
			
				btnDone.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						boolean isSuccess = newlecturer(
								lid.getText().toString(), 
								lname.getText().toString(),
								faculty.getSelectedItem().toString(),
								department.getSelectedItem().toString(),
								Integer.parseInt(adays.getValue().toString()),
								Integer.parseInt(ahours.getValue().toString()),
								center.getSelectedItem().toString(),
								building.getSelectedItem().toString(),
								Integer.parseInt(level.getValue().toString()),
								rank.getText().toString());
						
							if(isSuccess) {
							
							JOptionPane.showMessageDialog(null, "added successfully");
							}else {
						
							JOptionPane.showMessageDialog(null, "error");
						}
						
					}
				});
				
				//end navignation button 01
	}
	
	public boolean newlecturer (String lid, String lname, String faculty, String department,int adays, int ahours, String center, String building, int level, String rank) {
		
		boolean isSuccess = false;
		java.sql.Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "INSERT INTO Lecturers (lid, lname, faculty, department, adays, ahours, center, building, level, rank)"
					+ "VALUES ('"+lid+"', '"+lname+"', '"+faculty+"', '"+department+"', '"+adays+"', '"+ahours+"', '"+center+"', '"+building+"', '"+level+"', '"+rank+"')";
			
			Statement st1 = conn.createStatement();
			int rs = st1.executeUpdate(sql);
			
			st1.close();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
		}
		
		return isSuccess;
	}
}
