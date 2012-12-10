/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.swing;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Adam
 */
public class MyTableModelListener implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();   
                System.out.println("TableChanged");
                TableModel model = (TableModel) e.getSource();
                if((column != TableModelEvent.ALL_COLUMNS)&&(row != TableModelEvent.HEADER_ROW)){                    
                    String columnName = model.getColumnName(column);
                    Object data = model.getValueAt(row, column);
                    System.out.println("Zmenilo se:" + data.toString() + "na xy" + row + " " + column);
                    model.setValueAt(data, row, column);
                }

    }
}
