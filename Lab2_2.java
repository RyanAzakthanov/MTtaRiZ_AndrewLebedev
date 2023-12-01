public class Lab2_2
{
    public static void main(String[] args) 
    {
        CreateArray(2, 3, 0);
        CreateArray(4, 4, 10);
        CreateArray(6, 5, 1);
    }

    public static void CreateArray(int y, int x, int startValue)
    {        
        int[][] array = new int[y][x];

        for(int i = 0; i < y; i++ )
        {
            for(int j = 0; j < x; j++)
            {
                array[i][j] = startValue;
                startValue += 3;
            }
        }

        for(int i = 0; i < y; i++ )
        {
            for(int j = 0; j < x; j++)
            {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}