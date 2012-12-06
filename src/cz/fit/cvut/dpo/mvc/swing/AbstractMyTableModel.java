/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.swing;

import cz.fit.cvut.dpo.mvc.command.EnumShape;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;
import cz.fit.cvut.dpo.mvc.objects.Position;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Adam
 */
public abstract class AbstractMyTableModel extends AbstractTableModel{
    List<AbstractShape> shapeList;
    String columnNames[];
    EnumShape enumShape;

    public AbstractMyTableModel(List<AbstractShape> shapeList, EnumShape enumShape) {          
        super();
        this.shapeList = shapeList;  
        this.enumShape = enumShape;
    }

    @Override
    public void fireTableDataChanged() {
        initTableList(enumShape);
        super.fireTableDataChanged();
        
    }
    
    
    protected abstract void initTableList(EnumShape enumShape);

   
    @Override
    public int getColumnCount() {
        return 4;
    }

    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex != 0)  return true;
        return false;
    }
   
    @Override
     public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
         
     }

   
    
}
