package sk.stuba.fei.uim.oop.objects;

import java.awt.*;

public class Clock extends Object{
    public Clock(int x, int y, int size){
        super(x,y,size);
    }
    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        int[] xPoint = {x, x - size / 2, x + size / 2};
        int[] yPoint = {y, y - size / 2, y - size / 2};
        g.fillPolygon(xPoint,yPoint,3);

        int[] xPoint2 = {x, x - size / 2, x + size / 2};
        int[] yPoint2 = {y, y + size / 2, y + size / 2};
        g.fillPolygon(xPoint2,yPoint2,3);
    }
}
