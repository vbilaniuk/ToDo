//import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class tableModel extends AbstractTableModel {
	// declare data structure in here
	//private ArrayList<String> list;
	private Object[][] data = {{new Boolean(false), "New task"}};
	private int numRows;
	private int numCols;
	private String[] columnNames = {"Done?", "Task"};
	
	public tableModel() {
		//list = new ArrayList<>();
		numRows = 1;
		numCols = 2;
		//data = new Object[numRows][numCols];
		//data[0][0] = new Boolean(false);
		//data[0][1] = "New task"; 
	}
	
	public int getColumnCount() {
		return numCols;
	}
	
	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public int getRowCount() {
		//return list.size();
		return data.length;
	}
	
	public Object getValueAt(int row, int col) {
    	return data[row][col];
    }
	
	public boolean isCellEditable(int row, int col) {
		return true; 
	}
	
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        //fireTableDataChanged();
        fireTableCellUpdated(row, col);
    }
	
	public void addRow() {
		Object[][] tempData = new Object[numRows][numCols];
		System.arraycopy(data, 0, tempData, 0, data.length);
		data = new Object[numRows+1][numCols];
		System.arraycopy(tempData, 0, data, 0, tempData.length);
		data[numRows][0] = new Boolean(false);
		data[numRows][1] = "New task";
		numRows++;
		fireTableDataChanged();
	}
	
	public void deleteRow(int rowNum) {
		if (rowNum == -1) return; // exit immediately if we are not passed a valid row number
		// get record number first
		Object[][] tempData = new Object[numRows][numCols];
		System.arraycopy(data, 0, tempData, 0, data.length);
		data = new Object[numRows-1][numCols];
		// now it's a bit harder because we have to eliminate the specified row so we can't just blindly copy
		// also, it's possible we're deleting the last record, which means we have to update lastRecordNum
		int k = 0;
		for (int i = 0; i < numRows; i++) {
			if (i != rowNum) {
				for (int j = 0; j < 2; j++) {
					data[k][j] = tempData[i][j];
				}
				k++;
			}
		}
		
		numRows--;
		fireTableDataChanged();
	}
}
