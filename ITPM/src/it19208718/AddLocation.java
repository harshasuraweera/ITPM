package it19208718;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class AddLocation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocation frame = new AddLocation();
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
	public AddLocation() {
		
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
		
		JButton btnNewButton_1 = new JButton(" Back To Home");
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(24, 10, 225, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Manage Locations");
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(1017, 10, 225, 50);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Building Name");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(287, 237, 174, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoomName.setBounds(287, 315, 174, 46);
		contentPane.add(lblRoomName);
		
		textField = new JTextField();
		textField.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		textField.setBounds(440, 246, 525, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(440, 315, 525, 36);
		contentPane.add(textField_1);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblRoomType.setBounds(287, 416, 174, 46);
		contentPane.add(lblRoomType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lecture Hall");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(502, 416, 204, 46);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLaboratory = new JRadioButton("Laboratory");
		buttonGroup.add(rdbtnLaboratory);
		rdbtnLaboratory.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		rdbtnLaboratory.setBounds(761, 416, 204, 46);
		contentPane.add(rdbtnLaboratory);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		lblCapacity.setBounds(287, 494, 174, 46);
		contentPane.add(lblCapacity);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		spinner.setBounds(458, 494, 196, 46);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Add New Location");
		lblNewLabel_1.setBounds(452, 118, 306, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		
		JButton btnNewButton_1_1_1 = new JButton("Save");
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(287, 609, 225, 50);
		contentPane.add(btnNewButton_1_1_1);
		
		//end default
	}
}
