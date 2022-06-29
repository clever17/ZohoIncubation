package eval;
import java.util.LinkedList;

public class Question1
{
	
	private static class Mat {
		
		int x,y;
		
		int distance; 
		
		Mat previous; 
		
		Mat(int x, int y, int dist, Mat prev) {
			
			this.x = x;

			this.y = y;

			this.distance = dist;

			this.previous = prev;

		}
	}

	public static void shortestPath(char[][] matrix) {

		int sx = 0, sy = 0, dx = 0, dy = 0;

		int m = matrix.length;

		int n = matrix[0].length;

		Mat[][] mat = new Mat[m][n];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 'A') {

					sx = i;

					sy = j;

				}
				
				if (matrix[i][j] == 'G') {

					dx = i;

					dy = j;

				}

				mat[i][j] = new Mat(i, j, Integer.MAX_VALUE, null);
				
			}

		}

		LinkedList<Mat> queue = new LinkedList<>();

		Mat source = mat[sx][sy];

		source.distance = 0;

		queue.add(source);

		Mat dest = null;

		Mat p;

		while ((p = queue.poll()) != null) {

			if (p.x == dx && p.y == dy) {

				dest = p;

				break;

			}


			move(mat, queue, p.x - 1, p.y, p);


			move(mat, queue, p.x + 1, p.y, p);


			move(mat, queue, p.x, p.y - 1, p);


			move(mat, queue, p.x, p.y + 1, p);

		}



			System.out.println(dest.distance);



	}

	private static void move(Mat[][] mat, LinkedList<Mat> queue, int x, int y, Mat prev) 
	{
		if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == null) 
		{
			return;
		}
		int dist = prev.distance + 1;

		Mat p = mat[x][y];

		if (dist < p.distance) {

			p.distance = dist;

			p.previous = prev;

			queue.add(p);

		}
	}

	public static void main(String[] args) {

		char[][] matrix = {{ '0', '0', '0', 'G' },
						   { '0', '0', '0', '0' },
						   { '0', '0', '0', '0' },
						   { '0', '0', '0', '0' },
						   { 'A', '0', '0', '0' } };
		
		System.out.print("Minimum number of steps:");

		shortestPath(matrix);
	}

}