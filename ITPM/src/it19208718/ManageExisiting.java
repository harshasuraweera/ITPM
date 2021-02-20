package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class ManageExisiting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageExisiting frame = new ManageExisiting();
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
	public ManageExisiting() throws IOException {
		
		//do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Manage");
		
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
		
		//end default
		
		
		
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
		
		
		JButton btnNewButton_1_1 = new JButton(" Add New");
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnNewButton_1_1.setBounds(973, 10, 250, 50);
		btnNewButton_1_1.setFocusable(false);
		panel.add(btnNewButton_1_1);
		
		
		
		JButton btnManageWorkingDays = new JButton(" Manage Working Days And Hours");
		btnManageWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageWorkingDays.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageWorkingDays.setFocusable(false);
		btnManageWorkingDays.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageWorkingDays.setBounds(104, 173, 445, 100);
		contentPane.add(btnManageWorkingDays);
		
		JButton btnManageNewLecturer = new JButton(" Manage Lecturers");
		btnManageNewLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageNewLecturer.setFocusable(false);
		btnManageNewLecturer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageNewLecturer.setBounds(104, 322, 445, 100);
		contentPane.add(btnManageNewLecturer);
		
		JButton btnManageSubject = new JButton(" Manage Subjects");
		btnManageSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageSubject.setFocusable(false);
		btnManageSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageSubject.setBounds(104, 471, 445, 100);
		contentPane.add(btnManageSubject);
		
		JButton btnManageLocations = new JButton(" Manage Locations");
		btnManageLocations.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageLocations.setFocusable(false);
		btnManageLocations.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageLocations.setBounds(674, 471, 445, 100);
		contentPane.add(btnManageLocations);
		
		JButton btnManageTags = new JButton(" Manage Tags");
		btnManageTags.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageTags.setFocusable(false);
		btnManageTags.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageTags.setBounds(674, 322, 445, 100);
		contentPane.add(btnManageTags);
		
		JButton btnManageStudentGroups = new JButton(" Manage Student Groups");
		btnManageStudentGroups.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManageStudentGroups.setFocusable(false);
		btnManageStudentGroups.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
		btnManageStudentGroups.setBounds(674, 173, 445, 100);
		contentPane.add(btnManageStudentGroups);
		
		
		
		
		
		
		
		
	}

}
