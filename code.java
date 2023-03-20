import java.util.*;

class RecentSongs {
    private int capacity;
    private int queries;
    private int option;
    private int choice;
    private String user;
    private String song;
    private Map<String, Queue<String>> map;

    public RecentSongs() {
        capacity = 0;
        queries = 0;
        option = 0;
        choice = 0;
        user = "";
        song = "";
        map = new HashMap<>();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter 1 to give input of users and songs \nEnter 2 to query the recent songs played by users\nEnter 3 to exit");
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type");
            return;
        }
        if (option == 1) {
            inputMenu();
        } else if (option == 2) {
            printRecentSongs();
        } else {
            return;
        }
    }

    public void inputMenu() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Capability of playlist:");
            capacity = scanner.nextInt();

            if (capacity <= 0) {
                System.out.println("Out of Space.Please enter a positive number.\n");
                menu();
            }

            System.out.println("Enter no of user-song pairs:");
            queries = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type");
            return;
        }
        for (int i = 0; i < queries; i++) {
            System.out.println("Enter username:");
            user = scanner.next();

            System.out.println("Enter song:");
            song = scanner.next();

            checkPlaylist();
        }

        menu();
    }

    public void checkPlaylist() {
        if (map.containsKey(user)) {
            if (map.get(user).size() == capacity) {
                // remove least recently played song
                map.get(user).remove(); 
                // add new song
                map.get(user).add(song); 
            } else {
                // add new song
                map.get(user).add(song); 
            }
        } else {
            map.put(user,new PriorityQueue<>());
            map.get(user).add(song); 
        }
    }

    public void printRecentSongs() {
        if (map.isEmpty()) {
            System.out.println("No user data found.\nPlease enter song-user pairs first\n");
        } else {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter: \n1.To find recent songs of a single user\n2.To find recent songs of all users ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type");
                return;
            }
            if (choice == 1) {
                System.out.println("Enter username to find his or her recent songs:");
                String inp = scanner.next();
                if (map.containsKey(inp)) {
                    System.out.println(map.get(inp));
                } else {
                    System.out.println("Invalid user\n");
                }
            } else if (choice == 2) {
                System.out.println("Recent songs palyed by all users are:" + map);
            } else {
                System.out.println("Enter valid choice");
            }
        }
        menu();
    }

}

public class code{
    public static void main(String[] args) {
        RecentSongs obj = new RecentSongs();
        obj.menu();
        //Test cases can be found in Readme file
    }
}
