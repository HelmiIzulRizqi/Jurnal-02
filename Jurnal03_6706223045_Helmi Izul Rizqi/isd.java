import java.util.Scanner;

// Kelas untuk merepresentasikan data buku
class Buku {
    String judul;
    String penulis;
    int tahunTerbit;

    // Konstruktor untuk membuat objek buku baru
    Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Metode untuk menampilkan informasi buku
    public void displayInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println();
    }
}

// Kelas Node untuk merepresentasikan node dalam linked list
class Node {
    Buku data;
    Node next;

    // Konstruktor untuk membuat objek Node baru
    Node(Buku data) {
        this.data = data;
        this.next = null;
    }
}

// Kelas LinkedList untuk mengelola operasi-operasi linked list
class LinkedList {
    Node head;

    // Konstruktor untuk membuat objek LinkedList baru
    LinkedList() {
        this.head = null;
    }

    // Metode untuk menambahkan data buku ke awal linked list
    public void addNodeAtBeginning(Buku data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Metode untuk menambahkan data buku ke akhir linked list
    public void addNodeAtEnd(Buku data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Metode untuk menghapus data buku dari awal linked list
    public void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        head = head.next;
    }

    // Metode untuk menghapus data buku dari akhir linked list
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Metode untuk mencetak semua data buku dalam linked list
    public void printList() {
        if (head == null) {
            System.out.println("Linked list kosong.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            temp.data.displayInfo();
            temp = temp.next;
        }
    }
}

// Kelas utama untuk menjalankan program
public class isd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Input Data Buku di Awal List");
            System.out.println("2. Input Data Buku di Akhir List");
            System.out.println("3. Hapus Data Buku dari Awal List");
            System.out.println("4. Hapus Data Buku dari Akhir List");
            System.out.println("5. Cetak Seluruh Data Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih operasi yang ingin dilakukan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    scanner.nextLine(); // Membersihkan buffer
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int tahunTerbit = scanner.nextInt();
                    Buku bukuAwal = new Buku(judul, penulis, tahunTerbit);
                    linkedList.addNodeAtBeginning(bukuAwal);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku: ");
                    scanner.nextLine(); // Membersihkan buffer
                    judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    penulis = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    tahunTerbit = scanner.nextInt();
                    Buku bukuAkhir = new Buku(judul, penulis, tahunTerbit);
                    linkedList.addNodeAtEnd(bukuAkhir);
                    break;
                case 3:
                    linkedList.deleteNodeAtBeginning();
                    break;
                case 4:
                    linkedList.deleteNodeAtEnd();
                    break;
                case 5:
                    System.out.println("Daftar Buku:");
                    linkedList.printList();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}