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
	    txtpnSelectLecturerName.setBounds(43, 439, 244, 35);
	    contentPane.add(txtpnSelectLecturerName);
	    
	    JComboBox<Object> lecturer1 = new JComboBox <Object> (getlecturerNames());
	    lecturer1.setBounds(343, 439, 275, 27);
	    contentPane.add(lecturer1);
	    
	    JTextPane txtpnSelectLecturerName_2 = new JTextPane();
	    txtpnSelectLecturerName_2.setText(" Select Lecturer Name 02");
	    txtpnSelectLecturerName_2.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectLecturerName_2.setBackground(new Color(153, 204, 255));
	    txtpnSelectLecturerName_2.setBounds(43, 485, 244, 35);
	    contentPane.add(txtpnSelectLecturerName_2);
	    
	    JComboBox<Object> lecturer2 =new JComboBox <Object> (getlecturerNames());
	    lecturer2.setBounds(343, 485, 275, 27);
	    contentPane.add(lecturer2);
	    
	    JTextPane txtpnSelectTag = new JTextPane();
	    txtpnSelectTag.setText("Select Tag");
	    txtpnSelectTag.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectTag.setBackground(new Color(153, 204, 255));
	    txtpnSelectTag.setBounds(742, 439, 111, 35);
	    contentPane.add(txtpnSelectTag);
	    
	    JComboBox<Object> tag = new JComboBox <Object> (gettagNames());
	    tag.setBounds(1016, 439, 196, 27);
	    contentPane.add(tag);
	    
	    JTextPane txtpnNumberOfStudents = new JTextPane();
	    txtpnNumberOfStudents.setText("Number of Students");
	    txtpnNumberOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnNumberOfStudents.setBackground(new Color(153, 204, 255));
	    txtpnNumberOfStudents.setBounds(742, 485, 216, 35);
	    contentPane.add(txtpnNumberOfStudents);
	    
	    JSpinner nOfStudents = new JSpinner();
	    nOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    nOfStudents.setBounds(1016, 495, 196, 27);
	    contentPane.add(nOfStudents);
	    
	    JTextPane txtpnDuration = new JTextPane();
	    txtpnDuration.setText("Duration");
	    txtpnDuration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnDuration.setBackground(new Color(153, 204, 255));
	    txtpnDuration.setBounds(742, 542, 216, 35);
	    contentPane.add(txtpnDuration);
	    
	    JSpinner duration = new JSpinner();
	    duration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    duration.setBounds(1016, 542, 196, 27);
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
	    btnDelete.setBounds(1072, 243, 155, 50);
	    contentPane.add(btnDelete);
	    
	    JTextPane txtpnSelectGroup = new JTextPane();
	    txtpnSelectGroup.setText(" Select Sub Group");
	    txtpnSelectGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectGroup.setBackground(new Color(153, 204, 255));
	    txtpnSelectGroup.setBounds(43, 635, 223, 27);
	    contentPane.add(txtpnSelectGroup);
	    
	    JTextPane txtpnSelectSubject = new JTextPane();
	    txtpnSelectSubject.setText(" Select Subject");
	    txtpnSelectSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectSubject.setBackground(new Color(153, 204, 255));
	    txtpnSelectSubject.setBounds(43, 531, 163, 35);
	    contentPane.add(txtpnSelectSubject);
	    
	    JComboBox<Object> subGroupId = new JComboBox <Object> (getsubGroupIDs());
	    subGroupId.setBounds(343, 635, 275, 27);
	    contentPane.add(subGroupId);
	    
	    JComboBox<Object> subjectName = new JComboBox <Object> (getSubjects());
	    subjectName.setBounds(343, 539, 275, 27);
	    contentPane.add(subjectName);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(110, 120, 893, 305);
	    contentPane.add(scrollPane);
	    
	    JTextPane txtpnSelectGroup_1 = new JTextPane();
	    txtpnSelectGroup_1.setText(" Select Group");
	    txtpnSelectGroup_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectGroup_1.setBackground(new Color(153, 204, 255));
	    txtpnSelectGroup_1.setBounds(43, 585, 223, 27);
	    contentPane.add(txtpnSelectGroup_1);
	    
	    JComboBox<Object> groupId = new JComboBox <Object> (getGroupIDs());
	    groupId.setBounds(343, 585, 275, 27);
	    contentPane.add(groupId);
	    
	    JButton btnClear = new JButton("Clear");
	    btnClear.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnClear.setFocusable(false);
	    btnClear.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
	    btnClear.setBounds(1072, 326, 155, 50);
	    contentPane.add(btnClear);
	    
	    table = new JTable();
	    //handle mouse movement
	    table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lecturer1.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
				lecturer2.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
				subjectName.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
				groupId.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5).toString());
				subGroupId.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5).toString());
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
	    
	    
	    //updatebutton	
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
							subGroupId.getSelectedItem().toString(),
							subjectName.getSelectedItem().toString(),
							Integer.parseInt(nOfStudents.getValue().toString()),
							Integer.parseInt(duration.getValue().toString()));
					
					if(isSuccess) {
						
						ShowData();
						JOptionPane.showMessageDialog(null, "Successfull update");
						
					}else {
					
						JOptionPane.showMessageDialog(null, "Error");

					}
				}
				
			}
		});
	    
	    //delete buton
	    btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validation
				if(table.getSelectionModel().isSelectionEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Plesae Selecte the Row before pressing Update");
					
				}
				else {
					
				boolean isSuccess = deleteLecturer(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()));
				
					if(isSuccess) {
						
						ShowData();
						JOptionPane.showMessageDialog(null, "Succesfull delete");

					}else {
					
						JOptionPane.showMessageDialog(null, "error");

					}
				}
				
			}
				
		});
	 
	    //clear buton
	 btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				lecturer1.setSelectedIndex(0);
				lecturer2.setSelectedIndex(0);
				subjectName.setSelectedIndex(0);
				groupId.setSelectedIndex(0);
				subGroupId.setSelectedIndex(0);
				tag.setSelectedIndex(0);
				nOfStudents.setValue(0);
				duration.setValue(0);
				
			}
			
		});
	    
	  //end default
	}
	
	//update
	private boolean updateSession(int id, String lecturer1, String lecturer2, String tag, String groupid, String subgroupid, String subjectName, int nOfStudents, int duration) {
		
		boolean isSuccess = false;
		
		String groupidX = null;
		
		//check if tag is Lab or Lecture or tutorial
		if(tag.equals("Lab")) {
    		
			groupidX =  subgroupid;
			
			
			
		}else if(tag.equals("Tutorial") || tag.equals("Lecture")){
			
			groupidX = groupid;
			
		}
		
		java.sql.Connection conn = DBConnect.getConnection();
		
		try {
				//get subcode of the subject
				String subjectCode = null;
				String sql1 = "Select scode from Subjects WHERE sname = '"+subjectName+"'";
				Statement st =  conn.createStatement();
		        ResultSet rs =  st.executeQuery(sql1);
		        while(rs.next()) {
		        subjectCode = rs.getString("scode");
		         
		        }
		        
				String sql = "UPDATE Sessions SET lecturer1 = '"+lecturer1+"', lecturer2 = '"+lecturer2+"', subjectCode = '"+subjectCode+"', subjectName = '"+subjectName+"', groupId = '"+groupidX+"', tag = '"+tag+"', nOfStudents = '"+nOfStudents+"', duration = '"+duration+"' WHERE id = '"+id+"' ";
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
	
		//delete
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
	        	
	          //get lecturer names into array list 
	        	
	          String sql = "SELECT lname from Lecturers";
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
	 /*   private String [] getlecturer1Names() {
	    	Connection conn = DBConnect.getConnection();
	    	
	    	String[] lecturer1NameArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT lanme from Lecturers";
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
	}*/
	   
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
	    private String [] getsubGroupIDs() {
	    	java.sql.Connection conn = DBConnect.getConnection();
	    	
	    	String[] subgroupidArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT subGroupId from StudentGroups";
	          Statement st = (Statement) conn.createStatement();
	          ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("subGroupid"));
	          }
	          subgroupidArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return subgroupidArray;
	}
	    
	    //load data into combo box
	    private String [] getGroupIDs() {
	    	java.sql.Connection conn = DBConnect.getConnection();
	    	
	    	String[] groupidArray = null;
	        List<String> list = new ArrayList<>();
	        
	        try {
	          String sql = "SELECT groupId from StudentGroups";
	          Statement st = (Statement) conn.createStatement();
	          ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	          
	          list.add("");
	          while(rs.next()) {
	            
	            
	            list.add(rs.getString("groupId"));
	          }
	          groupidArray = list.toArray(new String[0]);
	          
	        }catch (Exception e) {
	          
	        }

	        
	        return groupidArray;
	}
	    
	    //load data into combo box
	    
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
	    //data shows in table and table creat
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
