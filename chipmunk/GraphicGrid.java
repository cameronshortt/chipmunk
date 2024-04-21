package chipmunk;

import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

public class GraphicGrid extends TextGrid
{
	final SpriteComponent bg;
	
    public GraphicGrid(InputI pad)
    {
		super();
		
		final BasicFrame frame = new BasicFrame("Chipmunk");
		final Container content = frame.getContentPane();
		final BasicContainer box = new BasicContainer();

		final String[][] layout = {{
			"Screen"
		}};
		
		content.setLayout(new CardLayout());
		content.add(box, "Emulator");

		bg = new SpriteComponent()
		{
			@Override
			public void paintBackground(Graphics g)
			{
				Dimension dim = getSize();

				int w = dim.width/width();
				int h = dim.height/height();

				g.setColor(Color.BLACK);
				g.fillRect(0, 0, dim.width, dim.height);

				g.setColor(Color.WHITE);
				for (int y = 0; y < height(); y++)
					for (int x = 0; x < width(); x++)
						if (on(x, y))
						    g.fillRect(x*w, y*h, w, h);
			}
		};

		bg.setPreferredSize(new Dimension(640, 480));

		box.setStringLayout(layout);
		box.add("Screen", bg);

	    frame.show();

		box.requestFocus();
		box.addKeyListener(pad.listener());
    }

    @Override
    public void output()
    {
		bg.repaint();
    }
}
