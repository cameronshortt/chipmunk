package chipmunk;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class HexPad implements InputI
{
    private boolean isDown;
    private char keycode;

    private KeymapI keys;

	private final char badKey = 255;
	
    public HexPad()
    {
        isDown = false;
        keycode = badKey;
        keys = new HexLayout();
    }

    @Override
    public boolean keyDown()
    {
        return isDown;
    }

    @Override
    public char key()
    {
        return keycode;
    }

	@Override
	public KeyListener listener()
	{
		return events;
	}

	private final KeyListener events = new KeyAdapter()
	{
        @Override
        public void keyPressed(KeyEvent e)
        {
            if (keys.contains(e.getKeyChar())) {
				keycode = keys.get();
                isDown = true;
			}
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            if (keys.contains(e.getKeyChar())) {
				keycode = badKey;
			    isDown = false;
			}
        }
	};
}
