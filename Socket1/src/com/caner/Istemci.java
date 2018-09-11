package com.caner;

//import java.io.BufferedInputStream;
//import java.io.DataInputStream;
//import java.io.PrintStream;
//import java.net.Socket;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Istemci {

	public static void main(String[] args) {
		
		Socket istemciSocket = null;
		BufferedReader input = null;
		PrintStream output = null;
		Scanner scan = new Scanner(System.in);
		String inputLine = null;
		
		try { //Giriþ çýkýþ(I/O) problemleri için
			istemciSocket = new Socket("127.0.0.1",9099);  //"Pcadý" veya web sitesi ismi veya ip adresi, PortNo
			input = new BufferedReader (new InputStreamReader(istemciSocket.getInputStream())); //giriþ akýþý
			output = new PrintStream(istemciSocket.getOutputStream());	//Çýkýþ 
		}
	
		catch(Exception e) {
			System.err.println("Error : "+e);
		 }
		
		if( istemciSocket != null && output !=null && input != null) {
				try {
									
					while(true) {
						System.out.print("Mesaj giriniz :");
						inputLine = scan.nextLine();
						output.println(inputLine);
						String gelenData = input.readLine();
						System.out.println("Sunucudan Gelen data :"+gelenData);
					}
					
					
				}
				 catch(Exception e) {
					System.err.println("Error : "+e);
				 }
				
				finally {
					try {
						input.close();
						output.close();
						istemciSocket.close();
					}
					catch (Exception e) {
						System.err.println("Error : "+e);
					}
				}
				 
		}
	}
}
	
	

