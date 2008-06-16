package nehsics.test;
import nehsics.ui.*;
import nehsics.force.*;
import nehsics.bodies.*;
import java.awt.*;
import static nehsics.math.Util.*;

public class TestOneD extends Tester {
	public final static String NAME = "Rotating Triangle";

	public static void main(String[] args) {
		new Starter(NAME);
	}

	public TestOneD(Canvas c) {
		super(c);
	}

	protected void setup() {
		PRECISION = 1;
		world.setGravityEnabled(false);
		world.setWallsEnabled(true);
		Circle c1;
		Circle c2;
		Circle c3;
		world.addBody(c1 = new Circle(10,10));	
		c1.setPosition(v(20,00));
		world.addBody(c2 = new Circle(10,10));	
		c2.setColor(Color.green);
		c2.setPosition(v(0,-10));
		world.addBody(c3 = new Circle(10,10));	
		c3.setColor(Color.red);
		c3.setPosition(v(0,-30));
		BindingForce b2 = new BindingForce(c1,c2);	
		BindingForce b1 = new BindingForce(c2,c1);	
		BindingForce b3 = new BindingForce(c2,c3);	
		BindingForce b4 = new BindingForce(c3,c2);	
		BindingForce b5 = new BindingForce(c1,c3);	
		BindingForce b6 = new BindingForce(c3,c1);	

		c1.addBond(b6,c3);
		c3.addBond(b5,c1);
		world.addBond(b6);
		world.addBond(b5);


		c2.addBond(b2,c1);
		c3.addBond(b3,c2);
		world.addBond(b2);
		world.addBond(b3);
		world.addBond(b4);
		c2.addBond(b4,c3);
		c1.addBond(b1,c2);
		world.addBond(b1);
//		world.addBody(c1 = new Circle(10,10));
//		c1.setPosition(v(-500,-30));
//		c1.setVelocity(v(90,0));
		double temp = 100;
		Circle c;
	        for (int i = 0; i < 9; i++)
       		     for (int j = 0; j < 9; j++) {
			world.addBody(c = new Circle(5,5));	
			c.setPosition(v(50+15*i-150, 50+15*j-150));
			c.setVelocity(v(temp*(Math.random()-.5), temp*(Math.random()-.5)));
		//	c.setTempColorEnabled(true,world);
		}	
//		world.addBody(c1 = new Circle(10,10));
//		c1.setPosition(v(100,10));
//		c1.setVelocity(v(-50,0));
	}
}
