// Emily Bui and Joe Luhrman
// CS 462 Group Project
// We believe that the running time of the algorithm is O(ab) where a and b are the number of lines in either file respectively, 
// similar to the running time of the other memoization table algorithms we've looked at

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

  /**
   * Creates the memoization table and retrieves result
   * @param file1A the first file's contents
   * @param file2A the second file's contents
   * @return maximum number of common lines
   */
  public ArrayList<String> memoTable(ArrayList file1A, ArrayList file2A)
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
          //System.out.println("Added " + file1A.get(i-1) + " " + i + " " + j);
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
    
    ArrayList<String> termsInCommon = new ArrayList<String>();
    boolean finished = false;
    int rows2 = rows-1;
    int columns2 = columns-1;
    String term;
    while(finished == false)
    {

      if(table[rows2][columns2].diagonal == true)
      {
        term = (String)file1A.get(rows2-1);
        //System.out.println("Added2 " + file1A.get(i-1) + " " + i + " " + j);
        
	if (!(termsInCommon.contains(term)))
	  termsInCommon.add(term);
        
	rows2--;
        columns2--;
      }
      else if(table[rows2][columns2].left == true)
      {
        columns2--;
      }
      else if(table[rows2][columns2].above == true)
      {
        rows2--;
      }
      else
        finished = true;
      
    }
    return termsInCommon;
    
    
 }   
}    
    
    //return table;
  
  

    //return table[rows-1][columns-1].value; <-- number of common terms
  
 
  
  //retrieval method
  //if diagonal == true, then add the value of file1A[i] to the array
  // if diagonal is false, then check to see if left or above is true
  //if either of those are true, go in that direction, then check to see if diagonal is true again
  //loop till finished
  




