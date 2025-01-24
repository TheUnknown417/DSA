public class my_playlist {

    Node head ;
    Node tail ;
    Node curr ; // tracking the current song

    class Node {
        String songname;
        String artistname;
        Node next;
        Node prev;

        public Node(String songname, String artistname) {
            this.songname = songname;
            this.artistname = artistname;
            next = null;
            prev = null;

        }

    }
    public void Add_song(String songname , String artistname)
    {
        Node newnode = new Node(songname , artistname) ;

        if(head == null) // adding in an empty playlist
        {
            head = newnode;
            tail = newnode ;
            return;
        }

        tail.next=newnode;
        newnode.prev=tail;   // adding at end
        tail= newnode ;

        // locating curr
        if(curr == null)
        {
            curr = head ;
        }

    }

    public void delete_song(String song)
    {
        Node temp = head ;

        while(temp!=null)
        {
            if(temp.songname.equals(song))
            {
                // if song is at start
                if(temp==head)
                {
                    head = temp.next ;
                    if(head!=null)
                        head.prev = null;
                }
                // if song is at send
                else if(temp==tail)
                {
                    tail = temp.prev ;
                    if(tail!=null)
                        tail.next = null;
                }

                //if song is in middle
                else
                {
                    temp.prev.next = temp.next ;
                    temp.next.prev = temp.prev ;
                }
                System.out.println("REMOVED :" + song);
                return;

            }
            temp = temp.next ;

        }
        System.out.println( song + " not found in the playlist.");

    }




    public void play_next()
    {
        if(curr!=null && curr.next!=null)
        {
            curr = curr.next ;
            System.out.println(curr.songname + " is playing right now");
        }

        else
        {
            System.out.println("Nothing in playlist OR you have reached End of the playlist");

        }

    }

    public void play_prev()
    {

        if(curr!=null && curr.prev!=null)
        {
            curr = curr.prev ;
            System.out.println(curr.songname + " is playing right now");

        }
        else
        {
            System.out.println("Nothing in playlist OR you have reached Start of the playlist");
        }

    }

    public void display_playlist()
    {
        Node temp = curr ;
        System.out.println("FORWARD-> [");
        while(temp!=null)
        {
            System.out.println(temp.songname + " BY "+ temp.artistname + " , ");
            temp= temp.next ;
        }
        System.out.println("]");

        temp = curr ;
        System.out.println("Backward -> [");
        while(temp!=null)
        {
            System.out.println(temp.songname + " BY "+ temp.artistname + " , ");
            temp= temp.prev ;
        }
        System.out.println("]");

    }

    public static void main(String[] args) {
        my_playlist mpl  = new my_playlist() ;
        mpl.Add_song("FORGET" , "SIDHU");
        mpl.Add_song("REGRET" , "SIDHU");
        mpl.Add_song("ON TOP" , "AUJALA");
        mpl.Add_song("SOFTLY" , "AUJALA");
        mpl.Add_song("DETOX" , "LIL BABY");
        mpl.Add_song("EXCUESS" , "AP DHILLON");

        mpl.play_next();
        mpl.play_next();
        mpl.play_next();
        mpl.play_next();
        mpl.play_next();
        mpl.play_next();

        mpl.play_prev();
        mpl.play_prev();
        mpl.play_prev();

        mpl.delete_song("DETOX");
        mpl.display_playlist();










    }


}
