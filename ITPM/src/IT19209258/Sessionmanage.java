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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnect;
import it19208718.AddLocation;
import it19208718.HomeWindow;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;

public class Sessionmanage extends JFrame {

	private JPanel contentPane;

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
	    txtpnSelectTag.setBounds(744, 472, 111, 35);
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
	    
	    JComboBox<Object> groupid = new JComboBox <Object> (getGroupIDs());
	    groupid.setBounds(347, 618, 275, 27);
	    contentPane.add(groupid);
	    
	    JComboBox<Object> subjectName = new JComboBox <Object> (getSubjects());
	    subjectName.setBounds(347, 572, 275, 27);
	    contentPane.add(subjectName);
	    
	    //end default
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
}
