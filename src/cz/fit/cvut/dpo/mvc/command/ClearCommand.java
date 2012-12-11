/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.command;

import cz.fit.cvut.dpo.mvc.model.IModel;

/**
 *
 * @author Adam
 */
public class ClearCommand extends ICommand{

    public ClearCommand(IModel model) {
        super(model);
    }
    

    @Override
    public void execute() {
        model.clearAllShapes();
    }
    
}
