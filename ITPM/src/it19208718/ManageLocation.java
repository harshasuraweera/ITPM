package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;

public class ManageLocation extends JFrame {

	private JPanel contentPane;
	private JTable locationTable;
	private JScrollPane scrollPane;
	private JTextField buildingNameTxt;
	private JTextField roomNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public ManageLocation() throws IOException{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showLocations();
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
		
		JButton btnBackToHome = new JButton(" Back To Home");
		btnBackToHome.addActionListener(new ActionListener() {
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
		btnBackToHome.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
		btnBackToHome.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnBackToHome.setFocusable(false);
		btnBackToHome.setBounds(24, 10, 225, 50);
		panel.add(btnBackToHome);
		
		
		JButton btnNewButton_1_1 = new JButton("Add Locations");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddLocation AddLocation = new AddLocation();
					dispose();
					AddLocation.setVisible(true);
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("location3.png")));
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(1014, 10, 225, 50);
		panel.add(btnNewButton_1_1);
		
		//end default
		
		
		JLabel lblNewLabel_1 = new JLabel("Manage Location");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(484, 98, 306, 44);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 179, 805, 306);
		contentPane.add(scrollPane);
		
		locationTable = new JTable();
		scrollPane.setViewportView(locationTable);
		
		JButton updateLocation = new JButton("Update");
		updateLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		updateLocation.setFocusable(false);
		updateLocation.setBounds(917, 358, 120, 50);
		contentPane.add(updateLocation);
		
		JButton deleteLocation = new JButton("Delete");
		deleteLocation.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		deleteLocation.setFocusable(false);
		deleteLocation.setBounds(1069, 358, 120, 50);
		contentPane.add(deleteLocation);
		
