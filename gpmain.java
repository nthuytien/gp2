import java.util.*;
import java.io.*;


class gpmain
{

public static void main (String [] args) throws IOException
{
  ArrayList<String> file1A = new ArrayList<String>();
  ArrayList<String> file2A = new ArrayList<String>();
  
  FileReader file1 = null;
  Scanner sc1 = new Scanner(new FileReader("file1.txt")).useDelimiter("\n");
  Scanner sc2 = new Scanner(new FileReader("file2.txt")).useDelimiter("\n");
  String str1;
  String str2;
  
  while(sc1.hasNext())
  {
    str1 = sc1.next();
    file1A.add(str1);
  }
  
  while(sc2.hasNext())
  {
    str2 = sc2.next();
    file2A.add(str2);
  }
  System.out.println("File 1 contains:");
  for (int i = 0; i < file1A.size(); i++)
    System.out.println(file1A.get(i));
  System.out.println("\nFile 2 contains:");
  for (int i = 0; i < file2A.size(); i++)
    System.out.println(file2A.get(i));
  
}

}
  