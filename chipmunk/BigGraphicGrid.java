package chipmunk;

public class BigGraphicGrid extends GraphicGrid
{
	public BigGraphicGrid(InputI pad)
	{
		super(pad, 128, 64);
	}

	@Override
	public boolean big()
	{
		return true;
	}

	public Scrollable scroller()
	{
		final Scrollable sc = new Scroll() {
			@Override
			public void scroll(int down, int right)
			{
				for (int y = 0; y < height(); y++) {
					for (int x = 0; x < width(); x++) {
						if (truncate(y, down, 0, height()))
							screen[y+down][x] = screen[y][x];
						if (truncate(x, right, 0, width()))
							screen[y][x+right] = screen[y][x];
					}
				}
			}
		};

		return sc;
	}

	private boolean truncate(int axis, int direction, int min, int max)
	{
		return (axis + direction >= min) && (axis + direction < max);
	}
}
