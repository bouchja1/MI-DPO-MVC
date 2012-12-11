/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.swing;

import cz.fit.cvut.dpo.mvc.command.EnumShape;
import cz.fit.cvut.dpo.mvc.controller.FacadeController;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;
import cz.fit.cvut.dpo.mvc.objects.Position;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adam
 */
public abstract class AbstractMyTableModel<T extends AbstractShape> extends AbstractTableModel {

    List<AbstractShape> shapeList;
    String columnNames[];
    EnumShape enumShape;
    FacadeController controller;
    List<T> tableList;

    public AbstractMyTableModel(FacadeController controller, List<AbstractShape> shapeList, EnumShape enumShape) {
        super();
        this.shapeList = shapeList;
        this.enumShape = enumShape;
        this.controller = controller;
    }

    @Override
    public void fireTableDataChanged() {
        initTableList(enumShape);
        super.fireTableDataChanged();
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column);
        System.out.println("Zmenilo se:" + row + " " + column);
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
        if (columnIndex != 0) {
            return true;
        }
        return false;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        
        Position pos;
        T shape = (T)controller.getAbstractShapeById(getShapeId(rowIndex));
        int intValue = Integer.valueOf(aValue.toString());
        switch (columnIndex) {

            case 1:
                pos = new Position(intValue, shape.getPosition().y);                
                tableList.get(rowIndex).setPosition(pos);
                controller.editShape(shape);
                break;
            case 2:
                pos = new Position(shape.getPosition().x, intValue);                
                tableList.get(rowIndex).setPosition(pos);
                controller.editShape(shape);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    Position setPosition(AbstractShape shape, int columnIndex, int intValue) {
        Position pos = null;

        return pos;
    }

    int getShapeId(int rowIndex) {
        return Integer.parseInt(getValueAt(rowIndex, 0).toString());
    }
}
