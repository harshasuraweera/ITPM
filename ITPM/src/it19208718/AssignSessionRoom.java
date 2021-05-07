package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AssignSessionRoom extends JFrame {

	private JPanel contentPane;

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
		
		JLabel addNewLocationLabel = new JLabel("Assign Session Rooms");
		addNewLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addNewLocationLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		addNewLocationLabel.setBounds(457, 122, 345, 44);
		contentPane.add(addNewLocationLabel);
		
		JComboBox<Object> roomTypeFilter = new JComboBox<Object>(new Object[]{});
		//roomTypeFilter.setSelectedIndex(0);
		roomTypeFilter.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomTypeFilter.setBackground(Color.WHITE);
		roomTypeFilter.setBounds(291, 199, 818, 36);
		contentPane.add(roomTypeFilter);
		
		JLabel lblSelectSession = new JLabel("Select Session");
		lblSelectSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectSession.setBounds(116, 194, 165, 46);
		contentPane.add(lblSelectSession);
		
		JLabel lblConse = new JLabel("<html>Consecutive<br>(If avaliable)</html>");
		lblConse.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblConse.setBounds(116, 278, 165, 46);
		contentPane.add(lblConse);
		
		JComboBox<Object> roomTypeFilter_1 = new JComboBox<Object>(new Object[]{});
		//roomTypeFilter_1.setSelectedIndex(0);
		roomTypeFilter_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomTypeFilter_1.setBackground(Color.WHITE);
		roomTypeFilter_1.setBounds(291, 283, 818, 36);
		contentPane.add(roomTypeFilter_1);
		
		JLabel lblSelectRoom = new JLabel("Select Room");
		lblSelectRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectRoom.setBounds(116, 367, 165, 46);
		contentPane.add(lblSelectRoom);
		
		JComboBox<Object> roomTypeFilter_1_1 = new JComboBox<Object>(new Object[]{});
		//roomTypeFilter_1_1.setSelectedIndex(0);
		roomTypeFilter_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomTypeFilter_1_1.setBackground(Color.WHITE);
		roomTypeFilter_1_1.setBounds(291, 372, 818, 36);
		contentPane.add(roomTypeFilter_1_1);
		
		JLabel lblSelectedSessions = new JLabel("Selected Sessions");
		lblSelectedSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectedSessions.setBounds(116, 456, 165, 46);
		contentPane.add(lblSelectedSessions);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(291, 456, 818, 112);
		contentPane.add(textArea);
		
		JButton updateLocation = new JButton("Assign");
		updateLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		updateLocation.setFocusable(false);
		updateLocation.setBounds(116, 608, 120, 50);
		contentPane.add(updateLocation);
		
		JButton updateLocation_1 = new JButton("Clear");
		updateLocation_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		updateLocation_1.setFocusable(false);
		updateLocation_1.setBounds(288, 608, 120, 50);
		contentPane.add(updateLocation_1);
	}
}
