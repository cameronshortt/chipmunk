package chipmunk;

public interface DisplayI
{
    public void output();

    public boolean draw(int x, int y, boolean[][] sprite);
    public void clear();

    public int width();
    public int height();
	public boolean on(int x, int y);
}
