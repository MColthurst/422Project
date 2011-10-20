package com.cs.uwindsor.group.project;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


 
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	   private TextView output;
	    
	   private DataHelper dh;
	   
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.output = (TextView) this.findViewById(R.id.editText3);
        this.dh = new DataHelper(this);    
           
        
    }
    
    public void sendMovie(View view) {  
    	TextView title = (TextView) this.findViewById(R.id.editText1);
    	TextView year = (TextView) this.findViewById(R.id.editText2);
    	this.dh.insert(title.getText().toString(), year.getText().toString());
    	
        StringBuilder sb = new StringBuilder();
        sb.append("Names in database:\n");
        List<String> names = this.dh.selectAll();

        for (String name : names) {
           sb.append(name + "\n");
        }
        
        this.output.setText(sb.toString());
    } 
}