package com.example.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.prefs.PreferencesFactory;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    EditText editText4, editText5,editText9;
    Button button1, button2;
    public static final String MYPRFERENCES="sharedprefs";
    public static final String NU1="n1";
    public static final String NU2="n2";
    private String x1;
    private String x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.button1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText4=(EditText)findViewById(R.id.editText4);
                editText5=(EditText)findViewById(R.id.editText5);
                editText9=(EditText)findViewById(R.id.editText9);
                try {
       //             loadData();
         //           updateView();
                    String x1=editText4.getText().toString();
                    String x2=editText5.getText().toString();
                    double number1 = Double.parseDouble(x1);
                    double number2 = Double.parseDouble(x2);
                    if (button1.getText() == "add") {
                        double s = 0;
                        s = number1 + number2;
                        String k = String.valueOf(s);
                        editText9.setText(k);
                        //deletePrefs();
                    }
                    if (button1.getText() == "mul") {
                        double s = 1;
                        s = number1 * number2;
                        String k = String.valueOf(s);
                        editText9.setText(k);
                        //deletePrefs();
                    }
                    if (button1.getText() == "sub") {
                        double s = 0;
                        s = number1 - number2;
                        String k = String.valueOf(s);
                        editText9.setText(k);
                        //deletePrefs();
                    }
                    if (button1.getText() == "divide") {
                        double s = 1;
                        if (number2 == 0) {
                            Toast.makeText(getApplicationContext(), "cannot divide by 0", Toast.LENGTH_SHORT).show();
                            editText5.setText(" ");
                        } else {
                            s = number1 / number2;
                            String k = String.valueOf(s);
                            editText9.setText(k);
                          //  deletePrefs();
                        }
                    }
                }catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"please enter numbers ",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
public void showPopup(View view)
{
    PopupMenu popupMenu=new PopupMenu(this,view);
    popupMenu.setOnMenuItemClickListener(this);
    popupMenu.inflate(R.menu.popup_menu);
    popupMenu.show();
}


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                button1.setText("add");
                return true;
            case R.id.mul:
                button1.setText("mul");
                return true;
            case R.id.divide:
                button1.setText("divide");
                return true;
            case R.id.sub:
                button1.setText("sub");
                return true;
            default:
                return false;
        }
    }
 /*   @Override
    public void onBackPressed() {

        saveData();

        super.onBackPressed();

    }
    public void saveData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(MYPRFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(NU1,editText4.getText().toString());
        editor.putString(NU2,editText5.getText().toString());
        editor.apply();
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(MYPRFERENCES,MODE_PRIVATE);
        x1=sharedPreferences.getString(NU1," ");
        x2=sharedPreferences.getString(NU2," ");
    }
    public void updateView()
    {
        editText4.setText(x1);
        editText5.setText(x2);
    }
   public void deletePrefs()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(MYPRFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }*/

}
