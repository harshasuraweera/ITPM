package IT19216492;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ManageStudentGroups extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups frame = new ManageStudentGroups();
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
	public ManageStudentGroups() {
		//do these for each and every JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Forza Timetable Management System - Add Location");
		
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
		
		
		
		JButton btnNewButton_1 = new JButton(" Add Student Groups");
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 225, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(" Back To Home");
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(978, 10, 264, 50);
		panel.add(btnNewButton_1_1);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Manage Student Groups");
		lblNewLabel_1.setBounds(544, 85, 278, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		
		
		
		
		JLabel lblAcademic = new JLabel("Academic Year & Semester");
		lblAcademic.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblAcademic.setBounds(76, 489, 199, 25);
		contentPane.add(lblAcademic);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox.setBounds(317, 489, 213, 25);
		contentPane.add(comboBox);
		
		
		
		JLabel lblProgramme = new JLabel("Degree Programme");
		lblProgramme.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblProgramme.setBounds(76, 536, 149, 25);
		contentPane.add(lblProgramme);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox_1.setBounds(317, 536, 213, 25);
		contentPane.add(comboBox_1);
		
		
		
		JLabel lblGroupNum = new JLabel("Group Numbers");
		lblGroupNum.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblGroupNum.setBounds(76, 585, 131, 25);
		contentPane.add(lblGroupNum);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		spinner.setBounds(427, 584, 103, 25);
		contentPane.add(spinner);
		
		
		

		JLabel lblSubGroup = new JLabel("Sub Group Numbers");
		lblSubGroup.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblSubGroup.setBounds(657, 489, 149, 25);
		contentPane.add(lblSubGroup);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		spinner_1.setBounds(953, 488, 103, 25);
		contentPane.add(spinner_1);
		
		
		
		
		JLabel lblGroupID = new JLabel("Group ID");
		lblGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblGroupID.setBounds(657, 536, 116, 25);
		contentPane.add(lblGroupID);
		
		textField = new JTextField();
		textField.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(843, 536, 213, 25);
		contentPane.add(textField);
		
		
		
		JLabel lblSubGroupID = new JLabel("Sub Group ID");
		lblSubGroupID.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		lblSubGroupID.setBounds(657, 583, 116, 25);
		contentPane.add(lblSubGroupID);
			
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(843, 578, 213, 25);
		contentPane.add(textField_1);
		
		
		
		
		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(381, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBounds(612, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Generate ID");
		btnNewButton_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1_1.setBounds(1092, 567, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1_1.setBounds(835, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1_1);
		
		table = new JTable();
		table.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		table.setBounds(153, 164, 1004, 294);
		contentPane.add(table);
		
		

		
		//end default
	}
}
