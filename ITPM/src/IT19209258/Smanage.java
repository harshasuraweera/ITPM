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
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Smanage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
				btnNewButton.setBounds(999, 11, 250, 50);
				btnNewButton.setFocusable(false);
				panel.add(btnNewButton);
				
				//end navignation button 01
				
				
				
				JButton btnNewButton_1 = new JButton("Back");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						subject subject = new subject();
						dispose();
						subject.setVisible(true);
						
							
						
						
					}
				});
				btnNewButton_1.setBounds(10, 11, 250, 50);
				panel.add(btnNewButton_1);
				btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnNewButton_1.setFocusable(false);
				btnNewButton_1.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				
				table = new JTable();
				table.setBounds(117, 134, 555, 242);
				contentPane.add(table);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnUpdate.setFocusable(false);
				btnUpdate.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnUpdate.setBounds(774, 145, 250, 50);
				contentPane.add(btnUpdate);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDelete.setFocusable(false);
				btnDelete.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDelete.setBounds(774, 239, 250, 50);
				contentPane.add(btnDelete);
				
				JButton btnDone = new JButton("View");
				btnDone.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
				btnDone.setFocusable(false);
				btnDone.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
				btnDone.setBounds(774, 326, 250, 50);
				contentPane.add(btnDone);
				
				JTextPane txtpnLecturerName = new JTextPane();
				txtpnLecturerName.setText("Offered Year");
				txtpnLecturerName.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerName.setBounds(117, 429, 121, 29);
				contentPane.add(txtpnLecturerName);
				
				JTextPane txtpnLecturerId = new JTextPane();
				txtpnLecturerId.setText("Offered Semester");
				txtpnLecturerId.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLecturerId.setBounds(117, 492, 149, 29);
				contentPane.add(txtpnLecturerId);
				
				JTextPane txtpnFaculty = new JTextPane();
				txtpnFaculty.setText("Subject Name");
				txtpnFaculty.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnFaculty.setBounds(117, 552, 121, 29);
				contentPane.add(txtpnFaculty);
				
				JTextPane txtpnCenter = new JTextPane();
				txtpnCenter.setText("Subject Code");
				txtpnCenter.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnCenter.setBounds(117, 612, 121, 29);
				contentPane.add(txtpnCenter);
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(362, 429, 177, 29);
				contentPane.add(textField);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(362, 492, 177, 29);
				contentPane.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(362, 552, 177, 29);
				contentPane.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(362, 612, 177, 29);
				contentPane.add(textField_3);
				
				JTextPane txtpnDepartment = new JTextPane();
				txtpnDepartment.setText("Number of Lectures Hours");
				txtpnDepartment.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnDepartment.setBounds(698, 429, 223, 29);
				contentPane.add(txtpnDepartment);
				
				JTextPane txtpnBuilding = new JTextPane();
				txtpnBuilding.setText("Number of Lab Hours");
				txtpnBuilding.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnBuilding.setBounds(698, 492, 141, 29);
				contentPane.add(txtpnBuilding);
				
				JTextPane txtpnLevel = new JTextPane();
				txtpnLevel.setText("Number of Tutorial Hours");
				txtpnLevel.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnLevel.setBounds(698, 552, 223, 29);
				contentPane.add(txtpnLevel);
				
				JTextPane txtpnRank = new JTextPane();
				txtpnRank.setText("Number of Evaluation Hours");
				txtpnRank.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
				txtpnRank.setBounds(698, 612, 241, 29);
				contentPane.add(txtpnRank);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(991, 429, 177, 29);
				contentPane.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(991, 492, 177, 29);
				contentPane.add(textField_5);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(991, 552, 177, 29);
				contentPane.add(textField_6);
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(991, 612, 177, 29);
				contentPane.add(textField_7);
				
				//end navignation button 01
				
	}

}
