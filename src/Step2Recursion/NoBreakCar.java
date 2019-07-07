package Step2Recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoBreakCar {	
	private static final int PATH = 0;
	private static final int WALL = 1;
	private static final int BLOCK = 2;
	private int [][]maze;
	private int N;
	
	private class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean equals(Pos other) {
			if(x == other.x && y == other.y)
				return true;
			return false;
		}
		public Pos add(Pos p) {
			return new Pos(x + p.x, y + p.y);
		}
	}
	Pos NORTH = new Pos(-1, 0);
	Pos EAST = new Pos(0, 1);
	Pos SOUTH = new Pos(1, 0);
	Pos WEST = new Pos(0, -1);
	
	private void readFile() {
		try {
			Scanner in = new Scanner(new File("input3_2.txt"));
			int T = in.nextInt();
			for(int i = 0; i < T; i++) {
				N = in.nextInt();
				maze = new int[N][N];
				for(int p = 0; p < N; p++) 
					for(int q = 0; q < N; q++)
						maze[p][q] = in.nextInt();
				Pos startPoint = new Pos(0, 0);
				Pos dir = new Pos(0, 0);
				if(availableToDestination(startPoint, dir))
					System.out.println("Available!");
				else
					System.out.println("Not Available!");
			}			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File");
		}
	}
	private boolean availableToDestination(Pos point, Pos dir) {
		if(maze[point.x][point.y] == BLOCK)
			return false;
		if(point.x == N-1 && point.y == N-1) {
			maze[point.x][point.y] = BLOCK;
			return true;
		}
		else {
			Pos tmpE = getNeighbor(point, EAST);
			Pos tmpW = getNeighbor(point, WEST);
			Pos tmpN = getNeighbor(point, NORTH);
			Pos tmpS = getNeighbor(point, SOUTH);

			if(dir.equals(new Pos(0,0))) {
				if(!tmpE.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpE, EAST))
						return true;
				}
				
				if(!tmpS.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpS, SOUTH))
						return true;
				}
				return false;
			}
			else if(dir.equals(NORTH) || dir.equals(SOUTH)) {
				if(!tmpE.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpE, EAST))
						return true;
				}

				if(!tmpW.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpW, WEST))
						return true;
				}
				else
					return false;

			}
			else {
				if(!tmpN.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpN, NORTH))
						return true;
				}

				if(!tmpS.equals(point)) {
					maze[point.x][point.y] = BLOCK;
					if(availableToDestination(tmpS, SOUTH))
						return true;
				}
				else
					return false;

			} 
			maze[point.x][point.y] = PATH;
			return false;
		}
	}
	private Pos getNeighbor(Pos point, Pos dir) {
		if (point.x < 0 || point.y < 0 || point.x >= N || point.y >= N || maze[point.x][point.y] == WALL)
			return point.add(new Pos(-dir.x, -dir.y));
		
		else if (maze[point.x][point.y] == BLOCK)
			return point;
		
		else
			return getNeighbor(point.add(dir), dir);
	}
	public static void main(String[] args) {
		NoBreakCar app = new NoBreakCar();
		app.readFile();
	}
}
