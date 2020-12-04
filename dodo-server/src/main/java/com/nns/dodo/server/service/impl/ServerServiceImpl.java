package com.nns.dodo.server.service.impl;


import com.nns.dodo.server.service.ServerService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerServiceImpl  implements ServerService {

	public static void main(String[] args) throws IOException {
		new ServerServiceImpl().run();
	}

	private void run() throws IOException {
		ServerSocket listener = new ServerSocket(9090);

		while (true) {
			Socket socket = listener.accept();
			System.out.println("hahhh");
			try {
				System.out.println("客户端:"+socket.getInetAddress().getLocalHost()+"已连接到服务器");


				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

				Object object = objectInputStream.readObject();
//				Object object = objectInputStream.readInt();
				System.out.println("hello world ==" + object );

				ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

				objectOutputStream.writeObject(consoleReader.readLine());
				consoleReader.close();



//
//				objectOutputStream.writeChars("return");
//				System.out.println((String) object);
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
