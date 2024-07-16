package com.pr.myapp_pauldiego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public Button login_btn;
    public EditText username_txt;
    public EditText pass_txt;
    public TextView result;

    private final String USERNAME = "paul";
    private final String PASSWORD = "1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login_btn = findViewById(R.id.login_btn);
        username_txt = findViewById(R.id.username_txt);
        pass_txt = findViewById(R.id.pass_txt);
        result = findViewById(R.id.result);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast torres = Toast.makeText(getApplicationContext(), "You tried to log in", Toast.LENGTH_LONG);
                torres.show();

                if (username_txt.getText().toString().equals(USERNAME) && pass_txt.getText().toString().equals(PASSWORD)){
                    Intent login_success = new Intent(MainActivity.this, Login_Success.class);
                    MainActivity.this.startActivity(login_success);
                    /*result.setText(R.string.correct_result);
                    result.setTextColor(getColor(R.color.green)); */
                }else{
                    Intent login_error = new Intent(MainActivity.this, Login_Error.class);
                    MainActivity.this.startActivity(login_error);
                    /*result.setText(R.string.wrong_result);
                    result.setTextColor(getColor(R.color.red));*/
                }
            }
        });
    }
}