package com.example.omfg.messanger;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by omfg on 19.10.2017.
 */

public class Receaver implements Runnable {
    DataInputStream in;
    public Receaver(DataInputStream in) {
    this.in = in;
    }

    @Override
    public void run() {
        while (true){
            String input = null;
            try {
                input = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
