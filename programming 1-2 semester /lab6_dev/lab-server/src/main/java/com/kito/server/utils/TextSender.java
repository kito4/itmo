package com.kito.server.utils;



import com.kito.server.abstractions.AbstractMessage;

import java.io.IOException;
import java.io.OutputStream;

public class TextSender {

    public static final String MESSAGE_COLOR = "\u001B[32m"; //ANSI_GREEN
    public static final String ERROR_COLOR = "\u001B[31m"; //ANSI_RED
    public static final String ANSI_RESET = "\u001B[0m";

    public static OutputStream os;

//    public static  printStream = ;

    public static void printText(String message) {
        try {
            os.write((MESSAGE_COLOR + message + ANSI_RESET).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printError(String message) {
        try {
            os.write((ERROR_COLOR + message + ANSI_RESET).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printMessage(AbstractMessage message) {
        try {
            os.write(message.getMessage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changePrintStream(OutputStream newPrintStream) {
        os = newPrintStream;
    }



//    public static void printText(String message) {
//        printStream.println(MESSAGE_COLOR + message + ANSI_RESET);
//    }
//
//    public static void printError(String message) { printStream.println(ERROR_COLOR + message + ANSI_RESET); }
//
//    public static void printMessage(AbstractMessage message) {
//        printStream.println(message.getMessage());
//    }
//
//    public static void changePrintStream(PrintStream newPrintStream) {
//        printStream = newPrintStream;
//    }
}
