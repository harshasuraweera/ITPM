package it19208718;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnect;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddLocation extends JFrame {

	private JPanel contentPane;
	private JTextField buildingNameTxtField;
	private JTextField roomNameTxtField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocation frame = new AddLocation();
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
	public AddLocation()  throws IOException{
		
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
		
		JButton btnManageLocation = new JButton("Manage Locations");
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
		btnManageLocation.setBounds(982, 10, 260, 50);
		panel.add(btnManageLocation);
		
		JLabel lblNewLabel = new JLabel("Building Name");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(287, 242, 139, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoomName.setBounds(287, 320, 130, 46);
		contentPane.add(lblRoomName);
		
		buildingNameTxtField = new JTextField();
		buildingNameTxtField.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		buildingNameTxtField.setBounds(440, 251, 525, 36);
		contentPane.add(buildingNameTxtField);
		buildingNameTxtField.setColumns(10);
		
		roomNameTxtField = new JTextField();
		roomNameTxtField.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomNameTxtField.setColumns(10);
		roomNameTxtField.setBounds(440, 326, 525, 36);
		contentPane.add(roomNameTxtField);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoomType.setBounds(287, 402, 121, 46);
		contentPane.add(lblRoomType);
		
		JRadioButton lecRadioBtn = new JRadioButton("Lecture Hall");
		lecRadioBtn.setFocusPainted(false);
		lecRadioBtn.setBackground(null);
		lecRadioBtn.setSelected(true);
		lecRadioBtn.setActionCommand("Lecture Hall");
		buttonGroup.add(lecRadioBtn);
		lecRadioBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lecRadioBtn.setBounds(440, 402, 174, 46);
		contentPane.add(lecRadioBtn);
		
		JRadioButton labRadioBtn = new JRadioButton("Laboratory");
		labRadioBtn.setFocusPainted(false);
		labRadioBtn.setBackground(null);
		labRadioBtn.setActionCommand("Laboratory");
		buttonGroup.add(labRadioBtn);
		labRadioBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		labRadioBtn.setBounds(623, 402, 204, 46);
		contentPane.add(labRadioBtn);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblCapacity.setBounds(287, 476, 130, 46);
		contentPane.add(lblCapacity);
		
		JSpinner roomCapacity = new JSpinner();
		roomCapacity.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomCapacity.setBounds(448, 477, 196, 46);
		contentPane.add(roomCapacity);
		
		JLabel addNewLocationLabel = new JLabel("Add New Location");
		addNewLocationLabel.setBounds(452, 118, 306, 44);
		contentPane.add(addNewLocationLabel);
		addNewLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addNewLocationLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		
		
		JLabel operationStatus = new JLabel("");
		operationStatus.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		operationStatus.setBounds(544, 585, 591, 46);
		contentPane.add(operationStatus);
		
		
		JButton saveLocationBtn = new JButton(" Save Location");
		saveLocationBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("save.png")));
		saveLocationBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		saveLocationBtn.setFocusable(false);
		saveLocationBtn.setBounds(287, 585, 225, 50);
		contentPane.add(saveLocationBtn);
		
		//end default
		
		
		
		// Add new location to the system
		saveLocationBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// Validate input fields
				if(buildingNameTxtField.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Building name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(roomNameTxtField.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Room name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}else if (buttonGroup.getSelection().toString().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Room type cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(roomCapacity.getValue().toString().isEmpty() || roomCapacity.getValue().toString().equals("0")) {
					JOptionPane.showMessageDialog(new JFrame(), "Capacity should be grater than 0 and cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					
					//find duplicates
					boolean foundDuplicates = findDuplicateLocations(
							buildingNameTxtField.getText().toString(),
							roomNameTxtField.getText().toString());
					
					if(foundDuplicates) { //this location is already in the db
						JOptionPane.showMessageDialog(new JFrame(), "This location is already already exists!", "Error", JOptionPane.ERROR_MESSAGE);
						operationStatus.setForeground(Color.decode("#b50727"));
						operationStatus.setText("Room (" + roomNameTxtField.getText().toString() + ") in (" + buildingNameTxtField.getText().toString() + ") building is already already exists!");
						
					}else {// the location is a fresh location
						
						
						
						// Do the insertation operation
						boolean isSuccess = addNewLocation(
							buildingNameTxtField.getText().toString(), 
							roomNameTxtField.getText().toString(),
							buttonGroup.getSelection().getActionCommand(),
							Integer.parseInt(roomCapacity.getValue().toString()));
						
						//According to the operation status show the success or unsuccess message
						if(isSuccess) {
						
							buildingNameTxtField.setText(null);
							roomNameTxtField.setText(null);
							roomCapacity.setValue(Integer.valueOf(0));
							
							operationStatus.setForeground(Color.decode("#038013"));
							operationStatus.setText("Location successfully added!");
							
						}else {
						
							operationStatus.setForeground(Color.decode("#b50727"));
							operationStatus.setText("Something went wrong. Please check and try again!");
						}
					}
					
					
					
				}
				
			}
		});
		
		
	}
	
	
	//method to add new location
	public boolean addNewLocation (String buildingName, String roomName, String roomType, int capacity) {
		
		boolean isSuccess = false;
		Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "INSERT INTO Locations (buildingName, roomName, roomType, capacity)"
					+ "VALUES ('"+buildingName+"', '"+roomName+"', '"+roomType+"', '"+capacity+"')";
			
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
	
	
	
	//check duplicates
	public boolean findDuplicateLocations (String buildingName, String roomName) {
		
		boolean foundDuplicate = false; //default no duplicates
		Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "SELECT id FROM Locations WHERE buildingName='"+buildingName+"' and roomName='"+roomName+"'";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			if (!rs.next()) { //ResultSet is empty
				foundDuplicate = false; //no duplicates
				
			}else {	//ResultSet is not empty
				
				foundDuplicate = true; //duplicates have
			}
			
			st.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return foundDuplicate;
	}


}
