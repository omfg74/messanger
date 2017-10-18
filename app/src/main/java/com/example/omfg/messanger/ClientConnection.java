package com.example.omfg.messanger;

import android.util.Log;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by omfg on 19.10.2017.
 */

public class ClientConnection  {
    int port = 6346;
    String address = "127.0.0.1";


    public Socket connect(){
        Socket socket =null;
        try{
            InetAddress inetAddress= InetAddress.getByName(address);
            socket =new Socket(inetAddress,port);
        }catch (Exception e){
            Log.d("Connection log","Connection "+e);
        }
        return socket;
    }
}
