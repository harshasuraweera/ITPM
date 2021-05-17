package IT19142692;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnect;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.sql.*;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class AddNotAvailableTimes extends JFrame {

	private JPanel contentPane;
	private JTextField time;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotAvailableTimes frame = new AddNotAvailableTimes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddNotAvailableTimes() {
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
		JButton btnHome = new JButton("Back to Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(new Color(0, 102, 255));
		
		btnHome.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		//btnHome.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addNew2.png")));
		btnHome.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnHome.setBounds(24, 10, 162, 50);
		btnHome.setFocusable(false);
		panel.add(btnHome);
		
		JButton btnDefaultSession = new JButton("Default Session");
		btnDefaultSession.setForeground(Color.WHITE);
		btnDefaultSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnDefaultSession.setFocusable(false);
		btnDefaultSession.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnDefaultSession.setBackground(new Color(0, 102, 255));
		btnDefaultSession.setBounds(33, 106, 189, 50);
		contentPane.add(btnDefaultSession);
		
		JButton btnConsecutive = new JButton("Consecutive");
		btnConsecutive.setForeground(Color.WHITE);
		btnConsecutive.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnConsecutive.setFocusable(false);
		btnConsecutive.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnConsecutive.setBackground(new Color(0, 102, 255));
		btnConsecutive.setBounds(307, 106, 162, 50);
		contentPane.add(btnConsecutive);
		
		JButton btnParallel = new JButton("Parallel");
		btnParallel.setForeground(Color.WHITE);
		btnParallel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnParallel.setFocusable(false);
		btnParallel.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnParallel.setBackground(new Color(0, 102, 255));
		btnParallel.setBounds(554, 106, 162, 50);
		contentPane.add(btnParallel);
		
		JButton btnNonOverlapping = new JButton("Non Overlapping");
		btnNonOverlapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNonOverlapping.setForeground(Color.WHITE);
		btnNonOverlapping.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNonOverlapping.setFocusable(false);
		btnNonOverlapping.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnNonOverlapping.setBackground(new Color(0, 102, 255));
		btnNonOverlapping.setBounds(794, 106, 183, 50);
		contentPane.add(btnNonOverlapping);
		
		JButton btnNotAvailableTimes = new JButton("Not Available Times");
		btnNotAvailableTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNotAvailableTimes.setForeground(new Color(0, 0, 0));
		btnNotAvailableTimes.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNotAvailableTimes.setFocusable(false);
		btnNotAvailableTimes.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnNotAvailableTimes.setBackground(new Color(255, 99, 71));
		btnNotAvailableTimes.setBounds(1044, 106, 212, 50);
		contentPane.add(btnNotAvailableTimes);
		
		JLabel lblLecturer = new JLabel("Select Lecturer");
		lblLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblLecturer.setBounds(33, 215, 189, 50);
		contentPane.add(lblLecturer);
		
		JLabel lblGroup = new JLabel("Select Group");
		lblGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblGroup.setBounds(33, 301, 154, 50);
		contentPane.add(lblGroup);
		
		JLabel lblSubGroup = new JLabel("Select Sub Group");
		lblSubGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSubGroup.setBounds(33, 392, 162, 50);
		contentPane.add(lblSubGroup);
		
		JLabel lblSession = new JLabel("Select Session ID");
		lblSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSession.setBounds(33, 479, 162, 50);
		contentPane.add(lblSession);
		
		JLabel lblRoom = new JLabel("Select Room");
		lblRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoom.setBounds(33, 569, 128, 50);
		contentPane.add(lblRoom);
		
		String lecturerArray [] = {null,"Nasir Mohomadh","Yasiru Gunasinghe","Nisitha Fernando","Kavindu Gunasinghe","Pasan Abesinghe"};
		String groupArray [] = {null,"Y3S1.CS.4","Y2S2.ICS.5","Y3S2.ICS.6","Y2S1.DS.6","Y2S1.ICS.2","Y1S2.IM.3"};
		String subgroupArray [] = {null,"Y3S1.CS.4.7","Y2S2.ICS.5.5","Y3S2.ICS.6.5","Y2S1.DS.6.4","Y2S1.ICS.2.2","Y1S2.IM.3.3"};
		String sessionidArray [] = {null,"6","7","8","9","10","18"};
		String roomArray [] = {null,"B506","B403","A406","CyberSecLab","B501","B502"};
		
		JComboBox<Object> lecturer = new JComboBox<Object>(lecturerArray);
		lecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lecturer.setBounds(267, 221, 202, 44);
		contentPane.add(lecturer);
		
		JComboBox<Object> group = new JComboBox<Object>(groupArray);
		group.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		group.setBounds(267, 313, 202, 44);
		contentPane.add(group);
		
		JComboBox<Object> subgroup = new JComboBox<Object>(subgroupArray);
		subgroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		subgroup.setBounds(267, 398, 202, 44);
		contentPane.add(subgroup);
		
		JComboBox<Object> sessionid = new JComboBox<Object>(sessionidArray);
		sessionid.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		sessionid.setBounds(267, 485, 202, 44);
		contentPane.add(sessionid);
		
		JComboBox<Object> room = new JComboBox<Object>(roomArray);
		room.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		room.setBounds(267, 577, 202, 44);
		contentPane.add(room);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblTime.setBounds(955, 215, 81, 50);
		contentPane.add(lblTime);
		
		time = new JTextField();
		time.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		time.setBounds(1056, 215, 183, 44);
		contentPane.add(time);
		time.setColumns(10);
		
		//Submit Button
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					
					String lec = lecturer.getSelectedItem().toString();
					String gr = group.getSelectedItem().toString();
					String sg = subgroup.getSelectedItem().toString();
					String si = sessionid.getSelectedItem().toString();
					String rm = room.getSelectedItem().toString();
					String ti = time.getText().toString();
					
					Connection conn = DBConnect.getConnection();
					String sql1 = "insert into NotAvailableTimes values (null, '"+lec+"', '"+gr+"', '"+sg+"', '"+si+"', '"+rm+"', '"+ti+"')";
					Statement st = conn.createStatement();
					int rs = st.executeUpdate(sql1);
					
					JOptionPane.showMessageDialog(null, "Insertion Successful");
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnSubmit.setBackground(new Color(0, 102, 255));
		btnSubmit.setBounds(1077, 313, 162, 50);
		contentPane.add(btnSubmit);
		
		//VIEW Button
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Go to the next page
				ManageNotAvailableTimes obj = new ManageNotAvailableTimes();
				obj.setVisible(true);
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnView.setFocusable(false);
		btnView.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setBounds(1077, 432, 162, 50);
		contentPane.add(btnView);
		
		//CLEAR Button
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lecturer.setSelectedIndex(0);
					group.setSelectedIndex(0);
					subgroup.setSelectedIndex(0);
					sessionid.setSelectedIndex(0);
					room.setSelectedIndex(0);
					time.setText(null);				
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnClear.setFocusable(false);
		btnClear.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnClear.setBackground(new Color(220, 20, 60));
		btnClear.setBounds(1077, 558, 162, 50);
		contentPane.add(btnClear);
	}
}
