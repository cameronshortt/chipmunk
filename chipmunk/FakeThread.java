package chipmunk;

public class FakeThread
{
    public static Runnable run;
    public static int sleep;
    
    public static void yield()
    {
        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
            System.exit(-1);
        }
        run.run();
    }
}
