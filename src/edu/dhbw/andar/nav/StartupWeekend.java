package edu.dhbw.andar.nav;

import edu.dhbw.andar.pub.Global;
import edu.dhbw.andobjviewer.graphics.MiCharacter;
import edu.dhbw.andobjviewer.models.Model;

public class StartupWeekend extends MiCharacter {

	static String model = "startupweekend.obj";
	static String pattern = "startupw.patt";
	
	public StartupWeekend() {
		super(Global.getModel(model), pattern);
		this.selected.model.scale=0;
	}
	
}
