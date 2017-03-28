package org.koushik.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1 = new Message(1L, "Hello World 1", "Tuan 1");
		Message m2 = new Message(2L, "Hello World 2", "Tuan 2");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
}