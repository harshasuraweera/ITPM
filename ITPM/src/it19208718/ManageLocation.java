package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.result.StringValueFactory;

import database.DBConnect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageLocation extends JFrame {

	private JPanel contentPane;
	private JTable locationTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocation frame = new ManageLocation();
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
	public ManageLocation() {
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
		setTitle("Forza Timetable Management System - Manage Location");
		
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
		btnNewButton_1.setBounds(41, 10, 225, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add Locations");
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(1014, 10, 225, 50);
		panel.add(btnNewButton_1_1);
		
		//end default
		
		
		JLabel lblNewLabel_1 = new JLabel("Manage Location");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(484, 105, 306, 44);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 237, 805, 306);
		contentPane.add(scrollPane);
		
		locationTable = new JTable();
		scrollPane.setViewportView(locationTable);
		
		JLabel name = new JLabel();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setBounds(986, 329, 113, 58);
		contentPane.add(name);
		
		JLabel room = new JLabel();
		room.setFont(new Font("Tahoma", Font.PLAIN, 18));
		room.setBounds(986, 416, 113, 58);
		contentPane.add(room);
		
		JLabel type = new JLabel();
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBounds(986, 505, 113, 58);
		contentPane.add(type);
		
		JLabel capacity = new JLabel();
		capacity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		capacity.setBounds(986, 598, 113, 58);
		contentPane.add(capacity);
		
		
		DefaultTableModel locationTableModel = (DefaultTableModel)locationTable.getModel();
		
		
//		locationTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//	        public void valueChanged(ListSelectionEvent event) {
//	            // do some actions here, for example
//	            // print first column value from selected row
//	            System.out.println(locationTable.getValueAt(locationTable.getSelectedRow(), 0).toString());
//	        }
//	    });
		
		locationTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(locationTable.getValueAt(locationTable.getSelectedRow(), 0).toString());
				name.setText(locationTable.getValueAt(locationTable.getSelectedRow(), 1).toString());
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	
	private void ShowData() {
		
		Connection conn = DBConnect.getConnection();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Building Name");
		model.addColumn("Room Name");
		model.addColumn("Room Type"); 
		model.addColumn("Capacity");
		
		try {
			
			String sql = "SELECT * FROM Locations";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("buildingName"),
						rs.getString("roomName"),
						rs.getString("roomType"),
						rs.getString("capacity"),
				});;
			}
			
			rs.close();
			st.close();
			conn.close();
			
			locationTable.setModel(model);
			locationTable.setAutoResizeMode(0);
			locationTable.getColumnModel().getColumn(0).setPreferredWidth(80);
			locationTable.getColumnModel().getColumn(1).setPreferredWidth(140);
			locationTable.getColumnModel().getColumn(2).setPreferredWidth(140);
			locationTable.getColumnModel().getColumn(3).setPreferredWidth(140);
			locationTable.getColumnModel().getColumn(4).setPreferredWidth(140);
			
			
			
		}catch (Exception e) {
			
		}
		
	}
}
