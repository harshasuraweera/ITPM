//IT19142692
//Anuththara K.G.S.N

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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import it19208718.HomeWindow;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageNotAvailableTimes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField time;

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

	public ManageNotAvailableTimes() {
	
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
		
		//navigation buttons
		JButton btnHome = new JButton("Back to Home");
		btnHome.addActionListener(new ActionListener() {
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
		
		//Storing details in arrays
		String lecturerArray [] = {null,"Nasir Mohomadh","Yasiru Gunasinghe","Nisitha Fernando","Kavindu Gunasinghe","Pasan Abesinghe"};
		String groupArray [] = {null,"Y3S1.CS.4","Y2S2.ICS.5","Y3S2.ICS.6","Y2S1.DS.6","Y2S1.ICS.2","Y1S2.IM.3"};
		String subgroupArray [] = {null,"Y3S1.CS.4.7","Y2S2.ICS.5.5","Y3S2.ICS.6.5","Y2S1.DS.6.4","Y2S1.ICS.2.2","Y1S2.IM.3.3"};
		String sessionidArray [] = {null,"6","7","8","9","10","18"};
		String roomArray [] = {null,"B506","B403","A406","CyberSecLab","B501","B502"};
		
		
		JLabel lblLecturer = new JLabel("Select Lecturer");
		lblLecturer.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblLecturer.setBounds(24, 412, 189, 42);
		contentPane.add(lblLecturer);
		
		JComboBox<Object> lect = new JComboBox<Object>(lecturerArray);
		lect.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lect.setBounds(203, 411, 202, 44);
		contentPane.add(lect);
		
		JLabel lblGroup = new JLabel("Select Group");
		lblGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblGroup.setBounds(24, 490, 154, 50);
		contentPane.add(lblGroup);
		
		JComboBox<Object> grp = new JComboBox<Object>(groupArray);
		grp.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		grp.setBounds(203, 493, 202, 44);
		contentPane.add(grp);
		
		JLabel lblSubGroup = new JLabel("Select Sub Group");
		lblSubGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSubGroup.setBounds(24, 574, 162, 50);
		contentPane.add(lblSubGroup);
		
		JComboBox<Object> subgrp = new JComboBox<Object>(subgroupArray);
		subgrp.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		subgrp.setBounds(203, 580, 202, 44);
		contentPane.add(subgrp);
		
		JLabel lblSession = new JLabel("Select Session ID");
		lblSession.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblSession.setBounds(529, 414, 162, 50);
		contentPane.add(lblSession);
		
		JComboBox<Object> sessionId = new JComboBox<Object>(sessionidArray);
		sessionId.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		sessionId.setBounds(701, 414, 202, 44);
		contentPane.add(sessionId);
		
		JLabel lblRoom = new JLabel("Select Room");
		lblRoom.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoom.setBounds(555, 505, 128, 50);
		contentPane.add(lblRoom);
		
		JComboBox<Object> room = new JComboBox<Object>(roomArray);
		room.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		room.setBounds(700, 508, 202, 44);
		contentPane.add(room);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblTime.setBounds(592, 577, 81, 50);
		contentPane.add(lblTime);
		
		time = new JTextField();
		time.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		time.setColumns(10);
		time.setBounds(701, 584, 202, 44);
		contentPane.add(time);
		
		//Load the Table
		JButton btnRefresh = new JButton("UPDATE");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String lec = lect.getSelectedItem().toString();
					String gr = grp.getSelectedItem().toString();
					String sg = subgrp.getSelectedItem().toString();
					String si = sessionId.getSelectedItem().toString();
					String rm = room.getSelectedItem().toString();
					String ti = time.getText().toString();
									
					Connection conn = DBConnect.getConnection();
					int i=table.getSelectedRow();
					int selectedRowId = Integer.parseInt(table.getValueAt(i,0).toString());
					String sql1 = "update NotAvailableTimes set nlecturer='"+lec+"',ngroup='"+gr+"',nsubgroup='"+sg+"',nsessionid='"+si+"',nroom='"+rm+"',ntime='"+ti+"' where nid='"+selectedRowId+"'";
					Statement st = conn.createStatement();
					int rs = st.executeUpdate(sql1);
					ShowData();
					
					//Show a successful message
					JOptionPane.showMessageDialog(null, "Successfully updated the table.");
					
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
		btnRefresh.setBounds(1015, 175, 162, 50);
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
		btnBack.setBounds(1015, 272, 162, 50);
		contentPane.add(btnBack);
		
		//DELETE Button
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DBConnect.getConnection();
					int row = table.getSelectedRow();
					
					//get table model first
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					//delete row
					if(table.getSelectedRowCount()==1) {
						//model.removeRow(table.getSelectedRow());	
						String cell = table.getModel().getValueAt(row, 0).toString();
						String sql1 = "delete from NotAvailableTimes where nid = '"+cell+"'";
						Statement st = conn.createStatement();
						int rs = st.executeUpdate(sql1);
						ShowData();
						JOptionPane.showMessageDialog(null, "Deleted from the table.");
					}
					else {
						if(table.getSelectedRowCount()==0) {
							JOptionPane.showMessageDialog(null, "Select a row to delete.");
						}
						else {
							JOptionPane.showMessageDialog(null, "Please select single row at a time to delete.");
						}
					}
					
					conn.close();
				}
				catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setBounds(1015, 375, 162, 50);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 147, 942, 257);
		contentPane.add(scrollPane);
		
		//Table
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
		int i=table.getSelectedRow();
			lect.setSelectedItem(table.getValueAt(i, 1).toString());
			grp.setSelectedItem(table.getValueAt(i, 2).toString());
			subgrp.setSelectedItem(table.getValueAt(i, 3).toString());
			sessionId.setSelectedItem(table.getValueAt(i, 4).toString());
			room.setSelectedItem(table.getValueAt(i, 5).toString());
			time.setText(table.getValueAt(i, 6).toString());
		}
		});

		scrollPane.setViewportView(table);
		table.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
	
	}
	
	//Show data
	private void ShowData() {
		Connection conn = DBConnect.getConnection();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Lecturer");
		model.addColumn("Group");
		model.addColumn("SubGroup");
		model.addColumn("SessionId");
		model.addColumn("Room");
		model.addColumn("Time");
		try {
		String sql = "SELECT * FROM NotAvailableTimes";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
		model.addRow(new Object[] {
		rs.getString("nid"),
		rs.getString("nlecturer"),
		rs.getString("ngroup"),
		rs.getString("nsubgroup"),
		rs.getString("nsessionid"),
		rs.getString("nroom"),
		rs.getString("ntime"),
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
		table.getColumnModel().getColumn(6).setPreferredWidth(160);

		}catch (Exception e) {
		}
		}
		
}
