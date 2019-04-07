package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.File;

import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

public interface IMail {

	public File newMail();
	public void inbox();
	public void sent();
	public void indexFile(File folder, String s, LinkedBased r);
	public void draft();
}
