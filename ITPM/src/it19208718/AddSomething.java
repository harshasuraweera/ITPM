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
		
		//do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("ForzaTimetable Management System - Add New");
		
		//set Icon to the window
		ImageIcon img = new ImageIcon("images/icon.png");
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
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
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
		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
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
		addWorkingDaysAndHours.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addWorkingDaysAndHours.setBounds(111, 165, 445, 100);
		contentPane.add(addWorkingDaysAndHours);
		
		
		
		
		JButton addNewLecturer = new JButton(" Add New Lecturer");
		addNewLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewLecturer.setFocusable(false);
		addNewLecturer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addNewLecturer.setBounds(111, 314, 445, 100);
		contentPane.add(addNewLecturer);
		
		
		
		
		
		
		JButton addNewSubject = new JButton(" Add New Subject");
		addNewSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addNewSubject.setFocusable(false);
		addNewSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addNewSubject.setBounds(111, 463, 445, 100);
		contentPane.add(addNewSubject);
		
		
		
		JButton addStudentGroup = new JButton(" Add Student Group");
		addStudentGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addStudentGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addStudentGroup.setFocusable(false);
		addStudentGroup.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addStudentGroup.setBounds(681, 165, 445, 100);
		contentPane.add(addStudentGroup);
		
		
		
		
		
		JButton addTags = new JButton(" Add Tags");
		addTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addTags.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addTags.setFocusable(false);
		addTags.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addTags.setBounds(681, 314, 445, 100);
		contentPane.add(addTags);
		
		
		
		
		JButton addLocation = new JButton(" Add Location");
		addLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		addLocation.setFocusable(false);
		addLocation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		addLocation.setBounds(681, 463, 445, 100);
		contentPane.add(addLocation);
		
		
		
		
		
	}

}
