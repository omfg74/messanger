package com.example.omfg.messanger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by omfg on 19.10.2017.
 */

public class DataFlow {

    public DataInputStream dataControlIn(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        DataInputStream in = new DataInputStream(inputStream);

return in;

    }
    public DataOutputStream dataControlOut(Socket socket) throws IOException {

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outputStream);

return out;
    }

}

