package com.example.omfg.messanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClientConnection connection= new ClientConnection();
        Socket socket = connection.connect();
        DataFlow dataFlow = new DataFlow();
        try {
            DataInputStream in = dataFlow.dataControlIn(socket);
            DataOutputStream outputStream = dataFlow.dataControlOut(socket);
        } catch (IOException e) {
            Log.d("Data log",""+e);
        }

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
