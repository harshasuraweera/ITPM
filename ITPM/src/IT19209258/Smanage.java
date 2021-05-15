package IT19209258;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import it19208718.AddSomething;
import it19208718.HomeWindow;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class Smanage extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField scode;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Smanage frame = new Smanage();
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
	public Smanage() {
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
				panel.setBounds(0, 0, 1274, 70);
				contentPane.add(panel);
				panel.setLayout(null);
				
				//end default
				
				
				
				//navigation buttons
				JButton btnNewButton = new JButton("  Home");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						try {
							HomeWindow homewindow = new HomeWindow();
							dispose();
							homewindow.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							
						
						
					}
				});
				btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
				btnNewButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton.setBounds(999, 11, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				//end navignation button 01
				
				
				
				JButton btnNewButton_1 = new JButton("   Add New Subject");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						subject subject = new subject();
						dispose();
						subject.setVisible(true);
						
							
						
						
					}
				});
				btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("subject1.png")));
				btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton_1.setBounds(10, 11, 250, 50);
				btnNewButton_1.setFocusable(false);
				panel.add(btnNewButton_1);
				
				JButton btnUpdate = new JButton("Update");	
				btnUpdate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnUpdate.setFocusable(false);
				btnUpdate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnUpdate.setBounds(978, 139, 250, 50);
				contentPane.add(btnUpdate);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDelete.setFocusable(false);
				btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDelete.setBounds(978, 233, 250, 50);
				contentPane.add(btnDelete);
				
				JButton btnDone = new JButton("View");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(978, 320, 250, 50);
				contentPane.add(btnDone);
				
				JTextPane txtpnLecturerName = new JTextPane();
				txtpnLecturerName.setBackground(new Color(153, 204, 255));
				txtpnLecturerName.setEditable(false);
				txtpnLecturerName.setText("Offered Year");
				txtpnLecturerName.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerName.setBounds(117, 429, 121, 29);
				contentPane.add(txtpnLecturerName);
				
				JTextPane txtpnLecturerId = new JTextPane();
				txtpnLecturerId.setBackground(new Color(153, 204, 255));
				txtpnLecturerId.setEditable(false);
				txtpnLecturerId.setText("Offered Semester");
				txtpnLecturerId.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerId.setBounds(117, 492, 149, 29);
				contentPane.add(txtpnLecturerId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setBackground(new Color(153, 204, 255));
				txtpnFaculty.setEditable(false);
				txtpnFaculty.setText("Subject Name");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnFaculty.setBounds(117, 552, 121, 29);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setBackground(new Color(153, 204, 255));
				txtpnCenter.setEditable(false);
				txtpnCenter.setText("Subject Code");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnCenter.setBounds(117, 612, 121, 29);
				contentPane.add(txtpnCenter);
				
				sname = new JTextField();
				sname.setColumns(10);
				sname.setBounds(362, 552, 177, 29);
				contentPane.add(sname);
				
				scode = new JTextField();
				scode.setColumns(10);
				scode.setBounds(362, 612, 177, 29);
				contentPane.add(scode);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setEditable(false);
				txtpnDepartment.setBackground(new Color(153, 204, 255));
				txtpnDepartment.setText("Number of Lectures Hours");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnDepartment.setBounds(698, 429, 223, 29);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setBackground(new Color(153, 204, 255));
				txtpnBuilding.setEditable(false);
				txtpnBuilding.setText("Number of Lab Hours");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnBuilding.setBounds(698, 492, 141, 29);
				contentPane.add(txtpnBuilding);
				
				JTextPane txtpnLevel = new JTextPane();
				txtpnLevel.setBackground(new Color(153, 204, 255));
				txtpnLevel.setEditable(false);
				txtpnLevel.setText("Number of Tutorial Hours");
				txtpnLevel.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLevel.setBounds(698, 552, 223, 29);
				contentPane.add(txtpnLevel);
				
				JTextPane txtpnRank = new JTextPane();
				txtpnRank.setBackground(new Color(153, 204, 255));
				txtpnRank.setEditable(false);
				txtpnRank.setText("Number of Evaluation Hours");
				txtpnRank.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnRank.setBounds(698, 612, 241, 29);
				contentPane.add(txtpnRank);
				
				JSpinner offyear = new JSpinner();
				offyear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				offyear.setBounds(362, 429, 177, 29);
				contentPane.add(offyear);
				
				JSpinner offsem = new JSpinner();
				offsem.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				offsem.setBounds(362, 492, 177, 29);
				contentPane.add(offsem);
				
				JSpinner nlhours = new JSpinner();
				nlhours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nlhours.setBounds(991, 429, 177, 29);
				contentPane.add(nlhours);
				
				JSpinner nlbhours = new JSpinner();
				nlbhours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nlbhours.setBounds(991, 492, 177, 29);
				contentPane.add(nlbhours);
				
				JSpinner nthours = new JSpinner();
				nthours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nthours.setBounds(991, 552, 177, 29);
				contentPane.add(nthours);
				
				JSpinner nehours = new JSpinner();
				nehours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				nehours.setBounds(991, 612, 177, 29);
				contentPane.add(nehours);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(62, 114, 840, 279);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {

						offyear.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString()));
						offsem.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString()));
						sname.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
						scode.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
						nlhours.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString()));
						nlbhours.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString()));
						nthours.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 7).toString()));
						nehours.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString()));
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					


				});
				//table.setBounds(0, 0, 1, 1);
				scrollPane.setViewportView(table);
				
				
				
				
				
				//end navignation button 01
				
				//up----
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(table.getSelectionModel().isSelectionEmpty()) {
							JOptionPane.showMessageDialog(null, "Plesae Selecte the Row before pressing Update");
						}
						
						else {
							
							boolean isSuccess = updatesubject(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()),
									Integer.parseInt(offyear.getValue().toString()),
									Integer.parseInt(offsem.getValue().toString()),
									sname.getText().toString(), 
									scode.getText().toString(),
									Integer.parseInt(nlhours.getValue().toString()),
									Integer.parseInt(nlbhours.getValue().toString()),
									Integer.parseInt(nthours.getValue().toString()),
									Integer.parseInt(nehours.getValue().toString()));
							
							if(isSuccess) {
								JOptionPane.showMessageDialog(null, "Successfull update");
								ShowData();
								
							}else {
							
								JOptionPane.showMessageDialog(null, "Error");
	
							}
						}
						
					}
				});
				
				//del---
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(table.getSelectionModel().isSelectionEmpty()) {
							JOptionPane.showMessageDialog(null, "Plesae Selecte the Row before pressing Delete");
						}
						
						else {
							
							boolean isSuccess = deletesubject(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()));
								if(isSuccess) {
									JOptionPane.showMessageDialog(null, "Succesfull delete");
								ShowData();
		
								}else {
								
									JOptionPane.showMessageDialog(null, "error");
									
								}
						}
						
					}
						
				});
				
	}
		
	//up method
		private boolean updatesubject(int id, int offyear, int offsem, String sname, String scode, int nlhours, int nlbhours, 
				int nthours, int nehours) {
			
			boolean isSuccess = false;
			
			java.sql.Connection conn = DBConnect.getConnection();
			
			try {
				
				String sql = "UPDATE Subjects SET offyear = '"+offyear+"', offsem = '"+offsem+"', sname = '"+sname+"', scode = '"+scode+"',"
						+ " nlhours = '"+nlhours+"',"
						+ " nlbhours = '"+nlbhours+"', nthours = '"+nthours+"', nehours = '"+nehours+"' WHERE id = '"+id+"' ";
				
				Statement st1 = conn.createStatement();
				int rs = st1.executeUpdate(sql);
				
				st1.close();
				conn.close();
				isSuccess = true;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				isSuccess = false;
				
			}	
			
			return isSuccess;
		}
		
		//del metod
		private boolean deletesubject(int id) {
			
			boolean isSuccess = false;
			
			java.sql.Connection conn = DBConnect.getConnection();
			
			try {
				
				String sql = "DELETE FROM Subjects WHERE id = '"+id+"' ";
				
				Statement st2 = conn.createStatement();
				int rs = st2.executeUpdate(sql);
				
				st2.close();
				conn.close();
				isSuccess = true;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				isSuccess = false;
				
			}	
			
			return isSuccess;
		}
	
	
		//show data
	private void ShowData() {
		
	java.sql.Connection conn = DBConnect.getConnection();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Offer Year");
		model.addColumn("Offer Semester");
		model.addColumn("Subject Name"); 
		model.addColumn("Subject Code");
		model.addColumn("Lecture Hours");
		model.addColumn("Lab Hours");
		model.addColumn("Tute Hours");
		model.addColumn("Evaluation Hours");
		
		try {
			
			String sql = "SELECT * FROM Subjects";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("offyear"),
						rs.getString("offsem"),
						rs.getString("sname"),
						rs.getString("scode"),
						rs.getString("nlhours"),
						rs.getString("nlbhours"),
						rs.getString("nthours"),
						rs.getString("nehours"),
				});;
			}
			
			rs.close();
			st.close();
			conn.close();
			
			table.setModel(model);
			table.setAutoResizeMode(1);
			
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
