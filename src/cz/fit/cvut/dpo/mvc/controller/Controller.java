/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.controller;

import cz.fit.cvut.dpo.mvc.command.ClearCommand;
import cz.fit.cvut.dpo.mvc.command.CreateShapeCommand;
import cz.fit.cvut.dpo.mvc.command.EditCommand;
import cz.fit.cvut.dpo.mvc.command.EnumShape;
import cz.fit.cvut.dpo.mvc.model.IModel;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;
import cz.fit.cvut.dpo.mvc.objects.Position;
import cz.fit.cvut.dpo.mvc.view.IView;

/**
 *
 * @author honza
 */
public class Controller implements IController {

       private IView view;
    private IModel model;
    
    public Controller( IModel model) {        
        this.model = model;
    }
    
    @Override
    public void notifyAllViews() {
            view.notifyView();
    }
    
    @Override
    public AbstractShape getAbstractShapeById(int id) {
      return model.getShapeById(id);
    }
    
    
    @Override
    public void createShape(EnumShape enumShape, Position position) {
        System.out.println("controller create shape");
        model.executeCommand(new CreateShapeCommand(model, enumShape, position));
        notifyAllViews();
    } 
    
    @Override
    public void clearAll(){
        model.executeCommand(new ClearCommand(model));
        notifyAllViews();
    }
    
    @Override
    public void editShape(AbstractShape shape){
        model.executeCommand(new EditCommand(model, shape));
        notifyAllViews();
    }
    
    @Override
    public void addView(IView view){
        this.view=view;
    }
    
}
