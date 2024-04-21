package chipmunk;

import java.awt.event.KeyListener;

public interface InputI
{
    public boolean keyDown();
    public char key();

	public KeyListener listener();
}
