package sk.stuba.fei.uim.oop.objects;

import java.awt.*;

public abstract class Object {
    protected int x;
    protected int y;
    protected int size;

    public Object(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public abstract void draw(Graphics g, Color color);
}
