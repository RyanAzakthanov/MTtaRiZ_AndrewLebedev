public class Lab2_1
{
    public static void main(String[] args) 
    {
        PrintTree(4);
        PrintTree(10);
    }

    public static void PrintTree(int size)
    {
        int n = 0;
        
        for( int i = 0; i < size; i++)
        {
            /*
             
             
            n = 0;
            
            while ( n < size - i)
            {
                System.out.print(" ");
                n++;
            }
            */
            
            n = 0;

            while( n < 1 + i + i )
            {
                System.out.print("*");
                n++;
            }
            System.out.println();
        }
        System.out.println();
    }
}
