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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings({ "serial", "unused" })
public class ManageSessionRooms extends JFrame {

	private JPanel contentPane;
	private JTable assignedSessionRoomTable;
	private JScrollPane assignedSessionRoomScrollPane;
	
	public String sessionType = "default";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSessionRooms frame = new ManageSessionRooms();
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
	public ManageSessionRooms() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showAssignedSessionRooms(sessionType);
			}
		});
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
						try {
							ManageLocation manageLocation = new ManageLocation();
							dispose();
							manageLocation.setVisible(true);
							
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
					}
				});
				btnManageLocation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
				btnManageLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnManageLocation.setFocusable(false);
				btnManageLocation.setBounds(940, 10, 302, 50);
				panel.add(btnManageLocation);
				
				JLabel addNewLocationLabel = new JLabel("Manage Session Rooms");
				addNewLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
				addNewLocationLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
				addNewLocationLabel.setBounds(434, 103, 365, 44);
				contentPane.add(addNewLocationLabel);
				
				JButton btnDefaultSessions = new JButton("Default Sessions");
				
				btnDefaultSessions.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnDefaultSessions.setFocusable(false);
				btnDefaultSessions.setBounds(54, 177, 308, 50);
				contentPane.add(btnDefaultSessions);
				
				JButton btnConsecutiveSessions = new JButton("Consecutive Sessions");
				
				btnConsecutiveSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnConsecutiveSessions.setFocusable(false);
				btnConsecutiveSessions.setBounds(419, 177, 380, 50);
				contentPane.add(btnConsecutiveSessions);
				
				JButton btnNotAvailableTimes = new JButton("Not Available Times");
				btnNotAvailableTimes.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNotAvailableTimes.setFocusable(false);
				btnNotAvailableTimes.setBounds(855, 177, 335, 50);
				contentPane.add(btnNotAvailableTimes);
				
				//on click buttons 
				
				btnDefaultSessions.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnConsecutiveSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
						btnDefaultSessions.setFont(new Font("Kristen ITC", Font.BOLD, 18));
						sessionType = "default";
						showAssignedSessionRooms(sessionType);
					}
				});
				
				
				btnConsecutiveSessions.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnDefaultSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
						btnConsecutiveSessions.setFont(new Font("Kristen ITC", Font.BOLD, 18));
						sessionType = "consecutive";
						showAssignedSessionRooms(sessionType);
						
					}
				});
				
				
				
				//table
				assignedSessionRoomScrollPane = new JScrollPane();
				assignedSessionRoomScrollPane.setBounds(54, 250, 1136, 331);
				contentPane.add(assignedSessionRoomScrollPane);
				
				assignedSessionRoomTable = new JTable();
				assignedSessionRoomScrollPane.setViewportView(assignedSessionRoomTable);
				
				
				
				
				
				
				JButton btnChangeRoom = new JButton("Change Room");
				btnChangeRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnChangeRoom.setFocusable(false);
				btnChangeRoom.setBounds(354, 607, 214, 50);
				contentPane.add(btnChangeRoom);
				
				JButton btnUnassignRoom = new JButton("Unassign Room");
				
				btnUnassignRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnUnassignRoom.setFocusable(false);
				btnUnassignRoom.setBounds(650, 607, 214, 50);
				contentPane.add(btnUnassignRoom);
				assignedSessionRoomTable.getTableHeader().setFont(new Font("Kristen ITC", Font.BOLD, 12));
				
				
				
				btnChangeRoom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(sessionType == "default") {
							
							String selectedSessionId = assignedSessionRoomTable.getValueAt(assignedSessionRoomTable.getSelectedRow(), 0).toString();
							String sessionTag = assignedSessionRoomTable.getValueAt(assignedSessionRoomTable.getSelectedRow(), 6).toString();
							
							String roomType = null;
							
							if(sessionTag == "Tutorial" || sessionTag == "Lecture") {
								roomType = "Lecture Hall";
							}else {
								roomType = "Laboratory";
							}
							
							String[] roomNameList = getRoomNames(roomType);
							
							String newRoom = (String) JOptionPane.showInputDialog(null, "Please select a new room", "Changing the room", 
									 JOptionPane.QUESTION_MESSAGE, null, roomNameList, roomNameList[0]); // Initial choice
							 
							String locationId = String.valueOf( newRoom.charAt(2)) +  String.valueOf(newRoom.charAt(3)) ;
							
							//update the new room for existing one
							updateAssignedRoom(selectedSessionId, locationId);
							
							showAssignedSessionRooms("default");
							
						}else if(sessionType == "consecutive") {
							
							String selectedSessionId = assignedSessionRoomTable.getValueAt(assignedSessionRoomTable.getSelectedRow(), 0).toString();
							String sessionTag = assignedSessionRoomTable.getValueAt(assignedSessionRoomTable.getSelectedRow(), 6).toString();
							
							String roomType = null;
							
							if(sessionTag == "Tutorial" || sessionTag == "Lecture") {
								roomType = "Lecture Hall";
							}else {
								roomType = "Laboratory";
							}
							
							String[] roomNameList = getRoomNames(roomType);
							
							String newRoom = (String) JOptionPane.showInputDialog(null, "Please select a new room", "Changing the room", 
									 JOptionPane.QUESTION_MESSAGE, null, roomNameList, roomNameList[0]); // Initial choice
							 
							String locationId = String.valueOf( newRoom.charAt(2)) +  String.valueOf(newRoom.charAt(3)) ;
							
							//update the new room for existing one
							updateAssignedRoomForConsecutive(selectedSessionId, locationId);
							
							showAssignedSessionRooms("consecutive");

							
						}
						
						
						
					}
				});
				
				
				btnUnassignRoom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String selectedSessionId = assignedSessionRoomTable.getValueAt(assignedSessionRoomTable.getSelectedRow(), 0).toString();
						
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "Operation cannot be undone! Do you want to continue?","Warning",dialogButton);
						
						if(dialogResult == JOptionPane.YES_OPTION) {
							
							if(sessionType == "default") {
								unAssignNormalSessionRoom(selectedSessionId);
								showAssignedSessionRooms("default");
								
							}else if(sessionType == "consecutive") {
								unAssignConsSessionRoom(selectedSessionId);
								showAssignedSessionRooms("consecutive");
							}
							
							
							
							
						}else {
							
						}
						
						
					}
				});
				
				
	}
	
	
	
	
	
	//load default and consecutive sessions
	
	private void showAssignedSessionRooms(String sessionType) {


		Connection conn = DBConnect.getConnection();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Lecturer 01");
		model.addColumn("Lecturer 02");
		model.addColumn("Subject Name"); 
		model.addColumn("Subject Code");
		model.addColumn("Group ID");
		model.addColumn("Tag");
		model.addColumn("Assigned Room");
		
		String sql = "SELECT * FROM Sessions WHERE sessionType = '"+sessionType+"' and roomAssignedStatus = 'assigned' ";
		
		
		
		try {
			
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String room = null;
			
			while(rs.next()) {
				
				//get room details of current session
				String sql2 = "SELECT * FROM Locations WHERE id IN (SELECT locationId FROM AssignedSessionRooms WHERE sessionId= '"+rs.getString("id")+"' ) ";
				Statement st2 = conn.createStatement();
				ResultSet rs2 = st2.executeQuery(sql2);
				
				while(rs2.next()) {
					 room = rs2.getString("roomName") +" At "+ rs2.getString("buildingName");
				}
				
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("lecturer1"),
						rs.getString("lecturer2"),
						rs.getString("subjectName"),
						rs.getString("subjectCode"),
						rs.getString("groupId"),
						rs.getString("tag"),
						room,
				});;
			}
			
			rs.close();
			st.close();
			
			
			assignedSessionRoomTable.setModel(model);
			assignedSessionRoomTable.setAutoResizeMode(1);
			assignedSessionRoomTable.setFillsViewportHeight( true );
			assignedSessionRoomTable.setRowHeight(30);
			assignedSessionRoomTable.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	//get assigned location details for selected sessionID
	public String roomDetails (String sessionId) {
		
		Connection conn = DBConnect.getConnection();
		String roomDetail = null;
		
		//get room details of current session
		String sql2 = "SELECT * FROM Locations WHERE id IN (SELECT locationId FROM AssignedSessionRooms WHERE sessionId= '"+Integer.valueOf(sessionId)+"' ) ";
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql2);
			
			String AIID;
			
			while(rs.next()) {
				
				
				if( rs.getString("id").equals("1") || rs.getString("id").equals("2") || rs.getString("id").equals("3")|| rs.getString("id").equals("4") || rs.getString("id").equals("5") 
						|| rs.getString("id").equals("6") || rs.getString("id").equals("7") || rs.getString("id").equals("8") || rs.getString("id").equals("9") ) {
					
					AIID = "0" + rs.getString("id");
					
				}else {
					AIID = rs.getString("id");
				}
				
				roomDetail = "ID"+ AIID + " | " + rs.getString("buildingName") + " | " + rs.getString("roomName") + " | Capacity: " + rs.getString("capacity");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return roomDetail;
		
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
	
	
	
	//update the new room for existing one
	public boolean updateAssignedRoom(String sessionId, String newLocationId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "UPDATE AssignedSessionRooms SET locationId = '"+newLocationId+"' WHERE sessionId = '"+sessionId+"' ";
			
			Statement st = conn.createStatement();
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
	
	
	//update room for consecutive sessions
	public boolean updateAssignedRoomForConsecutive(String sessionId, String newLocationId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			
			//get consGroup according to sessionID
			String sql2 =  "SELECT consGroup FROM ConsecutiveSession WHERE sessionId = '"+sessionId+"' ";
			Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(sql2);
			String consGroup = null;
			
			while(rs2.next()) {
				consGroup = rs2.getString("consGroup");
			}
			
			
			String sql = "UPDATE AssignedSessionRooms SET locationId = '"+newLocationId+"' "
					+ "WHERE sessionId IN (SELECT sessionId FROM ConsecutiveSession WHERE consGroup = '"+consGroup+"' ) ";
			
			Statement st = conn.createStatement();
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
	
	
	//un-assign normal session room
	public boolean unAssignNormalSessionRoom(String sessionId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			//delete from assignedSessionRoomTable
			String deleteQuery = "DELETE FROM AssignedSessionRooms WHERE sessionId= '"+sessionId+"' ";
			Statement st1 = conn.createStatement();
			int rs1 = st1.executeUpdate(deleteQuery);
			
			
			
			//update main session table as not-assigned
			String sql = "UPDATE Sessions SET roomAssignedStatus = 'not-assigned' "
					+ "WHERE id = '"+sessionId+"' ";
			
			Statement st = conn.createStatement();
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
	
	
	//un-assign cons session room
	public boolean unAssignConsSessionRoom(String sessionId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			//get cons group for the selected session
			String sql2 =  "SELECT consGroup FROM ConsecutiveSession WHERE sessionId = '"+sessionId+"' ";
			Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(sql2);
			String consGroup = null;
			
			while(rs2.next()) {
				consGroup = rs2.getString("consGroup");
			}
			
			
			//delete from assignedSessionRoomTable
			String deleteQuery = "DELETE FROM AssignedSessionRooms WHERE sessionId IN (SELECT sessionId FROM ConsecutiveSession WHERE consGroup = '"+consGroup+"') ";
			Statement st1 = conn.createStatement();
			int rs1 = st1.executeUpdate(deleteQuery);
			
			
			
			//update main session table as not-assigned
			String sql = "UPDATE Sessions SET roomAssignedStatus = 'not-assigned' "
					+ "WHERE id IN (SELECT sessionId FROM ConsecutiveSession WHERE consGroup = '"+consGroup+"') ";
			
			Statement st = conn.createStatement();
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
	
	

}
