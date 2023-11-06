package com.example.myfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,feedback;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.edit1);
        feedback=findViewById(R.id.edit2);
        send=findViewById(R.id.buttonID);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/html");
                String s = "mahabub9463@gmail.com";

                intent.setType("phone/html");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {s});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name.getText()+"\nFeedback: "+feedback.getText());
                try {
                    startActivity(Intent.createChooser(intent,"Please select Email"));
                }catch(android.content.ActivityNotFoundException exception){
                    Toast.makeText(MainActivity.this,"There is no email client",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}