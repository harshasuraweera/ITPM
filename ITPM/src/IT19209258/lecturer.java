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
import it19208718.HomeWindow;

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
				btnNewButton.setBounds(10, 10, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				JButton btnManageLecturerDetails = new JButton(" Manage Lecturer Details");
				btnManageLecturerDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Lmanage lmanage = new Lmanage();
						dispose();
						lmanage.setVisible(true);
						
							
						
						
					}
				});
				btnManageLecturerDetails.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnManageLecturerDetails.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lecturer.png")));
				btnManageLecturerDetails.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnManageLecturerDetails.setBounds(936, 10, 311, 50);
				btnManageLecturerDetails.setFocusable(false);
				panel.add(btnManageLecturerDetails);
				
				JTextPane txtpnLectureName = new JTextPane();
				txtpnLectureName.setBackground(new Color(153, 204, 255));
				txtpnLectureName.setText(" Lecture Name");
				txtpnLectureName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureName.setBounds(75, 262, 171, 35);
				contentPane.add(txtpnLectureName);
				
				JTextPane txtpnLectureId = new JTextPane();
				txtpnLectureId.setBackground(new Color(153, 204, 255));
				txtpnLectureId.setEditable(false);
				txtpnLectureId.setText(" Lecture ID");
				txtpnLectureId.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureId.setBounds(75, 182, 171, 35);
				contentPane.add(txtpnLectureId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setBackground(new Color(153, 204, 255));
				txtpnFaculty.setEditable(false);
				txtpnFaculty.setText("Faculty");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnFaculty.setBounds(75, 349, 171, 35);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setBackground(new Color(153, 204, 255));
				txtpnDepartment.setEditable(false);
				txtpnDepartment.setText("Department");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnDepartment.setBounds(75, 430, 171, 35);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnAvailableHours = new JTextPane();
				txtpnAvailableHours.setBackground(new Color(153, 204, 255));
				txtpnAvailableHours.setEditable(false);
				txtpnAvailableHours.setText("Available Hours");
				txtpnAvailableHours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnAvailableHours.setBounds(75, 514, 171, 35);
				contentPane.add(txtpnAvailableHours);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setBackground(new Color(153, 204, 255));
				txtpnCenter.setEditable(false);
				txtpnCenter.setText("Center");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnCenter.setBounds(744, 182, 171, 35);
				contentPane.add(txtpnCenter);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setBackground(new Color(153, 204, 255));
				txtpnBuilding.setEditable(false);
				txtpnBuilding.setText("Building");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnBuilding.setBounds(744, 262, 171, 35);
				contentPane.add(txtpnBuilding);
				
				JTextPane txtpnLevel = new JTextPane();
				txtpnLevel.setBackground(new Color(153, 204, 255));
				txtpnLevel.setEditable(false);
				txtpnLevel.setText("Level");
				txtpnLevel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLevel.setBounds(744, 349, 171, 35);
				contentPane.add(txtpnLevel);
				
				JTextPane txtpnRank = new JTextPane();
				txtpnRank.setBackground(new Color(153, 204, 255));
				txtpnRank.setEditable(false);
				txtpnRank.setText("Rank");
				txtpnRank.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnRank.setBounds(744, 430, 171, 35);
				contentPane.add(txtpnRank);
				
				rank = new JTextField();
				rank.setEditable(false);
				rank.setBounds(941, 430, 96, 35);
				contentPane.add(rank);
				rank.setColumns(10);
				
				lname = new JTextField();
				lname.setColumns(10);
				lname.setBounds(397, 262, 275, 35);
				contentPane.add(lname);
				
				lid = new JTextField();
				lid.setColumns(10);
				lid.setBounds(397, 182, 275, 35);
				contentPane.add(lid);
				
				String array1 [] = {"", "IT"};
				JComboBox faculty = new JComboBox(array1);
				faculty.setBounds(397, 349, 275, 35);
				contentPane.add(faculty);
				
				String array3 [] = {"", "IT", "DS", "SE"};
				JComboBox department = new JComboBox(array3);
				department.setBounds(397, 430, 275, 35);
				contentPane.add(department);
				
				String array4 [] = {"", "Malabe", "Kandy"};
				JComboBox center = new JComboBox(array4);
				center.setBounds(941, 182, 275, 35);
				contentPane.add(center);
				
				String array5 [] = {"", "Main Building", "New Building", "Enginering Building", "Busciness Building"};
				JComboBox building = new JComboBox(array5);
				building.setBounds(941, 262, 275, 35);
				contentPane.add(building);
				
				JSpinner monday = new JSpinner();
				monday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				monday.setBounds(410, 551, 35, 32);
				contentPane.add(monday);
				
				String array [] = {"1", "2", "3", "4", "5", " 6"};
				JComboBox level = new JComboBox(array);
				level.setBounds(941, 349, 275, 35);
				contentPane.add(level);
				
				JTextPane txtpnAddLecturer = new JTextPane();
				txtpnAddLecturer.setText("Add New Lecturer");
				txtpnAddLecturer.setFont(new Font("Kristen ITC", txtpnAddLecturer.getFont().getStyle() | Font.BOLD, txtpnAddLecturer.getFont().getSize() + 30));
				txtpnAddLecturer.setEditable(false);
				txtpnAddLecturer.setBackground(new Color(153, 204, 255));
				txtpnAddLecturer.setBounds(459, 91, 432, 90);
				contentPane.add(txtpnAddLecturer);
				
				JTextPane txtpnMonday = new JTextPane();
				txtpnMonday.setText("Monday");
				txtpnMonday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnMonday.setEditable(false);
				txtpnMonday.setBackground(new Color(153, 204, 255));
				txtpnMonday.setBounds(400, 514, 71, 22);
				contentPane.add(txtpnMonday);
				
				JTextPane txtpnTuesday = new JTextPane();
				txtpnTuesday.setText("Tuesday");
				txtpnTuesday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnTuesday.setEditable(false);
				txtpnTuesday.setBackground(new Color(153, 204, 255));
				txtpnTuesday.setBounds(476, 514, 71, 22);
				contentPane.add(txtpnTuesday);
				
				JSpinner tuesday = new JSpinner();
				tuesday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				tuesday.setBounds(486, 551, 35, 32);
				contentPane.add(tuesday);
				
				JTextPane txtpnWednesday = new JTextPane();
				txtpnWednesday.setText("Wednesday");
				txtpnWednesday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnWednesday.setEditable(false);
				txtpnWednesday.setBackground(new Color(153, 204, 255));
				txtpnWednesday.setBounds(548, 514, 77, 22);
				contentPane.add(txtpnWednesday);
				
				JSpinner wednesday = new JSpinner();
				wednesday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				wednesday.setBounds(548, 551, 35, 32);
				contentPane.add(wednesday);
				
				JTextPane txtpnThuresday = new JTextPane();
				txtpnThuresday.setText("Thursday");
				txtpnThuresday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnThuresday.setEditable(false);
				txtpnThuresday.setBackground(new Color(153, 204, 255));
				txtpnThuresday.setBounds(623, 514, 71, 22);
				contentPane.add(txtpnThuresday);
				
				JSpinner thursday = new JSpinner();
				thursday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				thursday.setBounds(633, 551, 35, 32);
				contentPane.add(thursday);
				
				JTextPane txtpnFriday = new JTextPane();
				txtpnFriday.setText("Friday");
				txtpnFriday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnFriday.setEditable(false);
				txtpnFriday.setBackground(new Color(153, 204, 255));
				txtpnFriday.setBounds(704, 514, 47, 22);
				contentPane.add(txtpnFriday);
				
				JSpinner friday = new JSpinner();
				friday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				friday.setBounds(706, 551, 35, 32);
				contentPane.add(friday);
				
				JTextPane txtpnSatureday = new JTextPane();
				txtpnSatureday.setText("Satureday");
				txtpnSatureday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnSatureday.setEditable(false);
				txtpnSatureday.setBackground(new Color(153, 204, 255));
				txtpnSatureday.setBounds(767, 514, 71, 22);
				contentPane.add(txtpnSatureday);
				
				JSpinner satureday = new JSpinner();
				satureday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				satureday.setBounds(777, 551, 35, 32);
				contentPane.add(satureday);
				
				JTextPane txtpnSunday = new JTextPane();
				txtpnSunday.setText("Sunday");
				txtpnSunday.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
				txtpnSunday.setEditable(false);
				txtpnSunday.setBackground(new Color(153, 204, 255));
				txtpnSunday.setBounds(843, 514, 58, 22);
				contentPane.add(txtpnSunday);
				
				JSpinner sunday = new JSpinner();
				sunday.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				sunday.setBounds(843, 551, 35, 32);
				contentPane.add(sunday);
				
				JButton btnDone = new JButton("Done");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(977, 613, 250, 50);
				contentPane.add(btnDone);
				
				JButton btnGenerate = new JButton("   generate");
				btnGenerate.setBackground(Color.RED);
				btnGenerate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String generatedRank = level.getSelectedItem().toString() + "." + lid.getText().toString();
						rank.setText(generatedRank);
						
					}
				});
				btnGenerate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnGenerate.setFocusable(false);
				btnGenerate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnGenerate.setBounds(1069, 430, 147, 35);
				contentPane.add(btnGenerate);
				
				
			
				btnDone.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(lid.getText().equals("")||lname.getText().equals("")||faculty.getSelectedItem().equals("")||department.getSelectedItem().equals("")) {
						
							JOptionPane.showMessageDialog(null, "Please Fill the Informations");
						}
						
						else {
					
							boolean isSuccess = newlecturer(
								lid.getText().toString(), 
								lname.getText().toString(),
								faculty.getSelectedItem().toString(),
								department.getSelectedItem().toString(),
								center.getSelectedItem().toString(),
								building.getSelectedItem().toString(),
								level.getSelectedItem().toString(),
								rank.getText().toString(),
								Integer.parseInt(monday.getValue().toString()),
								Integer.parseInt(tuesday.getValue().toString()),
								Integer.parseInt(wednesday.getValue().toString()),
								Integer.parseInt(thursday.getValue().toString()),
								Integer.parseInt(friday.getValue().toString()),
								Integer.parseInt(satureday.getValue().toString()),
								Integer.parseInt(sunday.getValue().toString()));
						
							if(isSuccess) {
							
							JOptionPane.showMessageDialog(null, "added successfully");
							}else {
						
							JOptionPane.showMessageDialog(null, "error");
							}
						}
						
					}
				});
				
				//end navignation button 01
	}
	
	public boolean newlecturer (String lid, String lname, String faculty, String department, String center, String building, String level, String rank, int monday, int tuesday, int wednesday, int thursday, int friday, int satureday, int sunday) {
		
		boolean isSuccess = false;
		java.sql.Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "INSERT INTO Lecturers (lid, lname, faculty, department, center, building, level, rank, monday, tuesday, wednesday, thursday, friday, satureday, sunday)"
					+ "VALUES ('"+lid+"', '"+lname+"', '"+faculty+"', '"+department+"', '"+center+"', '"+building+"', '"+level+"', '"+rank+"', '"+monday+"', '"+tuesday+"', '"+wednesday+"', '"+thursday+"', '"+friday+"', '"+satureday+"', '"+sunday+"')";
			
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
