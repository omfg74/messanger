package com.example.omfg.messanger;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by omfg on 19.10.2017.
 */

public class SendMessage {

        public boolean sendMessage(String message,DataOutputStream out){
            boolean sent =false;
            try {
                out.writeUTF(message);
                out.flush();
            } catch (IOException e) {
             return false;
            }

            return sent;
        }

}
