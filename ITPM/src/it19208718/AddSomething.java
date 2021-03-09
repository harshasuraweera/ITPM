package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings({ "serial", "unused" })
public class AddSomething extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSomething frame = new AddSomething();
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
	public AddSomething() throws IOException {
		
		// do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("ForzaTimetable Management System - Add New");
		
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
		
		//default end
		
		JButton btnNewButton_1 = new JButton(" Back To Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeWindow homeWindow = new HomeWindow();
					dispose();
					homeWindow.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
		btnNewButton_1.setBounds(38, 10, 225, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(" Manage Exisiting");
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
		btnNewButton_1_1.setBounds(973, 10, 250, 50);
		btnNewButton_1_1.setFocusable(false);
		panel.add(btnNewButton_1_1);
		
		
		
		
		JButton addWorkingDaysAndHours = new JButton(" Add Working Days And Hours");
		addWorkingDaysAndHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addWorkingDaysAndHours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addWorkingDaysAndHours.setFocusable(false);
		addWorkingDaysAndHours.setIcon(new ImageIcon(getClass().getClassLoader().getResource("workingDaysAndHours.png")));
		addWorkingDaysAndHours.setBounds(111, 106, 500, 100);
		contentPane.add(addWorkingDaysAndHours);
		
		
		
		
		JButton addNewLecturer = new JButton(" Add New Lecturer");
		addNewLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewLecturer.setFocusable(false);
		addNewLecturer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lecturer2.png")));
		addNewLecturer.setBounds(111, 216, 500, 100);
		contentPane.add(addNewLecturer);
		
		
		
		
		
		
		JButton addNewSubject = new JButton(" Add New Subject");
		addNewSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewSubject.setFocusable(false);
		addNewSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("subject2.png")));
		addNewSubject.setBounds(111, 326, 500, 100);
		contentPane.add(addNewSubject);
		
		
		
		JButton addNewStudentGroup = new JButton(" Add Student Group");
		addNewStudentGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewStudentGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewStudentGroup.setFocusable(false);
		addNewStudentGroup.setIcon(new ImageIcon(getClass().getClassLoader().getResource("studentGroup.png")));
		addNewStudentGroup.setBounds(626, 106, 500, 100);
		contentPane.add(addNewStudentGroup);
		
		
		
		
		
		JButton addNewTags = new JButton(" Add Tags");
		addNewTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewTags.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewTags.setFocusable(false);
		addNewTags.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tags.png")));
		addNewTags.setBounds(626, 216, 500, 100);
		contentPane.add(addNewTags);
		
	
		JButton addNewLocation = new JButton(" Add Location");
		addNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewLocation.setFocusable(false);
		addNewLocation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("location.png")));
		addNewLocation.setBounds(626, 326, 500, 100);
		contentPane.add(addNewLocation);
		
		JButton addNewSession = new JButton(" Add Session");
		addNewSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewSession.setFocusable(false);
		addNewSession.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addSession.png")));
		addNewSession.setBounds(111, 436, 500, 100);
		contentPane.add(addNewSession);
		
		JButton assignNewRooms = new JButton(" Assign Rooms");
		assignNewRooms.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		assignNewRooms.setFocusable(false);
		assignNewRooms.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lecRoom2.png")));
		assignNewRooms.setBounds(626, 436, 500, 100);
		contentPane.add(assignNewRooms);
		
		JButton sessionTypesANTA = new JButton(" Session Types and Not Available Time Allocations");
		sessionTypesANTA.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		sessionTypesANTA.setFocusable(false);
		sessionTypesANTA.setIcon(new ImageIcon(getClass().getClassLoader().getResource("sessionTypes.png")));
		sessionTypesANTA.setBounds(111, 546, 1015, 100);
		contentPane.add(sessionTypesANTA);
		
		
		
		
		
	}

}
