import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Tugas implements Comparable<Tugas> {
    private String mataKuliah;
    private String namaTugas;
    private String deadline;

    public Tugas(String mataKuliah, String namaTugas, String deadline) {
        this.mataKuliah = mataKuliah;
        this.namaTugas = namaTugas;
        this.deadline = deadline;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public int compareTo(Tugas other) {
        return this.deadline.compareTo(other.deadline);
    }
}

public class ToDoList {
    private static LinkedList<Tugas> toDoList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Input Tugas\n2. Delete Tugas\n3. Lihat List Tugas\n4. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    inputTugas();
                    break;
                case 2:
                    deleteTugas();
                    break;
                case 3:
                    lihatListTugas();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void inputTugas() {
        System.out.println("Input Data Tugas");
        System.out.print("Mata Kuliah: ");
        String mataKuliah = scanner.nextLine();
        System.out.print("Tugas: ");
        String namaTugas = scanner.nextLine();
        System.out.print("Deadline: ");
        String deadline = scanner.nextLine();

        Tugas newTugas = new Tugas(mataKuliah, namaTugas, deadline);
        toDoList.addFirst(newTugas);
        System.out.println("Tugas berhasil ditambahkan!");
    }

    private static void deleteTugas() {
        if (toDoList.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }

        System.out.println("1. Hapus Tugas di Awal\n2. Hapus Tugas di Akhir\n3. Hapus berdasarkan Mata Kuliah\n4. Hapus berdasarkan Nama Tugas");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                toDoList.removeFirst();
                System.out.println("Tugas di awal list berhasil dihapus.");
                break;
            case 2:
                toDoList.removeLast();
                System.out.println("Tugas di akhir list berhasil dihapus.");
                break;
            case 3:
                deleteByMataKuliah();
                break;
            case 4:
                deleteByNamaTugas();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void deleteByMataKuliah() {
        System.out.print("Masukkan nama Mata Kuliah yang ingin dihapus: ");
        String mataKuliah = scanner.nextLine();
        boolean removed = toDoList.removeIf(tugas -> tugas.getMataKuliah().equals(mataKuliah));
        if (removed) {
            System.out.println("Tugas dengan Mata Kuliah '" + mataKuliah + "' berhasil dihapus.");
        } else {
            System.out.println("Tugas dengan Mata Kuliah '" + mataKuliah + "' tidak ditemukan.");
        }
    }

    private static void deleteByNamaTugas() {
        System.out.print("Masukkan nama Tugas yang ingin dihapus: ");
        String namaTugas = scanner.nextLine();
        boolean removed = toDoList.removeIf(tugas -> tugas.getNamaTugas().equals(namaTugas));
        if (removed) {
            System.out.println("Tugas dengan Nama '" + namaTugas + "' berhasil dihapus.");
        } else {
            System.out.println("Tugas dengan Nama '" + namaTugas + "' tidak ditemukan.");
        }
    }

    private static void lihatListTugas() {
        if (toDoList.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }

        System.out.println("1. Print Depan\n2. Print Belakang\n3. Print Terurut (berdasarkan deadline)");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                printDepan();
                break;
            case 2:
                printBelakang();
                break;
            case 3:
                printTerurut();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void printDepan() {
        ListIterator<Tugas> iterator = toDoList.listIterator();
        while (iterator.hasNext()) {
            Tugas tugas = iterator.next();
            System.out.println("Mata Kuliah = " + tugas.getMataKuliah() + ", Tugas = " + tugas.getNamaTugas() + ", Deadline = " + tugas.getDeadline());
        }
    }

    private static void printBelakang() {
        ListIterator<Tugas> iterator = toDoList.listIterator(toDoList.size());
        while (iterator.hasPrevious()) {
            Tugas tugas = iterator.previous();
            System.out.println("Mata Kuliah = " + tugas.getMataKuliah() + ", Tugas = " + tugas.getNamaTugas() + ", Deadline = " + tugas.getDeadline());
        }
    }

    private static void printTerurut() {
        LinkedList<Tugas> sortedList = new LinkedList<>(toDoList);
        Collections.sort(sortedList);
        for (Tugas tugas : sortedList) {
            System.out.println("Mata Kuliah = " + tugas.getMataKuliah() + ", Tugas = " + tugas.getNamaTugas() + ", Deadline = " + tugas.getDeadline());
        }
    }
}
