/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.dpo.mvc.controller;

import cz.fit.cvut.dpo.mvc.command.EnumShape;
import cz.fit.cvut.dpo.mvc.objects.AbstractShape;
import cz.fit.cvut.dpo.mvc.objects.Position;
import cz.fit.cvut.dpo.mvc.view.IView;

/**
 *
 * @author Adam
 */
public interface IController {
    public void notifyAllViews();
    public AbstractShape getAbstractShapeById(int id);
    public void createShape(EnumShape enumShape, Position position);
    public void clearAll();
    public void editShape(AbstractShape shape);
    public void addView(IView view);
}
