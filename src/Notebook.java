import java.util.Objects;

public class Notebook {
    private final CPUType cpuType;
    private float cpuFreq;
    private int memory;
    private int HDDvol;
    private final float diag;
    private final String name;
    private OS os;

    public Notebook(String name, float diag, OS os, CPUType cpuType, float cpuFreq, int memory, int HDDvol) {
        this.name = name;
        this.diag = diag;
        this.os = os;
        this.cpuType = cpuType;
        this.cpuFreq = cpuFreq;
        this.memory = memory;
        this.HDDvol = HDDvol;
    }

    public String getName() {
        return name;
    }

    public float getCpuFreq() {
        return cpuFreq;
    }

    public float getDiag() {
        return diag;
    }

    public int getMemory() {
        return memory;
    }

    public int getHDDvol() {
        return HDDvol;
    }

    public OS getOs() {
        return os;
    }

    public CPUType getCpuType() {
        return cpuType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return cpuFreq == notebook.cpuFreq && memory == notebook.memory && HDDvol == notebook.HDDvol && Float.compare(diag, notebook.diag) == 0 && cpuType == notebook.cpuType && Objects.equals(name, notebook.name) && os == notebook.os;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpuType, cpuFreq, memory, HDDvol, diag, name, os);
    }

    @Override
    public String toString() {
        return name + " " + diag + "\"\nCPU: " + cpuType + " " + cpuFreq + "Hz\n" + memory + "Gb RAM\nOS " + os + "\n" + HDDvol + " Gb\n";
    }
}
