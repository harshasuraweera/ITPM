package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GenerateTimetable extends JFrame {

	private JPanel contentPane;
	String selectedType = null;
	JComboBox<Object> dropdownList;
	
	private JScrollPane scrollPane;
	private JTable timetable;
	
	public ArrayList<String> timeSlots =  new ArrayList<String>(); 
	
	List<String> timeSlotList = Arrays.asList( "08.30 - 09.30", "09.30 - 10.30", "10.30 - 11.30","11.30 - 12.30", "12.30 - 13.30", "13.30 - 14.30",  "14.30 - 15.30", "15.30 - 16.30", "16.30 - 17.30", "17.30 - 18.30", "18.30 - 19.30");
	  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateTimetable frame = new GenerateTimetable();
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
	public GenerateTimetable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				dropdownList.setModel(new DefaultComboBoxModel<Object>(getlecturerNames ()));
			}
		});
		
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
		
		JLabel label = new JLabel("Lecturer");
		label.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		label.setBounds(24, 92, 165, 46);
		contentPane.add(label);
		
		JButton btnLecturer = new JButton("Lecturer");
		
		btnLecturer.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		btnLecturer.setFocusable(false);
		btnLecturer.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnLecturer.setBounds(26, 10, 150, 50);
		panel.add(btnLecturer);
		
		JButton btnStudent = new JButton("Student Group");
		btnStudent.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnStudent.setFocusable(false);
		btnStudent.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnStudent.setBounds(228, 10, 199, 50);
		panel.add(btnStudent);
		
		JButton btnLocation = new JButton("Location");
		
		btnLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnLocation.setFocusable(false);
		btnLocation.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnLocation.setBounds(474, 10, 150, 50);
		panel.add(btnLocation);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnPrint.setFocusable(false);
		btnPrint.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnPrint.setBounds(1086, 10, 150, 50);
		panel.add(btnPrint);
		
		dropdownList = new JComboBox<Object>(new Object[]{});
		//allTheSessionsDropDownList.setSelectedIndex(0);
		dropdownList.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		dropdownList.setBackground(Color.WHITE);
		dropdownList.setBounds(208, 102, 818, 36);
		contentPane.add(dropdownList);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnGenerate.setFocusable(false);
		btnGenerate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnGenerate.setBounds(1087, 89, 150, 50);
		contentPane.add(btnGenerate);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 179, 1213, 476);
		contentPane.add(scrollPane);
		
		timetable = new JTable();
		scrollPane.setViewportView(timetable);
		timetable.getTableHeader().setFont(new Font("Kristen ITC", Font.BOLD, 12));
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Time Slots");
		model.addColumn("Monday");
		model.addColumn("Tuesday");
		model.addColumn("Wednesday"); 
		model.addColumn("Thursday");
		model.addColumn("Friday");
		
		timetable.setModel(model);
		timetable.setAutoResizeMode(1);
		timetable.setFillsViewportHeight( true );
		timetable.setRowHeight(30);
		timetable.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		
		//insert time slots
		
		timeSlots.addAll(timeSlotList);
		
		for(int i=0; i<11 ; i++) {
			model.addRow(new Object[] {
					" " + timeSlots.get(i),
			});;
		}
		
		btnLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label.setText("Lecturer");
				btnLecturer.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnStudent.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				selectedType = "Lecturer";
				dropdownList.setModel(new DefaultComboBoxModel<Object>(getlecturerNames ()));
			}
		});
		
		
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Student Group");
				btnStudent.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				selectedType = "StudentGroup";
				dropdownList.setModel(new DefaultComboBoxModel<Object>(loadStudentGroups ()));
				
			}
		});
		
		
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Location");
				btnLocation.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnStudent.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				selectedType = "Location";
				dropdownList.setModel(new DefaultComboBoxModel<Object>(loadLocations ()));
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	//load lecturers
	private String [] getlecturerNames() {
		
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
				
				singleRoom = rs.getString("groupId");
				
				list.add(singleRoom);
			}
			groupIdArray = list.toArray(new String[0]);
			
		}catch (Exception e) {
			
		}

		
		return groupIdArray;
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
}
