//IT19142692
//Anuththara K.G.S.N

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class AddSpecialRoom extends JFrame {

	private JPanel contentPane;
	private JTextField stime;
	private JTextField etime;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSpecialRoom frame = new AddSpecialRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddSpecialRoom() {
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
		
		
		JButton btnManage = new JButton("Manage Session Rooms");
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManage.setForeground(Color.WHITE);
		btnManage.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManage.setFocusable(false);
		btnManage.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnManage.setBackground(new Color(0, 102, 255));
		btnManage.setBounds(994, 10, 237, 50);
		panel.add(btnManage);
		
		//end navigation buttons
		
		JButton btnSessionMain = new JButton("Sessions");
		btnSessionMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSessionMain.setForeground(Color.WHITE);
		btnSessionMain.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnSessionMain.setFocusable(false);
		btnSessionMain.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnSessionMain.setBackground(new Color(0, 102, 255));
		btnSessionMain.setBounds(176, 120, 162, 50);
		contentPane.add(btnSessionMain);
		
		JButton btnConsecutive = new JButton("Consecutive");
		btnConsecutive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsecutive.setForeground(Color.WHITE);
		btnConsecutive.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnConsecutive.setFocusable(false);
		btnConsecutive.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnConsecutive.setBackground(new Color(0, 102, 255));
		btnConsecutive.setBounds(458, 120, 162, 50);
		contentPane.add(btnConsecutive);
		
		JButton btnNotAvailableTimes = new JButton("Not Available Times");
		btnNotAvailableTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNotAvailableTimes.setForeground(new Color(0, 0, 0));
		btnNotAvailableTimes.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNotAvailableTimes.setFocusable(false);
		btnNotAvailableTimes.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnNotAvailableTimes.setBackground(new Color(255, 51, 51));
		btnNotAvailableTimes.setBounds(726, 120, 207, 50);
		contentPane.add(btnNotAvailableTimes);
		
		JLabel lblNewLabel = new JLabel("Select Room");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(72, 234, 142, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectDay = new JLabel("Select Day");
		lblSelectDay.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSelectDay.setBounds(72, 333, 142, 44);
		contentPane.add(lblSelectDay);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblStartTime.setBounds(72, 424, 142, 44);
		contentPane.add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblEndTime.setBounds(72, 522, 142, 44);
		contentPane.add(lblEndTime);
		
		//Arrays to store data
		String roomArray [] = {null,"B506","B403","A406","CyberSecLab","B501","B502"};
		String dayArray [] = {null,"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		JComboBox<Object> room = new JComboBox<Object>(roomArray);
		room.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		room.setBounds(280, 237, 182, 44);
		contentPane.add(room);
		
		JComboBox<Object> day = new JComboBox<Object>(dayArray);
		day.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		day.setBounds(280, 336, 182, 44);
		contentPane.add(day);
		
		//SAVE details
		JButton btnAddSession = new JButton("Add Session");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rm = room.getSelectedItem().toString();
					String dy = day.getSelectedItem().toString();
					String sti = stime.getText().toString();
					String eti = etime.getText().toString();
					
					Connection conn = DBConnect.getConnection();
					String sql1 = "insert into SpecialRoom values (null, '"+rm+"', '"+dy+"', '"+sti+"', '"+eti+"')";
					Statement st = conn.createStatement();
					int rs = st.executeUpdate(sql1);
					
					//Show a Insertion Successful message
					JOptionPane.showMessageDialog(null, "Insertion Successful");
					
					conn.close();
					
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnAddSession.setFocusable(false);
		btnAddSession.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnAddSession.setBackground(new Color(0, 102, 255));
		btnAddSession.setBounds(895, 329, 213, 50);
		contentPane.add(btnAddSession);
		
		//Clear the fields
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Clear fields after insertion
					room.setSelectedIndex(0);
					day.setSelectedIndex(0);
					stime.setText(null);
					etime.setText(null);					
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnClear.setFocusable(false);
		btnClear.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnClear.setBackground(new Color(255, 255, 0));
		btnClear.setBounds(895, 442, 213, 50);
		contentPane.add(btnClear);
		
		stime = new JTextField();
		stime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		stime.setBounds(280, 424, 182, 44);
		contentPane.add(stime);
		stime.setColumns(10);
		
		etime = new JTextField();
		etime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		etime.setColumns(10);
		etime.setBounds(280, 526, 182, 44);
		contentPane.add(etime);
		
	}
}
