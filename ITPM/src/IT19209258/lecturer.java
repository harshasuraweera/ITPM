package IT19209258;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it19208718.AddSomething;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class lecturer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lecturer frame = new lecturer();
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
	public lecturer() {
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
				btnNewButton.setBounds(33, 10, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				JButton btnManageLecturerDetails = new JButton(" Manage Lecturer Details");
				btnManageLecturerDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Lmanage Lmanage = new Lmanage();
						dispose();
						Lmanage.setVisible(true);
						
							
						
						
					}
				});
				btnManageLecturerDetails.setBackground(Color.WHITE);
				btnManageLecturerDetails.setForeground(Color.BLACK);
				btnManageLecturerDetails.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnManageLecturerDetails.setFocusable(false);
				btnManageLecturerDetails.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnManageLecturerDetails.setBounds(1000, 10, 250, 50);
				panel.add(btnManageLecturerDetails);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(397, 149, 275, 35);
				contentPane.add(textArea);
				
				JTextPane txtpnLectureName = new JTextPane();
				txtpnLectureName.setText(" Lecture Name");
				txtpnLectureName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureName.setBounds(75, 149, 171, 35);
				contentPane.add(txtpnLectureName);
				
				JTextPane txtpnLectureId = new JTextPane();
				txtpnLectureId.setEditable(false);
				txtpnLectureId.setText(" Lecture ID");
				txtpnLectureId.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLectureId.setBounds(75, 240, 171, 35);
				contentPane.add(txtpnLectureId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setText("Faculty");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnFaculty.setBounds(75, 323, 171, 35);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setText("Department");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnDepartment.setBounds(75, 405, 171, 35);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnAvailableDays = new JTextPane();
				txtpnAvailableDays.setText("Available Days");
				txtpnAvailableDays.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnAvailableDays.setBounds(75, 488, 171, 35);
				contentPane.add(txtpnAvailableDays);
				
				JTextPane txtpnAvailableHours = new JTextPane();
				txtpnAvailableHours.setText("Available Hours");
				txtpnAvailableHours.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnAvailableHours.setBounds(75, 593, 171, 35);
				contentPane.add(txtpnAvailableHours);
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(397, 240, 275, 35);
				contentPane.add(textArea_1);
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
				chckbxNewCheckBox.setBounds(397, 488, 97, 23);
				contentPane.add(chckbxNewCheckBox);
				
				JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
				chckbxTuesday.setBounds(506, 488, 97, 23);
				contentPane.add(chckbxTuesday);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setText("Center");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnCenter.setBounds(740, 149, 171, 35);
				contentPane.add(txtpnCenter);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setText("Building");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnBuilding.setBounds(740, 240, 171, 35);
				contentPane.add(txtpnBuilding);
				
				JTextPane txtpnLevel = new JTextPane();
				txtpnLevel.setText("Level");
				txtpnLevel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnLevel.setBounds(740, 323, 171, 35);
				contentPane.add(txtpnLevel);
				
				JTextPane txtpnRank = new JTextPane();
				txtpnRank.setText("Rank");
				txtpnRank.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				txtpnRank.setBounds(740, 405, 171, 35);
				contentPane.add(txtpnRank);
				
				textField = new JTextField();
				textField.setBounds(977, 405, 275, 35);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Wednesday");
				chckbxNewCheckBox_1_1.setBounds(617, 488, 97, 23);
				contentPane.add(chckbxNewCheckBox_1_1);
				
				JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Thuresday");
				chckbxNewCheckBox_1_2.setBounds(733, 488, 97, 23);
				contentPane.add(chckbxNewCheckBox_1_2);
				
				JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Friday");
				chckbxNewCheckBox_1_3.setBounds(844, 488, 97, 23);
				contentPane.add(chckbxNewCheckBox_1_3);
				
				JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("Satureday");
				chckbxNewCheckBox_1_4.setBounds(397, 536, 97, 23);
				contentPane.add(chckbxNewCheckBox_1_4);
				
				JCheckBox chckbxNewCheckBox_1_5 = new JCheckBox("Sunday");
				chckbxNewCheckBox_1_5.setBounds(506, 536, 97, 23);
				contentPane.add(chckbxNewCheckBox_1_5);
				
				JButton btnDone = new JButton("Done");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(977, 613, 250, 50);
				contentPane.add(btnDone);
				
				
				String array [] = {"A", "B", "C", "D"}; 
				JComboBox comboBox = new JComboBox(array);
				comboBox.setBounds(397, 323, 248, 38);
				contentPane.add(comboBox);
				
				String array1 [] = {"A", "B", "C", "D"};
				JComboBox comboBox_1 = new JComboBox(array1);
				comboBox_1.setBounds(397, 402, 248, 38);
				contentPane.add(comboBox_1);
				
				String array2 [] = {"1", "2", "3", "4"};
				JComboBox comboBox_1_1 = new JComboBox(array2);
				comboBox_1_1.setBounds(397, 590, 248, 38);
				contentPane.add(comboBox_1_1);
				
				String array3 [] = {"A", "B", "C", "D"};
				JComboBox comboBox_2 = new JComboBox(array3);
				comboBox_2.setBounds(977, 240, 248, 38);
				contentPane.add(comboBox_2);
				
				String array4 [] = {"1", "2", "3", "4", "5", "6"};
				JComboBox comboBox_2_1 = new JComboBox(array4);
				comboBox_2_1.setBounds(977, 320, 248, 38);
				contentPane.add(comboBox_2_1);
				
				String array5 [] = {"A", "B", "C", "D"};
				JComboBox comboBox_2_2 = new JComboBox(array5);
				comboBox_2_2.setBounds(977, 149, 248, 38);
				contentPane.add(comboBox_2_2);
				
				
				
				//end navignation button 01
	}
}
