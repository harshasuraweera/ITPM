package IT19216492;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import it19208718.HomeWindow;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageStudentGroups extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	//private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups frame = new ManageStudentGroups();
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
	public ManageStudentGroups() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		
		//do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Manage Student Groups");
		
		//set Icon to the window
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
		setIconImage(img.getImage());
		
		//inner contentPane
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 204, 255));
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 153));
		panel.setBounds(0, 0, 1266, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton(" Add Student Groups");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudentGroups addStudentGroups = new AddStudentGroups();
				dispose();
				addStudentGroups.setVisible(true);
			
			}
		});
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 264, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(" Back To Home");
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(948, 10, 294, 50);
		panel.add(btnNewButton_1_1);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Manage Student Groups");
		lblNewLabel_1.setBounds(544, 85, 278, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		
		
		
		
		JLabel lblAcademic = new JLabel("Academic Year & Semester");
		lblAcademic.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblAcademic.setBounds(76, 489, 199, 25);
		contentPane.add(lblAcademic);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox.setBounds(317, 489, 213, 25);
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
		lblProgramme.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblProgramme.setBounds(76, 536, 149, 25);
		contentPane.add(lblProgramme);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox_1.setBounds(317, 536, 213, 25);
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
		lblGroupNum.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblGroupNum.setBounds(76, 585, 131, 25);
		contentPane.add(lblGroupNum);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		spinner.setBounds(427, 584, 103, 25);
		contentPane.add(spinner);
		
		
		

		JLabel lblSubGroup = new JLabel("Sub Group Numbers");
		lblSubGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblSubGroup.setBounds(657, 489, 149, 25);
		contentPane.add(lblSubGroup);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		spinner_1.setBounds(953, 488, 103, 25);
		contentPane.add(spinner_1);
		
		
		
		
		JLabel lblGroupID = new JLabel("Group ID");
		lblGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblGroupID.setBounds(657, 536, 116, 25);
		contentPane.add(lblGroupID);
		
		textField = new JTextField();
		textField.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(843, 536, 213, 25);
		contentPane.add(textField);
		
		
		
		JLabel lblSubGroupID = new JLabel("Sub Group ID");
		lblSubGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblSubGroupID.setBounds(657, 583, 116, 25);
		contentPane.add(lblSubGroupID);
			
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(843, 578, 213, 25);
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
		
		
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(381, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					Connection conn = DBConnect.getConnection();
					
					int i=table.getSelectedRow();
					
					int selectedRowId = Integer.parseInt(table.getValueAt(i,0).toString());
					
					String query = "DELETE FROM StudentGroups WHERE id='"+selectedRowId+"'";         
	            	
					 Statement sta = conn.createStatement();
	                 int x = sta.executeUpdate(query);
	                 ShowData();
	                 if (x == 0) 
	                 {
	                 	JLabel label = new JLabel("This is alredy exist");
	 					label.setHorizontalAlignment(SwingConstants.CENTER);
	 					JOptionPane.showMessageDialog(null, label);
	                 } 
	                 else
	                 {
	                 	JLabel label = new JLabel("Data Delete Successfully");
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
			
				
		});
		
		
		btnNewButton_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBounds(612, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Generate ID");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(comboBox.getSelectedItem().toString()+"."+comboBox_1.getSelectedItem().toString()+"."+spinner.getValue().toString());
				textField_1.setText(comboBox.getSelectedItem().toString()+"."+comboBox_1.getSelectedItem().toString()+"."+spinner.getValue().toString()+"."+spinner_1.getValue().toString());
			}
		});
		
		
		btnNewButton_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1_1.setBounds(1092, 567, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
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
					
					int i=table.getSelectedRow();
					
					int selectedRowId = Integer.parseInt(table.getValueAt(i,0).toString());
					
					String query = "UPDATE `StudentGroups` SET `academicYearSemester`='" + value1 + "',`degreeProgramme`='" + value2 + "',`groupNumbers`='" + value3 + "',`subGroupNumbers`='" + value4 + "',`groupId`='" + value5 + "',`subGroupId`='" + value6 + "' WHERE id='"+selectedRowId+"'";
					
					 Statement sta = conn.createStatement();
	                 int x = sta.executeUpdate(query);
	                 ShowData();
	                 if (x == 0) 
	                 {
	                 	JLabel label = new JLabel("This is alredy exist");
	 					label.setHorizontalAlignment(SwingConstants.CENTER);
	 					JOptionPane.showMessageDialog(null, label);
	                 } 
	                 else
	                 {
	                 	JLabel label = new JLabel("Data Updated Successfully");
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
		
		
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1_1.setBounds(835, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 160, 922, 298);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i=table.getSelectedRow();
				
			    comboBox.setSelectedItem(table.getValueAt(i, 1).toString());
			    comboBox_1.setSelectedItem(table.getValueAt(i, 2).toString());
			    
			    spinner.setValue(Integer.parseInt(table.getValueAt(i, 3).toString()));
			    spinner_1.setValue(Integer.parseInt(table.getValueAt(i, 4).toString()));
				
				textField.setText(table.getValueAt(i, 5).toString());
				textField_1.setText(table.getValueAt(i, 6).toString());
				
			}
		});
		
		
		scrollPane.setViewportView(table);
		table.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		
		
		
	}
	
		private void ShowData() {
			
			Connection conn = DBConnect.getConnection();
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("academicYearSemester");
			model.addColumn("degreeProgramme");
			model.addColumn("groupNumbers"); 
			model.addColumn("subGroupNumbers");
			model.addColumn("groupId");
			model.addColumn("subGroupId");
			
			try {
				
				String sql = "SELECT * FROM StudentGroups";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString("id"),
							rs.getString("academicYearSemester"),
							rs.getString("degreeProgramme"),
							rs.getString("groupNumbers"),
							rs.getString("subGroupNumbers"),
							rs.getString("groupId"),
							rs.getString("subGroupId"),
					});;
				}
				
				rs.close();
				st.close();
				conn.close();
				
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(80);
				table.getColumnModel().getColumn(1).setPreferredWidth(140);
				table.getColumnModel().getColumn(2).setPreferredWidth(140);
				table.getColumnModel().getColumn(3).setPreferredWidth(140);
				table.getColumnModel().getColumn(4).setPreferredWidth(140);
				table.getColumnModel().getColumn(5).setPreferredWidth(140);
				table.getColumnModel().getColumn(6).setPreferredWidth(140);
				
				
				
			}catch (Exception e) {
				
			}
			
		}
	}
