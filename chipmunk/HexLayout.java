package chipmunk;

public class HexLayout implements KeymapI
{
    private final char pad[]; 
    private final char hex[];
    private int i;

    public HexLayout()
    {
        pad = new char[] {
            '1', '2', '3', '4',
            'q', 'w', 'e', 'r',
            'a', 's', 'd', 'f',
            'z', 'x', 'c', 'v'
        };
        hex = new char[] {
            0x1, 0x2, 0x3, 0xc,
            0x4, 0x5, 0x6, 0xd,
            0x7, 0x8, 0x9, 0xe,
            0xa, 0x0, 0xb, 0xf
        };
    }

    public boolean contains(char c)
    {
        for (i = 0; c != pad[i]; i++);

        return i != pad.length;
    }

    public char get()
    {
        return hex[i];
    }
}
