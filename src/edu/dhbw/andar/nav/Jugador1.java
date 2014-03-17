package edu.dhbw.andar.nav;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.FuncionesNaves;
import edu.dhbw.andobjviewer.graphics.MiCharacter;

public class Jugador1 extends MiCharacter implements FuncionesNaves{
	
	static String model_str = "SilverLight.obj";
	static String pattern_str = "Wing.patt";
	public Bala bala;
	boolean moveY = false;
	
	public Jugador1()
	{
		super(Global.getModel(model_str),pattern_str);
	}
	
	public String getPattName(){
		return pattern_str;
	}

	@Override
	public void moverY() {
		// TODO Auto-generated method stub
		if (moveY==false){
			moveY=true;
		}
	}

	@Override
	public void armaUno() {
		this.bala = new Bala(pattern_str);
		try{
			Global.artoolkit.registerARObject(this.bala);
			this.bala.model.setYrot(90f);
		}catch(Exception e){
			
		}
	}

	@Override
	public void armaDos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armaTres() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armaCuatro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armaCinco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armaSeis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kamikaze() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void specialBuff() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void draw(GL10 gl){
		super.draw(gl);
		
		if(this.hp.current<=0){
			this.model.scale=0;
		}
		
		if(moveY){
			this.model.setYpos(-1f);
			
			if(this.model.ypos<-20){
				moveY = false;
			}
		}else{
			this.model.ypos=0f;
		}
		
		if(this.moveY && Global.jugador2.moveY){
			if(this.model.ypos<=-20 || Global.jugador2.model.ypos<=-20){
				this.hp.decrese(Global.jugador2.hp.current);
			}
		}
	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
