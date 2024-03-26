package chipmunk;

import java.io.*;
import basicgraphics.ClockWorker;
import basicgraphics.Task;

public class Chipmunk
{
    public static void usage(int status)
    {
        final String help = "usage: java Chipmunk [-h|--help] <file.rom>";

        if (status == 0) {
            System.out.println(help);
        } else {
            System.err.println(help);
        }

        System.exit(status);
    }

    public static void main(String[] args)
    {
        int[] code = new int[0xE00];
        int b;

        if (args.length != 1)
            usage (1);

        if (args[0].equals("-h") || args[0].equals("--help"))
            usage (0);

        try (InputStream in = new FileInputStream(args[0])) {
            for (int i = 0; (b = in.read()) != -1; i++)
                code[i] = b;
        } catch(IOException e) {
            usage (2);
        }

        Chip8 chip = new Chip8(code);

        //FakeThread.run = () -> chip.run();
        //FakeThread.sleep = 1000 / 60;
        //FakeThread.yield();

        ClockWorker.initialize(1000 / 60);
        ClockWorker.addTask(new Task() {
            @Override
            public void run()
            {
                chip.run();
            }
        });
    }
}