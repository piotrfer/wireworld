public class ModulesCreator {
    private static Matrix kite;
    private static Matrix flower;
    private static Matrix heart;

    public static Matrix getKite() {
        return kite;
    }

    public static Matrix getFlower() {
        return flower;
    }

    public static Matrix getHeart() {
        return heart;
    }

    public static void initializeModules() {
        createFlower();
        createHeart();
        createKite();
    }

    private static void createKite() {
        Cell[][] board = new Cell[5][5];
        int[][] board2 = {{2, 3, 1, 1, 1},
                {3, 2, 1, 1, 1},
                {1, 1, 3, 1, 1},
                {1, 1, 1, 3, 1},
                {1, 1, 1, 1, 2}};

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = new Cell(board2[i][j]);

        kite = new Matrix(board, 5, 5);


    }

    private static void createFlower() {
        Cell[][] board = new Cell[5][5];
        int[][] board2 = {{1, 1, 3, 1, 1},
                {1, 3, 2, 3, 1},
                {3, 2, 2, 2, 3},
                {1, 3, 2, 3, 1},
                {1, 1, 3, 1, 1}};

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = new Cell(board2[i][j]);

        flower = new Matrix(board, 5, 5);


    }

    private static void createHeart() {
        Cell[][] board = new Cell[5][5];
        int[][] board2 = {{1, 3, 1, 3, 1},
                {3, 2, 3, 2, 3},
                {1, 3, 2, 3, 1},
                {1, 1, 3, 1, 1},
                {1, 1, 1, 1, 1}};

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = new Cell(board2[i][j]);

        heart = new Matrix(board, 5, 5);


    }
}
