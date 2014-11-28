package com.jelqui.SharedPreference;


import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.OnClickListener;
import android.content.Context;

public class MainActivity extends Activity
{


//Definimos las variables para los 3 controles
	private Button btnEmail;
	private TextView lblEmail;
	private EditText txtEmail;
	private TextView lblPass;
	private EditText pass;

	//Definimos una variable para el objeto de tipo configuracion
	private DataContent conf;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //Instanciamos los controles y el objeto configuración
        btnEmail = (Button) findViewById(R.id.btnEmail);
        lblEmail = (TextView) findViewById(R.id.lblEmail);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        pass 	 = (EditText) findViewById(R.id.pass);
		conf = new DataContent(this);

        //Escribimos el valor del email guardado anteriormente, si existe dicho valor
        if(conf.getUserEmail() != null)
			lblEmail.setText(conf.getUserEmail());       

        //Definimos el evento click del botón para poder guardar el nuevo email
        btnEmail.setOnClickListener(new OnClickListener() {   
				public void onClick(View v) {    


					Context context = getApplicationContext();

					int duration = Toast.LENGTH_SHORT;


					if(txtEmail.getText().toString().matches("")  || pass.getText().toString().matches("")){
						CharSequence text = "E-mail y Password no pueden estar vacios !";
						Toast toast = Toast.makeText(context , text, duration);
						toast.show();
					}//fin if
					else{
						conf.setUserEmail(txtEmail.getText().toString(), pass.getText().toString());
						Toast toast = Toast.makeText(context , "Guardado con exito", duration);
						toast.show();
						txtEmail.setText("");
						pass.setText("");
						lblEmail.setText(conf.getUserEmail()); 										
					}// fin else
				}//fin onClick
			});
	}





}

