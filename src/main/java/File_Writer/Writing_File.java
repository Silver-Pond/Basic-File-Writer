/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File_Writer;

import Encryption.Encrypting;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Ashford Mc Harlies
 * @version 2022.3.1
 */
public class Writing_File
{
    File file;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    public Writing_File()
    {
        //Declaring variables
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String choice, text, reText;
        boolean correctData = false, encryptData;

        //Prompt user for input.
        choice = JOptionPane.showInputDialog(null, "Do You Wish To Write (y) for YES and (n) for NO: ");

        //Initiating while loop for error handling.
        while(correctData == false)
        {
            if(!choice.equals("y") && !choice.equals("n"))
            {
                //Error message.
                JOptionPane.showMessageDialog(null,"Please Enter (y) or (n)!");

                //Prompt user for input.
                choice = JOptionPane.showInputDialog(null, "Do You Wish To Write (y) for YES and (n) for NO: ");
            }
            else
            {
                correctData = true;
            }
        }

        //Initiating while loop.
        while(choice.equals("y"))
        {
            correctData = false; encryptData = false;

            //Prompt user for input.
            text = JOptionPane.showInputDialog(null, "Please Enter Text: ");

            //Prompt user for input.
            reText = JOptionPane.showInputDialog(null, "Do You Want To Encrypt Your Message (y) YES and (n) NO: ");

            //Initiating while loop for error handling.
            while(encryptData == false)
            {
                if(!reText.equals("y") && !reText.equals("n"))
                {
                    //Error message.
                    JOptionPane.showMessageDialog(null,"Please Enter (y) or (n) For Encryption!");

                    //Prompt user for input.
                    reText = JOptionPane.showInputDialog(null, "Do You Want To Encrypt Your Message (y) YES and (n) NO: ");
                }
                else
                {
                    encryptData = true;
                }
            }
            //Calling private method FileConstructor.
            FileConstructor(date,time,text,reText);

            //Prompt user for input.
            choice = JOptionPane.showInputDialog(null,"Do You Wish To Write (y) for YES and (n) for NO: ");

            //Initiating while loop for error handling.
            while(correctData == false)
            {
                if(!choice.equals("y") && !choice.equals("n"))
                {
                    //Error message.
                    JOptionPane.showMessageDialog(null,"Please Enter (y) or (n)!");

                    //Prompt user for input.
                    choice = JOptionPane.showInputDialog(null, "Do You Wish To Write (y) for YES and (n) for NO: ");
                }
                else
                {
                    correctData = true;
                }
            }
            try
            {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        //Set file to readable.
        file.setWritable(true,true);

        //Goodbye message.
        JOptionPane.showMessageDialog(null,"Thank You For Your Service :)");
    }

    private void FileConstructor(LocalDate date, LocalTime time, String text, String reText)
    {
        //Creating an instance of class Encrypting.
        Encrypting encrypt = new Encrypting();

        //Declaring file.
        file = new File("Personal Info\\personal info " + date + ".txt");

        try
        {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            if(reText.equals("y"))
            {
                text = encrypt.Encryr(text);
            }

            pw.println("PERSONAL INFO:");
            pw.println("DATE: "+date+"\nTIME: "+time);
            pw.println("TEXT: "+text);
            pw.println();

        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    
}
