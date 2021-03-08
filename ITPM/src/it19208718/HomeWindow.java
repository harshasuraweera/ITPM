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
		
		JLabel lblNewLabel = new JLabel("24");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel.setBounds(115, 83, 45, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("15");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(115, 210, 45, 32);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("18");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(115, 346, 45, 32);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("78");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(115, 472, 45, 32);
		panel_1.add(lblNewLabel_1_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 272, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 267, 272, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 397, 272, 2);
		panel_1.add(separator_2);
		
		JLabel lblNewLabel_2 = new JLabel("24");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(115, 83, 45, 32);
		panel_1.add(lblNewLabel_2);
		
		
		
		
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("60%");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(50, 67, 100, 32);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("40 %");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_2_1_1.setBounds(707, 67, 100, 32);
		panel_2.add(lblNewLabel_2_1_1);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setBounds(29, 275, 789, 2);
		panel_2.add(separator_3_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(421, 139, 2, 364);
		panel_2.add(separator_4);
		
		
		
		
		
		
		
	}
}
