Saya Maula Mirza Ananda dengan NIM 2407087 mengerjakan Tugas Praktikum 3 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. 

# Sistem Manajemen Person

Aplikasi desktop berbasis Java Swing untuk mengelola data individu yang tersimpan di dalam basis data MySQL. Aplikasi ini menyediakan fungsi CRUD (Create, Read, Update, Delete) lengkap dengan antarmuka bertab dan pembaruan tabel secara dinamis.

---

## Fitur Utama

* **Tambah Data**: Menyimpan data baru berupa ID, Nama, Tahun, Email, dan Kategori. Sistem memvalidasi agar tidak ada bidang kosong atau ID ganda.


* **Cari & Edit Data**: Mencari data berdasarkan ID atau memilih baris langsung dari tabel untuk mengisi formulir penyuntingan.


* **Hapus Data**: Menghapus data berdasarkan ID atau baris yang dipilih pada tabel, dilengkapi dialog konfirmasi.


* **Pilihan Terstruktur**: Pilihan status kategori mencakup "LULUS", "TIDAK LULUS", "MENGUNDURKAN DIRI", dan "DIKELUARKAN" serta rentang tahun dari 1900 hingga 2026.



---

## Prasyarat System

* **Java Development Kit (JDK)**: Versi 8 atau lebih baru
* **MySQL Database Server**: E.g., via XAMPP, WampServer, atau MySQL Standalone
* **MySQL Connector/J**: Driver JDBC `.jar` yang ditambahkan ke classpath proyek

---

## Konfigurasi Basis Data

Aplikasi ini terhubung ke MySQL lokal menggunakan parameter berikut:

* **Host**: `localhost`

* **Database Name**: `person`

* **Username**: `root`

* **Password**: *(kosong)*


### Skema dan Data SQL (`person.sql`)

Gunakan skrip SQL berikut untuk membuat struktur basis data dan mengisinya dengan data awal:

```sql
CREATE DATABASE IF NOT EXISTS person;
USE person;

CREATE TABLE `persontable` (
  `id` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `year` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `category` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `persontable` (`id`, `name`, `year`, `email`, `category`) VALUES
('M001', 'John Stewart', 2026, 'Granny@gmail.com', 'LULUS'),
('M003', 'Hal Jordan', 1983, 'HalJord@gmail.com', 'DIKELUARKAN'),
('M002', 'MOGO', 1900, 'mogoandi@gmail.com', 'LULUS'),
('M004', 'Meursault', 1933, 'absurd@gmail.com', 'LULUS'),
('M005', 'King gondo', 1940, 'kg@gmail.com', 'MENGUNDURKAN DIRI'),
('M006', 'JIA BAOYU', 2026, 'HL@gmail.com', 'MENGUNDURKAN DIRI'),
('M007', 'Heathcliff', 1900, 'LintonsucksSSSSS@gmail.com', 'TIDAK LULUS');
COMMIT;

```

---

## Struktur Proyek

* `Database.java`: Mengelola koneksi JDBC dan eksekusi perintah SQL (`SELECT`, `INSERT`, `UPDATE`, `DELETE`).


* `UI.java`: Memuat antarmuka pengguna (Swing GUI), manajemen event listener, validasi input, serta pembaruan tampilan tabel.


* `person.sql`: File dump SQL untuk inisialisasi basis data dan data sampel.



---

## Cara Menjalankan Aplikasi

1. Jalankan layanan MySQL di komputer Anda (misalnya melalui XAMPP Control Panel).
2. Impor file `person.sql` atau eksekusi skrip SQL di atas melalui phpMyAdmin / MySQL CLI.


3. Kompilasi berkas Java dengan mengikutkan driver JDBC:


```bash
javac -cp .:mysql-connector-java.jar Database.java UI.java

```


4. Jalankan aplikasi:


```bash
java -cp .:mysql-connector-java.jar UI

```


*(Catatan: Pada sistem operasi Windows, gunakan tanda titik koma `;` sebagai pemisah classpath menggantikan titik dua `:`)*.
