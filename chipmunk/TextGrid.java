package chipmunk;

public class TextGrid implements DisplayI
{
    private boolean[][] screen;
    private int width;
    private int height;

    public TextGrid()
    {
        width = 64;
        height = 32;
        screen = new boolean[height][width];
    }

    @Override
    public int width()
    {
        return width;
    }

    @Override
    public int height()
    {
        return height;
    }

	@Override
	public boolean on(int x, int y)
	{
		return screen[y][x];
	}

    @Override
    public void output()
    {
        System.out.printf("%c[2J%c[H", 033, 033);

        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                System.out.print(on(x, y) ? '#' : '.');
            }
            System.out.println();
        }
    }

    @Override
    public boolean draw(int x, int y, boolean[][] sprite)
    {
        boolean save = false;
        boolean mod = false;

        for (int i = 0; i < sprite.length; i++) {
            for (int j = 0; j < sprite[i].length; j++) {
                if (i+y < height() && j+x < width()) { // clip on overflow
                    save = screen[i+y][j+x];

                    screen[i+y][j+x] ^= sprite[i][j];

                    if (screen[i+y][j+x] != sprite[i][j])
                        mod = true;
                }
            }
        }

        return mod;
    }

    @Override
    public void clear()
    {
        for (int y = 0; y < height(); y++)
            for (int x = 0; x < width(); x++)
                screen[y][x] = false;
    }
}
