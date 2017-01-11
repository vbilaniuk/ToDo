// adding a comment.

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ToDoMain {

	private JFrame frmToDoList;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnClose;
	private tableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoMain window = new ToDoMain();
					window.frmToDoList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ToDoMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmToDoList = new JFrame();
		frmToDoList.getContentPane().setBackground(new Color(255, 240, 240));
		frmToDoList.setBackground(new Color(255, 240, 240));
		frmToDoList.setTitle("To Do List");
		frmToDoList.setBounds(100, 100, 450, 300);
		frmToDoList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmToDoList.getContentPane().setLayout(new MigLayout("", "[grow][][][]", "[grow][]"));
		tableModel = new tableModel();
		table = new JTable(tableModel);
		table.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		frmToDoList.getContentPane().add(table, "cell 0 0 4 1,grow");
		 
		//set the column sizes:
		TableColumn column = null;
		for (int i = 0; i < 2; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 0) {
		        column.setMinWidth(10); //checkbox
		    } else {
		        column.setPreferredWidth(1000);
		    }
		}
		table.setRowHeight(30);
		
		//table.setBackground(Color.getHSBColor(45, 75, 100)); // faint yellow
		//table.setBackground(Color.getHSBColor(329, 100, 50));
		//table.setBackground(Color.decode("#ff0084"));
		table.setForeground(Color.DARK_GRAY);
		table.setBackground(Color.decode("#fff0f0"));
		table.setSelectionBackground(Color.decode("#ff0084"));
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add button code goes here
				tableModel.addRow();
			}
		});
		frmToDoList.getContentPane().add(btnNewButton, "flowx,cell 0 1");
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete button code goes here
				tableModel.deleteRow(table.getSelectedRow());
			}
		});
		frmToDoList.getContentPane().add(btnNewButton_1, "cell 0 1");
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmToDoList.dispose();
			}
		});
		frmToDoList.getContentPane().add(btnClose, "cell 3 1");
	}

}
