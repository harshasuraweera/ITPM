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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnect;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextPane;

@SuppressWarnings({ "unused", "serial" })
public class AssignSessionRoom extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> selectedSessionsArrayList =  new ArrayList<String>();  
	private ArrayList<String> selectedRoomssArrayList =  new ArrayList<String>(); 
	private ArrayList<String> selectedAllSessions = new ArrayList<String>();

	private ArrayList<String>  consecutiveSessionList =  new ArrayList<String>();  
	boolean ifConsecutive = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignSessionRoom frame = new AssignSessionRoom();
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
	public AssignSessionRoom() {

		// do these for each and every JFrame
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
		
		JButton btnManageLocation = new JButton("Manage Session Rooms");
		btnManageLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSessionRooms ManageSessionRooms = new ManageSessionRooms();
				dispose();
				ManageSessionRooms.setVisible(true);
			}
		});
		btnManageLocation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
		btnManageLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageLocation.setFocusable(false);
		btnManageLocation.setBounds(940, 10, 302, 50);
		panel.add(btnManageLocation);
		
		JButton sutiableRoomsBtn = new JButton("Set Suitable Rooms");
		sutiableRoomsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SutiableRoom SutiableRoom = new SutiableRoom();
				dispose();
				SutiableRoom.setVisible(true);
			}
		});
		sutiableRoomsBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		sutiableRoomsBtn.setFocusable(false);
		sutiableRoomsBtn.setBounds(436, 10, 302, 50);
		panel.add(sutiableRoomsBtn);
		sutiableRoomsBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addNew.png")));
		
		JTextArea selectedSessions = new JTextArea();
		selectedSessions.setEditable(false);
		selectedSessions.setBounds(291, 456, 818, 122);
		contentPane.add(selectedSessions);
		
		JLabel addNewLocationLabel = new JLabel("Assign Session Rooms");
		addNewLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addNewLocationLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		addNewLocationLabel.setBounds(457, 122, 345, 44);
		contentPane.add(addNewLocationLabel);
		
		JComboBox<Object> allTheSessionsDropDownList = new JComboBox<Object>(getSessionsList());
		allTheSessionsDropDownList.setSelectedIndex(0);
		allTheSessionsDropDownList.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		allTheSessionsDropDownList.setBackground(Color.WHITE);
		allTheSessionsDropDownList.setBounds(291, 199, 818, 36);
		contentPane.add(allTheSessionsDropDownList);
		
		JLabel lblSelectSession = new JLabel("Select Session");
		lblSelectSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectSession.setBounds(116, 194, 165, 46);
		contentPane.add(lblSelectSession);
		
		JLabel lblConse = new JLabel("<html>Consecutive<br>(If avaliable)</html>");
		lblConse.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblConse.setBounds(116, 278, 165, 46);
		contentPane.add(lblConse);
		
		JLabel lblSelectRoom = new JLabel("Select Room");
		lblSelectRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectRoom.setBounds(116, 381, 165, 46);
		contentPane.add(lblSelectRoom);
		
		JComboBox<Object> allTheAvailableRoomList = new JComboBox<Object>(new Object[]{});
		//allTheAvailableRoomList.setSelectedIndex(0);
		allTheAvailableRoomList.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		allTheAvailableRoomList.setBackground(Color.WHITE);
		allTheAvailableRoomList.setBounds(291, 386, 818, 36);
		contentPane.add(allTheAvailableRoomList);
		
		JLabel lblSelectedSessions = new JLabel("Selected Sessions");
		lblSelectedSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectedSessions.setBounds(116, 456, 165, 46);
		contentPane.add(lblSelectedSessions);
		
		JButton assignSessionBtn = new JButton("Assign");
		assignSessionBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		assignSessionBtn.setFocusable(false);
		assignSessionBtn.setBounds(116, 608, 120, 50);
		contentPane.add(assignSessionBtn);
		
		
		//clear selected items
		JButton clearSelectedSessionArrayBtn = new JButton("Clear");
		clearSelectedSessionArrayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedSessions.setText("");
				selectedSessionsArrayList.clear();
				selectedRoomssArrayList.clear();
				selectedAllSessions.clear();
				
			}
		});
		clearSelectedSessionArrayBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		clearSelectedSessionArrayBtn.setFocusable(false);
		clearSelectedSessionArrayBtn.setBounds(288, 608, 120, 50);
		contentPane.add(clearSelectedSessionArrayBtn);
		
		JTextArea ifTheSelectedSessionConsectiveShowTheRelatedOneHere = new JTextArea();
		ifTheSelectedSessionConsectiveShowTheRelatedOneHere.setEditable(false);
		ifTheSelectedSessionConsectiveShowTheRelatedOneHere.setBounds(288, 279, 818, 70);
		contentPane.add(ifTheSelectedSessionConsectiveShowTheRelatedOneHere);
		
		
		
		
		
		
		//on select the session, according to the tag,  load locations
		allTheSessionsDropDownList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ifTheSelectedSessionConsectiveShowTheRelatedOneHere.setText(null);
				
				String selectedSession = String.valueOf(allTheSessionsDropDownList.getSelectedItem());
				
				if(selectedSession.endsWith("Tutorial")) { //is the selected session a Tutorial, load lecture halls to the room dropdown list
					allTheAvailableRoomList.setModel(new DefaultComboBoxModel<Object>(getRoomNames("Lecture Hall")));
					
					
				}else if(selectedSession.endsWith("Lab")) { //is the selected session a Lab, load laboratories to the room dropdown list
					allTheAvailableRoomList.setModel(new DefaultComboBoxModel<Object>(getRoomNames("Laboratory")));
					
				}
				
				
				//if the selected session is Consecutive session, load the relavant sessions to the feild
				String sessionId = String.valueOf(allTheSessionsDropDownList.getSelectedItem().toString().charAt(2)) + String.valueOf( allTheSessionsDropDownList.getSelectedItem().toString().charAt(3) );
				
				
				//check weather the sessionID available at Consecutive Session table
				ifConsecutive = checkIfTheSessionConsecutive(sessionId);
				
				if(ifConsecutive) {
					
					//Conversion of Array To ArrayList
					Collections.addAll(consecutiveSessionList, getConsecutiveSessionsList(sessionId));
					
					for(String s : consecutiveSessionList) {
						ifTheSelectedSessionConsectiveShowTheRelatedOneHere.append(s + System.getProperty("line.separator"));
					}
					
				}else {
					ifTheSelectedSessionConsectiveShowTheRelatedOneHere.setText("This session is not a Consecutive session");
				}
				
				
			}
		});
		
		
		
		//after select the room, take the complete session ID and the roomID to diffrent array
		allTheAvailableRoomList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedSessionName = String.valueOf(allTheSessionsDropDownList.getSelectedItem());
				String selectedRoomName = String.valueOf(allTheAvailableRoomList.getSelectedItem());
				
				
				
				if(ifConsecutive) {
					
						
					
					selectedSessionsArrayList = consecutiveSessionList;
					selectedRoomssArrayList.add(selectedRoomName);
					selectedRoomssArrayList.add(selectedRoomName);
					
					for(int i=0; i<consecutiveSessionList.size(); i++) {
						selectedAllSessions.add(consecutiveSessionList.get(i) + " At " + selectedRoomName );
					}

					selectedSessions.setText("");
					for(String s : selectedAllSessions){
						selectedSessions.append(s + System.getProperty("line.separator"));
					}
					
//					allTheSessionsDropDownList.setSelectedIndex(0);
//					allTheAvailableRoomList.setSelectedIndex(0);
					
				}else {
					
					selectedSessionsArrayList.add(selectedSessionName);
					selectedRoomssArrayList.add(selectedRoomName);
					
					
					
					//load these to selected sessions textbox
					selectedAllSessions.add(selectedSessionName + " At " + selectedRoomName );

					selectedSessions.setText("");
					for(String s : selectedAllSessions){
						selectedSessions.append(s + System.getProperty("line.separator"));
					}
					
					

				}
				
				
			}
		});
		
		
		//insert into session table on button clicked + make the sessionAssignedStatus as assigned
		assignSessionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(allTheSessionsDropDownList.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Please select a session", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(allTheAvailableRoomList.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(new JFrame(), "Please select a relavant room", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					
					int count = 0;
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Operation cannot be undone! Do you want to continue?","Warning",dialogButton);
					
					if(dialogResult == JOptionPane.YES_OPTION){
						
						for(int i=0; i<selectedSessionsArrayList.size(); i++) {
							
							String sessionId = String.valueOf(selectedSessionsArrayList.get(i).toString().charAt(2)) + String.valueOf( selectedSessionsArrayList.get(i).toString().charAt(3) );

							String locationId = String.valueOf(selectedRoomssArrayList.get(i).toString().charAt(2)) + String.valueOf( selectedRoomssArrayList.get(i).toString().charAt(3) );
							
							//make the session as a room assigned session
							markAsRoomAssigned(sessionId);
							
							//reload sessions list
							allTheSessionsDropDownList.setModel(new DefaultComboBoxModel<Object>(getSessionsList()));
							
							boolean isSuccess = insertIntoSessionRoomTable(sessionId, locationId);
							if(isSuccess) {
								count++;
							}
							
						}
						
						if(count == selectedSessionsArrayList.size()) {
							
						}
						
						allTheSessionsDropDownList.setSelectedIndex(0);
						allTheAvailableRoomList.setSelectedIndex(0);
						selectedSessions.setText("");
						selectedSessionsArrayList.clear();
						selectedRoomssArrayList.clear();
						selectedAllSessions.clear();
						ifTheSelectedSessionConsectiveShowTheRelatedOneHere.setText("");
						
					}else {
						
							
					}
					
				}
				
				
				
					
			}
		});
		
		
	}
	
	
	//load sessions to the dropdown list
	private String [] getSessionsList () {
		
		Connection conn = DBConnect.getConnection();
		
		String[] sessionListArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		String AIID;
		
		try {
			String sql = "SELECT * from Sessions WHERE roomAssignedStatus = 'not-assigned' ";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			list.add("Select a available session on here");
			
			while(rs.next()) {
				
				if( rs.getString("id").equals("1") || rs.getString("id").equals("2") || rs.getString("id").equals("3")|| rs.getString("id").equals("4") || rs.getString("id").equals("5") 
						|| rs.getString("id").equals("6") || rs.getString("id").equals("7") || rs.getString("id").equals("8") || rs.getString("id").equals("9") ) {
					
					AIID = "0" + rs.getString("id");
					
				}else {
					AIID = rs.getString("id");
				}
				
				singleRoom = "ID"+ AIID + " | " + rs.getString("subjectName") + " (" + rs.getString("subjectCode") + ") for " + rs.getString("groupId") + " by " + rs.getString("lecturer1") + " and " + rs.getString("lecturer2") + " | "  + rs.getString("tag");
				list.add(singleRoom);
			}
			sessionListArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return sessionListArray;
	}
	
	
	
	//get all the rooms available to a list
	private String [] getRoomNames(String roomType) {
		
		Connection conn = DBConnect.getConnection();
		
		String[] roomListArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		
		String AIID;
		
		
		try {
			String sql = "SELECT * from Locations WHERE roomType = '"+roomType+"' ";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(roomType.equals("Lecture Hall")) {
				list.add("Select a Lecture Hall on here");
			}
			if(roomType.equals("Laboratory")) {
				list.add("Select a Laboratory on here");
			}
			
			while(rs.next()) {
				
				if( rs.getString("id").equals("1") || rs.getString("id").equals("2") || rs.getString("id").equals("3")|| rs.getString("id").equals("4") || rs.getString("id").equals("5") 
						|| rs.getString("id").equals("6") || rs.getString("id").equals("7") || rs.getString("id").equals("8") || rs.getString("id").equals("9") ) {
					
					AIID = "0" + rs.getString("id");
					
				}else {
					AIID = rs.getString("id");
				}
				
				singleRoom = "ID"+ AIID + " | " + rs.getString("buildingName") + " | " + rs.getString("roomName") + " | Capacity: " + rs.getString("capacity");
				list.add(singleRoom);
			}
			roomListArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return roomListArray;
		
		
		
	}
	
	
	
	//insert into sessionRooms table which are selected
	public boolean insertIntoSessionRoomTable(String sessionId, String locationId) {
		
		boolean isSuccess = false;
		Connection conn = DBConnect.getConnection();
		try {
			
			String sql = "INSERT INTO AssignedSessionRooms (sessionId, locationId)"
					+ "VALUES ('"+sessionId+"', '"+locationId+"')";
			
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
	
	
	
	//make the session as a room assigned session
	public boolean markAsRoomAssigned(String sessionId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		
		try {
			
			String sql = "UPDATE Sessions SET roomAssignedStatus = 'assigned' WHERE id = '"+sessionId+"' ";
			
			Statement st = conn.createStatement();
			@SuppressWarnings("unused")
			int rs = st.executeUpdate(sql);
			
			st.close();
			conn.close();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
			
		}	
		
		return isSuccess;
	}
	
	
	//check weather the sessionID available at Consecutive Session table
	public boolean checkIfTheSessionConsecutive (String sessionID) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		
		try {
			
			String sql = "SELECT * FROM ConsecutiveSession WHERE sessionId = '"+sessionID+"' ";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}
			
			st.close();
			conn.close();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
			
		}	
		
		return isSuccess;
	}
	
	
	
	
	//find the related Consecutive session
	private String [] getConsecutiveSessionsList (String sessionId) {
		
		Connection conn = DBConnect.getConnection();
		
		String[] sessionListArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		String AIID;
		
		try {
			
			//get cons group via database
			String consGroupSql = "SELECT * FROM ConsecutiveSession WHERE sessionId = '"+sessionId+"'";
			Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(consGroupSql);
			String consGroup = null;
			while(rs2.next()) {
				consGroup = rs2.getString("consGroup");
			}
			
			
			String sql = "SELECT * FROM Sessions WHERE id IN (select sessionId from ConsecutiveSession where consGroup = '"+consGroup+"') ";
							
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				
				if( rs.getString("id").equals("1") || rs.getString("id").equals("2") || rs.getString("id").equals("3")|| rs.getString("id").equals("4") || rs.getString("id").equals("5") 
						|| rs.getString("id").equals("6") || rs.getString("id").equals("7") || rs.getString("id").equals("8") || rs.getString("id").equals("9") ) {
					
					AIID = "0" + rs.getString("id");
					
				}else {
					AIID = rs.getString("id");
				}
				
				singleRoom = "ID"+ AIID + " | " + rs.getString("subjectName") + " (" + rs.getString("subjectCode") + ") for " + rs.getString("groupId") + " by " + rs.getString("lecturer1") + " and " + rs.getString("lecturer2") + " | "  + rs.getString("tag");
				list.add(singleRoom);
			}
			sessionListArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return sessionListArray;
	} 
}
