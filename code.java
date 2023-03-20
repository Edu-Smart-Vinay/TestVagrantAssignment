import java.util.*;
import java.io.*;
class recentSongs
{
    Scanner sc = new Scanner(System.in);
    int capacity,queries,option,choice;
    String user,song;
    Map<String, Queue<String>> map = new HashMap<>();
    
    void menu()
    {
        try
        {
        	System.out.println("Enter 1 to give input of users and songs \nEnter 2 to query the recent songs played by users\nEnter 3 to exit");
        	option = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input type");
            return;
        }
        if(option==1)
        	inputMenu();
        else if(option==2)
        	printRecentSongs();
        else
        	return;
    }
    
    void inputMenu()
    {
        try
        {
        	System.out.println("Enter Capability of playlist:");
        	capacity=sc.nextInt();
			
			if(capacity<=0){
                System.out.println("Out of Space.Please enter a positive number.\n");
                menu();
            }
        
        	System.out.println("Enter no of user-song pairs:");
        	queries=sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input type");
            return;
        }
        sc.nextLine();
       
        for(int i=0;i<queries;i++){
            
            System.out.println("Enter username:");
            user = sc.nextLine();
           
            System.out.println("Enter song:");
            song = sc.nextLine();
            
            
            checkPlaylist();
           
        }
        
        menu();
    }
    
    void checkPlaylist()
    {
          if(map.containsKey(user))
          {
               
                if(map.get(user).size()==capacity)
                {
                    //remove least recently played song
                    map.get(user).remove(); 
                    //add new song
                    map.get(user).add(song); 
                }
                else{
                    //add new song
                    map.get(user).add(song); 
                }
            }
            
            if(!map.containsKey(user))
            {
                map.put(user,new PriorityQueue<>());
                map.get(user).add(song); 
            }
    }
    
    void printRecentSongs()
    {
            if(map.isEmpty())
            {
                System.out.println("No user data found.\nPlease enter song-user pairs first\n");
            }
            else
            {
                try
                {
                    System.out.println("Enter: \n1.To find recent songs of a single user\n2.To find recent songs of all users ");
                    choice=sc.nextInt();
                    sc.nextLine();
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input type");
                    return;
                }
                    if(choice==1)
                    {
                        System.out.println("Enter username to find his or her recent songs:");
                        String inp=sc.nextLine();
                        if(map.containsKey(inp))
                            System.out.println(map.get(inp));
                        else
                            System.out.println("Invalid user\n");
                    }
                    else if(choice==2)
                        System.out.println("Recent songs palyed by all users are: " + map);
                    else
                        System.out.println("Enter valid choice");
            }
            
            menu();
    }
}
public class code 
{
    public static void main(String args[]) 
    {
    	recentSongs obj = new recentSongs();
    	obj.menu();
		
		//Testcases can be found in Readme file
    }
}