import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main ( String args [])
    {
        /*ListOfUsers list = new ListOfUsers();
        User user1 = new User(1,0);
        User user2 = new User(2,0);
        User user3 = new User(1, 1);
        list.Insert(user1);
        list.Insert(user2);
        list.Insert(user3);
        list.showusers();
        System.out.println("");*/
        BufferedReader br = null;
        Master r = new Master();

        try {
            String actionString;
            br = new BufferedReader(new FileReader("actions1.txt"));

            while ((actionString = br.readLine()) != null) {
                r.performAction(actionString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        /*
        UserNode node = r.UserList.Search(1);
        NodeText temp =node.data.TextList.head;
        while(temp != null){
            System.out.println(temp.text.TextString);
            temp = temp.next;
        }*/

       /* NodeUsersAndText node1 = r.TextList.head;
        while(node1 != null){
            System.out.println(node1.textid+", " + node1.pid+", "+ node1.text);
            node1 = node1.next;
        }*/
        //r.UserList.Show();
    }
}