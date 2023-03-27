package TugasKelompokT;

import java.util.Scanner;

public class Menu{
	private int pilih, tanggal, bulan;
	private String uncle, niece, hadiah;
	
	
	Family family = new Family();
	
	Scanner in = new Scanner(System.in);
	
	public void tampilanMenuUtama() {
		System.out.println("\n1. Family");
		System.out.println("2. Present");
		System.out.println("0. Keluar");
		System.out.print("Pilih Opsi Menu : ");
		pilih = in.nextInt();
		this.pilihTampilkanMenuUtama(pilih);
	}
	
	public void pilihTampilkanMenuUtama(int pilih) {
		switch(pilih) {
		case 1: 
			tampilanMenuFamily();
			break;
		case 2:
			tampilanMenuPresent();
			break;
		case 0:
			break;
		default:
			System.out.println("\nOpsi Tersebut Tidak Ada");
			this.tampilanMenuUtama();
		}
	}
	
	public void tampilanMenuFamily() {
		System.out.println("\n1. Tambahkan Uncle");
		System.out.println("2. Tambahkan Niece");
		System.out.println("3. Cari Uncle");
		System.out.println("4. Cari Niece");
		System.out.println("5. Tampilkan Uncle");
		System.out.println("6. Tampilkan Niece");
		System.out.println("0. Kembali");
		pilih = in.nextInt();
		pilihMenuTampilkanMenuFamily(pilih);
	}
	
	public void pilihMenuTampilkanMenuFamily(int pilih) {	
		String lagi;
		switch(pilih) {
			case 1:
			do {
					System.out.println("\nMasukan nama uncle : ");
					uncle = in.next();
					family.addUncle(uncle);
					System.out.println("Tambah lagi? (y/n)");
					lagi = in.next();
			}while(lagi.equals("y"));
				break;
			case 2: 
			do {	
				System.out.println("\nMasukan nama niece : ");
				niece = in.next();
				System.out.print("Masukan tanggal lahir niece : ");
				tanggal = in.nextInt();
				System.out.print("Masukan bulan lahir niece : ");
				bulan = in.nextInt();
				family.addNiece(niece, tanggal, bulan);
				System.out.println("Tambah lagi? (y/n)");
				lagi = in.next();
			}while(lagi.equals("y"));
				break;
			case 3: 
			do {
				System.out.print("\nMasukan nama uncle : ");
				uncle = in.next();
				if (family.findUncle(uncle) == null) {
                    System.out.println("Tidak ada Uncle bernama " + uncle);
                }else {
                	System.out.println("Uncle bernama " + uncle + " ada");
                }
					System.out.println("Cari lagi? (y/n)");
					lagi = in.next();
				}while(lagi.equals("y"));
				break;
			case 4:
			do {
				System.out.print("\nMasukan nama niece : ");
				niece = in.next();
				if (family.findNiece(niece) == null) {
                    System.out.println("Tidak ada Niece bernama " + niece);
                }else {
                	System.out.println("Niece bernama " + niece + " ada");
                }
					System.out.println("Cari lagi? (y/n)");
					lagi = in.next();
				}while(lagi.equals("y"));
				break;
			case 5: 
				family.listUncles();
				break;
			case 6: 
				family.listNieces();
				break;
			case 0: 
				tampilanMenuUtama();
				break;
			default: 
				System.out.println("\nOpsi Tersebut Tidak Ada");
				tampilanMenuFamily();
		}
		tampilanMenuUtama();
	}
	
	public void tampilanMenuPresent() {
		System.out.println("\n1. Beri Hadiah");
		System.out.println("2. Hapus Hadiah");
		System.out.println("3. Tampilkan Pemberi Hadiah");
		System.out.println("4. Tampilkan Penerima Hadiah");
		System.out.println("0. Kembali");
		pilih = in.nextInt();
		pilihTampilanMenuPresent(pilih);
	};
	
	public void pilihTampilanMenuPresent(int pilih) {
		switch(pilih) {
			case 1: 
				System.out.print("\nMasukan nama uncle : ");
				uncle = in.next();
				if (family.findUncle(uncle) == null) {
                    System.out.println("Tidak ada Uncle bernama " + uncle);
                    this.pilihTampilanMenuPresent(pilih);
                }else {
                	System.out.print("Masukan nama Niece : ");
    				niece = in.next();
    				if (family.findNiece(niece) == null) {
                        System.out.println("Tidak ada Niece bernama " + niece);
                        this.pilihTampilanMenuPresent(pilih);
                    }else {
                    	System.out.print("Masukan nama hadiah : ");
        				hadiah = in.next();
        				family.findUncle(uncle).addPresent(family.findNiece(niece), hadiah, family.getNieces());
                    }
                }
				break;
			case 2: 
				System.out.print("\nMasukan nama niece : ");
				niece = in.next();
				System.out.println(family.findNiece(niece).clearPresents() + " hadiah telah di hapus");
				break;
			case 3:
				System.out.print("\nMasukan nama Niece : ");
				niece = in.next();
				family.findNiece(niece).listPresents(family.getUncles());
				break;
			case 4:
				System.out.print("\nMasukan nama Uncle : ");
				uncle = in.next();
				family.findUncle(uncle).listPresents(family.getNieces());
				break;
			case 0: 
				tampilanMenuUtama();
				break;
			default:
				System.out.println("\nOpsi Tersebut Tidak Ada");
				tampilanMenuPresent();
		}
		tampilanMenuUtama();
	}
}
