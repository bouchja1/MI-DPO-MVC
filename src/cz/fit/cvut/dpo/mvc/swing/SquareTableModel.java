/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.swing;

import cz.fit.cvut.dpo.mvc.command.EnumShape;
import cz.fit.cvut.dpo.mvc.controller.Controller;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;
import cz.fit.cvut.dpo.mvc.objects.Circle;
import cz.fit.cvut.dpo.mvc.objects.Position;
import cz.fit.cvut.dpo.mvc.objects.Square;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class SquareTableModel extends AbstractMyTableModel<Square>{
    //private List<Square> tableList;

    public SquareTableModel(Controller controller, List<AbstractShape> shapeList, EnumShape enumShape) {
        super(controller, shapeList, enumShape);
        initTableList(enumShape);        
        this.columnNames = new String[] {"id", "x", "y", "side"};
    }
    
    @Override
    protected void initTableList(EnumShape enumShape){
        tableList = new ArrayList<Square>();
        for (AbstractShape abstractShape : shapeList) {
            if(abstractShape.getType() == enumShape) tableList.add((Square) abstractShape);
        }
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tableList.get(rowIndex).getId();
            case 1:
                return tableList.get(rowIndex).getPosition().x;
            case 2:
                return tableList.get(rowIndex).getPosition().y;
            case 3:                
                return tableList.get(rowIndex).getSide();
            default:
                return "fuck";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        super.setValueAt(aValue, rowIndex, columnIndex);
        Square shape = (Square)controller.getAbstractShapeById(getShapeId(rowIndex));
        int intValue = Integer.valueOf(aValue.toString());
        if(columnIndex == 3)  {
                controller.editShape(shape);
                tableList.get(rowIndex).setSide(intValue);
        }
    }
     @Override
    public int getRowCount() {
        return tableList.size();
    }

    
}
