package edu.dhbw.andar.nav;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.models.Model;
import edu.dhbw.andobjviewer.graphics.MiCharacter;
import edu.dhbw.andobjviewer.graphics.FuncionesNaves;

public class Rampano extends MiCharacter implements FuncionesNaves{
	
	static String model_str = "navealienigena.obj";
	static String pattern_str = "Rampano.patt";
	
	public Rampano() {
		super(Global.getModel(model_str), pattern_str);
		
	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void armaUno() {
		// TODO Auto-generated method stub
		
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
