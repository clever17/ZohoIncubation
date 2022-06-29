package eval;

import java.util.LinkedList;

public class Question2 
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
	public static LinkedList<Mat> shortestPath(char[][] matrix , int []start, int[] end) {

		int sx = start[0], sy = start[1], dx = end[0], dy = end[1];

		int m = matrix.length;

		int n = matrix[0].length;

		Mat[][] mat = new Mat[m][n];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) 
			{
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
			LinkedList<Mat> path = new LinkedList<>();
			p=dest;
			do
			{
				path.addFirst(p);
			}while((p=p.previous)!=null);
			return path;
	}
	public static void findpath(char [][] matrix, int []monster, int []advent, int []gold)
	{
		LinkedList<Mat> apath = shortestPath(matrix, advent, gold);
		LinkedList<Mat> mpath = shortestPath(matrix, monster, gold);
		
		for(int i=0;i<apath.size()-1;i++)
		{
			Mat adm = apath.get(i);
			for(int j=0;j<mpath.size()-1;j++)
			{
				Mat mdm = mpath.get(i);
				if(adm.x == mdm.x & adm.y == mdm.y)
				{
					System.out.println("No possible Solution");
					return;
				}
			}
		}
		System.out.println("Minimum Number of Steps:"+(apath.size()));
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
	public static void main(String[]  args)
	{
		char[][] matrix = {{ '0', '0', '0', '0' },
						   { '0', '0', '0', '0' },
				           { '0', '0', '0', '0' },
				           { '0', '0', '0', '0' },
				           { '0', '0', '0', '0' } };
		
		int [] advent= {4,0};
		int [] monster= {2,0};
		int [] gold= {2,2};
		findpath(matrix, advent, monster, gold);
		

	}
}
