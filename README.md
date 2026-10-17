Saya Maula Mirza Ananda dengan NIM 2407087 mengerjakan Tugas Praktikum 3 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. 

# Sistem Manajemen Person

Aplikasi desktop berbasis Java Swing untuk mengelola data individu yang tersimpan di dalam basis data MySQL. Aplikasi ini menyediakan fungsi CRUD (Create, Read, Update, Delete) lengkap dengan antarmuka bertab dan pembaruan tabel secara dinamis.

---
## Penjelasan fungsi di kelas : Database
* Database() : Konstruktor kelas, menginisialisasi Variable cn(konektor ke mysql database), dan variable st untuk untuk command ke mysql database
* selectQuery(string sql) : digunakan untuk memanggil dan memilih table di database
* Changes(string sql) : digunakan untuk melakukan command ke database(menambah , mengedit, atau menghapus)
---
## Penjelasan fungsi di kelas : UI
* setComboBox() : inisialisasi combo box untuk comboBox year & category di tabbedpanel "ADD" & "EDIT"
* findRowById(JTable model, Object targetId, int idColumnIndex, boolean tableVisRelated) : model digunakan untuk referensi table yang akan dicari, targetId digunakan untuk referensi id yang akan dicari di table, idColumnIndex digunakan untuk menentukan kolom yang akan digunakan(e.g. 0 = id, 1 = nama, ..., etc), tableVisRelated digunakan hanya saat pada search di edit.
* setVisibility(boolean vis) : digunakan untuk memunculkan atau menghilangkan textField, label, dan comboBox di tabbedPanel bagian "EDIT"
* clearForm() : fungsi hardcode untuk mengosongkan textField di tabbedPanel "ADD"
* setTable() : fungsi hardcode untuk mengambil isi di database "person", table "persontable". Fungsi ini juga digunakan untuk membuat table tidak bisa digerakkan
* main(String args[]) : fungsi main untuk setting mainPanel dan menjalankan program
* UI() : Konstruktor kelas, digunakan untuk inisialisasi ADD,EDIT,SEARCH, dan DELETE button. digunakan juga untuk menjalankan combo box dan table dengan setComboBox() dan setTable(). digunakan juga untuk listener di tabble di tabbedPanel "EDIT" & "DELETE" agar table bisa dipilih dengan klik untung mengisi field
---
## Fitur Utama

* **Tambah Data**: Menyimpan data baru berupa ID, Nama, Tahun, Email, dan Kategori. Sistem memvalidasi agar tidak ada bidang kosong atau ID ganda.

https://github.com/user-attachments/assets/7a70f0cf-bcb5-4c7d-b5db-38e053c6bc09

https://github.com/user-attachments/assets/68c5a306-79bf-47dc-9931-893be68d948b

* **Cari & Edit Data**: Mencari data berdasarkan ID atau memilih baris langsung dari tabel untuk mengisi formulir penyuntingan.
  




https://github.com/user-attachments/assets/740d7eb0-90d7-4a77-ba81-4d22166771e0

https://github.com/user-attachments/assets/fe206f30-9c12-45eb-8131-b5c2cb1cd0a0

https://github.com/user-attachments/assets/116adc1e-39b9-41ec-bf99-e03766140cba

https://github.com/user-attachments/assets/65fedb54-09fb-4a2c-8bdd-7be34cbcdc5b

* **Hapus Data**: Menghapus data berdasarkan ID atau baris yang dipilih pada tabel, dilengkapi dialog konfirmasi.


https://github.com/user-attachments/assets/c9ffb418-596e-45c8-90cb-3456c7037c57


https://github.com/user-attachments/assets/3f179ffc-ec7a-44b5-a47f-922291e942de

---
## Alur 
* Ketika program di jalankan Terdapat opsi 3 panel yaitu "ADD", "EDIT", & "DELETE"
* Ketika di panel ADD pengguna dapat mengisi data id, nama, tahun lahir(1900-2026), email, dan kategori(LULUS, TIDAK LULUS, DIKELUARKAN, MENGUNDURKAN DIRI). Pengguna **WAJIB** Mengisi textfield id, nama dan email. jika tidak data tidak akan bisa di input. ID tidak boleh duplikat, dan data tidak akan bisa di input apabila duplikat. ketika tombol "EDIT" sudah ditekan maka data akan diubah
* Ketika  di panel EDIT pengguna bisa memilih data yang akan di edit langsung dari tabel atau dengan mengetik ID yang dicari menggunakan search button. Apabila ID belum dipilih atau data dari tabel belum dipilih maka pengguna tidak akan bisa melihat textField dan combobox lainnya. Pengguna **WAJIB** Mengisi textfield id, nama dan email untuk mengedit data. ketika tombol "EDIT" sudah ditekan maka data akan diubah
* Ketika di panel EDIT terdapat tombol SEARCH yang dapat digunakan untuk mencari id. apabila id ditemukan maka form akan terisi dengan data yang ada sebagai default, apabila id tidak ditemukan maka akan ada message yang menunjukkan id tidak ditemukan/tidak ada
* Ketika di panel DELETE pengguna bisa memilih langsung data yang akan di hapus dari tabel, atau memasukkan id secara manual. apabila id yang dimasukkan tidak ada maka program akan mengeluarkan message. apabila id yang dimasukkan ada , maka pengguna akan diberi opsi apabila pengguna sudah yakin untuk menghapus atau belum. apabila pengguna mengetik ya maka data yang pengguna pilih akan hilang dari database


---



## Konfigurasi Basis Data

Program ini terhubung ke MySQL lokal menggunakan parameter berikut:

* **Host**: `localhost`

* **Database Name**: `person`

* **Username**: `root`

* **Password**: *(kosong)*


### Skema dan Data SQL (`person.sql`)


### struktur "persontable"

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
  Penjelasan fungsi


* `UI.java`: Memuat antarmuka pengguna (Swing GUI), manajemen event listener, validasi input, serta pembaruan tampilan tabel.


* `person.sql`: File dump SQL untuk inisialisasi basis data dan data sampel.



---

