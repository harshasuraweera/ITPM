package IT19216492;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.DBConnect;
import it19208718.HomeWindow;

import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DefaultSession extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultSession frame = new DefaultSession();
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
	public DefaultSession() {
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
		setTitle("Forza Timetable Management System - Default Session");
		
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
		btnNewButton_1.addActionListener(new ActionListener() {
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
		
		
		btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 225, 50);
		panel.add(btnNewButton_1);
	

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Default Session");
		lblNewLabel_1.setBounds(530, 171, 238, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 25));
		
		
		
		
		JButton btnNewButton_2 = new JButton("Default Session");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				 	DefaultSession DefaultSession = new DefaultSession();
					dispose();
					DefaultSession.setVisible(true);
				}
				
			});
		
		
		
		
		btnNewButton_2.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(77, 114, 203, 44);
		contentPane.add(btnNewButton_2);
		
		
		
		
		JButton btnNewButton = new JButton("Consecutive Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConsecutiveSession ConsecutiveSession = new ConsecutiveSession();
				dispose();
				ConsecutiveSession.setVisible(true);
			}
			
		});
		
		
		
		btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(302, 114, 203, 44);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_3 = new JButton("Parallel Session");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ParallelSession ParallelSession = new ParallelSession();
				dispose();
				ParallelSession.setVisible(true);
			}
			
		});
		
		
		
		
		btnNewButton_3.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBounds(530, 114, 203, 44);
		contentPane.add(btnNewButton_3);
		
		
		
		JButton btnNewButton_3_1 = new JButton("NonOverlapping Session");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NonOverlappingSession NonOverlappingSession = new NonOverlappingSession();
				dispose();
				NonOverlappingSession.setVisible(true);
			}
			
		});
		
		
		
		
		btnNewButton_3_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3_1.setFocusable(false);
		btnNewButton_3_1.setBounds(760, 114, 221, 44);
		contentPane.add(btnNewButton_3_1);
		
		
		
		JButton btnNewButton_3_1_1 = new JButton("Not Available Times");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		btnNewButton_3_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3_1_1.setFocusable(false);
		btnNewButton_3_1_1.setBounds(1010, 114, 203, 44);
		contentPane.add(btnNewButton_3_1_1);
		
		
		
		
		table = new JTable();
		table.setBounds(207, 226, 891, 366);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(207, 226, 891, 366);
		contentPane.add(scrollBar);
		
		
		
		
		
		JButton btnNewButton_3_1_1_1 = new JButton("Set As Consecutive");
		btnNewButton_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
				
			Connection conn = DBConnect.getConnection();
			
			
			TableModel model = table.getModel();
			int indexs[] = table.getSelectedRows();
			
			
			Object [] row = new Object[2];
				
				for(int i=0; i < indexs.length; i++) 
				
					
				{
					
					row[0] = model.getValueAt(indexs [i], 0);
					row[1] = model.getValueAt(indexs [i], 1);
					
					
				String randomId = UUID.randomUUID().toString();	
				
					
				String query = "INSERT INTO ConsecutiveSession (consGroup, sessionId) values('"+String.valueOf(randomId)+"','"+row[0]+"')";
				Statement sta = conn.createStatement();
				sta.executeUpdate(query);
				
				String query1 = "UPDATE Sessions SET sessionType = 'consecutive' WHERE id = '"+row[0]+"'";
				Statement sta1 = conn.createStatement();
				sta1.executeUpdate(query1);
				ShowData();
				
				}				
				  conn.close();
            }
				catch (Exception exception) 
				{
            	 System.out.println(exception.getMessage().toString());
            }
			}
		
				
			
				
				
	}); 
			

		
		btnNewButton_3_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3_1_1_1.setFocusable(false);
		btnNewButton_3_1_1_1.setBounds(264, 615, 221, 44);
		contentPane.add(btnNewButton_3_1_1_1);
		
		
		
		JButton btnNewButton_3_1_1_1_1 = new JButton("Set As Parallel");
		btnNewButton_3_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				
			Connection conn = DBConnect.getConnection();
			
			
			TableModel model = table.getModel();
			int indexs[] = table.getSelectedRows();
			
			
			Object [] row = new Object[2];
				
				for(int i=0; i < indexs.length; i++) 
				
					
				{
					
					row[0] = model.getValueAt(indexs [i], 0);
					row[1] = model.getValueAt(indexs [i], 1);
					
				String randomId = UUID.randomUUID().toString();
					
				String query = "INSERT INTO ParallelSession (paraGroup, sessionId) values('"+String.valueOf(randomId)+"','"+row[0]+"')";
				Statement sta = conn.createStatement();
				sta.executeUpdate(query);
				
				String query1 = "UPDATE Sessions SET sessionType = 'parallel' WHERE id = '"+row[0]+"'";
				Statement sta1 = conn.createStatement();
				sta1.executeUpdate(query1);
				ShowData();
				
				}				
				  conn.close();
            }
				catch (Exception exception) 
				{
            	 System.out.println(exception.getMessage().toString());
            }
			}
		
				
			
				
				
	}); 
			
		
		
		
		
		btnNewButton_3_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3_1_1_1_1.setFocusable(false);
		btnNewButton_3_1_1_1_1.setBounds(550, 615, 221, 44);
		contentPane.add(btnNewButton_3_1_1_1_1);
		
		
		
		JButton btnNewButton_3_1_1_1_1_1 = new JButton("Set As NonOverlapping");
		btnNewButton_3_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection conn = DBConnect.getConnection();
					
					
					TableModel model = table.getModel();
					int indexs[] = table.getSelectedRows();
					
					
					Object [] row = new Object[2];
						
						for(int i=0; i < indexs.length; i++) 
						
							
						{
							
							row[0] = model.getValueAt(indexs [i], 0);
							row[1] = model.getValueAt(indexs [i], 1);
							
				String randomId = UUID.randomUUID().toString();
							
				String query = "INSERT INTO NonOverlappingSession (nonGroup, sessionId) values('"+String.valueOf(randomId)+"','"+row[0]+"')";
				Statement sta = conn.createStatement();
				sta.executeUpdate(query);
				
				String query1 = "UPDATE Sessions SET sessionType = 'nonOverlapping' WHERE id = '"+row[0]+"'";
				Statement sta1 = conn.createStatement();
				sta1.executeUpdate(query1);
				ShowData();
				
				}				
				  conn.close();
            }
				catch (Exception exception) 
				{
            	 System.out.println(exception.getMessage().toString());
            }
			}
		
				
			
				
				
	}); 
			
		
		
		
		btnNewButton_3_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_3_1_1_1_1_1.setFocusable(false);
		btnNewButton_3_1_1_1_1_1.setBounds(825, 615, 221, 44);
		contentPane.add(btnNewButton_3_1_1_1_1_1);
		

		
		
	}
	
	private void ShowData() {
		
		Connection conn = DBConnect.getConnection();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("lecturer1");
		model.addColumn("lecturer2");
		model.addColumn("subjectCode");
		model.addColumn("subjectName");
		model.addColumn("groupId");
		model.addColumn("tag");
		model.addColumn("nOfStudents");
		model.addColumn("duration");

		try {
			
			String sql = "SELECT * FROM Sessions WHERE sessionType = 'default'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("lecturer1"),
						rs.getString("lecturer2"),
						rs.getString("subjectCode"),
						rs.getString("subjectName"),
						rs.getString("groupId"),
						rs.getString("tag"),
						rs.getString("nOfStudents"),
						rs.getString("duration"),
						
						
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
			table.getColumnModel().getColumn(7).setPreferredWidth(140);
			table.getColumnModel().getColumn(8).setPreferredWidth(140);
			
			
		}catch (Exception e) {
			
		}
		
	}
}
	
