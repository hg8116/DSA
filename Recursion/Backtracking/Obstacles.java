/*
Suppose you are having a 3x3 matrix and a person is standing on (0, 0) and there is an obstacle on center cell.
The person needs to go to (2, 2). Count the number of paths & Print all the paths.

When you land on a new cell, check weather there is obstacle or not.
*/

package Recursion.Backtracking;

public class Obstacles {
    public static void main(String[] args) {
        boolean board[][] = {
                {true, true, true},{true, false, true},{true, true, true}
        };
        pathObstacle("", board, 0, 0);
    }

    static void pathObstacle(String p, boolean maze[][],int r, int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length-1){
            pathObstacle(p + 'D', maze, r+1, c);
        }

        if(c < maze[0].length-1){
            pathObstacle(p + 'R', maze, r, c+1);
        }
    }
}
