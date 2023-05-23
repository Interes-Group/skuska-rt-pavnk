package sk.stuba.fei.uim.oop.chain;

import java.awt.*;
import java.util.ArrayList;

public class Chain {
    private int length;
    private ArrayList chainList;

    public Chain(int length){
        this.length = length;
        this.chainList = new ArrayList<>();
    }

    public void addIntoChain(int x, int y){
        if(chainList.size() == length){
            chainList.remove(length-1);
        }
        Dimension d = new Dimension(x,y);
        chainList.add(0,d);
    }

    public void setChainList(ArrayList newChainList){
        this.chainList = newChainList;
    }
    public ArrayList getChainList(){
        return this.chainList;
    }

    public int getLength(){
        return this.chainList.size();
    }

}
