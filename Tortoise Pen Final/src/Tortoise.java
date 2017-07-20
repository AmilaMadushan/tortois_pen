
import java.awt.Color;
import java.awt.Graphics;
import java.util.Formatter;
import java.util.Random;

public class Tortoise implements shape{
	float x, y; // Tortoise's center x and y
	float speedX, speedY; // Tortoises's speed per step in x and y
	float radius; // Tortoises's radius
	Color color; // Tortoises's color
        float x1,x2,x3,x4,x5,y1,y2,y3,y4,y5,factor=1;
        int direction;

	public Tortoise(float x, float y, float radius, float speed, float angleInDegree, Color color) {
		this.x = x;
		this.y = y;
		this.speedX = (float) (speed * Math.cos(Math.toRadians(angleInDegree)));
		this.speedY = (float) (-speed * (float) Math.sin(Math.toRadians(angleInDegree)));
		this.radius = radius;
		this.color = color;
                x1=((x - radius));
                y1=(y -radius);
                x2=(x-11);
                y2=(y+15);
                x3=(x+11);
                y3=(y-20);
                
                x4=(x-31);
                y4=(y);
                x5=(x-9);
                y5=(y-35);
	}

	public void update(float incr,int i) {
          
              direction = (int) (((Math.random()*360) % 360)+1)*(i+1);
              System.out.println(""+direction);

		this.x += ((this.speedX *incr));
		this.y += (this.speedY *incr);
                this.y1+=(this.speedY*incr);
                this.x1+=(this.speedX*incr);
                
                this.y2+=(this.speedY*incr);
                this.x2+=(this.speedX*incr);
                
                 this.y3+=(this.speedY*incr);
                this.x3+=(this.speedX*incr);
                 this.y4+=(this.speedY*incr);
                this.x4+=(this.speedX*incr);
                 this.y5+=(this.speedY*incr);
                this.x5+=(this.speedX*incr);
                
	}

	/** Draw itself using the given graphics context. */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                
	}
        /** Draw itself using the given graphics context. */
	public void draw1(Graphics g) {
		g.setColor(color);
		//g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                g.fillOval((int) (x1-factor),(int) (y1-factor),20,20);//head
               
	}
       public void draw2(Graphics g) {
		g.setColor(color);
		//g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                g.fillOval((int) (x2),(int) (y2),15,15);//leg1
               
	}
        public void draw3(Graphics g) {
		g.setColor(color);
		//g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                g.fillOval((int) (x3),(int) (y3),15,15);//leg2
               
	}
        public void draw4(Graphics g) {
		g.setColor(color);
		//g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                g.fillOval((int) (x4),(int) (y4),15,15);//leg 3
               
	}
         public void draw5(Graphics g) {
		g.setColor(color);
		//g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
                g.fillOval((int) (x5),(int) (y5),15,15);//leg 4
               
	}
	/** Return mass */
	public float getMass() {
		return 2 * radius * radius * radius / 1000f;
	}

 

}
