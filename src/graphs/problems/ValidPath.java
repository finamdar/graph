package graphs.problems;

/**
 * Check https://www.geeksforgeeks.org/path-rectangle-containing-circles/ for
 * problem statement.
 * 
 * Improve this approach to mark visited nodes that cant be used to reach the
 * destination as -1 recursively. Use number of paths between nodes approach.
 * 
 * @author finamdar
 *
 */
public class ValidPath {

	static int m = 5, n = 5, r = 1;
	static int[][] circles = { { 0, 2 }, { 4, 2 } };
	static int[][] variables = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int[][] adjMatrix = new int[m][n];
	static {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) {
		dfs(0, 0);
		System.out.println(adjMatrix[m - 1][n - 1] == 1 ? "YES" : "NO");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println("");
		}

	}

	public static void dfs(int si, int ei) {
		if (validIndex(si, ei)) {
			adjMatrix[si][ei] = 1;
			for (int[] var : variables) {
				int i = si + var[0];
				int y = ei + var[1];
				if (i >= 0 && i < m && y >= 0 && y < n && adjMatrix[i][y] == -1) {
					dfs(i, y);
				}
			}
		}
	}

	private static boolean validIndex(int x, int y) {
		for (int[] circle : circles) {
			int cx = circle[0], cy = circle[1];
			if (x == cx && y == cy) {
				return false;
			}
			for (int[] var : variables) {
				int dx = circle[0] + var[0];
				int dy = circle[1] + var[1];
				if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
					adjMatrix[dx][dy] = 0;// This line is for understanding purposes. Will mark the circumference of the
											// circles 0. Adjacency matrix will have -1 for unvisited nodes and 1 for
											// visited nodes
					int distance = ((x - dx) * (x - dx) + (y - dy) * (y - dy));
					if (distance <= 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
