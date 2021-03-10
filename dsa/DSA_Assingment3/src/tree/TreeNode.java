package tree;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	String folderName;
	int countOfSubFolders = 0;
	List<TreeNode> subFolders;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String createdTime;
	TreeNode parentNode;

	public TreeNode() {
		folderName = "root";
		createdTime = formatter.format(new Date());
		subFolders = new ArrayList<TreeNode>();
		parentNode = null;
	}

	public TreeNode(String value) {
		this.folderName = value;
		createdTime = formatter.format(new Date());
		subFolders = new ArrayList<TreeNode>();
		parentNode = Tree.currentDirectory;

	}

	public TreeNode addSubFolder(String folderName2) {
		TreeNode child = new TreeNode(folderName2);
		subFolders.add(child);
		countOfSubFolders++;
		return child;

	}

}
