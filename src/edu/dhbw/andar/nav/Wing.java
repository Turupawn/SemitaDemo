package edu.dhbw.andar.nav;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.FuncionesNaves;
import edu.dhbw.andobjviewer.graphics.MiCharacter;
import edu.dhbw.andobjviewer.models.Model;

public class Wing extends MiCharacter implements FuncionesNaves{
	
	static String model_str = "SilverLight.obj";
	static String pattern_str = "Wing.patt";
	
	public Wing() {
		super(Global.getModel(model_str), pattern_str);
		
	}

	@Override
	public void mover(int x, int y) {
		//this.
	}

	@Override
	public void armaUno() {
		
		
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
	
}
