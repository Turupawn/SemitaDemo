package edu.dhbw.andar.nav;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.Model3D;
import edu.dhbw.andobjviewer.models.Model;

public class Bala extends Model3D {
	
	public boolean disparando = false;
	float mitad = 0.0f;
	float tmp = 0.4f;

	public Bala(String pattern_file) {
		super(Global.getModel("balacanon.obj"), pattern_file);
		this.model.setScale(15);
		
	}
	
	@Override
	public void draw(GL10 gl) {
		super.draw(gl);
		if(disparando){
			if(Global.turno_jugador_1){
				this.model.setYpos(-1f);
				
				if(this.model.ypos<-10){
					Global.jugador1.hp.decrese(Global.jugador1.hp.current/8);
					this.disparando=!this.disparando;
				}
				//this.tmp += tmp;
				
				/*if((this.model.ypos%5)*(-1) == tmp){
					this.model.scale=0f;
					this.disparando=!this.disparando;
				}*/
			}else{
				this.model.setYpos(-1f);
				
				if(this.model.ypos<-10){
					Global.jugador2.hp.decrese(Global.jugador2.hp.current/8);
					this.disparando=!this.disparando;
				}
				//this.tmp += tmp;
				
				/*if((this.model.ypos%5)*(-1) == tmp){
					this.model.scale=0f;
					this.disparando=!this.disparando;
				}*/
			}
		}else{
			this.model.scale=0;
			this.model.ypos=0;
		}
	}

}
