package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;
import eg.edu.alexu.csd.datastructure.stack.cs12.Stack;

public class Trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MailServer x = new MailServer();
		Mail y = new Mail();
		x.signin("eman@mail.com", "123456");
		File mail = new File("New.txt");
		y.setBody(mail);
		String r = "eman14@mail.com";
		LinkedBased re = new LinkedBased();
		re.enqueue(r);
		y.setReceivers(re);
		y.setPriority("2");
		y.setSubject("No subject");
		x.compose(y);

		/*DLinkedList mails = new DLinkedList();
		Mail x = new Mail();
		x.setDate("09/10/2016 23:45:12");
		Mail y = new Mail();
		y.setDate("07/11/2017 05:23:15");
		Mail x1 = new Mail();
		x1.setDate("07/11/2017 03:52:49");
		Mail x2 = new Mail();
		x2.setDate("05/01/2018 12:01:06");
		Mail x3 = new Mail();
		x3.setDate("07/11/2017 11:58:49");
		mails.add(x1);
		mails.add(x3);	
		
		mails.add(x2);
		mails.add(y);
		mails.add(x);
		
		Sort s = new Sort();
		s.setMails(mails);
		s.defaultSort();
		mails = s.getMails();
		for (int i = 0; i < mails.size(); i++) {
			Mail temp = (Mail) mails.get(i);
			System.out.println(temp.getDate());
		}
		Filter f = new Filter();
		mails = f.binarySearch(mails, "07/11/2017");
		for (int i = 0; i < mails.size(); i++) {
			Mail temp = (Mail) mails.get(i);
			System.out.println(temp.getDate());
		}
		/*
		boolean b = x.signin("eman@mymail.com", "123456");
		System.out.println(b);*/
		/*Contact new1 = new Contact("eman@mymail.com", "123456");
		Contact new2 = new Contact("nada@mymail.com", "7895");
		Contact new3 = new Contact("yomna@mymail.com", "abcd");
		x.signup(new1);
		x.signup(new2);
		x.signup(new3);*/
		
		
		/*Mail y = new Mail();
		y.setSubject("Subject");
		y.setSender("eman@mymail.com");
		LinkedBased q = new LinkedBased();
		q.enqueue("b@mymail.com");
		q.enqueue("yomna@mymail.com");
		y.setReceivers(q);
		File z = new File("New.txt");
		y.setBody(z);
		boolean b = x.compose(y);
		System.out.println(b);
		/*x.signin("nada@mymail.com","7895");
		SLinkedList y = new SLinkedList();
		y.add("2018 05 04 01 24 45");
		Folder z = new Folder();
		z.setFolder("Inbox");
		x.setViewingOptions(z, null, null);
		x.deleteEmails(y);*/
		
	}
}
