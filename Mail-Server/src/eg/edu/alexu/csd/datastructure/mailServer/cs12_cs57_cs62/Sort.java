package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;
import eg.edu.alexu.csd.datastructure.stack.cs12.Stack;

public class Sort implements ISort{

	private DLinkedList mails = new DLinkedList();
	private String criteria;
	private boolean filter;
	private File current;
	Functions functions = new Functions();

	public boolean isFilter() {
		return filter;
	}

	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	public File getCurrent() {
		return current;
	}

	public void setCurrent(File current) {
		this.current = current;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public DLinkedList getMails() {
		return mails;
	}

	public void setMails(DLinkedList mails) {
		this.mails = mails;
	}

	@Override
	public DLinkedList sort() {
		// TODO Auto-generated method stub
		if (!filter) {
			mails = functions.readMails(current);
		}
		if (criteria.equals("default")) {
			defaultSort();
		} else if (criteria.equals("priority")) {
			priority();
		} else if (criteria.equals("status")) {
			read();
		}  else if (criteria.equals("starred")) {
			starred();
		}
		return mails;
	}

	@Override
	public void defaultSort() {
		// TODO Auto-generated method stub
		quickSort(0, mails.size() - 1);
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		DLinkedList unread = new DLinkedList();
		for (int i = 0; i < mails.size(); i++) {
			Mail x = (Mail) mails.get(i);
			if (x.getStatus().equals("Unread")) {
				unread.add(x);
				mails.remove(i);
			}
		}
		defaultSort();
		Sort x = new Sort();
		x.setMails(unread);
		x.defaultSort();
		unread = x.getMails();
		for (int i = 0; i < unread.size(); i++) {
			mails.add(unread.get(i));
		}
	}

	@Override
	public void priority() {
		// TODO Auto-generated method stub
		defaultSort();
		PriorityQueue p = new PriorityQueue();
		for (int i = 0; i < mails.size(); i++) {
			Mail x = (Mail) mails.get(i);
			System.out.println(x.getPriority());
			int key = Integer.valueOf(x.getPriority());
			p.insert(x, key);
		}
		mails.clear();
		while(!p.isEmpty()) {
			Mail y = (Mail) p.removeMin();
			mails.add(y);
		}
	}

	@Override
	public void starred() {
		// TODO Auto-generated method stub
		DLinkedList unstarred = new DLinkedList();
		for (int i = 0; i < mails.size(); i++) {
			Mail x = (Mail) mails.get(i);
			if (x.getStarred().equals("False")) {
				unstarred.add(x);
				mails.remove(i);
			}
		}
		defaultSort();
		Sort x = new Sort();
		x.setMails(unstarred);
		x.defaultSort();
		unstarred = x.getMails();
		for (int i = 0; i < unstarred.size(); i++) {
			mails.add(unstarred.get(i));
		}
	}

	@Override
	public void quickSort(int low, int high) {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty()){
            high = (int) stack.pop();
            low = (int) stack.pop();
            if (low < high) {
                int pivotal = partition(low, high);
                if (pivotal - 1 > 1) {
                    stack.push(low);
                    stack.push( pivotal - 1);
                }

                if (pivotal + 1 < high) {
                    stack.push(pivotal + 1);
                    stack.push( high);
                }
            }

        }
	}

	private int partition(int low, int high){
		Mail pivot = (Mail) mails.get(high);
        int i = low - 1;
        for(int j = low; j < high; j++){
        	Mail temp = (Mail) mails.get(j);
        	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date tempDate = new Date();
			Date pivotDate = new Date();
			try {
				tempDate = format.parse(temp.getDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pivotDate = format.parse(pivot.getDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (tempDate.compareTo(pivotDate) > 0) {
        		i++;
                swap(i, j);
        	}
        }
        swap(i + 1, high);
        return  i + 1;
    }

    private void swap(int i, int j) {
        Mail temp = (Mail) mails.get(i);
        mails.set(i, mails.get(j));
        mails.set(j, temp);
    }
}
