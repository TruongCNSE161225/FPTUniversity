package maze_ver2;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.ArrayList;

public class Maze_V2 {

    char entryChar = 'E', destChar = 'M';
    char emptyChar = '0', blockedChar = '1';
    int rows = 0, cols = 0;

    Cell_V2[][] cells = null;
    Cell_V2 entryCell = null;
    Cell_V2 destCell = null;
    boolean completed = false;
    boolean succeeded = false;

    public Maze_V2() {
    }

    public Maze_V2(char entryChar, char destChar, char emptyChar, char blockedChar) {
        this.entryChar = entryChar;
        this.destChar = destChar;
        this.emptyChar = emptyChar;
        this.blockedChar = blockedChar;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(cells[i][j].value);
            }
            System.out.println();
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows
                && col >= 0 && col < cols
                && cells[row][col].canBeVisited();
    }

    private ArrayList<Cell_V2> getAdjs(Cell_V2 curCell) {
        ArrayList<Cell_V2> adjs = new ArrayList();
        int row = curCell.row, col = curCell.col;
        if (isValid(row - 1, col)) {
            cells[row - 1][col].previous = curCell;
            adjs.add(cells[row - 1][col]);
        }
        if (isValid(row + 1, col)) {
            cells[row + 1][col].previous = curCell;
            adjs.add(cells[row + 1][col]);
        }
        if (isValid(row, col - 1)) {
            cells[row][col - 1].previous = curCell;
            adjs.add(cells[row][col - 1]);
        }
        if (isValid(row, col + 1)) {
            cells[row][col + 1].previous = curCell;
            adjs.add(cells[row][col + 1]);
        }
        return adjs;
    }

    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("The file " + filename + " doesn't existed!");
            System.exit(0);
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList();
            String line;
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    list.add(line.toUpperCase());
                }
            }
            bf.close();;
            fr.close();
            this.rows = list.size();
            this.cols = list.get(0).length();
            this.cells = new Cell_V2[rows][cols];
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                for (int j = 0; j < cols; j++) {
                    char ch = line.charAt(j);
                    cells[i][j] = new Cell_V2(i, j, ch);
                    if (ch == blockedChar) {
                        cells[i][j].setBlock();
                    } else if (ch == entryChar) {
                        this.entryCell = cells[i][j];
                    } else if (ch == destChar) {
                        this.destCell = cells[i][j];
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return true;
    }

    public boolean solve() {
        LinkedList<Cell_V2> stack = new LinkedList();
        Cell_V2 curCell = this.entryCell;
        while (!completed) {
            curCell.visited = true;
            if (curCell == this.destCell) {
                completed = succeeded = true;
            } else {
                ArrayList<Cell_V2> adjs = getAdjs(curCell);
                if (adjs.size() > 0) {
                    curCell = adjs.get(0);
                    for (int i = 1; i < adjs.size(); i++) {
                        stack.addFirst(adjs.get(i));
                    }
                } else if (!stack.isEmpty()) {
                    curCell = stack.removeFirst();
                } else {
                    completed = true;
                    succeeded = false;
                }
            }
        }
        return completed;
    }

    public LinkedList<Cell_V2> getPath() {
        if (!succeeded) {
            return null;
        }
        LinkedList<Cell_V2> path = new LinkedList();
        Cell_V2 cell = this.destCell;
        while (cell != null) {
            path.addFirst(cell);
            cell = cell.previous;
        }
        return path;
    }
}
