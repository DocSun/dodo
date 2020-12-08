package com.nns.dodo.client;

import lombok.Data;

import java.io.IOException;

@Data
public class ClientApp {
	public static void main(String[] args) throws IOException {
		ConsumerService consumerService = new ConsumerServiceImpl();
		consumerService.run();
	}
}
