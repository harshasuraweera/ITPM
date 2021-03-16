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
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Lmanage extends JFrame {

	private JPanel contentPane;
	private JTextField lid;
	private JTextField lname;
	private JTextField faculty;
	private JTextField department;
	private JTextField center;
	private JTextField building;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lmanage frame = new Lmanage();
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
	public Lmanage() {
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
				JButton btnNewButton = new JButton("Home");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						try {
							AddSomething addSomething = new AddSomething();
							dispose();
							addSomething.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							
						
						
					}
				});
				btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addNew2.png")));
				btnNewButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton.setBounds(997, 10, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Back");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						lecturer lecturer = new lecturer();
						dispose();
						lecturer.setVisible(true);
						
							
						
						
					}
				});
				btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton_1.setFocusable(false);
				btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnNewButton_1.setBounds(27, 10, 250, 50);
				panel.add(btnNewButton_1);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnUpdate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnUpdate.setFocusable(false);
				btnUpdate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnUpdate.setBounds(772, 122, 250, 50);
				contentPane.add(btnUpdate);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDelete.setFocusable(false);
				btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDelete.setBounds(772, 216, 250, 50);
				contentPane.add(btnDelete);
				
				JButton btnDone = new JButton("View");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(772, 303, 250, 50);
				contentPane.add(btnDone);
				
				JTextPane txtpnLecturerName = new JTextPane();
				txtpnLecturerName.setEditable(false);
				txtpnLecturerName.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerName.setText("Lecturer Name");
				txtpnLecturerName.setBounds(118, 492, 141, 29);
				contentPane.add(txtpnLecturerName);
				
				lid = new JTextField();
				lid.setBounds(363, 423, 177, 29);
				contentPane.add(lid);
				lid.setColumns(10);
				
				JTextPane txtpnLecturerId = new JTextPane();
				txtpnLecturerId.setEditable(false);
				txtpnLecturerId.setText("Lecturer ID");
				txtpnLecturerId.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerId.setBounds(118, 423, 141, 29);
				contentPane.add(txtpnLecturerId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setEditable(false);
				txtpnFaculty.setText("Faculty");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnFaculty.setBounds(118, 546, 141, 29);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setEditable(false);
				txtpnCenter.setText("Center");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnCenter.setBounds(724, 473, 141, 29);
				contentPane.add(txtpnCenter);
				
				lname = new JTextField();
				lname.setColumns(10);
				lname.setBounds(363, 486, 177, 29);
				contentPane.add(lname);
				
				faculty = new JTextField();
				faculty.setColumns(10);
				faculty.setBounds(363, 546, 177, 29);
				contentPane.add(faculty);
				
				department = new JTextField();
				department.setColumns(10);
				department.setBounds(363, 606, 177, 29);
				contentPane.add(department);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setEditable(false);
				txtpnDepartment.setText("Department");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnDepartment.setBounds(118, 606, 141, 29);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setEditable(false);
				txtpnBuilding.setText("Building");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnBuilding.setBounds(724, 536, 141, 29);
				contentPane.add(txtpnBuilding);
				
				center = new JTextField();
				center.setColumns(10);
				center.setBounds(984, 473, 177, 29);
				contentPane.add(center);
				
				building = new JTextField();
				building.setColumns(10);
				building.setBounds(984, 536, 177, 29);
				contentPane.add(building);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(62, 112, 610, 276);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.setBounds(0, 0, 1, 1);
				
				scrollPane.setViewportView(table);
				
				//end navignation button 01
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						lid.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
						lname.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
						faculty.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
						department.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
						center.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
						building.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
						
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
				
				//up----
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean isSuccess = updateLecturer(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()),
								lid.getText().toString(), 
								lname.getText().toString(),
								faculty.getText().toString(),
								department.getText().toString(),
								center.getText().toString(),
								building.getText().toString());
					
						if(isSuccess) {
							JOptionPane.showMessageDialog(null, "Successfull update");
							ShowData();
							
						}else {
						
							JOptionPane.showMessageDialog(null, "Error");

						}
						
					}
				});
				
				//del---
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean isSuccess = deleteLecturer(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()));
						
				
						if(isSuccess) {
							JOptionPane.showMessageDialog(null, "Succesfull delete");
						ShowData();

						}else {
						
							JOptionPane.showMessageDialog(null, "error");

						}
						
					}
						
				});
				
				
	}
	
	//up method
			private boolean updateLecturer(int id, String lid, String lname, String faculty , String department, String center, String building) {
				
				boolean isSuccess = false;
				
				java.sql.Connection conn = DBConnect.getConnection();
				
				try {
					
					String sql = "UPDATE Lecturers SET lid = '"+lid+"', lname = '"+lname+"', faculty = '"+faculty+"', department = '"+department+"',"
							+ " center = '"+center+"',"
							+ " building = '"+building+"'  WHERE id = '"+id+"' ";
					
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
			private boolean deleteLecturer(int id) {
				
				boolean isSuccess = false;
				
				java.sql.Connection conn = DBConnect.getConnection();
				
				try {
					
					String sql = "DELETE FROM Lecturers WHERE id = '"+id+"' ";
					
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
	
	private void ShowData() {
		
	java.sql.Connection conn = DBConnect.getConnection();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Lecturer ID");
		model.addColumn("Lecturer Name");
		model.addColumn("Faculty"); 
		model.addColumn("Department");
		model.addColumn("Available Days");
		model.addColumn("Available Hours");
		model.addColumn("Center");
		model.addColumn("Building");
		model.addColumn("Level");
		model.addColumn("Rank");
		
		try {
			
			String sql = "SELECT * FROM Lecturers";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("lid"),
						rs.getString("lname"),
						rs.getString("faculty"),
						rs.getString("department"),
						rs.getString("adays"),
						rs.getString("ahours"),
						rs.getString("center"),
						rs.getString("building"),
						rs.getString("level"),
						rs.getString("rank"),
				});;
			}
			
			rs.close();
			st.close();
			conn.close();
			
			table.setModel(model);
			table.setAutoResizeMode(1);
			
//			table.getColumnModel().getColumn(0).setPreferredWidth(80);
//			table.getColumnModel().getColumn(1).setPreferredWidth(140);
//			table.getColumnModel().getColumn(2).setPreferredWidth(140);
//			table.getColumnModel().getColumn(3).setPreferredWidth(140);
//			table.getColumnModel().getColumn(4).setPreferredWidth(140);
//			table.getColumnModel().getColumn(5).setPreferredWidth(140);
//			table.getColumnModel().getColumn(6).setPreferredWidth(140);
//			table.getColumnModel().getColumn(7).setPreferredWidth(140);
//			table.getColumnModel().getColumn(8).setPreferredWidth(140);
			
			
		}catch (Exception e) {
			
		}
		
	}
}
