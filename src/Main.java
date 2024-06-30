import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notebook note1 = new Notebook("Asus 2347823", 15.6f, OS.Windows, CPUType.Intel, 4.7f, 16, 500);
        Notebook note2 = new Notebook("Acer 232432", 14.5f, OS.Linux, CPUType.AMD, 3.6f, 8, 750);
        Notebook note3 = new Notebook("Thunderrobot DX", 15.6f, OS.Windows, CPUType.Intel, 4.9f, 32, 1024);
        Notebook note4 = new Notebook("UltaBook 2000", 16.0f, OS.DOS, CPUType.AMD, 5.0f, 64, 2048);

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(note1, note2, note3, note4));

        /**
         * 1 - диагональ
         * 2 - частота
         * 3 - ОЗУ
         * 4 - ЖД
         * 5 - ОС
         * 6 - Проц
         */
        float diag = 0;
        float freq = 0;
        float mem = 0;
        float hdd = 0;
        float os = 0;
        float cpu = 0;
        boolean flag = true;
        while (flag) {
            try {


                System.out.println("Введите минимальную диагональ");
                diag = Float.parseFloat(scanner.nextLine());
                System.out.println("Введите минимальную частоту процессора");
                freq = Float.parseFloat(scanner.nextLine());
                System.out.println("Введите мимниальный объём ОЗУ");
                mem = Float.parseFloat(scanner.nextLine());
                System.out.println("Введите минимальный объём HDD");
                hdd = Float.parseFloat(scanner.nextLine());
                System.out.println("Выберите ОС\n1 - Windows\n2 - Linux\n3 - DOS");
                os = Float.parseFloat(scanner.nextLine());
                System.out.println("Выберите процессор\n1 - Intel\n2 - AMD");
                cpu = Float.parseFloat(scanner.nextLine());
                flag = false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                flag = true;
            } finally {

            }
        }


        Filter f = new Filter(notebooks);
        f.setFilter(diag, freq, mem, hdd, os, cpu);
        f.filter();
        for (Notebook notebook : f.getFiltered()){
            System.out.println(notebook + System.lineSeparator());
        }


    }
}