		JLabel lblNewLabel = new JLabel("Building Name");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 527, 138, 46);
		contentPane.add(lblNewLabel);
		
		buildingNameTxt = new JTextField();
		buildingNameTxt.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		buildingNameTxt.setColumns(10);
		buildingNameTxt.setBounds(222, 536, 272, 36);
		contentPane.add(buildingNameTxt);
		
		JLabel lblNewLabel_2 = new JLabel("Room Name");
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(69, 587, 138, 46);
		contentPane.add(lblNewLabel_2);
		
		roomNameTxt = new JTextField();
		roomNameTxt.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomNameTxt.setColumns(10);
		roomNameTxt.setBounds(222, 596, 272, 36);
		contentPane.add(roomNameTxt);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoomType.setBounds(551, 527, 123, 46);
		contentPane.add(lblRoomType);
		
		JRadioButton lecRadioBtn = new JRadioButton("Lecture Hall");
		buttonGroup.add(lecRadioBtn);
		
		lecRadioBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lecRadioBtn.setFocusPainted(false);
		lecRadioBtn.setBackground((Color) null);
		lecRadioBtn.setActionCommand("Lecture Hall");
		lecRadioBtn.setBounds(704, 527, 174, 46);
		contentPane.add(lecRadioBtn);
		
		JRadioButton labRadioBtn = new JRadioButton("Laboratory");
		buttonGroup.add(labRadioBtn);
		labRadioBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		labRadioBtn.setFocusPainted(false);
		labRadioBtn.setBackground((Color) null);
		labRadioBtn.setActionCommand("Laboratory");
		labRadioBtn.setBounds(887, 527, 204, 46);
		contentPane.add(labRadioBtn);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblCapacity.setBounds(551, 586, 130, 46);
		contentPane.add(lblCapacity);
		
		JSpinner roomCapacity = new JSpinner();
		roomCapacity.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		roomCapacity.setBounds(712, 587, 196, 46);
		contentPane.add(roomCapacity);
		
		JLabel operationStatus = new JLabel("");
		operationStatus.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		operationStatus.setBounds(917, 420, 272, 65);
		contentPane.add(operationStatus);
		
		
		
		updateLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(locationTable.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "You should select a row to update!", "Error",
					        JOptionPane.ERROR_MESSAGE);
				}else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Operation cannot be undone! Do you want to continue?","Warning",dialogButton);
					
					if(dialogResult == JOptionPane.YES_OPTION){
						
						
						boolean isSuccess = updateLocation(Integer.valueOf(locationTable.getValueAt(locationTable.getSelectedRow(), 0).toString()),
								buildingNameTxt.getText().toString(), 
								roomNameTxt.getText().toString(),
								buttonGroup.getSelection().getActionCommand(),
								Integer.parseInt(roomCapacity.getValue().toString()));
						
						if(isSuccess) {
							
							buildingNameTxt.setText(null);
							roomNameTxt.setText(null);
							roomCapacity.setValue(Integer.valueOf(0));
							
							operationStatus.setForeground(Color.decode("#038013"));
							operationStatus.setText("Successfully updated!");
							lecRadioBtn.setSelected(false);
							labRadioBtn.setSelected(false);
						}else {
						
							operationStatus.setForeground(Color.decode("#b50727"));
							operationStatus.setText("<html>Something went wrong.<br>Try again!</html>");
						}
						
					}
				}
				
				
				
			}
		});
		
		deleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(locationTable.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "You should select a row to delete!", "Error",
					        JOptionPane.ERROR_MESSAGE);
				}else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to permanently delete this location?","Warning",dialogButton);
					
					if(dialogResult == JOptionPane.YES_OPTION){
						
						
						boolean isSuccess = deleteLocation(Integer.valueOf(locationTable.getValueAt(locationTable.getSelectedRow(), 0).toString()));
						if(isSuccess) {
							
							buildingNameTxt.setText(null);
							roomNameTxt.setText(null);
							roomCapacity.setValue(Integer.valueOf(0));
							
							operationStatus.setForeground(Color.decode("#038013"));
							operationStatus.setText("Successfully deleted!");
							lecRadioBtn.setSelected(false);
							labRadioBtn.setSelected(false);
						}else {
						
							operationStatus.setForeground(Color.decode("#b50727"));
							operationStatus.setText("<html>Something went wrong.<br>Try again!</html>");
						}
						
					}
				}
				

				
			}
		});
		
		
		locationTable.getTableHeader().setFont(new Font("Kristen ITC", Font.BOLD, 12));
		
		locationTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
				buildingNameTxt.setText(locationTable.getValueAt(locationTable.getSelectedRow(), 1).toString());
				roomNameTxt.setText(locationTable.getValueAt(locationTable.getSelectedRow(), 2).toString());
				
				if (locationTable.getValueAt(locationTable.getSelectedRow(), 3).toString().equals("Lecture Hall")) {
					lecRadioBtn.setSelected(true);
				}else {
					labRadioBtn.setSelected(true);
				}
				roomCapacity.setValue(Integer.valueOf(locationTable.getValueAt(locationTable.getSelectedRow(), 4).toString()));
				
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
	
	
	private void showLocations() {


		
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
			locationTable.setAutoResizeMode(1);
			locationTable.setFillsViewportHeight( true );
			locationTable.setRowHeight(30);
			locationTable.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
			
			
		}catch (Exception e) {
			
		}
		
	}


	private boolean deleteLocation(int rowId) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "DELETE FROM Locations WHERE id = '"+rowId+"' ";
			
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			
			st.close();
			conn.close();
			showLocations();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
			
		}	
		
		return isSuccess;
	}
	
	
	private boolean updateLocation(int rowId, String buildingName, String roomName, String roomType, int capacity) {
		
		boolean isSuccess = false;
		
		Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "UPDATE Locations SET buildingName = '"+buildingName+"', roomName = '"+roomName+"', roomType = '"+roomType+"', capacity = '"+capacity+"' WHERE id = '"+rowId+"' ";
			
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			
			st.close();
			conn.close();
			showLocations();
			isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
			
		}	
		
		return isSuccess;
	}
	
	
	
}
