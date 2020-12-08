package com.nns.dodo.client.service.impl;

import com.nns.dodo.client.ConsumerService;

import java.io.*;
import java.net.Socket;

public class ConsumerServiceImpl implements ConsumerService {
	@Override
	public void run () throws IOException {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9090);
			// 向服务器发送请求
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			objectOutputStream.writeObject(consoleReader.readLine());
			consoleReader.close();
			objectOutputStream.flush();


			// 获取服务器响应
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			Object response = objectInputStream.readObject();
			System.out.println(response);

//
//			Object object = objectInputStream.readObject();

//			InputStream inputStream = socket.getInputStream();
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//			System.out.println(bufferedReader.lines().findFirst());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (socket != null) {
				socket.close();
			}
		}

	}
}
