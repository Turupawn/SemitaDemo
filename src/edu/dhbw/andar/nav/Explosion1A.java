package edu.dhbw.andar.nav;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.Model3D;

public class Explosion1A extends Model3D{

	public boolean explotando=false;
	
	public Explosion1A() {
		super(Global.getModel("explosionfinal.obj"), "Wing.patt");
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
			Global.jugador1.hp.decrese(Global.jugador1.hp.current/4);
			/*if(Global.jugador1.hp.current<=0)
			{
				Global.jugador1.model.scale=0;
			}*/
			explotando=false;
		}
		this.model.setScale(-0.3f);
	}
}
