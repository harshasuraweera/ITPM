package it19208718;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import database.DBConnect;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;

import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

@SuppressWarnings({ "unused", "serial" })
public class HomeWindow extends JFrame {

	private JPanel contentPane;
	java.sql.Connection conn = DBConnect.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow frame = new HomeWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public HomeWindow() throws IOException {
		
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
		panel.setBounds(0, 0, 1266, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//end default
		
		
		
		//navigation buttons
		JButton btnNewButton = new JButton(" Add New");
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
		
		//end navignation button 01
		
		
		
		JButton btnManageExisting = new JButton(" Manage Existing");
		btnManageExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ManageExisiting manageExisiting = new ManageExisiting();
					dispose();
					manageExisiting.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnManageExisting.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	//	btnManageExisting.setIcon(new ImageIcon(ImageIO.read(new File("images/manage.png")).getScaledInstance(40, 40,Image.SCALE_SMOOTH)));
		btnManageExisting.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
		btnManageExisting.setBounds(303, 10, 250, 50);
		btnManageExisting.setFocusable(false);
		panel.add(btnManageExisting);
		
		
		
		
		
		
		
		JButton btnGenerateTimetable = new JButton(" Generate Timetable");
		btnGenerateTimetable.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		//btnGenerateTimetable.setIcon(new ImageIcon(ImageIO.read(new File("images/generate.png")).getScaledInstance(40, 40,Image.SCALE_SMOOTH)));
		btnGenerateTimetable.setIcon(new ImageIcon(getClass().getClassLoader().getResource("generate.png")));
		
		btnGenerateTimetable.setFocusable(false);
		btnGenerateTimetable.setBounds(937, 10, 297, 50);
		panel.add(btnGenerateTimetable);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 114, 292, 530);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		//number of lecturers
		JLabel registeredLecturesText = new JLabel(" Registered Lectures");
		registeredLecturesText.setHorizontalAlignment(SwingConstants.CENTER);
		registeredLecturesText.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		registeredLecturesText.setBounds(10, 22, 272, 51);
		//registeredLecturesText.setIcon(new ImageIcon(ImageIO.read(new File("images/lecturer.png")).getScaledInstance(50, 50,Image.SCALE_SMOOTH)));
		registeredLecturesText.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lecturer.png")));
		panel_1.add(registeredLecturesText);
		
		
		//number of students
		JLabel studentGroupsText_1 = new JLabel(" Student Groups");
		studentGroupsText_1.setHorizontalAlignment(SwingConstants.CENTER);
		studentGroupsText_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		studentGroupsText_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("student.png")));
		studentGroupsText_1.setBounds(10, 149, 272, 51);
		panel_1.add(studentGroupsText_1);
		
		JLabel registeredLecturesText_1_1 = new JLabel(" Registered Subjects");
		registeredLecturesText_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		registeredLecturesText_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		registeredLecturesText_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("subject1.png")));
		registeredLecturesText_1_1.setBounds(10, 285, 272, 51);
		panel_1.add(registeredLecturesText_1_1);
		
		JLabel registeredLecturesText_1_1_1 = new JLabel(" Registered Rooms");
		registeredLecturesText_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		registeredLecturesText_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		registeredLecturesText_1_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lectureRoom.png")));
		registeredLecturesText_1_1_1.setBounds(10, 411, 272, 51);
		panel_1.add(registeredLecturesText_1_1_1);
		
		JLabel totalLecturers = new JLabel();
		totalLecturers.setHorizontalAlignment(SwingConstants.CENTER);
		totalLecturers.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		totalLecturers.setBounds(115, 83, 45, 32);
		panel_1.add(totalLecturers);
		
		JLabel totalStudentGroups = new JLabel();
		totalStudentGroups.setHorizontalAlignment(SwingConstants.CENTER);
		totalStudentGroups.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		totalStudentGroups.setBounds(115, 210, 45, 32);
		panel_1.add(totalStudentGroups);
		
		
		JLabel totalSubjects = new JLabel();
		totalSubjects.setHorizontalAlignment(SwingConstants.CENTER);
		totalSubjects.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		totalSubjects.setBounds(115, 346, 45, 32);
		panel_1.add(totalSubjects);
		
		JLabel totalRooms = new JLabel();
		totalRooms.setHorizontalAlignment(SwingConstants.CENTER);
		totalRooms.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		totalRooms.setBounds(115, 472, 45, 32);
		panel_1.add(totalRooms);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 272, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 267, 272, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 397, 272, 2);
		panel_1.add(separator_2);
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(373, 114, 849, 530);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(60);
		progressBar.setBounds(218, 55, 437, 34);
		panel_2.add(progressBar);
		
		JLabel registeredLecturesText_1_1_1_1 = new JLabel(" Lecture Rooms");
		registeredLecturesText_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		registeredLecturesText_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		registeredLecturesText_1_1_1_1.setBounds(29, 30, 179, 51);
		panel_2.add(registeredLecturesText_1_1_1_1);
		
		JLabel registeredLecturesText_1_1_1_1_1 = new JLabel("Laboratories");
		registeredLecturesText_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		registeredLecturesText_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		registeredLecturesText_1_1_1_1_1.setBounds(697, 30, 121, 51);
		panel_2.add(registeredLecturesText_1_1_1_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(29, 139, 789, 2);
		panel_2.add(separator_3);
		
		JLabel lectureRoomPercentage = new JLabel();
		lectureRoomPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lectureRoomPercentage.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lectureRoomPercentage.setBounds(50, 67, 100, 32);
		panel_2.add(lectureRoomPercentage);
		
		JLabel labRoomPercentage = new JLabel();
		labRoomPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		labRoomPercentage.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		labRoomPercentage.setBounds(707, 67, 100, 32);
		panel_2.add(labRoomPercentage);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setBounds(29, 275, 789, 2);
		panel_2.add(separator_3_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(421, 139, 2, 364);
		panel_2.add(separator_4);
		
		JLabel numberOfProfessors = new JLabel("Professors - ");
		numberOfProfessors.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfProfessors.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfProfessors.setBounds(39, 151, 311, 51);
		panel_2.add(numberOfProfessors);
		
		
		JLabel numberOfAssistantProfessors = new JLabel("Assistant Professors - ");
		numberOfAssistantProfessors.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfAssistantProfessors.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfAssistantProfessors.setBounds(39, 211, 311, 51);
		panel_2.add(numberOfAssistantProfessors);
		
		JLabel numberOfSeniorHgLecturers = new JLabel("Senior Lecturers (HG) - ");
		numberOfSeniorHgLecturers.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfSeniorHgLecturers.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfSeniorHgLecturers.setBounds(39, 272, 311, 51);
		panel_2.add(numberOfSeniorHgLecturers);
		
		JLabel numberOfSeniorLecturers = new JLabel("Senior Lecturers - ");
		numberOfSeniorLecturers.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfSeniorLecturers.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfSeniorLecturers.setBounds(39, 333, 311, 51);
		panel_2.add(numberOfSeniorLecturers);
		
		JLabel numberOfLecturers = new JLabel("Lecturers - ");
		numberOfLecturers.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfLecturers.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfLecturers.setBounds(39, 394, 311, 51);
		panel_2.add(numberOfLecturers);
		
		JLabel numberOfAssistantLecturers = new JLabel("Assistant Lecturers - ");
		numberOfAssistantLecturers.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfAssistantLecturers.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfAssistantLecturers.setBounds(39, 454, 311, 51);
		panel_2.add(numberOfAssistantLecturers);
		
		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setBounds(421, 333, 395, 2);
		panel_2.add(separator_3_2);
		
		JLabel numberOfConsecutiveSessions = new JLabel("Consecutive Sessions- ");
		numberOfConsecutiveSessions.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfConsecutiveSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfConsecutiveSessions.setBounds(449, 151, 311, 51);
		panel_2.add(numberOfConsecutiveSessions);
		
		JLabel numberOfParallelSessions = new JLabel("Parallel Sessions - ");
		numberOfParallelSessions.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfParallelSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfParallelSessions.setBounds(449, 211, 311, 51);
		panel_2.add(numberOfParallelSessions);
		
		JLabel numberOfNonOverlappingSessions = new JLabel("Non Overlaping Sessions - ");
		numberOfNonOverlappingSessions.setHorizontalAlignment(SwingConstants.LEFT);
		numberOfNonOverlappingSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOfNonOverlappingSessions.setBounds(449, 272, 311, 51);
		panel_2.add(numberOfNonOverlappingSessions);
		
		JLabel registeredLecturesText_1_1_1_1_2_4 = new JLabel("Subjects");
		registeredLecturesText_1_1_1_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		registeredLecturesText_1_1_1_1_2_4.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		registeredLecturesText_1_1_1_1_2_4.setBounds(592, 343, 83, 51);
		panel_2.add(registeredLecturesText_1_1_1_1_2_4);
		
		JLabel numberOf1stYearSubjects = new JLabel("1st Year - ");
		numberOf1stYearSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		numberOf1stYearSubjects.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOf1stYearSubjects.setBounds(459, 392, 169, 51);
		panel_2.add(numberOf1stYearSubjects);
		
		JLabel numberOf2ndYearSubjects = new JLabel("2nd Year - ");
		numberOf2ndYearSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		numberOf2ndYearSubjects.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOf2ndYearSubjects.setBounds(459, 452, 169, 51);
		panel_2.add(numberOf2ndYearSubjects);
		
		JLabel numberOf3rdYearSubjects = new JLabel("3rd Year - ");
		numberOf3rdYearSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		numberOf3rdYearSubjects.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOf3rdYearSubjects.setBounds(638, 392, 169, 51);
		panel_2.add(numberOf3rdYearSubjects);
		
		JLabel numberOf4thYearSubjects = new JLabel("4th Year - ");
		numberOf4thYearSubjects.setHorizontalAlignment(SwingConstants.LEFT);
		numberOf4thYearSubjects.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		numberOf4thYearSubjects.setBounds(638, 450, 169, 51);
		panel_2.add(numberOf4thYearSubjects);
		
		
		
		//set values left side bar
		totalRooms.setText(String.valueOf(getLectureRoomCount(conn) + getLaboratoryRoomCount(conn)));
		totalStudentGroups.setText(String.valueOf(getStudentGroupsCount(conn)));
		totalSubjects.setText(String.valueOf(getSubjectsCount(conn)));
		
		//set values prograss bar
		lectureRoomPercentage.setText(String.valueOf(generateLectureRoomPrecentage(conn)) + "%");
		labRoomPercentage.setText(String.valueOf(generateLaboratoryRoomPrecentage(conn)) + "%");
		progressBar.setValue((int)generateLectureRoomPrecentage(conn));
		
	}
	
	
	
	//get lecture room count
	private int getLectureRoomCount(Connection conn) {
		
		int count = 0;
		
		try {
			
			String sql = "SELECT COUNT(id) FROM Locations WHERE roomType = 'Lecture Hall' ";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // SELECT count(*) always returns exactly 1 row
			count = rs.getInt(1); // Get value of first column
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return count;
	}
	

	//get Laboratory room count
	private int getLaboratoryRoomCount(Connection conn) {
		
		int count = 0;
		
		try {
			
			String sql = "SELECT COUNT(id) FROM Locations WHERE roomType = 'Laboratory' ";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // SELECT count(*) always returns exactly 1 row
			count = rs.getInt(1); // Get value of first column
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return count;
	}
	
	
	//generate lecture room precentage
	private double generateLectureRoomPrecentage(Connection conn) {
		
		int lecRooms = getLectureRoomCount(conn);
		int labRooms = getLaboratoryRoomCount(conn);
		int totRooms = lecRooms + labRooms;
		
		//lec room precentage
		double lecRoomPrecentage = (lecRooms/(double)totRooms) * 100;
		
		return round(lecRoomPrecentage, 2);
		
	}
	
	//generate lab room precentage
	private double generateLaboratoryRoomPrecentage(Connection conn) {
			
			
		double labRoomPrecentage = 100 - generateLectureRoomPrecentage(conn);
			
		return round(labRoomPrecentage, 2); 
			
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	//get student groups count
	public int getStudentGroupsCount(Connection conn) {
		
		int count = 0;
		
		try {
			
			String sql = "SELECT COUNT(id) FROM StudentGroups";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // SELECT count(*) always returns exactly 1 row
			count = rs.getInt(1); // Get value of first column
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return count;
	}
	
	
	//get subjects count
	public int getSubjectsCount(Connection conn) {
		
		int count = 0;
		
		try {
			
			String sql = "SELECT COUNT(id) FROM Subjects";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // SELECT count(*) always returns exactly 1 row
			count = rs.getInt(1); // Get value of first column
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return count;
	}	
	

	
	//get lecturers count
	public int getLecturersCount(Connection conn) {
		
		int count = 0;
		
		try {
			
			String sql = "SELECT COUNT(id) FROM Lecturers";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // SELECT count(*) always returns exactly 1 row
			count = rs.getInt(1); // Get value of first column
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return count;
	}	
	
	
}
