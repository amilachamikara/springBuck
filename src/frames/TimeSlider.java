/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Amila
 */
public class TimeSlider extends JSlider implements TableCellRenderer {

    public TimeSlider(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
    }

    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        
        int colWidth = (table.getColumnModel()).getColumn(column).getWidth();
        int colHeight = table.getRowHeight();
        setOpaque(false);
        setPaintLabels(true);
        setPaintTicks(true);
        setSize(new Dimension(colWidth, colHeight));
        setValue(((Integer)value).intValue());
        updateUI();
        return this;
        
    }

}
