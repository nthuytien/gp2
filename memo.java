import java.util.*;
import java.io.*;



class memo
{
  public int value;
 	public boolean left;
  public boolean diagonal;
  public boolean above;

  public memo()
  {
    this.value = 0;
    this.left = false;
    this.diagonal = false;
    this.above = false;
  }


  public int memoTable(ArrayList file1A, ArrayList file2A)
  {
    int rows = file1A.size()+1;
    int columns = file2A.size()+1;
		memo[][] table = new memo[rows][columns];

    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < columns; j++)
      {
        table[i][j] = new memo();
        
        if (i == 0 || j == 0)
        { 
          table[i][j].value = 0;
        }
        else if (file1A.get(i-1).equals(file2A.get(j-1)))
        {
          table[i][j].value = table[i-1][j-1].value + 1;
          table[i][j].diagonal = true;
        }
        else
        {
          int aboveValue = table[i-1][j].value;
          int leftValue = table[i][j-1].value;
          table[i][j].value = Math.max(aboveValue, leftValue);
          if (table[i][j].value == aboveValue)
            table[i][j].above = true;
          else
            table[i][j].left = true;
        }
      }
    }
    return table[rows-1][columns-1].value;
  }
  
  //retrieval method
  //if diagonal == true, then add the value of file1A[i] to the array
  // if diagonal is false, then check to see if left or above is true
  //if either of those are true, go in that direction, then check to see if diagonal is true again
  //loop till finished
  
  
  
}



