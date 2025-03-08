package edu.up.isgc.og.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] command = new String[]{"ls", "-la"};

        final ProcessBuilder builder = new ProcessBuilder();
        try{
            final Process process = builder.command(command).start();
            InputStream in = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Waiting... " + process.waitFor());
            process.destroy();
        }catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}