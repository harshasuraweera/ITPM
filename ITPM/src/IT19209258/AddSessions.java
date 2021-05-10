package IT19209258;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


import database.DBConnect;
import it19208718.AddLocation;
import it19208718.HomeWindow;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;

public class AddSessions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessions frame = new AddSessions();
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
	public AddSessions() {
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
	          
	        } catch (Exception e1) {
	          
	          e1.printStackTrace();
	        }
	      }
	    });
	    btnBackToHome.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homepage.png")));
	    btnBackToHome.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnBackToHome.setFocusable(false);
	    btnBackToHome.setBounds(24, 10, 225, 50);
	    panel.add(btnBackToHome);
	    
	    JButton btnManageSessions = new JButton("Manage Sessions");
	    btnManageSessions.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnManageSessions.setFocusable(false);
	    btnManageSessions.setBounds(1026, 10, 225, 50);
	    panel.add(btnManageSessions);
	    
	    JTextPane txtpnAddNewSession = new JTextPane();
	    txtpnAddNewSession.setFont(new Font("Kristen ITC", Font.BOLD, 30));
	    txtpnAddNewSession.setText("Select Lecturer and Tag");
	    txtpnAddNewSession.setEditable(false);
	    txtpnAddNewSession.setBackground(new Color(153, 204, 255));
	    txtpnAddNewSession.setBounds(452, 113, 396, 83);
	    contentPane.add(txtpnAddNewSession);
	    
	    JTextPane txtpnSelectLecturerName = new JTextPane();
	    txtpnSelectLecturerName.setText(" Select Lecturer Name");
	    txtpnSelectLecturerName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectLecturerName.setBackground(new Color(153, 204, 255));
	    txtpnSelectLecturerName.setBounds(55, 213, 223, 35);
	    contentPane.add(txtpnSelectLecturerName);
	    
	    JComboBox <Object> lecturer1 = new JComboBox <Object> (getlecturerNames());
	    lecturer1.setBounds(325, 213, 275, 35);
	    contentPane.add(lecturer1);
	    
	    JTextPane txtpnSelectTag = new JTextPane();
	    txtpnSelectTag.setText("Select Tag");
	    txtpnSelectTag.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectTag.setBackground(new Color(153, 204, 255));
	    txtpnSelectTag.setBounds(713, 213, 171, 35);
	    contentPane.add(txtpnSelectTag);
	    
	    JComboBox <Object> tag = new JComboBox <Object> (gettagNames());
	    tag.setBounds(931, 213, 275, 35);
	    contentPane.add(tag);
	    
	    JTextPane txtpnSelectGroup = new JTextPane();
	    txtpnSelectGroup.setText(" Select Group");
	    txtpnSelectGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectGroup.setBackground(new Color(153, 204, 255));
	    txtpnSelectGroup.setBounds(55, 427, 223, 35);
	    contentPane.add(txtpnSelectGroup);
	    
	    JTextPane txtpnSelectSubject = new JTextPane();
	    txtpnSelectSubject.setText(" Select Subject");
	    txtpnSelectSubject.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnSelectSubject.setBackground(new Color(153, 204, 255));
	    txtpnSelectSubject.setBounds(55, 528, 163, 35);
	    contentPane.add(txtpnSelectSubject);
	    
	    JSpinner nOfStudents = new JSpinner();
	    nOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    nOfStudents.setBounds(1010, 419, 196, 46);
	    contentPane.add(nOfStudents);
	    
	    JComboBox <Object> groupid = new JComboBox <Object> (getGroupIDs());
	    groupid.setBounds(325, 427, 275, 35);
	    contentPane.add(groupid);
	    
	    JComboBox <Object> subjectName = new JComboBox <Object> (getSubjects());
	    subjectName.setBounds(325, 528, 275, 35);
	    contentPane.add(subjectName);
	    
	    JTextPane txtpnNumberOfStudents = new JTextPane();
	    txtpnNumberOfStudents.setText("Number of Students");
	    txtpnNumberOfStudents.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnNumberOfStudents.setBackground(new Color(153, 204, 255));
	    txtpnNumberOfStudents.setBounds(713, 427, 216, 35);
	    contentPane.add(txtpnNumberOfStudents);
	    
	    JTextPane txtpnDuration = new JTextPane();
	    txtpnDuration.setText("Duration");
	    txtpnDuration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    txtpnDuration.setBackground(new Color(153, 204, 255));
	    txtpnDuration.setBounds(713, 528, 216, 35);
	    contentPane.add(txtpnDuration);
	    
	    JSpinner duration = new JSpinner();
	    duration.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    duration.setBounds(1010, 517, 196, 46);
	    contentPane.add(duration);
	    
	    JTextPane txtpnSelectGroupAnd = new JTextPane();
	    txtpnSelectGroupAnd.setText("Select Group and Subject");
	    txtpnSelectGroupAnd.setFont(new Font("Kristen ITC", Font.BOLD, 30));
	    txtpnSelectGroupAnd.setEditable(false);
	    txtpnSelectGroupAnd.setBackground(new Color(153, 204, 255));
	    txtpnSelectGroupAnd.setBounds(435, 343, 413, 83);
	    contentPane.add(txtpnSelectGroupAnd);
	    
	    JButton btnDone = new JButton("Done");
	    btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
	    btnDone.setFocusable(false);
	    btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
	    btnDone.setBounds(956, 615, 250, 50);
	    contentPane.add(btnDone);
	    
	    //end default
	    
	    btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lecturer1.getSelectedItem().equals("") || tag.getSelectedItem().equals("") || groupid.getSelectedItem().equals("") || subjectName.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please Fill the Informations");
					
				}
				else {
					boolean isSuccess =  addsession(
							
							lecturer1.getSelectedItem().toString(),
							tag.getSelectedItem().toString(),
							groupid.getSelectedItem().toString(),
							subjectName.getSelectedItem().toString(),
							Integer.parseInt(nOfStudents.getValue().toString()),
							Integer.parseInt(duration.getValue().toString()));
				
					if(isSuccess) {
						
						JOptionPane.showMessageDialog(null, "added successfully");
						}else {
					
						JOptionPane.showMessageDialog(null, "error");
						
						}
				}	
			}
	    });
	    	
	    
	}
	    
	    
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
	    
	    public boolean addsession(String lecturer1, String tag, String groupid, String subjectName, int nOfStudent, int duration) {
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
				String sql = "INSERT INTO Sessions(lecturer1,tag,groupId,subjectName,nOfStudents,duration, subjectCode)   VALUES ('"+lecturer1+"', '"+tag+"', '"+groupid+"', '"+subjectName+"', '"+nOfStudent+"', '"+duration+"', '"+subjectCode+"')";
				Statement st1 = conn.createStatement();
				int rs1 = st1.executeUpdate(sql);
				
				st1.close();
				isSuccess = true;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				isSuccess = false;
			}
			
			
			return isSuccess;
	    }
}
