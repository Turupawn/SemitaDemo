package edu.dhbw.andar.nav;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.Model3D;

public class Terreno extends Model3D{
	public Terreno()
	{
		super(Global.getModel("espacio.obj"),"e2.patt");
		this.model.scale=15;
	}
}
