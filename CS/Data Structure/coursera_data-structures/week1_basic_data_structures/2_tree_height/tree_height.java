import java.util.*;
import java.io.*;

public class tree_height {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() throws FileNotFoundException {
			in = new BufferedReader(new FileReader(
					"/Users/kimdonghwan/github/TIL/CS/Data Structure/coursera_data-structures/week1_basic_data_structures/2_tree_height/tests/18"));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int old[];

		Queue<Integer> queue;
		ArrayList<ArrayList<Integer>> children;
		int[] heights;
		int root;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			heights = new int[n];
			children = new ArrayList<>(n);
			old = new int[n];

			for (int i = 0; i < n; i++) {
				children.add(i, new ArrayList<>());
			}

			for (int i = 0; i < n; i++) {
				int parent = in.nextInt();
				old[i] = parent;

				if (parent == -1) {
					root = i; // 1
				} else {
					children.get(parent).add(i);
				}

			}
		}

		int computeHeight_fast() {
			// Replace this code with a faster implementation
			int maxHeight = 0;
			queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int pop = queue.poll();
				for (Integer node : children.get(pop)) {
					heights[node] = heights[pop] + 1;
					queue.add(node);
				}
				maxHeight = heights[pop] + 1;
			}
			return maxHeight;

		}

		int computeHeight_origin() {
			// Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = old[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		private void measure_and_print() {
			long start = System.currentTimeMillis();
			int fast = computeHeight_fast();
			long end = System.currentTimeMillis();
			int origin = computeHeight_origin();
			System.out.println((origin == fast ? "OK" : "Error!") + " origin=" + origin + " fast=" + fast + " millis="
					+ (end - start));
		}

	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		tree.measure_and_print();
	}
}
