package com.caner;
import java.io.*;
import java.net.*;
public class Sunucu {
	public static void main(String[] args) {
		
		/*
		 * ilk a�amada ServerSocket s�n�f�ndan nesne olu�tururuz.
		 */
		ServerSocket serverSocket = null; 
		String line;
		BufferedReader input;
		PrintStream output; //OutPutStream tipidir. <-> println benzeri yaz�m imkan� sunar.
		Socket istemciSocket = null;
		try {
			serverSocket = new ServerSocket(9099);
		}
		catch (IOException e) {
			System.err.println("Sunucu a��lma hatas�");
		}
		/*
		 * Sunucu isimli nesneyi kullanarak ba�lant� sa�layabilmek i�in nesne olu�turduk.
		 */
		try {
			istemciSocket = serverSocket.accept(); //Ba�lant� olu�turuldu ve sokete y�nlendirildi
			input = new BufferedReader(new InputStreamReader(istemciSocket.getInputStream()));	//giri�
			output = new PrintStream(istemciSocket.getOutputStream()); 	//��k��
			while(true) {
				
			
			line = input.readLine();
			output.println(line);
			System.out.println("�stemciden gelen data : "+line);
			//output.print("istemciden gelen: "+  line);
		}
		}
		catch (IOException e) {
		System.out.println(e.toString());
		}
	}
}