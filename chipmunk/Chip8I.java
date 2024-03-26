package chipmunk;

public interface Chip8I
{
    public void run();
    public void execute(Word instruction);

    public void jump(Word address);
    public void cmp(Word args);
    public void set(Word args);
    public void add(Word args);
    public void math(Word regs);
    public void point(Word address);
    public void rand(Word args);
    public void draw(Word args);
    public void keypress(Word type);
    public void io(Word type);
}
