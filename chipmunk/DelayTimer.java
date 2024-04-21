package chipmunk;

public class DelayTimer implements TimerI
{
	private int timer;

	public DelayTimer()
	{
		timer = 0;
	}
	
	@Override
	public int get()
	{
		return timer;
	}

	@Override
	public void set(int i)
	{
		timer = i & 0xFF;
	}

	@Override
	public void run()
	{
		if (timer > 0)
			timer--;
	}
}
