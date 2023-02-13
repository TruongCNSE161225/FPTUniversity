package maze_ver2;

public class Cell_V2 {

    int row, col;
    char value;
    boolean blocked = false;
    boolean visited = false;
    Cell_V2 previous = null;

    public Cell_V2(int row, int col, char value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public void setBlock() {
        this.blocked = true;
    }

    public boolean canBeVisited() {
        return !blocked && !visited;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ", " + value + ")";
    }
}
