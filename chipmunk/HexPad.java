package chipmunk;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class HexPad implements InputI, KeyListener
{
    private boolean isDown;
    private char keycode;

    private KeymapI keys;

    public HexPad()
    {
        isDown = false;
        keycode = '\0';
        keys = new HexLayout();
    }

    @Override
    public boolean keyDown()
    {
        return isDown;
    }

    @Override
    public char key(boolean block)
    {
        while (block && !isDown);

        return keycode;
    }

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
        if (keys.contains(e.getKeyChar()))
            isDown = false;
    }  
    
    // unused
    @Override
    public void keyTyped(KeyEvent e) {}
}
