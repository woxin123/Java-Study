package top.mcwebsite.maze;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 18-7-28 下午10:19
 */
public class MazeTest {
    public static void main(String[] args) throws Exception {
//        System.out.println(Integer.parseInt("m"));
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();
        scanner.nextLine();
        String text = scanner.nextLine();
        try {
            String result = MazeParse.parseToMaze(row, column, text);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }
}

class MazeParse {

    public static String parseToMaze(Integer row, Integer column, String text) throws Exception {
        int mazeRow = row * 2 + 1, mazeColumn = column * 2 + 1;
        char[][] cells = new char[mazeRow][mazeColumn];
        for (int i = 0; i < mazeRow; i++) {
            for (int j = 0; j < mazeColumn; j++) {
                cells[i][j] = 'W';
            }
        }
        for (int i = 1; i < mazeRow - 1; i = i + 2) {
            for (int j = 1; j < mazeColumn - 1; j = j + 2) {
                cells[i][j] = 'R';
            }
        }

        String[] roadStrings = text.split(";");
        for (String roadString : roadStrings) {
            if (!roadString.matches("\\d+\\,\\d+\\s\\d+\\,\\d+")) {
                return "Incorrect command format.";
            }
            Road road = new Road();
            String[] roadArray = roadString.split(" ");
            String[] temp1 = roadArray[0].split(",");
            road.row1 = Integer.parseInt(temp1[0]);
            road.column1 = Integer.parseInt(temp1[1]);
            String[] temp2 = roadArray[1].split(",");
            road.row2 = Integer.parseInt(temp2[0]);
            road.column2 = Integer.parseInt(temp2[1]);
            int status = road.check(row, column);
            if (status == 0) {
                if (road.column1 == road.column2) {
                    cells[(Math.min(road.row1, road.row2) + 1) * 2][(road.column1 + 1) * 2 - 1] = 'R';
                } else {
                    cells[(road.row1 + 1) * 2 - 1][(Math.min(road.column1, road.column2) + 1) * 2] = 'R';
                }
            } else if (status == 1) {
                return "Number out of range.";

            } else if (status == 2) {
                return "Maze format error.";
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < mazeRow; i++) {
            for (int j = 0; j < mazeColumn; j++) {
                result.append("[" + cells[i][j] + "] ");
            }
            result.deleteCharAt(result.length() - 1).append("\n");
        }
        return result.toString();
    }
}


class Road {
    int row1, column1;
    int row2, column2;

    int check(int row, int column) {
        // 范围
        if (row1 < 0 || row2 < 0 || column1 < 0 || column2 < 0
                || row1 > row || row2 > row || column1 > column || column2 > column)
            return 1;
        // 合法
        if (!((row1 == row2 || Math.abs(column1 - column2) == 1)
                || (column1 == column2 || Math.abs(row1 - row2) == 1))) {
            return 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Road{" +
                "row1=" + row1 +
                ", column1=" + column1 +
                ", row2=" + row2 +
                ", column2=" + column2 +
                '}';
    }
}