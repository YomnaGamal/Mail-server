package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;
import eg.edu.alexu.csd.datastructure.stack.cs12.Stack;

public class Filter implements IFilter {

	private LinkedBased Q;
	private File searchIn;
	private boolean dateInterval;
	Functions functions = new Functions();

	public boolean isDateInterval() {
		return dateInterval;
	}

	public void setDateInterval(boolean dateInterval) {
		this.dateInterval = dateInterval;
	}

	public LinkedBased getQ() {
		return Q;
	}

	public void setQ(LinkedBased q) {
		Q = q;
	}

	public File getSearchIn() {
		return searchIn;
	}

	public void setSearchIn(File searchIn) {
		this.searchIn = searchIn;
	}

	@Override
	public DLinkedList filter() {
		// TODO Auto-generated method stub
		DLinkedList mails = new DLinkedList();
		mails = functions.readMails(searchIn);
		while (!Q.isEmpty()) {
			SearchFilter search = new SearchFilter();
			String type = search.type;
			String searchFor = search.searchFor;
			for (int i = 0; i < mails.size(); i++) {
				Mail x = (Mail) mails.get(i);
				if (type.equals("Sender")) {
					searchFor.toLowerCase();
					String temp = x.getSender().toLowerCase();
					if (!temp.equals(searchFor)) {
						mails.remove(i);
					}
				}
				if (type.equals("Subject")) {
					searchFor.toLowerCase();
					String temp = x.getSubject().toLowerCase();
					if (!temp.equals(searchFor)) {
						mails.remove(i);
					}
				}
				if (type.equals("Date")) {
					if (dateInterval) {
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date d1 = new Date();
						Date d2 = new Date();
						Date d = new Date();
						try {
							d1 = format.parse(search.start);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							d2 = format.parse(search.end);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							String date = x.getDate().substring(0, 10);
							d = format.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (d.compareTo(d1) < 0 || d.compareTo(d2) > 0) {
							mails.remove(i);
						}
					} else {
						mails = binarySearch(mails, searchFor);
					}
				}
				if (type.equals("AttachmentsTrue")) {
					File email = functions.findDir(searchIn, x.getName());
					if (functions.findFile(email, "Attachments.txt") == null) {
						mails.remove(i);
					}
				}
				if (type.equals("AttachmentsFalse")) {
					File email = functions.findDir(searchIn, x.getName());
					if (functions.findFile(email, "Attachments.txt") != null) {
						mails.remove(i);
					}
				}
				if (type.equals("Body")) {
					boolean check = false;
					File email = functions.findDir(searchIn, x.getName());
					File body = functions.findFile(email, "Body.txt");
					searchFor.toLowerCase();
					BufferedReader bf;
					try {
						bf = new BufferedReader(new FileReader(body.getPath()));
						String line;
						try {
							while ((line = bf.readLine()) != null) {
								line.toLowerCase();
								if (line.contains(searchFor)) {
									check = true;
									break;
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (!check) {
							mails.remove(i);
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (type.equals("Receiver")) {
					boolean check = false;
					LinkedBased receivers = x.getReceivers();
					LinkedBased temp = new LinkedBased();
					while (!receivers.isEmpty()) {
						String s = (String) receivers.dequeue();
						temp.enqueue(s);
					}
					while (!temp.isEmpty()) {
						String s = (String) receivers.dequeue();
						receivers.enqueue(s);
						if (s.equals(searchFor)) {
							check = true;
							break;
						}
					}
					if (!check) {
						mails.remove(i);
					} else {
						while (!temp.isEmpty()) {
							String s = (String) receivers.dequeue();
							receivers.enqueue(s);
						}
					}
				}
				if (type.equals("Importance")) {
					if (!x.getPriority().equals(searchFor)) {
						mails.remove(i);
					}
				}
			}
		}
		return mails;
	}

	public DLinkedList binarySearch(DLinkedList mails, String date) {
		DLinkedList m = new DLinkedList();
		Stack s = new Stack();
		Sort sort = new Sort();
		sort.setMails(mails);
		sort.defaultSort();
		mails = sort.getMails();
		int left = 0; 
		int right = mails.size() - 1;
		int mid = (left + right) / 2;
		s.push(mid);
		while (!s.isEmpty()) {
			mid = (int) s.pop();
			Mail x = (Mail) mails.get(mid);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date d1 = new Date();
			Date d2 = new Date();
			try {
				d1 = format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				d2 = format.parse(x.getDate().substring(0, 10));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (d1.compareTo(d2) == 0) {
				m.add(x);
				for (int i = mid - 1; i >= 0; i--) {
					Mail y = (Mail) mails.get(i);
					String temp = y.getDate();
					if (temp.substring(0, 10).equals(date)) {
						m.add(0,y);
					} else {
						break;
					}
				}
				for (int i = mid + 1; i < mails.size(); i++) {
					Mail y = (Mail) mails.get(i);
					String temp = y.getDate();
					if (temp.substring(0, 10).equals(date)) {
						m.add(y);
					} else {
						break;
					}
				}
			} else if (d1.compareTo(d2) > 0) {
				right = mid - 1;
				mid = (left + right) / 2;
				s.push(mid);
			} else if (d2.compareTo(d1) < 0) {
				left = mid + 1;
				s.push(mid);
			}
		}
		return m;
	}
}
