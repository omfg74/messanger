package com.example.omfg.messanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView status, message, income;
    Button sendBtn;
    DataInputStream in;
    DataOutputStream out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClientConnection connection= new ClientConnection();
        Socket socket = connection.connect();
        DataFlow dataFlow = new DataFlow();
        try {
           in = dataFlow.dataControlIn(socket);
            out = dataFlow.dataControlOut(socket);
        } catch (IOException e) {
            Log.d("Data log",""+e);
        }

        status = (TextView)findViewById(R.id.send_text);
        message = (TextView)findViewById(R.id.send_text);
        income = (TextView)findViewById(R.id.income_text);
        sendBtn = (Button)findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = sendBtn.getText().toString();
                sendMessage(text,out);

            }
        });


    }

    private void sendMessage(String text,DataOutputStream out){
        String message =null;
        SendMessage sendMessage =new SendMessage();
        boolean sent = sendMessage.sendMessage(message,out);
        if (!sent){
            //Alarma;
        }
    }

}
