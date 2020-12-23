package by.aginskiy.bundle.main;

import by.aginskiy.bundle.manager.MessageManager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        System.out.println("1 - eng, 2 = bel");
        char i = 0;
        try {
            i = (char)System.in.read();
        } catch(IOException e) {
            e.printStackTrace();
        }
        MessageManager manager;
        switch (i) {
            case '1': {
                manager = MessageManager.EN;
                break;
            }
            case '2': {
                manager = MessageManager.BY;
                break;
            }
            default: {
                manager = MessageManager.DEFAULT;
                break;
            }
        }

        String str1 = manager.getString("str1");
        String str2 = manager.getString("str2");
        try {
            str1 = new String(str1.getBytes("utf-8"), "utf-8");
            str2 = new String(str2.getBytes("utf-8"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str1);
        System.out.println(str2);
    }
}
