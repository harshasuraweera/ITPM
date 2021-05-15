package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GenerateTimetable extends JFrame {

	private JPanel contentPane;

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
		
		JComboBox<Object> dropdownList = new JComboBox<Object>(new Object[]{});
		//allTheSessionsDropDownList.setSelectedIndex(0);
		dropdownList.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		dropdownList.setBackground(Color.WHITE);
		dropdownList.setBounds(208, 102, 818, 36);
		contentPane.add(dropdownList);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnGenerate.setFocusable(false);
		btnGenerate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnGenerate.setBounds(1080, 94, 150, 50);
		contentPane.add(btnGenerate);
		
		
		
		//end default
		
		
		btnLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label.setText("Lecturer");
				btnLecturer.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnStudent.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				
				
			}
		});
		
		
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Student Group");
				btnStudent.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
			}
		});
		
		
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Location");
				btnLocation.setFont(new Font("Kristen ITC", Font.BOLD, 18));
				btnLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnStudent.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				
				

				dropdownList.setModel(new DefaultComboBoxModel<Object>(loadLocations ()));
				
			}
		});
		
		
		
	}
	
	
	//load lecturers
	
	
	
	
	//load student groups
	
	
	
	
	//load locations
	public String[] loadLocations () {
		
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
