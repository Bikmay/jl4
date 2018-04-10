package barBossHouse;

public class InternetOrdersManager {

    private Queue queue;


    public InternetOrdersManager()
    {
        queue=new Queue();
    }

    public InternetOrdersManager(Order[] arr)
    {
        for ( Order a:arr
             ) {
            queue.add(a);

        }
    }


}
