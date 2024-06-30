import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Filter {
    private OS os;
    private CPUType cpu;
    private Set<Notebook> notebooks;
    private Set<Notebook> filtered;
    private Map<Integer, Float> filter;

    public Filter(Set<Notebook> notebooks){
        this.notebooks = new HashSet<>(notebooks);
        filtered = new HashSet<>(notebooks);
        filter = new HashMap<>();
        os = null;
        cpu = null;
    }

    public Map<Integer, Float> getFilter() {
        return filter;
    }

    /**
     * 1 - диагональ
     * 2 - частота
     * 3 - ОЗУ
     * 4 - ЖД
     * 5 - ОС
     * 6 - Проц
     */
    public void setFilter(float diag, float freq, float memory, float HDDVol, float osVal, float cpuVal) {
        filter.put(1, diag);
        filter.put(2, freq);
        filter.put(3, memory);
        filter.put(4, HDDVol);
        setConstCriters(cpuVal, osVal);
        filter.put(5, osVal);
        filter.put(6, cpuVal);

    }

    public float getFloatCriter(Notebook notebook, int num){
        switch (num){
            case 1:
                return notebook.getDiag();
            case 2:
                return notebook.getCpuFreq();
            case 3:
                return notebook.getMemory();
            case 4:
                return notebook.getHDDvol();
            default:
                return 0;
        }
    }

    public OS getOS(Notebook notebook, int num){
        if (num == 5){
            return notebook.getOs();
        }
        return null;
    }

    public CPUType getcpuType(Notebook notebook, int num){
        if (num == 6){
            return notebook.getCpuType();
        }
        return null;
    }


    public void filter(){
        for (Notebook item : notebooks){
            for (int key : filter.keySet()){
                if (getFloatCriter(item, key) < filter.get(key) && os != getOS(item, key) && cpu != getcpuType(item, key))
                    filtered.remove(item);
            }
        }
    }

    public void setConstCriters(float cpuVal, float osVal){
        switch ((int) osVal){
            case 1:
                os = OS.Windows;
                break;
            case 2:
                os = OS.Linux;
                break;
            case 3:
                os = OS.DOS;
                break;
            default:
                os = null;
        }

        switch ((int) cpuVal){
            case 1:
                cpu = CPUType.Intel;
                break;
            case 2:
                cpu = CPUType.AMD;
                break;
            default:
                cpu = null;
        }
    }

    public Set<Notebook> getFiltered(){
        if (filtered.isEmpty()){
            System.out.println("Ноутбуков с такими параметрами не найдено");
        }
        return filtered;
    }
}
