package edu.dhbw.andar.pub;

import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.content.res.AssetManager;

import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.nav.*;
import edu.dhbw.andobjviewer.graphics.MiCharacter;
import edu.dhbw.andobjviewer.models.Model;
import edu.dhbw.andobjviewer.parser.ObjParser;
import edu.dhbw.andobjviewer.util.AssetsFileUtil;
import edu.dhbw.andobjviewer.util.BaseFileUtil;

public class Global {
	public static String player_action = "nada";
	
	public static ARToolkit artoolkit;
	public static AssetManager am;
	public static Hunter hunter;
	public static Rampano rampano;
	public static Wing wing;
	public static Dreamspark dreamspark;
	public static StartupWeekend sw;
	
	public static Model getModel(String obj_path)
	{
		BaseFileUtil fileUtil = new AssetsFileUtil(am);
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
	
	
	
}
