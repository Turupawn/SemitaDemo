package edu.dhbw.andar.nav;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.Model3D;

public class Explosion3 extends Model3D{

	public boolean explotando=false;
	
	public Explosion3() {
		super(Global.getModel("explosion.obj"), "Wing.patt");
		// TODO Auto-generated constructor stub
		this.model.scale=0;
	}
	
	@Override
	public void draw(GL10 gl) {
		super.draw(gl);
		if(explotando)
			this.model.setScale(0.8f);
		if(this.model.scale>=7)
		{
			Global.wing.model.scale=0;
			explotando=false;
		}
		this.model.setScale(-0.3f);
	}
}
