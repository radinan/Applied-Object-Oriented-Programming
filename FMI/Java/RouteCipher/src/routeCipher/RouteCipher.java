package routeCipher;

import static java.lang.Math.abs;

public class RouteCipher
{
    private int key; //number of columns
    private final int MAX_ROWS = 10;
    private final int MAX_COLS = 10;

    public RouteCipher(int key)
    {
        setKey(key);
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        if (key != 0)
        {
            this.key = key;
        }
        else
        {
            this.key = 1;
        }
    }

    public String encrypt(String plainText)
    {
        char [][] grid = convertStringToGrid(plainText);
        StringBuilder encryptedText = new StringBuilder();
        
        int rows = grid.length; //first dimension
        int cols = grid[0].length; //second dimension

        if(key > 0)
        {
            spiralTraverse(encryptedText, grid, rows, cols, 0, 0, 1);
        }
        else if(key < 0)
        {
            spiralTraverse(encryptedText, grid, rows, cols, rows - 1, cols - 1, 3);
        }

        return encryptedText.toString();
    }

    public String decrypt(String cipherText)
    {
        //1. create grid and fill it with '#'
        int rows = cipherText.length() / abs(key);
        int cols = cipherText.length() / rows;
        char[][] grid = new char[rows][cols];
        fillGrid(grid);

        //2. convert text to array
        char[] textToArray = cipherText.toCharArray(); //we know that it's properly formatted

        //3. traverse
        if (key > 0)
        {
            spiralTraverseD(textToArray, grid, rows, cols, 0, 0, 1);
        }
        else if (key < 0)
        {
            spiralTraverseD(textToArray, grid, rows, cols, rows - 1, cols - 1, 3);
        }

        //4. convert to string
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                //removing the fillers ('X')
                if ((i == rows - 1) && (grid[i][j] == 'X')) //'X' on last line
                {
                    boolean flag = true; //is it ok to be deleted
                    for (int k = j; k < cols; ++k)
                    {
                        if (grid[i][k] != 'X') //if there is something different than 'X' afterwards
                        {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == false)
                    {
                        decryptedText.append(grid[i][j]);
                    }
                }
                else
                {
                    decryptedText.append(grid[i][j]);
                }
            }
        }

        return decryptedText.toString();
    }

    public String toString()
    {
        return ("key: " + key);
    }

    private char[][] convertStringToGrid(String text)
    {
        //1. string -> array
        char[] textToArray = text.toCharArray();
        char[] holder = new char[MAX_ROWS * MAX_COLS];
        final int absKey = abs(key);

        //2. remove invalid chars
        int holderSize = makeLettersOnly(textToArray, holder);

        //3. fill in (for full rectangle)
        int countOfFillers = 0; //how many 'X' must be used to fill the grid
        if (holderSize % absKey != 0)
        {
            countOfFillers = absKey - (holderSize % absKey);
        }
        for (int i = 0; i < countOfFillers; ++i)
        {
            holder[holderSize + i] = 'X';
        }
        int countOfAllElements = holderSize + countOfFillers;

        //4. convert to grid
        char [][] grid = new char[countOfAllElements/absKey][absKey]; //[rows][cols]
        for (int i = 0, k = 0; k < countOfAllElements; ++i)
        {
            for(int j = 0; j < absKey && k < countOfAllElements; ++j)
            {
                grid[i][j] = holder[k];
                ++k;
            }
        }

        return grid;
    }

    private int makeLettersOnly (char[] original, char[] holder)
    {
        int holderSize = 0;
        for (int i = 0, j = 0; i < original.length; ++i)
        {
            if (original[i] >= 'a' && original[i] <= 'z')
            {
                holder[j] = (char)(original[i] - 32); //converting to Uppercase
                ++j;
                ++holderSize;
            }
            else if (original[i] >= 'A' && original[i] <= 'Z')
            {
                holder[j] = original[i];
                ++j;
                ++holderSize;
            }
        }
        return holderSize;
    }

    //used for encrypting
    //marking the traces with '#' so they are not repeatedly visited
    private void spiralTraverse (StringBuilder encryptedText, char[][] grid,
                                int rows, int cols, int currRow, int currCol, int direction)
    {
        //directions: 1 = down 2 = right 3 = up 4 = left
        while (encryptedText.length() < rows * cols)
        {
            if (direction == 1) //down
            {
                while (currRow < rows && grid[currRow][currCol] != '#')
                {
                    appendAndMark(encryptedText, grid, currRow, currCol);
                    currRow++;
                }
                currRow--;
                currCol++;
                direction = 2;
            }
            else if (direction == 2) //right
            {
                while (currCol < cols && grid[currRow][currCol] != '#')
                {
                    appendAndMark(encryptedText, grid, currRow, currCol);
                    currCol++;
                }
                currCol--;
                currRow--;
                direction = 3;
            }
            else if (direction == 3) //up
            {
                while (currRow >= 0 && grid[currRow][currCol] != '#')
                {
                    appendAndMark(encryptedText, grid, currRow, currCol);
                    currRow--;
                }
                currRow++;
                currCol--;
                direction = 4;
            }
            else if (direction == 4) //left
            {
                while (currCol >= 0 && grid[currRow][currCol] != '#')
                {
                    appendAndMark(encryptedText, grid, currRow, currCol);
                    currCol--;
                }
                currCol++;
                currRow++;
                direction = 1;
            }
        }
    }

    private void appendAndMark (StringBuilder encryptedText, char[][] grid, int currRow, int currCol)
    {
        encryptedText.append(grid[currRow][currCol]);
        grid[currRow][currCol] = '#';
    }

    private void fillGrid (char[][] grid)
    {
        for (int i = 0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[0].length; ++j)
            {
                grid[i][j] = '#';
            }
        }
    }

    //used in decrypting
    //replacing every '#' in the grid with a letter from cipherTextArray
    private void spiralTraverseD (char[] cipherTextArray, char[][] grid,
                                int rows, int cols, int currRow, int currCol, int direction)
    {
        int i = 0; //for iterating through cipherTextArray

        //directions: 1 = down 2 = right 3 = up 4 = left
        while (i < rows * cols)
        {
            if (direction == 1) //down
            {
                while (currRow < rows && grid[currRow][currCol] == '#')
                {
                    changeToLetter(cipherTextArray, grid, i, currRow, currCol);
                    currRow++;
                    i++;
                }
                currRow--;
                currCol++;
                direction = 2;
            }
            else if (direction == 2) //right
            {
                while (currCol < cols && grid[currRow][currCol] == '#')
                {
                    changeToLetter(cipherTextArray, grid, i, currRow, currCol);
                    currCol++;
                    i++;
                }
                currCol--;
                currRow--;
                direction = 3;
            }
            else if (direction == 3) //up
            {
                while (currRow >= 0 && grid[currRow][currCol] == '#')
                {
                    changeToLetter(cipherTextArray, grid, i, currRow, currCol);
                    currRow--;
                    i++;
                }
                currRow++;
                currCol--;
                direction = 4;
            }
            else if (direction == 4) //left
            {
                while (currCol >= 0 && grid[currRow][currCol] == '#')
                {
                    changeToLetter(cipherTextArray, grid, i, currRow, currCol);
                    currCol--;
                    i++;
                }
                currCol++;
                currRow++;
                direction = 1;
            }
        }
    }

    private void changeToLetter (char[] cipherTextArray, char[][] grid, int i, int currRow, int currCol)
    {
        grid[currRow][currCol] = cipherTextArray[i];
    }
}
