import static java.lang.Math.*;

public class Map {
    private int nowGeneration;//后代代数
    private Cell[][] grid;//网格中的细胞状态 1活0死
    private int maxLength;//游戏地图中网格的列数
    private int maxWidth;//网格行数

    //构造函数
    public Map(int maxLength,int maxWidth){
        this.maxWidth=maxWidth;
        this.maxLength=maxLength;
        nowGeneration=0;
        grid=new Cell[maxLength+2][maxWidth+2];
        //初始化细胞状态均为死亡
        for(int i=0;i<maxLength+2;i++)
        {
            for(int j=0;j<maxWidth+2;j++) {
                grid[i][j] =new Cell(i,j);
            }
        }
    }

    public void setNowGeneration(int nowGeneration) {
        this.nowGeneration = nowGeneration;
    }

    public int getNowGeneration() {
        return nowGeneration;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public boolean getCellstatus(int x,int y)
    {
        return grid[x][y].getStatus();
    }

    //初始化细胞
    public void InitGird()
    {
        for(int i=0;i<maxLength+2;i++)
            for(int j=0;j<maxWidth+2;j++)
            {
                grid[i][j].setStatus(Math.random()>0.5?true:false);
            }
    }
    //细胞清零
    public void delCells()
    {
        for(int i=0;i<maxLength+2;i++)
            for(int j=0;j<maxWidth+2;j++)
                grid[i][j].setStatus(false);
        nowGeneration=0;
    }

    //繁衍后代
    public void update() {
        Cell[][] newGrid = new Cell[maxLength + 2][maxWidth + 2];
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                switch (getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //细胞状态保持不变
                        break;
                    case 3:
                        newGrid[i][j] = grid[i][j];
                        newGrid[i][j].setStatus(true); // 细胞活着
                        break;
                    default:
                        newGrid[i][j] = grid[i][j];
                        newGrid[i][j].setStatus(false); //细胞死亡
                }
        for (int i = 1; i <= maxLength; i++)
            for (int j = 1; j <= maxWidth; j++)
                grid[i][j] = newGrid[i][j];
        nowGeneration++;
    }

    //获取细胞的邻居数量
    private int getNeighborCount(int i1, int j1) {
        int count = 0;
        for (int i = i1 - 1; i <= i1 + 1; i++) {
            for (int j = j1 - 1; j <= j1 + 1; j++) {
                if (grid[i][j].getStatus())
                    count++; //如果邻居还活着，邻居数便会+1
            }
        }
        if(grid[i1][j1].getStatus()) {
            count--; //每个细胞不是自己的邻居，则如果细胞还活着，邻居数-1.
        }
        return count;
    }
}

