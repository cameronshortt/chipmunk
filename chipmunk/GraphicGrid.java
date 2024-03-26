package chipmunk;

import basicgraphics.BasicFrame;

import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GraphicGrid extends TextGrid
{
    private final Dimension dim;
    private final Graphics g;

    public GraphicGrid()
    {
        dim = new Dimension(640, 480);

        Image tmp = BasicFrame.createImage(dim.width, dim.height);
        g = tmp.getGraphics();
    }

    @Override
    public void output()
    {
        int w = dim.width/width();
        int h = dim.height/height();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);

        g.setColor(Color.WHITE);
        for (int y = 0; y < dim.height; y += h)
            for (int x = 0; x < dim.width; x += w)
                g.fillRect(x, y, w, h);
    }
}
