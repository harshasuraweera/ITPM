package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import IT19142692.AddSpecialRoom;
import database.DBConnect;

import javax.swing.JComboBox;

public class SutiableRoom extends JFrame {

	private JPanel contentPane;
	public String selectedType = "Lecturer";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SutiableRoom frame = new SutiableRoom();
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
	public SutiableRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Add Location");
		

		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(img.getImage());
		
		
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
		
		JButton btnBackToHome = new JButton(" Back To Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeWindow homeWindow = new HomeWindow();
					dispose();
					homeWindow.setVisible(true);
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnBackToHome.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
		btnBackToHome.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnBackToHome.setFocusable(false);
		btnBackToHome.setBounds(24, 10, 225, 50);
		panel.add(btnBackToHome);
		
		JButton btnManageLocation = new JButton("Assign Session Rooms");
		btnManageLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignSessionRoom AssignSessionRoom = new AssignSessionRoom();
				dispose();
				AssignSessionRoom.setVisible(true);
			}
		});
		btnManageLocation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
		btnManageLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageLocation.setFocusable(false);
		btnManageLocation.setBounds(940, 10, 302, 50);
		panel.add(btnManageLocation);
		
		JLabel addNewLocationLabel = new JLabel("Set Sutiable Rooms");
		addNewLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addNewLocationLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		addNewLocationLabel.setBounds(434, 103, 365, 44);
		contentPane.add(addNewLocationLabel);
		
		JButton forLecturer = new JButton("For Lecturers");
		forLecturer.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		forLecturer.setFocusable(false);
		forLecturer.setBounds(54, 177, 308, 50);
		contentPane.add(forLecturer);
		
		JButton forStdGroup = new JButton("For Student Group");
		
		forStdGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		forStdGroup.setFocusable(false);
		forStdGroup.setBounds(419, 177, 380, 50);
		contentPane.add(forStdGroup);
		
		JButton forSubject = new JButton("For Subject");
		forSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		forSubject.setFocusable(false);
		forSubject.setBounds(855, 177, 335, 50);
		contentPane.add(forSubject);
		
		JComboBox<Object> dropDown = new JComboBox<Object>(loadlecturerNames ());
		dropDown.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		dropDown.setBackground(Color.WHITE);
		dropDown.setBounds(285, 328, 818, 36);
		contentPane.add(dropDown);
		
		JLabel SelectTypeLabel = new JLabel("Select Lecturer");
		SelectTypeLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		SelectTypeLabel.setBounds(110, 328, 165, 46);
		contentPane.add(SelectTypeLabel);
		
		JLabel lblSelectRoom = new JLabel("Select Room");
		lblSelectRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectRoom.setBounds(110, 430, 165, 46);
		contentPane.add(lblSelectRoom);
		
		JComboBox<Object> allTheAvailableRoomList = new JComboBox<Object>(loadLocations());
		allTheAvailableRoomList.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		allTheAvailableRoomList.setBackground(Color.WHITE);
		allTheAvailableRoomList.setBounds(285, 430, 818, 36);
		contentPane.add(allTheAvailableRoomList);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnSave.setFocusable(false);
		btnSave.setBounds(419, 543, 380, 50);
		contentPane.add(btnSave);
		
		
		
		//button onclick
		
		forLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forLecturer.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				forStdGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				forSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				SelectTypeLabel.setText("Select Lecturer");
				dropDown.setModel(new DefaultComboBoxModel<Object>(loadlecturerNames()));
				selectedType = "Lecturer";
				
			}
		});
		
		
		forStdGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				forStdGroup.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				forSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				SelectTypeLabel.setText("Select Group");
				dropDown.setModel(new DefaultComboBoxModel<Object>(loadStudentGroups()));
				selectedType = "StdGroup";
			}
		});
		
		
		forSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				forStdGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				forSubject.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				SelectTypeLabel.setText("Select Subject");
				dropDown.setModel(new DefaultComboBoxModel<Object>(loadSubjects()));
				selectedType = "Subject";
			}
		});
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(selectedType.equals("Lecturer")) {
					try {
						boolean isSuccess = LecturerSutiableRoom(dropDown.getSelectedItem().toString(), allTheAvailableRoomList.getSelectedItem().toString() );
					
						if(isSuccess) {
							dropDown.setSelectedIndex(0);
							allTheAvailableRoomList.setSelectedIndex(0);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				if(selectedType.equals("StdGroup")) {
					try {
						boolean isSuccess = StudentGroupSutiableRoom(dropDown.getSelectedItem().toString(), allTheAvailableRoomList.getSelectedItem().toString());
						if(isSuccess) {
							dropDown.setSelectedIndex(0);
							allTheAvailableRoomList.setSelectedIndex(0);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				if(selectedType.equals("Subject")) {
					try {
						boolean isSuccess = SubjectSutiableRoom(dropDown.getSelectedItem().toString(), allTheAvailableRoomList.getSelectedItem().toString());
						if(isSuccess) {
							dropDown.setSelectedIndex(0);
							allTheAvailableRoomList.setSelectedIndex(0);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		
		
		
	}
	
	
	@SuppressWarnings("unused")
	private boolean SubjectSutiableRoom(String selectedSubject ,String selectedLocation) throws SQLException {
		
		boolean isSuccess = false;
		Connection conn = DBConnect.getConnection();
		String subjectID = null;
		String locationId = null;
		
		//get subjectID
		String query1 = "SELECT id FROM Subjects WHERE sname = '"+selectedSubject+"' ";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query1);
		while(rs1.next()) {
			subjectID = rs1.getString("id");
		}
		
		//get location
		String query2 = "SELECT id FROM Locations WHERE roomName='"+selectedLocation+"'";
		Statement st2 = conn.createStatement();
		ResultSet rs2 = st2.executeQuery(query2);
		while(rs2.next()) {
			locationId = rs2.getString("id");
		}

		
		try {
			
			String sql = "INSERT INTO SubjectSutiableRoom (subjectId, locationId)"
					+ "VALUES ('"+subjectID+"', '"+locationId+"')";
			
			Statement st = conn.createStatement();
			@SuppressWarnings("unused")
			int rs = st.executeUpdate(sql);
			
			st.close();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
		}
		
		return isSuccess;
	}	
	
	@SuppressWarnings("unused")
	private boolean StudentGroupSutiableRoom(String selectedStudentGroup ,String selectedLocation) throws SQLException {
		
		boolean isSuccess = false;
		Connection conn = DBConnect.getConnection();
		String stdGrpId = null;
		String locationId = null;
		
		//get std groupID
		String query1 = "SELECT id FROM StudentGroups WHERE subGroupId='"+selectedStudentGroup+"'";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query1);
		while(rs1.next()) {
			stdGrpId = rs1.getString("id");
		}
		
		//get location
		String query2 = "SELECT id FROM Locations WHERE roomName='"+selectedLocation+"'";
		Statement st2 = conn.createStatement();
		ResultSet rs2 = st2.executeQuery(query2);
		while(rs2.next()) {
			locationId = rs2.getString("id");
		}

		
		try {
			
			String sql = "INSERT INTO StudentGroupSutiableRoom (stdGroupId, locationId)"
					+ "VALUES ('"+stdGrpId+"', '"+locationId+"')";
			
			Statement st = conn.createStatement();
			@SuppressWarnings("unused")
			int rs = st.executeUpdate(sql);
			
			st.close();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
		}
		
		return isSuccess;
	}
	
	
	@SuppressWarnings("unused")
	private boolean LecturerSutiableRoom(String selectedLecturer ,String selectedLocation) throws SQLException {
		
		boolean isSuccess = false;
		Connection conn = DBConnect.getConnection();
		String lecturerId = null;
		String locationId = null;
		
		//get lecturerId
		String query1 = "SELECT id FROM Lecturers WHERE lname='"+selectedLecturer+"'";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query1);
		while(rs1.next()) {
			lecturerId = rs1.getString("id");
		}
		
		//get lecturerId
		String query2 = "SELECT id FROM Locations WHERE roomName='"+selectedLocation+"'";
		Statement st2 = conn.createStatement();
		ResultSet rs2 = st2.executeQuery(query2);
		while(rs2.next()) {
			locationId = rs2.getString("id");
		}

		
		try {
			
			String sql = "INSERT INTO LecturerSutiableRoom (lecturerId, locationId)"
					+ "VALUES ('"+lecturerId+"', '"+locationId+"')";
			
			Statement st = conn.createStatement();
			@SuppressWarnings("unused")
			int rs = st.executeUpdate(sql);
			
			st.close();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
		}
		
		return isSuccess;
	}
	
	
	//load locations
	private String[] loadLocations () {

		
		Connection conn = DBConnect.getConnection();
		
		String[] locationArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		
		try {
			String sql = "SELECT * from Locations ";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			list.add("Select a room on here");
			
			while(rs.next()) {
				
				singleRoom = rs.getString("roomName");
				list.add(singleRoom);
			}
			locationArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return locationArray;
	}
	
	
	//load student groups
	private String[] loadStudentGroups () {
		
		Connection conn = DBConnect.getConnection();
		
		String[] groupIdArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		
		try {
			String sql = "SELECT * from StudentGroups ";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			list.add("Select a student group on here");
			
			while(rs.next()) {
				
				singleRoom = rs.getString("subGroupId");
				
				list.add(singleRoom);
			}
			groupIdArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return groupIdArray;
	}
	
	
	//load lecturers
	private String [] loadlecturerNames() {
		
		Connection conn = DBConnect.getConnection();

		String[] lecturerNameArray = null;
		List<String> list = new ArrayList<>();

		try {

		String sql = "SELECT lname from Lecturers";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		list.add("Select a lecturer on here");
		while(rs.next()) {


		list.add(rs.getString("lname"));
		}
		lecturerNameArray = list.toArray(new String[0]);

		}catch (Exception e) {

		}

		return lecturerNameArray;
	}
	
	
	//load subjects
	private String [] loadSubjects() {
		
		Connection conn = DBConnect.getConnection();

		String[] lecturerNameArray = null;
		List<String> list = new ArrayList<>();

		try {

		String sql = "SELECT * from Subjects";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		list.add("Select a subject on here");
		while(rs.next()) {


		list.add(rs.getString("sname"));
		}
		lecturerNameArray = list.toArray(new String[0]);

		}catch (Exception e) {

		}

		return lecturerNameArray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
