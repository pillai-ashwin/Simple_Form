package com.simple.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Simple_FormActivity extends Activity {
	EditText et_name;
	Button but_submit;

	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        
        et_name = (EditText) findViewById(R.id.editText_name);
        but_submit = (Button) findViewById(R.id.button_submit);
        
        but_submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String name = et_name.getText().toString();
				if(name == "" || name.trim().length() == 0 || name == null) {
					Toast.makeText(getApplicationContext(),"Kindly enter your name", 
			                Toast.LENGTH_LONG).show();
				} else {
					try {
						Bundle b = new Bundle();
						b.putString("name", name);
						String pack = getPackageName() + ".Welcome";
						Class cls = Class.forName(pack);
						Intent i = new Intent(Simple_FormActivity.this, cls);
						i.putExtras(b);
						startActivity(i);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
    }
}