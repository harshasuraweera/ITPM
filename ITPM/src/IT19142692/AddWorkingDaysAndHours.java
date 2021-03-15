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
import it19208718.AddSomething;
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

public class AddWorkingDaysAndHours extends JFrame {

	boolean monday=false, tuesday=false, wednesday=false, thursday=false, friday=false, saturday=false, sunday=false;
	
	int daysCount = 0;
	
	private JPanel contentPane;
	private JTextField totalSelectedDaysCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkingDaysAndHours frame = new AddWorkingDaysAndHours();
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
	public AddWorkingDaysAndHours() {
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
		
		//end navigation button 01
		
		JLabel lblNewLabel_1 = new JLabel("Add Working Days and Hours");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(375, 105, 503, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Select Working Days");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel.setBounds(28, 225, 262, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("No. of Working Days");
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(28, 382, 262, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Working Time Per Day");
		lblNewLabel_3.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(28, 489, 277, 44);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					monday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}			
				else {
					monday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxMonday.setBackground(new Color(240, 240, 240));
		chckbxMonday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxMonday.setBounds(375, 230, 114, 38);
		contentPane.add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					tuesday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					tuesday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxTuesday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxTuesday.setBackground(SystemColor.menu);
		chckbxTuesday.setBounds(552, 231, 114, 38);
		contentPane.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					wednesday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					wednesday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxWednesday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxWednesday.setBackground(SystemColor.menu);
		chckbxWednesday.setBounds(718, 230, 135, 38);
		contentPane.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					thursday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					thursday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxThursday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxThursday.setBackground(SystemColor.menu);
		chckbxThursday.setBounds(899, 230, 123, 38);
		contentPane.add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					friday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					friday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}	
		});
		chckbxFriday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxFriday.setBackground(SystemColor.menu);
		chckbxFriday.setBounds(1074, 230, 114, 38);
		contentPane.add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					saturday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					saturday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxSaturday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxSaturday.setBackground(SystemColor.menu);
		chckbxSaturday.setBounds(375, 306, 114, 38);
		contentPane.add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					sunday = true;
					daysCount ++;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
				else {
					sunday = false;
					daysCount --;
					totalSelectedDaysCount.setText(String.valueOf(daysCount));
				}
			}
		});
		chckbxSunday.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		chckbxSunday.setBackground(SystemColor.menu);
		chckbxSunday.setBounds(552, 306, 114, 38);
		contentPane.add(chckbxSunday);
		
		JLabel lblNewLabel_4 = new JLabel("Hours");
		lblNewLabel_4.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(464, 499, 87, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Minutes");
		lblNewLabel_4_1.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(649, 499, 87, 34);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.WHITE);
		
		btnSave.setBackground(Color.BLUE);
		btnSave.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnSave.setBounds(693, 589, 140, 51);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("UPDATE");
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 153, 0));
		btnUpdate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnUpdate.setBounds(893, 589, 140, 51);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnDelete.setBounds(1088, 589, 140, 51);
		contentPane.add(btnDelete);
		
		JList list = new JList();
		list.setBounds(332, 487, -65, -38);
		contentPane.add(list);
		
		totalSelectedDaysCount = new JTextField();
		totalSelectedDaysCount.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		totalSelectedDaysCount.setEditable(false);
		totalSelectedDaysCount.setBounds(375, 382, 79, 49);
		contentPane.add(totalSelectedDaysCount);
		totalSelectedDaysCount.setColumns(10);
		totalSelectedDaysCount.setText(String.valueOf(daysCount));	
		
		String dailyHoursArray [] = {"0","1","2","3","4","5","6","7","8","9","10","11","12"};
		String dailyMinArray [] = {"0","30"};
	
		JComboBox<Object> dailyHours = new JComboBox<Object>(dailyHoursArray);
		dailyHours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		dailyHours.setBounds(375, 497, 79, 44);
		contentPane.add(dailyHours);
		

		JComboBox<Object> dailyMinutes = new JComboBox<Object>(dailyMinArray);
		dailyMinutes.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		dailyMinutes.setBounds(552, 497, 87, 44);
		contentPane.add(dailyMinutes);
		
		//SAVE Button
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnect.getConnection();
					int selectedDailyHours = Integer.parseInt(String.valueOf(dailyHours.getSelectedItem() ));
					int selectedDailyMins = Integer.parseInt(String.valueOf(dailyMinutes.getSelectedItem()) );
								
					if(monday) {
						String sql1 = "insert into WorkingDays (day, hours, minutes) values ('Monday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql1);
					}
					else if(tuesday) {
						String sql2 = "insert into WorkingDays (day, hours, minutes) values ('Tuesday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql2);
					}
					else if(wednesday) {
						String sql3 = "insert into WorkingDays (day, hours, minutes) values ('Wednesday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql3);
					}
					else if(thursday) {
						String sql4 = "insert into WorkingDays (day, hours, minutes) values ('Thursday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql4);
					}
					else if(friday) {
						String sql5 = "insert into WorkingDays (day, hours, minutes) values ('Friday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";			
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql5);
					}
					else if(saturday) {
						String sql6 = "insert into WorkingDays (day, hours, minutes) values ('Saturday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql6);
					}
					else {
						String sql7 = "insert into WorkingDays (day, hours, minutes) values ('Sunday', '"+selectedDailyHours+"', '"+selectedDailyMins+"')";	
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql7);
					}
					JOptionPane.showMessageDialog(null, "Insertion Successful");	
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		//UPDATE Button
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//chckbxSaturday.get
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		//DELETE Button
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					JOptionPane.showMessageDialog(null, "Deletion Successful");
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
	
	}
	
	
}