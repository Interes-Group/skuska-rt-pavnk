package sk.stuba.fei.uim.oop.objects;

import java.awt.*;

public class Circle extends Object{
    public Circle(int x, int y, int size){
        super(x,y,size);
    }
    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(x - size / 2,y - size / 2,size,size);
    }
}
