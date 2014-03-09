package edu.dhbw.andar.pub;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;
import edu.dhbw.andar.nav.*;
import edu.dhbw.andobjviewer.graphics.HP;
import edu.dhbw.andobjviewer.graphics.MiCharacter;
import edu.dhbw.andobjviewer.graphics.Model3D;
import edu.dhbw.andobjviewer.models.Model;
import edu.dhbw.andobjviewer.parser.ObjParser;
import edu.dhbw.andobjviewer.parser.ParseException;
import edu.dhbw.andobjviewer.util.AssetsFileUtil;
import edu.dhbw.andobjviewer.util.BaseFileUtil;
import edu.semita.demo.R;

/**
 * Example of an application that makes use of the AndAR toolkit.
 * @author Tobi
 *
 */
public class CustomActivity extends AndARActivity {
	
	private final int MENU_SCREENSHOT = 0;
	private final int MENU_THUNDER = 1;
	private final int MENU_HEAL = 2;
	
	Menu menu;
	
	boolean created =  false;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CustomRenderer renderer = new CustomRenderer();//optional, may be set to null
		Global.am=getResources().getAssets();
		
		super.setNonARRenderer(renderer);//or might be omited
		try
		{
			Global.artoolkit = super.getArtoolkit();

			Global.wing = new Wing();
			Global.artoolkit.registerARObject(Global.wing);
			
			Global.hunter = new Hunter();
			Global.artoolkit.registerARObject(Global.hunter);
			
			Global.rampano = new Rampano();
			Global.artoolkit.registerARObject(Global.rampano);
			
			Global.dreamspark = new Dreamspark();
			Global.artoolkit.registerARObject(Global.dreamspark);
			
			Global.sw = new StartupWeekend();
			Global.artoolkit.registerARObject(Global.sw);
			
		}catch (Exception ex){
			//handle the exception, that means: show the user what happened
			System.out.println("");
		}
	}
	
	Model getModel(String obj_path)
	{
		BaseFileUtil fileUtil = new AssetsFileUtil(getResources().getAssets());
		fileUtil.setBaseFolder("models/");
		Model model = null;
		ObjParser parser = new ObjParser(fileUtil);
		if(fileUtil != null) {
			BufferedReader fileReader = fileUtil.getReaderFromName(obj_path);
			if(fileReader != null) {
				try {
					model = parser.parse("Model", fileReader);
					model.scale=4;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return model;
	}

	/**
	 * Inform the user about exceptions that occurred in background threads.
	 * This exception is rather severe and can not be recovered from.
	 * Inform the user and shut down the application.
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e("AndAR EXCEPTION", ex.getMessage());
		finish();
	}
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		menu.add(0, MENU_SCREENSHOT, 0, getResources().getText(R.string.takescreenshot))
		.setIcon(R.drawable.screenshoticon);
		menu.add(1, MENU_THUNDER, 1, getResources().getText(R.string.thunder))
		.setIcon(R.drawable.thunder);
		menu.add(2, MENU_HEAL, 2, getResources().getText(R.string.heal))
		.setIcon(R.drawable.heal);
		
		this.menu=menu;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*if(item.getItemId()==1) {
			artoolkit.unregisterARObject(someObject);
		} else if(item.getItemId()==0) {
			try {
				someObject = new CustomObject
				("test", "patt.hiro", 80.0, new double[]{0,0});
				artoolkit.registerARObject(someObject);
			} catch (AndARException e) {
				e.printStackTrace();
			}
			
			
		}*/
		
		switch(item.getItemId()) {
		case MENU_SCREENSHOT:
			new TakeAsyncScreenshot().execute();
			break;
		case MENU_THUNDER:
			//Global.wing.mover(x, y);
		}
		return true;
	}
	
	class TakeAsyncScreenshot extends AsyncTask<Void, Void, Void> {
		
		private String errorMsg = null;

		@Override
		protected Void doInBackground(Void... params) {
			Bitmap bm = takeScreenshot();
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("/sdcard/AndARScreenshot"+new Date().getTime()+".png");
				bm.compress(CompressFormat.PNG, 100, fos);
				fos.flush();
				fos.close();					
			} catch (FileNotFoundException e) {
				errorMsg = e.getMessage();
				e.printStackTrace();
			} catch (IOException e) {
				errorMsg = e.getMessage();
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			if(errorMsg == null)
				Toast.makeText(CustomActivity.this, getResources().getText(R.string.screenshotsaved), Toast.LENGTH_SHORT ).show();
			else
				Toast.makeText(CustomActivity.this, getResources().getText(R.string.screenshotfailed)+errorMsg, Toast.LENGTH_SHORT ).show();
		};	
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		/*super.onTouchEvent(event);
		if(monstruo1.isVisible() && !monstruo2.isVisible() && monstruo1.model.scale==4)
		{
			monstruo1.model.scale=8;
			monstruo2.model.scale=4;
			monstruo2.selected.model.scale=0;
		}
		if(monstruo2.isVisible() && !monstruo1.isVisible() && monstruo2.model.scale==4)
		{
			monstruo2.model.scale=8;
			monstruo2.selected.model.scale=4;
			monstruo1.model.scale=4;
			monstruo2.hp.decrese(10);
		}*/
		return true;
	}
	
	@Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.exit(0);
    }
	
	
}
