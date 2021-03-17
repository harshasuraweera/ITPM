package IT19216492;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.mysql.cj.result.StringValueFactory;

import database.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AddStudentGroups extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGroups frame = new AddStudentGroups();
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
	public AddStudentGroups() {
		
		//do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Add Location");
		
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
		
		
		
		JButton btnNewButton_1 = new JButton(" Back To Home");
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 225, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Manage Student Groups");
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(978, 10, 264, 50);
		panel.add(btnNewButton_1_1);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Add Student Groups");
		lblNewLabel_1.setBounds(451, 96, 347, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		
		
		
		
		JLabel lblAcademic = new JLabel("Academic Year & Semester");
		lblAcademic.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblAcademic.setBounds(41, 240, 245, 46);
		contentPane.add(lblAcademic);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		comboBox.setBounds(317, 248, 282, 36);
		contentPane.add(comboBox);
		
		comboBox.addItem("");
		comboBox.addItem("Y1S1");
		comboBox.addItem("Y1S2");
		comboBox.addItem("Y2S1");
		comboBox.addItem("Y2S2");
		comboBox.addItem("Y3S1");
		comboBox.addItem("Y3S2");
		comboBox.addItem("Y4S1");
		comboBox.addItem("Y4S2");
		
		
		
		JLabel lblProgramme = new JLabel("Degree Programme");
		lblProgramme.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblProgramme.setBounds(41, 329, 213, 46);
		contentPane.add(lblProgramme);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		comboBox_1.setBounds(317, 337, 282, 36);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("");
		comboBox_1.addItem("IT");
		comboBox_1.addItem("SE");
		comboBox_1.addItem("IM");
		comboBox_1.addItem("ICS");
		comboBox_1.addItem("DS");
		comboBox_1.addItem("CS");
		comboBox_1.addItem("CSNE");
		
		
		
		JLabel lblGroupNum = new JLabel("Group Numbers");
		lblGroupNum.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblGroupNum.setBounds(41, 412, 213, 46);
		contentPane.add(lblGroupNum);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		spinner.setBounds(317, 420, 103, 36);
		contentPane.add(spinner);
		
		
		

		JLabel lblSubGroup = new JLabel("Sub Group Numbers");
		lblSubGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSubGroup.setBounds(41, 510, 213, 46);
		contentPane.add(lblSubGroup);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		spinner_1.setBounds(317, 518, 103, 36);
		contentPane.add(spinner_1);
		
		
		
		
		JLabel lblGroupID = new JLabel("Group ID");
		lblGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblGroupID.setBounds(694, 240, 174, 46);
		contentPane.add(lblGroupID);
		
		textField = new JTextField();
		textField.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(890, 246, 282, 36);
		contentPane.add(textField);
		
		
		
		JLabel lblSubGroupID = new JLabel("Sub Group ID");
		lblSubGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSubGroupID.setBounds(694, 319, 174, 46);
		contentPane.add(lblSubGroupID);
			
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(890, 325, 282, 36);
		contentPane.add(textField_1);
		
		
		
		
		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				spinner.setValue(0);
				spinner_1.setValue(0);
				textField.setText(" ");
				textField_1.setText(" ");
				
				
			}
		});
		
		
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(287, 609, 225, 50);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("") || comboBox_1.getSelectedItem().equals("") || spinner.getValue().equals("") || spinner_1.getValue().equals("") || textField.getText().equals("") || textField_1.getText().equals("")) {
					
					JLabel label = new JLabel("Please Fill Complete Information");
 					label.setHorizontalAlignment(SwingConstants.CENTER);
 					JOptionPane.showMessageDialog(null, label);
				}
				else {
					
					String value1 = comboBox.getSelectedItem().toString();
					String value2 = comboBox_1.getSelectedItem().toString();
					String value3 = spinner.getValue().toString();
					String value4 = spinner_1.getValue().toString();
					String value5 = textField.getText();
					String value6 = textField_1.getText();
					
				
				
				try {
					
					Connection conn = DBConnect.getConnection();
					
					String query = "INSERT INTO StudentGroups values(null, '" + value1 + "','" + value2 + "','" + value3 + "', '" + value4 + "', '" + value5 + "', '" + value6 + "')";
					
					 Statement sta = conn.createStatement();
	                 int x = sta.executeUpdate(query);
	                 if (x == 0) 
	                 {
	                 	JLabel label = new JLabel("This is alredy exist");
	 					label.setHorizontalAlignment(SwingConstants.CENTER);
	 					JOptionPane.showMessageDialog(null, label);
	                 } 
	                 else
	                 {
	                 	JLabel label = new JLabel("Data Inserted Successfully");
	 					label.setHorizontalAlignment(SwingConstants.CENTER);
	 					JOptionPane.showMessageDialog(null, label);
	                 } 
	                 conn.close();
	             }
					catch (Exception exception) 
					{
	             	 System.out.println("Error!!");
	             }
				
				}	
			}
				
		});
		
		
		btnNewButton_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBounds(696, 609, 225, 50);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Generate ID");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(comboBox.getSelectedItem().toString()+"."+comboBox_1.getSelectedItem().toString()+"."+spinner.getValue().toString());
				textField_1.setText(comboBox.getSelectedItem().toString()+"."+comboBox_1.getSelectedItem().toString()+"."+spinner.getValue().toString()+"."+spinner_1.getValue().toString());
			}
		});
		
		btnNewButton_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1_1.setBounds(926, 438, 225, 50);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		
	
		
		
			
		//end default
	}
}
