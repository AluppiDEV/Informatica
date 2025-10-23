/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 7.0
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Square ground;
    private Square sky;
    private Triangle roof;
    private Circle sun;
    private Circle moon;
    private boolean drawn;
    private boolean drawnSunset;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        ground = new Square();
        sky = new Square();
        roof = new Triangle();  
        sun = new Circle();
        moon = new Circle();
        drawn = false;
        drawnSunset = false;
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            sky.changeColor("black");
            sky.moveHorizontal(-350);
            sky.moveVertical(-350);
            sky.changeSize(5000);
            
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();
            
            window.changeColor("black");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();
    
            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();
    
            sun.changeColor("yellow");
            sun.moveHorizontal(80);
            sun.moveVertical(-40);
            sun.changeSize(80);
            sun.makeVisible();
            
            moon.changeColor("white");
            moon.moveHorizontal(-270);
            moon.moveVertical(120);
            moon.changeSize(80);
            moon.makeVisible();
            
            ground.changeColor("green");
            ground.moveHorizontal(-350);
            ground.moveVertical(130);
            ground.changeSize(5000);
            ground.makeVisible();
            
            drawn = true;
        }
    }
    
    /**
     * Ridisegna gli elementi velocemente
     */
    private void reDraw()
    {
        sky.makeVisible();
        moon.makeVisible();
        wall.makeVisible();
        window.makeVisible();
        roof.makeVisible();
        sun.makeVisible();
        ground.makeVisible();
    }
    
    /**
     * Sposta l'elemento luna contemporaneamente
     */
    private void moveMoon()
    {
        moon.slowMoveHorizontal(1);
        moon.slowMoveVertical(-1);
    }
    
    /**
     * Sposta l'elemento luna contemporaneamente
     */
    private void moveSun()
    {
        sun.slowMoveHorizontal(1);
        sun.slowMoveVertical(1);
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("black");
        window.changeColor("white");
        roof.changeColor("black");
        sun.changeColor("black");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        sun.changeColor("yellow");
    }
    
    /**
     * Animazione per il tramonto
     */
    public void drawSunset()
    {
        if (!drawnSunset)
        {
            for (int i=0; i<150; i++)
            {
                moveSun();
            }
            sun.changeColor("red");
            window.changeColor("yellow");
            reDraw();
            for (int i=0; i<150; i++)
            {
                moveMoon();
            }
            reDraw();
        }
    }
}
