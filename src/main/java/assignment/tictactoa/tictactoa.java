package assignment.tictactoa;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Logger;
public class tictactoa extends XoBoard
{
    static public int size;
    public static void main( String[] args )
    {
        Logger l = Logger.getLogger("hi");
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));
        XoBoard xb = new XoBoard();
        int position;
        int s=xb.size;
        int i=0;
        xb.printArray();
        l.info("Player 1  x");
        l.info("Player 2  o");
        while(i<s*s)
        {
            if(i%2==0)
            {
                l.info("Enter the position");
                position = sc.nextInt();
                int x = xb.insert(position,'x');
                if(x==1)
                {
                	i--;
                }
                xb.printArray();
                xb.check();
            }
            else
            {
                l.info("Enter the position");
                position = sc.nextInt();
                int x = xb.insert(position,'o');
                if(x==1)
                {
                	i--;
                }
                xb.printArray();
                xb.check();
            }
            i++;
            if(i>=9)
            {
            	ps.print("Draw");
            }
        }
        
        
        
    }
    
}
class XoBoard
{
    static PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));
    Scanner is = new Scanner(System.in);
    char ch[][];
    int size;
    XoBoard()
    {
        ps.print("Enter the size");
        this.size = is.nextInt();
        ch=new char[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
                {
                    ch[i][j] = ' ';
                }
        }
    }
    void printArray()
    {

    for(int i=0;i<size;i++)
    {
    	ps.print("|");
        for(int j=0;j<size;j++)
            {
                ps.print(ch[i][j]);
                ps.print("|");
            }
        ps.println();
    }
    }
    public int insert(int index,char x)
    {
        System.out.println(index);
        int row = (index-1)/size;
        int col = (index-1)%size;
        if(ch[row][col] == ' ')
        {
        	ch[row][col]=x;
        }
        else {
        	return 1;
        }
        return 0;
    }
    void check()
    {
    	for(int i=0;i<ch.length;i++) //checkrow
    	{
    		int flag = 0;
        	int flag1 = 0;
    		for(int j=0;j<ch.length;j++)
    		{
    			if(ch[i][j]== 'x')
    			{
    				flag++;
    			}
    			else if(ch[i][j]== 'x')
    			{
    				flag1++;
    			}
    		}
    		if(flag == size)
    		{
    			ps.print("player 1 winner");
    			System.exit(0);
    		}
    		if(flag1 == size)
    		{
    			ps.print("player 2 winner");
    			System.exit(0);
    		}
    	}
    	
    	for(int j=0;j<ch.length;j++) //checkcolumn
    	{
    		int flag = 0;
        	int flag1 = 0;
    		for(int i=0;i<ch.length;i++)
    		{
    			if(ch[i][j]== 'x')
    			{
    				flag++;
    			}
    			else if(ch[i][j]== 'o')
    			{
    				flag1++;
    			}
    		}
    		if(flag == size)
    		{
    			ps.print("player 1 winner");
    			System.exit(0);
    		}
    		if(flag1 == size)
    		{
    			ps.print("player 2 winner");
    			System.exit(0);
    		}
    	}
    	
    	int play1=0;
    	int play2=0;
		for(int j=0;j<ch.length;j++) //check right diagnole
    	{
    		for(int i=0;i<ch.length;i++)
    		{
    			if((i+j)== size-1)
    			{
	    			if(ch[i][j]== 'x')
	    			{
	    				play1++;
	    			}
	    			else if(ch[i][j]== 'o')
	    			{
	    				play2++;
	    			}
    			}
    		}
    	}
		if(play1 == size)
		{
			ps.print("player 1 winner");
			System.exit(0);
		}
		if(play2 == size)
		{
			ps.print("player 2 winner");
			System.exit(0);
		}
    	
    	int p1=0;
    	int p2=0;
    	for(int i=0;i<ch.length;i++) //check left diagnole
    	{
    		if(ch[i][i]=='x')
    		{
    			p1++;
    		}
    		else if(ch[i][i]=='o')
    		{
    			p2++;
    		}
    	}
    	if(p1 == size)
		{
			ps.print("player 1 winner");
			System.exit(0);
		}
		if(p2 == size)
		{
			ps.print("player 2 winner");
			System.exit(0);
		}
    }
}
