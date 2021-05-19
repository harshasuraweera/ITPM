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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import it19208718.HomeWindow;

import javax.swing.JTable;
import javax.swing.JTextField;
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

public class ManageTags extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTags frame = new ManageTags();
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
	public ManageTags() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		
		//do these for each and every JFrame ZZ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Manage Tags");
		
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
		
		
		
		JButton btnNewButton_1 = new JButton(" Add Tags");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddTags addTags = new AddTags();
				dispose();
				addTags.setVisible(true);
			}
		});

		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 225, 50);
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

		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(978, 10, 264, 50);
		panel.add(btnNewButton_1_1);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Manage Tags");
		lblNewLabel_1.setBounds(615, 82, 172, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 25));
		
		
		
		
		JLabel lblTagName = new JLabel("Tag Name");
		lblTagName.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		lblTagName.setBounds(403, 489, 116, 37);
		contentPane.add(lblTagName);
		
		textField = new JTextField();
		textField.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(721, 496, 213, 25);
		contentPane.add(textField);
		
		
		
		
		JLabel lblRelatedTag = new JLabel("Related Tag");
		lblRelatedTag.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		lblRelatedTag.setBounds(403, 547, 116, 37);
		contentPane.add(lblRelatedTag);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox_1.setBounds(721, 554, 213, 25);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("");
		comboBox_1.addItem("Lecture");
		comboBox_1.addItem("Lab");
		comboBox_1.addItem("Tutorial");
		comboBox_1.addItem("Practical");
		comboBox_1.addItem("Evaluation");
		comboBox_1.addItem("Lecture and Tute");
		
		
		
		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(" ");
				comboBox_1.setSelectedIndex(0);
			}
		});
		
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(313, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conn = DBConnect.getConnection();
					
					int i=table.getSelectedRow();
					
					int selectedRowId = Integer.parseInt(table.getValueAt(i,0).toString());
					
					String query = "DELETE FROM Tags WHERE id='"+selectedRowId+"'";         
	            	
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
		btnNewButton_1_1_1_1.setBounds(568, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
if(textField.getText().equals("") || comboBox_1.getSelectedItem().equals("")) {
					
					JLabel label = new JLabel("Please Fill Complete Information");
 					label.setHorizontalAlignment(SwingConstants.CENTER);
 					JOptionPane.showMessageDialog(null, label);
				}
				else {
					
					String value1 = textField.getText();
					String value2 = comboBox_1.getSelectedItem().toString();
					
				
				try {
					
					Connection conn = DBConnect.getConnection();
					
					int i=table.getSelectedRow();
					
					int selectedRowId = Integer.parseInt(table.getValueAt(i,0).toString());
					
					String query = "UPDATE `Tags` SET `tagName`='" + value1 + "',`relatedTag`='" + value2 + "' WHERE id='"+selectedRowId+"'";
					
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
		
		
		
		btnNewButton_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBounds(839, 635, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(512, 155, 363, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i=table.getSelectedRow();
				
				textField.setText(table.getValueAt(i, 1).toString());
			    comboBox_1.setSelectedItem(table.getValueAt(i, 2).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		
	}
	
	private void ShowData() {
			
			Connection conn = DBConnect.getConnection();
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("tagName");
			model.addColumn("relatedTag");
			
			
			try {
				
				String sql = "SELECT * FROM Tags";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString("id"),
							rs.getString("tagName"),
							rs.getString("relatedTag"),
							
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
				
				
			}catch (Exception e) {
				
			}
			
		}
	}
