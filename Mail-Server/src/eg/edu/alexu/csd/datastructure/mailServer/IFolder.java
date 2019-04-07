package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.File;

import eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62.SearchFilter;

public interface IFolder {

	public File selectedFolder();
	public void trash(File f);
	public boolean createNewFolder(String name, SearchFilter filter);
	public void deleteFolder(String name);
	public void renameFolder(String name, String newName);
}
