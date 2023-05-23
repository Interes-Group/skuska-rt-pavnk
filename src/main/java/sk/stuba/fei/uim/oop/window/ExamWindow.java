package sk.stuba.fei.uim.oop.window;

import sk.stuba.fei.uim.oop.chain.Chain;
import sk.stuba.fei.uim.oop.objects.Circle;
import sk.stuba.fei.uim.oop.objects.Clock;
import sk.stuba.fei.uim.oop.objects.Object;
import sk.stuba.fei.uim.oop.objects.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;

public class ExamWindow extends JFrame implements ItemListener {
    private final JPanel canvas;
    private final JSlider lengthSlider;
    private final JSlider radiusSlider;
    private final JSlider spacingSlider;
    private final JComboBox<String> objectBox;
    private Chain chain;
    private int length;
    private int radius;
    private int spacing;
    private int boxValue;

    public ExamWindow(){
        setTitle("ExamRT");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        boxValue = 0;

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                chain.addIntoChain(x, y);
                canvas.repaint();
            }
        });

        length = 50;
        radius = 5;
        spacing = 5;

        JPanel leftMenu = new JPanel();
        leftMenu.setLayout(new BorderLayout());

        lengthSlider = new JSlider(JSlider.VERTICAL,0,18,3);
        lengthSlider.setMajorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setSnapToTicks(true);
        BoundedRangeModel lengthModel = lengthSlider.getModel();
        lengthModel.addChangeListener(e -> {
            if (!lengthModel.getValueIsAdjusting()) {
                if(length>lengthSlider.getValue() * 10 + 20){
                    length = lengthSlider.getValue() * 10 + 20;
                    chain = new Chain(length);
                    canvas.repaint();
                } else{
                    length = lengthSlider.getValue() * 10 + 20;
                    Chain newChain = new Chain(length);
                    newChain.setChainList(chain.getChainList());
                    chain = newChain;
                }
            }
        });

        Hashtable<Integer, JLabel> lengthLabelTable = new Hashtable<>();
        lengthLabelTable.put(0, new JLabel("20"));
        lengthLabelTable.put(1, new JLabel("30"));
        lengthLabelTable.put(2, new JLabel("40"));
        lengthLabelTable.put(3, new JLabel("50"));
        lengthLabelTable.put(4, new JLabel("60"));
        lengthLabelTable.put(5, new JLabel("70"));
        lengthLabelTable.put(6, new JLabel("80"));
        lengthLabelTable.put(7, new JLabel("90"));
        lengthLabelTable.put(8, new JLabel("100"));
        lengthLabelTable.put(9, new JLabel("110"));
        lengthLabelTable.put(10, new JLabel("120"));
        lengthLabelTable.put(11, new JLabel("130"));
        lengthLabelTable.put(12, new JLabel("140"));
        lengthLabelTable.put(13, new JLabel("150"));
        lengthLabelTable.put(14, new JLabel("160"));
        lengthLabelTable.put(15, new JLabel("170"));
        lengthLabelTable.put(16, new JLabel("180"));
        lengthLabelTable.put(17, new JLabel("190"));
        lengthLabelTable.put(18, new JLabel("200"));

        lengthSlider.setLabelTable(lengthLabelTable);
        lengthSlider.setPaintLabels(true);
        leftMenu.add(lengthSlider, BorderLayout.WEST);


        radiusSlider = new JSlider(JSlider.VERTICAL,0,19,4);
        radiusSlider.setMajorTickSpacing(1);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setSnapToTicks(true);

        BoundedRangeModel radiusModel = radiusSlider.getModel();
        radiusModel.addChangeListener(e -> {
            if (!radiusModel.getValueIsAdjusting()) {
                radius = radiusSlider.getValue() + 1;
                canvas.repaint();
            }
        });

        Hashtable<Integer, JLabel> radiusLabelTable = new Hashtable<>();
        radiusLabelTable.put(0, new JLabel("1"));
        radiusLabelTable.put(1, new JLabel("2"));
        radiusLabelTable.put(2, new JLabel("3"));
        radiusLabelTable.put(3, new JLabel("4"));
        radiusLabelTable.put(4, new JLabel("5"));
        radiusLabelTable.put(5, new JLabel("6"));
        radiusLabelTable.put(6, new JLabel("7"));
        radiusLabelTable.put(7, new JLabel("8"));
        radiusLabelTable.put(8, new JLabel("9"));
        radiusLabelTable.put(9, new JLabel("10"));
        radiusLabelTable.put(10, new JLabel("11"));
        radiusLabelTable.put(11, new JLabel("12"));
        radiusLabelTable.put(12, new JLabel("13"));
        radiusLabelTable.put(13, new JLabel("14"));
        radiusLabelTable.put(14, new JLabel("15"));
        radiusLabelTable.put(15, new JLabel("16"));
        radiusLabelTable.put(16, new JLabel("17"));
        radiusLabelTable.put(17, new JLabel("18"));
        radiusLabelTable.put(18, new JLabel("19"));
        radiusLabelTable.put(19, new JLabel("20"));

        radiusSlider.setLabelTable(radiusLabelTable);
        radiusSlider.setPaintLabels(true);
        leftMenu.add(radiusSlider, BorderLayout.CENTER);

        spacingSlider = new JSlider(JSlider.VERTICAL,0,19,4);
        spacingSlider.setMajorTickSpacing(1);
        spacingSlider.setPaintTicks(true);
        spacingSlider.setSnapToTicks(true);

        BoundedRangeModel spacingModel = spacingSlider.getModel();
        spacingModel.addChangeListener(e -> {
            if (!spacingModel.getValueIsAdjusting()) {
                spacing = spacingSlider.getValue() + 1;
                canvas.repaint();
            }
        });

        Hashtable<Integer, JLabel> spacingLabelTable = new Hashtable<>();
        spacingLabelTable.put(0, new JLabel("1"));
        spacingLabelTable.put(1, new JLabel("2"));
        spacingLabelTable.put(2, new JLabel("3"));
        spacingLabelTable.put(3, new JLabel("4"));
        spacingLabelTable.put(4, new JLabel("5"));
        spacingLabelTable.put(5, new JLabel("6"));
        spacingLabelTable.put(6, new JLabel("7"));
        spacingLabelTable.put(7, new JLabel("8"));
        spacingLabelTable.put(8, new JLabel("9"));
        spacingLabelTable.put(9, new JLabel("10"));
        spacingLabelTable.put(10, new JLabel("11"));
        spacingLabelTable.put(11, new JLabel("12"));
        spacingLabelTable.put(12, new JLabel("13"));
        spacingLabelTable.put(13, new JLabel("14"));
        spacingLabelTable.put(14, new JLabel("15"));
        spacingLabelTable.put(15, new JLabel("16"));
        spacingLabelTable.put(16, new JLabel("17"));
        spacingLabelTable.put(17, new JLabel("18"));
        spacingLabelTable.put(18, new JLabel("19"));
        spacingLabelTable.put(19, new JLabel("20"));

        spacingSlider.setLabelTable(radiusLabelTable);
        spacingSlider.setPaintLabels(true);
        leftMenu.add(spacingSlider, BorderLayout.EAST);

        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(700,700));
        setLayout(new BorderLayout());
        add(canvas,BorderLayout.CENTER);
        add(leftMenu,BorderLayout.WEST);


        String[] values = {"CIRCLE", "RECTANGLE", "HOUR-GLASS"};
        objectBox = new JComboBox<>(values);
        objectBox.setSelectedIndex(0);
        objectBox.addItemListener(this);
        leftMenu.add(objectBox, BorderLayout.SOUTH);


        setFocusable(true);
        setVisible(true);

        chain = new Chain(length);
    }

    private void draw(Graphics g){
        ArrayList chainList = chain.getChainList();
        int chainLen = chain.getLength();
        if(chainLen > 0){
            g.setColor(Color.RED);
            for(int i=0; i<chainLen; ++i){
                Dimension d1 = (Dimension) chainList.get(i);
                if(i!=chainLen-1){
                    Dimension d2 = (Dimension) chainList.get(i+1);
                    g.drawLine(d1.width,d1.height,d2.width,d2.height);
                }
                if(i%spacing == 0 || i==0 || i==chainLen-1){
                    Object o = null;

                    if(boxValue==0){

                        o = new Circle(d1.width,d1.height,radius*2);
                    } else if (boxValue==1) {
                        o = new Rectangle(d1.width,d1.height, radius*2);
                    } else if(boxValue==2){
                        o = new Clock(d1.width,d1.height,radius*2);
                    }
                    if (o != null){
                        int val = 255/(chainLen+1);
                        int red = 255-(val*i);
                        int blue = 0+(val * i);
                        Color color = new Color(red,0,blue);
                        o.draw(g, color);
                    }
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            boxValue = objectBox.getSelectedIndex();
            canvas.repaint();
        }
    }
}
