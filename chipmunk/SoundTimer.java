package chipmunk;

import basicgraphics.sounds.ReusableClip;

public class SoundTimer implements SoundI, TimerI
{
	private int timer;

	public SoundTimer()
	{
		timer = 0;
	}
	
	@Override
	public void beep()
	{
		final ReusableClip beep = new ReusableClip("beep.wav");
		beep.play();
	}

	// unused, no instruction
	@Override
	public int get()
	{
		return 0;
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
