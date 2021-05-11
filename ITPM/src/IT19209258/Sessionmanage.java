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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.DBConnect;
import it19208718.AddLocation;
import it19208718.HomeWindow;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Sessionmanage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sessionmanage frame = new Sessionmanage();
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
	public Sessionmanage() {
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
	    
	    ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
	    setIconImage(img.getImage());

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
	    btnBackToHome.setBounds(1022, 11, 225, 50);
	    panel.add(btnBackToHome);
	    
	    JButton btnAddNewSessions = new JButton("Add New Sessions");
	    btnAddNewSessions.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    			AddSessions AddSessions = new AddSessions();
	    			dispose();
	    			AddSessions.setVisible(true);
	    			
	    		
	    	}
	    });
	    btnAddNewSessions.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_addnew.png")));
	    btnAddNewSessions.setBounds(20, 11, 245, 50);
	    panel.add(btnAddNewSessions);
	    btnAddNewSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnAddNewSessions.setFocusable(false);
	    
	    JTextPane txtpnSelectLecturerName = new JTextPane();
	    txtpnSelectLecturerName.setText(" Select Lecturer Name 01");
	    txtpnSelectLecturerName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectLecturerName.setBackground(new Color(153, 204, 255));
	    txtpnSelectLecturerName.setBounds(47, 472, 244, 35);
	    contentPane.add(txtpnSelectLecturerName);
	    
	    JComboBox<Object> lecturer1 = new JComboBox <Object> (getlecturerNames());
	    lecturer1.setBounds(347, 472, 275, 27);
	    contentPane.add(lecturer1);
	    
	    JTextPane txtpnSelectLecturerName_2 = new JTextPane();
	    txtpnSelectLecturerName_2.setText(" Select Lecturer Name 02");
	    txtpnSelectLecturerName_2.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectLecturerName_2.setBackground(new Color(153, 204, 255));
	    txtpnSelectLecturerName_2.setBounds(47, 518, 244, 35);
	    contentPane.add(txtpnSelectLecturerName_2);
	    
	    JComboBox<Object> lecturer2 =new JComboBox <Object> (getlecturer1Names());
	    lecturer2.setBounds(347, 518, 275, 27);
	    contentPane.add(lecturer2);
	    
	    JTextPane txtpnSelectTag = new JTextPane();
	    txtpnSelectTag.setText("Select Tag");
	    txtpnSelectTag.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectTag.setBackground(new Color(153, 204, 255));
	    txtpnSelectTag.setBounds(750, 472, 111, 35);
	    contentPane.add(txtpnSelectTag);
	    
	    JComboBox<Object> tag = new JComboBox <Object> (gettagNames());
	    tag.setBounds(1018, 472, 196, 35);
	    contentPane.add(tag);
	    
	    JTextPane txtpnNumberOfStudents = new JTextPane();
	    txtpnNumberOfStudents.setText("Number of Students");
	    txtpnNumberOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnNumberOfStudents.setBackground(new Color(153, 204, 255));
	    txtpnNumberOfStudents.setBounds(744, 539, 216, 35);
	    contentPane.add(txtpnNumberOfStudents);
	    
	    JSpinner nOfStudents = new JSpinner();
	    nOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    nOfStudents.setBounds(1018, 528, 196, 35);
	    contentPane.add(nOfStudents);
	    
	    JTextPane txtpnDuration = new JTextPane();
	    txtpnDuration.setText("Duration");
	    txtpnDuration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnDuration.setBackground(new Color(153, 204, 255));
	    txtpnDuration.setBounds(744, 602, 216, 35);
	    contentPane.add(txtpnDuration);
	    
	    JSpinner duration = new JSpinner();
	    duration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    duration.setBounds(1018, 602, 196, 35);
	    contentPane.add(duration);
	    
	    JButton btnUpdate = new JButton("Update");
	    btnUpdate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnUpdate.setFocusable(false);
	    btnUpdate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
	    btnUpdate.setBounds(1072, 160, 155, 50);
	    contentPane.add(btnUpdate);
	    
	    JButton btnDelete = new JButton("Delete");
	    btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnDelete.setFocusable(false);
	    btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
	    btnDelete.setBounds(1072, 279, 155, 50);
	    contentPane.add(btnDelete);
	    
	    JTextPane txtpnSelectGroup = new JTextPane();
	    txtpnSelectGroup.setText(" Select Group");
	    txtpnSelectGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectGroup.setBackground(new Color(153, 204, 255));
	    txtpnSelectGroup.setBounds(47, 610, 223, 35);
	    contentPane.add(txtpnSelectGroup);
	    
	    JTextPane txtpnSelectSubject = new JTextPane();
	    txtpnSelectSubject.setText(" Select Subject");
	    txtpnSelectSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectSubject.setBackground(new Color(153, 204, 255));
	    txtpnSelectSubject.setBounds(47, 564, 163, 35);
	    contentPane.add(txtpnSelectSubject);
	    
	    JComboBox<Object> groupId = new JComboBox <Object> (getGroupIDs());
	    groupId.setBounds(347, 618, 275, 27);
	    contentPane.add(groupId);
	    
	    JComboBox<Object> subjectName = new JComboBox <Object> (getSubjects());
	    subjectName.setBounds(347, 572, 275, 27);
	    contentPane.add(subjectName);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(110, 120, 893, 305);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
	    table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lecturer1.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
				lecturer2.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
				subjectName.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
				groupId.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5).toString());
				tag.setSelectedItem(table.getValueAt(table.getSelectedRow(), 6).toString());
				nOfStudents.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 7).toString()));
				duration.setValue(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString()));
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
	    
	    //table.setBounds(110, 120, 893, 305);
	    //contentPane.add(table);
	    scrollPane.setViewportView(table);
	    //table.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
	    
	    
	    	
	    btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Plesae Selecte the Row before pressing Update");
				}
				
				else {
					
					boolean isSuccess = updateSession(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()),
							lecturer1.getSelectedItem().toString(),
							lecturer2.getSelectedItem().toString(),
							tag.getSelectedItem().toString(),
							groupId.getSelectedItem().toString(),
							subjectName.getSelectedItem().toString(),
							Integer.parseInt(nOfStudents.getValue().toString()),
							Integer.parseInt(duration.getValue().toString()));
					
					if(isSuccess) {
						JOptionPane.showMessageDialog(null, "Successfull update");
						ShowData();
						
					}else {
					
						JOptionPane.showMessageDialog(null, "Error");

					}
				}
				
			}
		});
	    
	    btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validation
				if(table.getSelectionModel().isSelectionEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Plesae Selecte the Row before pressing Update");
					
				}
				else {
					
				boolean isSuccess = deleteLecturer(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()));
				
					if(isSuccess) {
						JOptionPane.showMessageDialog(null, "Succesfull delete");
					ShowData();

					}else {
					
						JOptionPane.showMessageDialog(null, "error");

					}
				}
				
			}
				
		});
	    
	  //end default
	}
	
	private boolean updateSession(int id, String lecturer1, String lecturer2, String tag, String groupId, String subjectName, int nOfStudents, int duration) {
		
		boolean isSuccess = false;
		
		java.sql.Connection conn = DBConnect.getConnection();
		
		try {
				String subjectCode = null;
				String sql1 = "Select scode from Subjects WHERE sname = '"+subjectName+"'";
				Statement st =  conn.createStatement();
		        ResultSet rs =  st.executeQuery(sql1);
		        while(rs.next()) {
		         subjectCode = rs.getString("scode");
		        }
				String sql = "UPDATE Sessions SET lecturer1 = '"+lecturer1+"', lecturer2 = '"+lecturer2+"', subjectCode = '"+subjectCode+"', subjectName = '"+subjectName+"', groupId = '"+groupId+"', tag = '"+tag+"', nOfStudents = '"+nOfStudents+"', duration = '"+duration+"' WHERE id = '"+id+"' ";
				Statement st1 = conn.createStatement();
				int rs1 = st1.executeUpdate(sql);
				
				st1.close();
				conn.close();
				isSuccess = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			isSuccess = false;
			
		}	
		
		return isSuccess;
	}
	
	private boolean deleteLecturer(int id) {
		
		boolean isSuccess = false;
		
		java.sql.Connection conn = DBConnect.getConnection();
		
		try {
			
			String sql = "DELETE FROM Sessions WHERE id = '"+id+"' ";
			
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

	
	 //load data into combo box
	 private String [] getlecturerNames() {
	    	Connection conn = DBConnect.getConnection();
	    	
	    	String[] lecturerNameArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT * from Lecturers";
	          Statement st =  conn.createStatement();
	          ResultSet rs =  st.executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("lname"));
	          }
	          lecturerNameArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return lecturerNameArray;
	}
	 	//load data into combo box
	    private String [] getlecturer1Names() {
	    	Connection conn = DBConnect.getConnection();
	    	
	    	String[] lecturer1NameArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT * from Lecturers";
	          Statement st =  conn.createStatement();
	          ResultSet rs =  st.executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("lname"));
	          }
	          lecturer1NameArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return lecturer1NameArray;
	}
	    //load data into combo box
	    private String [] gettagNames() {
	    	java.sql.Connection conn = DBConnect.getConnection();
	    	
	    	String[] tagNameArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT tagName from Tags";
	          Statement st = (Statement) conn.createStatement();
	          ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("tagName"));
	          }
	          tagNameArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return tagNameArray;
	}
	    //load data into combo box
	    private String [] getGroupIDs() {
	    	java.sql.Connection conn = DBConnect.getConnection();
	    	
	    	String[] groupidArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT subGroupId from StudentGroups";
	          Statement st = (Statement) conn.createStatement();
	          ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("subGroupid"));
	          }
	          groupidArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return groupidArray;
	}
	    //load data into combo box
	    private String [] getSubjects() {
	    	java.sql.Connection conn = DBConnect.getConnection();
	    	
	    	String[] subjectArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT sname from Subjects";
	          Statement st = (Statement) conn.createStatement();
	          ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("sname"));
	          }
	          subjectArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return subjectArray;
	}
	    
	    private void ShowData() {
			
	    	java.sql.Connection conn = DBConnect.getConnection();
	    		
	    		DefaultTableModel model = new DefaultTableModel();
	    		model.addColumn("Id");
	    		model.addColumn("Lecturer 01");
	    		model.addColumn("Lecturer 02");
	    		model.addColumn("Subject Code"); 
	    		model.addColumn("Subject Name");
	    		model.addColumn("Group Id");
	    		model.addColumn("Tag");
	    		model.addColumn("Number of Students");
	    		model.addColumn("Duration");
	    		
	    		try {
	    			
	    			String sql = "SELECT * FROM Sessions";
	    			Statement st = conn.createStatement();
	    			ResultSet rs = st.executeQuery(sql);
	    			
	    			while(rs.next()) {
	    				model.addRow(new Object[] {
	    						rs.getString("id"),
	    						rs.getString("lecturer1"),
	    						rs.getString("lecturer2"),
	    						rs.getString("subjectCode"),
	    						rs.getString("SubjectName"),
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
