package chipmunk;

public class Word
{
    private int address;

    public Word(int m, int n)
    {
        address = m * 0x100 + n;
    }

    public int get()
    {
        return address;
    }

    public int get(int start, int end)
    {
        final int[] mask = new int[] {
            0x000F, 0x00F0, 0x0F00, 0xF000
        };
        final int[] pull = new int[] {
            0, 4, 8, 12
        };
        int access = 0;
        int shift = 0;

        for (int i = start; i < end; i++)
            access += mask[i];
        shift = pull[start];

        //System.out.printf("%x %x %x\n", address, access, (address & access) >> shift);
        return (address & access) >> shift;
    }

    public int get(int index)
    {
        return get(index, index+1);
    }

    /*
     *        0 0 E 0
     * index: 3 2 1 0
     */

    // get nibble 2
    public int x()
    {
        return get(2);
    }

    // get nibble 1
    public int y()
    {
        return get(1);
    }

    // get nibble 0
    public int n()
    {
        return get(0);
    }

    // get nibbles 0-1
    public int nn()
    {
        return get(0, 2);
    }

    // get nibbles 0-2
    public int nnn()
    {
        return get(0, 3);
    }

    // get nibble 3
    public int op()
    {
        return get(3);
    }

    public boolean getBit(int bit)
    {
        return getBit(address, bit);
    }

    public static boolean getBit(int num, int bit)
    {
        return ((num & (1 << bit)) >> bit) == 1;
    }

    public static boolean[][] bitEncode(int[] arr)
    {
        boolean[][] ret = new boolean[arr.length][8];

        for (int i = 0; i < arr.length; i++)
            for (int bit = 0; bit < 8; bit++)
                ret[i][bit] = getBit(arr[i], 7-bit);

        return ret;
    }

	public static boolean[][] bitEncode16(int[] arr)
	{
		boolean[][] ret = new boolean[16][16];

		for (int i = 0; i < arr.length && i < 16; i++)
			for (int bit = 0; bit < 16; bit++)
				ret[i][bit] = getBit(arr[i], 15-bit);

		return ret;
	}
}
