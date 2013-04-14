package org.vinsert.component.debug;

import org.vinsert.bot.script.api.Widget;

import javax.swing.*;
import java.awt.*;

public class DebugWidgets extends Debugger {

    private int group = -1;
    private boolean inputRequested = false;

    @Override
    public void draw(Graphics2D g) {
        if (group == -1 && !inputRequested) {
            inputRequested = true;
            group = Integer.parseInt(JOptionPane.showInputDialog("Enter group id: "));
        }

        for (Widget widget : getContext().widgets.get(group)) {
            if (widget == null) continue;

            g.setColor(Color.WHITE);
            //g.drawString("p=" + widget.getParentId() + ", c=" + widget.getId(), widget.getX(), widget.getY());
            g.drawString("c=" + widget.getId(), widget.getX(), widget.getY());
            g.setColor(Color.ORANGE);
            g.drawRect(widget.getX(), widget.getY(), widget.getBounds().width, widget.getBounds().height);

            for (Widget child : widget.getChildren()) {
                g.setColor(Color.WHITE);
                g.drawString("c=" + child.getId(), child.getX(), child.getY());
                g.setColor(Color.ORANGE);
                g.drawRect(child.getX(), child.getY(), child.getBounds().width, child.getBounds().height);
            }
        }
    }

}
