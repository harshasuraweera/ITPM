package IT19142692;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;

public class ManageNotAvailableTimes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageNotAvailableTimes frame = new ManageNotAvailableTimes();
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
	public ManageNotAvailableTimes() {
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
		
		
		JButton btnManage = new JButton("Add Not Available Times");
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Go to the previous page
				AddNotAvailableTimes obj = new AddNotAvailableTimes();
				obj.setVisible(true);
			}
		});
		btnManage.setForeground(Color.WHITE);
		btnManage.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnManage.setFocusable(false);
		btnManage.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnManage.setBackground(new Color(0, 102, 255));
		btnManage.setBounds(962, 10, 269, 50);
		panel.add(btnManage);
		
		JLabel lblNewLabel = new JLabel("Manage Not Available Times");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(395, 95, 346, 42);
		contentPane.add(lblNewLabel);
		
		//Load the Table
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnect.getConnection();
					String query = "Select * from NotAvailableTimes";
					Statement stmt = conn.createStatement();
					ResultSet rs1 = stmt.executeQuery(query);
					
					//table.setModel(DbUtils.resultSetToTableModel(rs1));
					
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnRefresh.setFocusable(false);
		btnRefresh.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnRefresh.setBackground(new Color(30, 144, 255));
		btnRefresh.setBounds(346, 552, 162, 50);
		contentPane.add(btnRefresh);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Go to the previous page
				AddNotAvailableTimes obj = new AddNotAvailableTimes();
				obj.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnBack.setFocusable(false);
		btnBack.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(579, 552, 162, 50);
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setBounds(812, 552, 162, 50);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(184, 185, 811, 253);
		contentPane.add(table);
		
		Object[] column = {"ID","Duration","Lecturer","Group ID","Sub Group","SessionID","Room"};
		Object[] row = new Object[0];
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		//scrollPane.setViewportView(table);
	
	}
}
