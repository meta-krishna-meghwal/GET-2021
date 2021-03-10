package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import queue.CustomNode;
import queue.CustomQueue;
import queue.LinkedList;

public class VirtualTerminal {
	static String prompt = "R:/$ ";
	Tree folderStrcture = new Tree();

	char a = '\u251c';
	char b = '\u2500';
	char c = '\u2502';
	char d = '\u2514';

	/**
	 * '\u251c' -> ├
	 * 
	 * '\u2500' -> ─
	 * 
	 * '\u2502' -> │
	 * 
	 * '\u2514' -> └
	 */

	public boolean chooseOperation(String command, String arguement) {
		if (command.equals("ls")) {
			showFiles();
		} else if (command.equals("mkdir")) {
			makeDirectory(prompt, arguement);
		} else if (command.equals("cd")) {
			changeDirectory(arguement);
		} else if (command.equals("bk")) {
			back();
		} else if (command.equals("find")) {
			find(arguement);
		} else if (command.equals("tree")) {
			tree(prompt);
		} else if (command.equals("exit")) {
			return false;
		} else {
			System.out.println("command does not exist");
		}
		return true;
	}

	private void showFiles() {
		for (TreeNode folder : Tree.currentDirectory.subFolders) {
			System.out.println(folder.createdTime + " " + folder.folderName);
		}
		int total = Tree.currentDirectory.countOfSubFolders;
		if (total > 0)
			System.out.println("    " + total + " Folder<s>");

	}

	public void drawTree(CustomQueue<TreeNode> folders, int subFolder) {
		String format = "" + d + b;
		int j = -1;
		while (folders.size > 0) {
			TreeNode temp = folders.deQueue();
			if (temp == null) {
				j -= 1;
				if (j == -1) {
					subFolder--;
				}
			} else {
				j++;
				for (int i = 0; i < 4 * j; i++) {
					if (i == 0 && subFolder > 1) {
						System.out.print(c);
					} else
						System.out.print(" ");
				}
				System.out.println(format + " " + temp.folderName);

			}
		}
		System.out.print("\n");
	}

	private void tree(String prompt2) {
		if (Tree.currentDirectory.countOfSubFolders > 0) {
			CustomQueue<TreeNode> folders = new CustomQueue<TreeNode>();
			TreeNode currentNode = Tree.currentDirectory;
			String ans = ".\n";
			dfs(folders, currentNode);
			System.out.print(ans);
			drawTree(folders, currentNode.countOfSubFolders);
		}
	}

	private void dfs(CustomQueue<TreeNode> folders, TreeNode currentNode) {
		if (currentNode.countOfSubFolders > 0) {
			for (int i = 0; i < currentNode.countOfSubFolders; i++) {
				folders.enQueue(currentNode.subFolders.get(i));
				dfs(folders, currentNode.subFolders.get(i));
				folders.enQueue(null);
			}

		}
	}

	private void find(String arguement) {
		List<String> matchedFilespath = new ArrayList<String>();
		String path = "./";
		TreeNode temp = Tree.currentDirectory;
		findPaths(temp, matchedFilespath, arguement, path);
		for (String s : matchedFilespath) {
			System.out.println(s);
		}

	}

	private void findPaths(TreeNode currentNode, List<String> matchedFilespath,
			String arguement, String path) {
		for (TreeNode node : currentNode.subFolders) {
			if (node.folderName.contains(arguement)) {
				matchedFilespath.add(path + node.folderName + '/');
			}

			path = path + node.folderName + '/';
			findPaths(node, matchedFilespath, arguement, path);
		}

	}

	private void back() {
		if (Tree.currentDirectory != Tree.root) {
			Tree.currentDirectory = Tree.currentDirectory.parentNode;
			String[] folders = prompt.split("/");
			String toReplace = folders[folders.length - 2] + "/$ ";
			String replaceTo = "$ ";
			prompt = prompt.replace(toReplace, replaceTo);
		}
	}

	private void changeDirectory(String arguement) {
		String[] folders = arguement.split("/");
		TreeNode temp = findDirectory(folders, 0, Tree.currentDirectory);

		if (temp != null) {
			Tree.currentDirectory = temp;
			prompt = prompt.replace("$ ", arguement + "/$ ");
		} else {
			System.out.println("folder not found");
		}

	}

	private void makeDirectory(String prompt2, String arguement) {
		Tree.currentDirectory.addSubFolder(arguement);
	}

	public static TreeNode findDirectory(String[] folders, int level,
			TreeNode root) {

		if (level < folders.length) {
			for (int i = 0; i < root.countOfSubFolders; i++) {
				if (root.subFolders.get(i).folderName.equals(folders[level])) {
					return findDirectory(folders, level + 1,
							root.subFolders.get(i));
				}
			}
			return null;
		}

		return root;

	}

	public void startTerminal() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			String command = "", arguement = "";
			boolean gotCommand = false;
			for (int i = 0; i < input.length(); i++) {

				if (input.charAt(i) != ' ' && !gotCommand) {
					command += input.charAt(i);
				} else {
					gotCommand = true;
					if (input.charAt(i) != ' ') {
						arguement += input.charAt(i);
					}

				}
			}

			if (!chooseOperation(command, arguement)) {
				break;
			}

		}
		sc.close();
	}

	public static void main(String[] args) {
		VirtualTerminal shell = new VirtualTerminal();
		shell.startTerminal();

	}
}
