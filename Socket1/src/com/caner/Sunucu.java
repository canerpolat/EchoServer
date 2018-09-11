package com.caner;
import java.io.*;
import java.net.*;
public class Sunucu {
	public static void main(String[] args) {
		
		/*
		 * ilk aþamada ServerSocket sýnýfýndan nesne oluþtururuz.
		 */
		ServerSocket serverSocket = null; 
		String line;
		BufferedReader input;
		PrintStream output; //OutPutStream tipidir. <-> println benzeri yazým imkaný sunar.
		Socket istemciSocket = null;
		try {
			serverSocket = new ServerSocket(9099);
		}
		catch (IOException e) {
			System.err.println("Sunucu açýlma hatasý");
		}
		/*
		 * Sunucu isimli nesneyi kullanarak baðlantý saðlayabilmek için nesne oluþturduk.
		 */
		try {
			istemciSocket = serverSocket.accept(); //Baðlantý oluþturuldu ve sokete yönlendirildi
			input = new BufferedReader(new InputStreamReader(istemciSocket.getInputStream()));	//giriþ
			output = new PrintStream(istemciSocket.getOutputStream()); 	//çýkýþ
			while(true) {
				
			
			line = input.readLine();
			output.println(line);
			System.out.println("Ýstemciden gelen data : "+line);
			//output.print("istemciden gelen: "+  line);
		}
		}
		catch (IOException e) {
		System.out.println(e.toString());
		}
	}
}