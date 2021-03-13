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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ManageTags extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTags frame = new ManageTags();
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
	public ManageTags() {
		//do these for each and every JFrame ZZ
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
		
		JButton btnNewButton_1_1 = new JButton("Manage Tags");
		btnNewButton_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(978, 10, 264, 50);
		panel.add(btnNewButton_1_1);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("Add Tags");
		lblNewLabel_1.setBounds(615, 82, 172, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 25));
		
		
		
		
		JLabel lblTagName = new JLabel("Tag Name");
		lblTagName.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		lblTagName.setBounds(403, 489, 116, 37);
		contentPane.add(lblTagName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox.setBounds(721, 496, 213, 25);
		contentPane.add(comboBox);
		
		
		
		JLabel lblRelatedTag = new JLabel("Related Tag");
		lblRelatedTag.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		lblRelatedTag.setBounds(403, 547, 116, 37);
		contentPane.add(lblRelatedTag);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		comboBox_1.setBounds(721, 554, 213, 25);
		contentPane.add(comboBox_1);
		
		
		
		
		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(313, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Done");
		btnNewButton_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBounds(568, 634, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1_1_1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBounds(839, 635, 149, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		table = new JTable();
		table.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		table.setBounds(214, 155, 900, 309);
		contentPane.add(table);
		
		
		
	
		//end default
	}
}

