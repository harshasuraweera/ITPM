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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ManageSessionRooms extends JFrame {

	private JPanel contentPane;
	private JTable assignedSessionRoomTable;
	private JScrollPane assignedSessionRoomScrollPane;

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
				btnDefaultSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
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
				
				
				
				
				
				
	}

}
