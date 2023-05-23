package sk.stuba.fei.uim.oop.objects;


import java.awt.*;

public class Rectangle extends Object{

    public Rectangle(int x, int y, int size){
        super(x,y,size);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(x - size / 2,y - size / 2,size,size);
    }
}
