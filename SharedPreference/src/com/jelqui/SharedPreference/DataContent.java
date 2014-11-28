package com.jelqui.SharedPreference;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.*;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;

public class DataContent
{

	private final String SHARED_PREFS_FILE = "JelquiPrefs"; // nombre del xml
	private final String KEY_EMAIL = "email"; //nombre del campo xml
	private final String KEY_PASS = "pass";
	private Context mContext;





	public DataContent(Context context){
		mContext = context;
	}


	private SharedPreferences getSettings(){
		return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
	}

	//function que retorna el valor en el xml
	public String getUserEmail(){
		return getSettings().getString(KEY_EMAIL, null);  
	}

	// funcion que ingresa los datos en el archivo xml
	public void setUserEmail(String email,String pass){

		SharedPreferences.Editor editor = getSettings().edit();
		editor.putString(KEY_EMAIL, email );
		editor.putString(KEY_PASS, pass);
		editor.commit();



	}


}

