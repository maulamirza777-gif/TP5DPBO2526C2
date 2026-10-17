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


Berikut adalah tabel Markdown (format tabel GitHub) yang merepresentasikan struktur dari skrip SQL tersebut:

### `persontable` Structure

| Nama Kolom (Field) | Tipe Data | Boleh Kosong (Null) | Keterangan |
| --- | --- | --- | --- |
| `id` | `VARCHAR(6)` | NO | ID Unik Person |
| `name` | `VARCHAR(50)` | NO | Nama Lengkap |
| `year` | `INT(11)` | NO | Tahun |
| `email` | `VARCHAR(50)` | NO | Alamat Email |
| `category` | `VARCHAR(20)` | NO | Kategori Status |


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
