import utils.*;
import utils.Rectangle;

import java.applet.Applet;
import java.awt.*;

public class AppletLauncher extends Applet{

    @Override
    public void init(){
        this.setSize(500, 500);
        System.out.println("setsize");
    }
    @Override
    public void paint(Graphics g){

        super.paint(g);

        for(int i=0; i<100; i++){
            double rand = Math.random();
            GeometricFigure geoFig = null;
            if(rand>0.7){
                geoFig = new Carre(rand*100*i, rand*100*i);
            }else if(rand>0.5){
                geoFig = new Cercle(i*20, rand*200, rand*200);
            }else if(rand>0.3){
                geoFig = new Elipse(i*200, rand*200, rand*10*i, rand*10);
            }else{
                geoFig = new Rectangle(i*rand*200, rand*200);
            }
            geoFig.draw(g);
        }
    }
}
