package Step2Recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberOfPath {
	int N, K;
	int [][]maze;
	private void readFile() {
		try {
			Scanner in = new Scanner(new File("input3_1.txt"));
			int T = in.nextInt();
			for(int i = 0; i < T; i++) {
				N = in.nextInt();
				maze = new int[N][N];
				for(int p = 0; p < N; p++)
					for(int q = 0; q < N; q++)
						maze[p][q] = in.nextInt();
				K = in.nextInt();
				
				int result = mazePath(0, 0, 0);
				System.out.println(result);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file.");
		}
		
	}
	private int mazePath(int x, int y, int dist) {
		if(x < 0 || y < 0 || x >= N || y >= N || maze[x][y] != 0 )
			return 0;
		else if(dist > K) {
			maze[x][y] = 0;
			return 0;
		}
		else if(x == N-1 && y == N-1) {
			return 1;
		}
		else {
			maze[x][y] = 2;
			int result = 0;
			result += mazePath(x - 1, y, dist + 1);
			result += mazePath(x, y + 1, dist + 1);
			result += mazePath(x + 1, y, dist + 1);
			result += mazePath(x, y - 1, dist + 1);
			
			maze[x][y] = 0;
			
			return result;
		}
	}
	public static void main(String[] args) {
		NumberOfPath app = new NumberOfPath();
		app.readFile();
	}

}
