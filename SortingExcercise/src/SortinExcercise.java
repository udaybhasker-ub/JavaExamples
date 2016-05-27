import java.util.Stack;

public class SortinExcercise {

	private static Stack<TreeNode> stack;

	public static void main(String args[]) {
		int[] test = { 2, 3, 5, 7 };
		int[] test2 = { 1, 4, 5, 6, 8, 9, 10, 15, 22, 34 };
		int[] test4 = { 2, 7, 5, 9 };
		int[] test5 = { 6, 4, 3, 8, 1, 5 };
		int[] test3 = { 1, 2, 1, 4, 4, 6, 8, 6, 8 };
		// print(test);
		// selectionSort(test);
		// bubbleSort(test);
		// insertionSort(test);
		// mergeArraysSort(test, test2);
		// mergeArraysSort(test4, test5);
		// removeDuplicates(test3);
		// alternateItems(test2, 0);
		// System.out.println(primeNumber(173));
		/*
		 * Node ten = new Node(10); Node eight = new Node(8); Node nine = new
		 * Node(9); Node four = new Node(4, eight, nine); Node five = new
		 * Node(5, ten); Node six = new Node(6); Node seven = new Node(7); Node
		 * two = new Node(2, four, five); Node three = new Node(3, six, seven);
		 * Node one = new Node(1, two, three);
		 */
		TreeNode ten = new TreeNode(10);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5, eight);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7, nine, ten);
		TreeNode two = new TreeNode(2, four, five);
		TreeNode three = new TreeNode(3, six, seven);
		TreeNode one = new TreeNode(1, two, three);
		// printPreorderTree(one);
		// printPreorderTree(one);
		// printInorderTree(one);
		// printPostorderTree(one);
		// binarySearch(test2, 0, test2.length-1, 15);
		// mergeTwoUnsorted(test, test5);
		// mergeSort(test5);
		// postOrder(one);
		stack = new Stack<TreeNode>();
		//printLevelOrderTree(one);
		//printLevelOrderTreeReverse(one);
	}

	private static void printLevelOrderTreeReverse(TreeNode head) {
		int level = getTreeHeight(head);
		for(int i=level; i>=1;i--){//1
			printNodes(head, i);//1,4
		}
	}

	private static void printLevelOrderTree(TreeNode head) {
		int level = getTreeHeight(head);
		for(int i=1; i<=level;i++){
			printNodes(head, i);
		}
	}
	
	private static void removeNode(TreeNode head, TreeNode searchNode){
		
	}

	private static void printNodes(TreeNode head, int i) {
		if(head == null){
			return;
		}
		if(i == 1){
			System.out.println(head.getData());
		}else{
			printNodes(head.getLeft(), i-1);
			printNodes(head.getRight(), i-1);
		}
	}
	
	private static int getTreeHeight(TreeNode tree){
		if(tree == null){
			return 0;
		}
		int leftTreeHeight = getTreeHeight(tree.getLeft());
		int rightTreeHeight = getTreeHeight(tree.getRight());
		return Math.max(leftTreeHeight, rightTreeHeight)+1;
	}

	private static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		// System.out.println("array size="+array.length);
		int mid = array.length / 2;// 3
		int[] left = new int[mid];// 3
		int[] right = new int[array.length - mid];// 3
		// System.out.println("left array size="+left.length+", right array
		// size="+right.length);
		for (int i = 0; i < mid; i++) {// 0 to 2
			left[i] = array[i];
		}
		for (int i = mid, j = 0; i < array.length; i++, j++) {// 3 to 5
			right[j] = array[i];
		}
		//
		// print(left);
		// print(right);
		mergeSort(left);
		mergeSort(right);
		mergeArraysSort(left, right);
	}

	/*
	 * int[] test = { 2, 7, 5, 4}; int[] test5 = { 6, 3, 8, 1};
	 */
	private static void mergeTwoUnsorted(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		array1 = insertionSort(array1);
		array2 = insertionSort(array2);
		mergeArraysSort(array1, array2);
	}

	private static void binarySearch(int[] array, int startIndex, int endIndex, int searchVal) {
		System.out.println("searching start=" + startIndex + ", end=" + endIndex);
		int middle = startIndex + (endIndex - startIndex) / 2;
		if (searchVal == array[middle]) {
			System.out.println(middle);
			return;
		}
		if (searchVal < array[middle]) {
			binarySearch(array, startIndex, middle, searchVal);
		} else {
			binarySearch(array, middle + 1, endIndex, searchVal);
		}
	}

	private static void printPostorderTree(TreeNode treeNode) {
		if (treeNode.getLeft() != null) {
			printPostorderTree(treeNode.getLeft());
		}

		if (treeNode.getRight() != null) {
			printPostorderTree(treeNode.getRight());
		}
		System.out.println(treeNode.getData());
	}

	private static void printPreorderTree(TreeNode treeNode) {
		System.out.println(treeNode.getData());
		if (treeNode.getLeft() != null) {
			printPreorderTree(treeNode.getLeft());
		}
		if (treeNode.getRight() != null) {
			printPreorderTree(treeNode.getRight());
		}
	}

	private static void printInorderTree(TreeNode treeNode) {
		if (treeNode.getLeft() != null) {
			printInorderTree(treeNode.getLeft());
		}
		System.out.println(treeNode.getData());
		if (treeNode.getRight() != null) {
			printInorderTree(treeNode.getRight());
		}
	}

	private static void alternateItems(int[] array, int index) {
		if (index >= array.length) {
			return;
		}
		System.out.println(array[index]);
		index += 2;
		alternateItems(array, index);
	}

	private static boolean primeNumber(int no) {
		if (no == 2 || no == 3) {
			return true;
		}
		if (no == 1 || no % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= no; i += 2) {
			System.out.println("checking between " + i + " and " + i * i);
			if (no % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void removeDuplicates(int[] array) {
		int i = 0, k = 0;
		int[] result = new int[array.length];
		result[k] = array[i];
		i++;
		k++;
		while (i < array.length) {
			boolean foundflag = false;
			int j = 0;
			while (j < result.length) {// n times
				if (array[i] == result[j]) {
					foundflag = true;
				}
				j++;
			}
			if (!foundflag) {
				result[k] = array[i];
				k++;
			}
			i++;
		}
		int[] result2 = new int[k];
		for (int l = 0; l < k; l++) {
			result2[l] = result[l];
		}
		print(result2);
	}

	private static int[] mergeArraysSort(int[] test, int[] test2) {// k=6
		System.out.print("merging ");
		print(test);
		System.out.print(" with ");
		print(test2);
		int[] result = new int[test.length + test2.length];// 1,2,3,4,5,6,7
		int i = 0, j = 0, k = 0;
		while (i < test.length && j < test2.length) { // n-1 times
			if (test[i] < test2[j]) {// 7<8
				result[k] = test[i];
				i++;
			} else {
				result[k] = test2[j];
				j++;
			}
			k++;
		}

		while (i < test.length) {// n times
			result[k] = test[i];
			k++;
			i++;
		}
		while (j < test2.length) {// ntimes
			result[k] = test2[j];
			j++;
			k++;
		}
		print(result);
		return result;
		// System.out.println("i="+i+",j="+j);
	}

	private static void mergeArraysSortInplace(int[] test, int[] test2) {
		int[] result = new int[test.length + test2.length];
		int i = 0, j = 0, k = 0;
		while (i < test.length && j < test2.length) {
			if (test[i] < test2[j]) {// 7<8
				result[k] = test[i];
				i++;
			} else {
				result[k] = test2[j];
				j++;
			}
			k++;
		}

		while (i < test.length) {
			result[k] = test[i];
			k++;
			i++;
		}
		while (j < test2.length) {
			result[k] = test2[j];
			j++;
			k++;
		}
		print(result);
		System.out.println("i=" + i + ",j=" + j);
	}

	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		print(array);
	}

	public static void bubbleSort(int[] array) {
		int len = array.length;
		for (int j = 0; j < len; j++) {// n
			boolean swap = false;
			System.out.println("pass=" + j);
			for (int i = 0; i < (len - j - 1); i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
					print(array);
				}

			}
			if (swap == false) {
				return;
			}
		}
	}

	public static int[] insertionSort(int[] array) {
		int holeIndex = 1;
		for (int i = 0; i < array.length - 1; i++) { // i=0
			for (int j = holeIndex; j > 0; j--) { // h = 4, j=1
				if (array[j] < array[j - 1]) {// 2<7, 2<5, 2<3, 1<2
					int temp = array[j]; //
					array[j] = array[j - 1];
					array[j - 1] = temp;
					// print(array);//1,2,3,5,7
				}
			}
			holeIndex++;
		}
		print(array);
		return array;
	}

	public static void print(int[] array) {
		String temp = "[";
		for (int i = 0; i < array.length; i++) {
			temp += array[i];
			if (i == array.length - 1) {
				temp += "]";
			} else
				temp += ",";
		}
		System.out.println(temp);
	}
}
