public class Cell {
    private int x;//细胞横坐标
    private int y;//纵坐标
    private boolean status;//细胞状态 true活false死

    public Cell(int x,int y)
    {
        this.x=x;
        this.y=y;
        status=false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus()
    {
        return status;
    }
}
