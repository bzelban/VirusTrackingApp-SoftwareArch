//Client
class Computer
{
    CPU cpu = new CPU();
    Memory mem = new Memory();
    HDD hdd = new HDD();

    ComputerFacade af = new ComputerFacade(cpu, mem, hdd);



}


//Facade, All composition // IT'S COMPOSITE PATTERN A-LIKE
class ComputerFacade
{
    private CPU processor;
    private Memory ram;
    private HDD hdd;

    public ComputerFacade(CPU processor, Memory ram, HDD hdd) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
    }

    public void start()
    {
        processor.freeze();
        ram.load(155, hdd.read(1970, 80));
        processor.jump(155);
        processor.execute();
    }
}
//Subsystem

class CPU
{
    public void freeze()
    {
        System.out.println("Computer Freezing...");
    }
    public void jump(long position)
    {
        System.out.println("Jumping to..." + position);
    }
    public void execute()
    {
        System.out.println("Computer executing commands...");
    }

}

class HDD
{
    public byte[] read(long iba, int size)
    {
        return new byte[]{'f', 'z'};
    }
}

class Memory
{
    public void load(long position, byte[] data)
    {
        System.out.println("Added item to memory..." + position );
    }
}


public class facadeTest {

    public static void main(String[] args) {

        Computer comp = new Computer();

    }
}
