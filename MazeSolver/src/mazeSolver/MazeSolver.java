package mazeSolver;

import java.util.*;

public class MazeSolver {

	static int[][] maze = {
			{0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
			{0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1},
			{0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
			{0, 1, 0, 2, 1, 1, 1, 1, 1, 0, 1, 1},
			{0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
			{0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1},
			{0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1}
	};

	// 0 wall
	// 1 path
	// 2 destination

	static LinkedList<Position> path = new LinkedList<>();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Position p = new Position(0, 8); // starting position in maze	
		path.push(p);
		
		while (true) {
			int row = path.peek().row;
			int column = path.peek().column;
			
			maze[row][column] = 0;
			
			if (isValid(row + 1, column)) {
				// Going DOWN the maze, starting from the specified position(maze[0][3]).
				if (maze[row + 1][column] == 2) {
					System.out.println("Moved DOWN...You won!");
					break;
				} else if (maze[row + 1][column] == 1) {
					System.out.println("Moving DOWN");
					path.push(new Position(row + 1, column));
					continue;
				}
			}
			
			if (isValid(row, column - 1)) {
				// Going LEFT
				if (maze[row][column - 1] == 2) {
					System.out.println("Moved LEFT... You Won!");
					break;
				} else if (maze[row][column - 1] == 1) {
					System.out.println("Moving LEFT");
					path.push(new Position(row, column - 1));
					continue;
				}
			}
			
			if (isValid(row - 1, column)) {
				// Going UP
				if (maze[row - 1][column] == 2) {
					System.out.println("Moved UP... You Won!");
					break;
				} else if (maze[row - 1][column] == 1) {
					System.out.println("Moving UP");
					path.push(new Position(row -1, column));
					continue;
				}	
			}
			
			if (isValid(row,  column + 1)) {
				// Going RIGHT
				if (maze[row][column + 1] == 2) {
					System.out.println("Moved RIGHT... You Won!");
					break;
				} else if (maze[row][column + 1] == 1) {
					System.out.println("Moving RIGHT");
					path.push(new Position(row, column + 1));
					continue;
				}	
			}
				
			path.pop();
			System.out.println("Moved BACK");
			
			if (path.size() <= 0) {
				System.out.println("There is a WALL. Unable to continue");
				break;
			}
		}
	}
	
	public static boolean isValid(int row, int column) {
		if ((row < 0 || row >= maze.length) || (column < 0 || column >= maze[row].length)) {
			return false;
		}
		
		return true;
	}
			
}
		