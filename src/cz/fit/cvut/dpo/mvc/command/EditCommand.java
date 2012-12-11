/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.command;

import cz.fit.cvut.dpo.mvc.model.IModel;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;

/**
 *
 * @author Adam
 */
public class EditCommand extends ICommand {
    AbstractShape shape;

    public EditCommand(IModel model, AbstractShape shape) {
        super(model);
        this.shape = shape;
    }
    
    @Override
    public void execute() {
        model.editShape(shape);
    }
    
}
