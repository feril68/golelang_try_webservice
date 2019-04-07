package com.kelompok5.golelang.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nama barang is required")
    @Column(nullable = false, unique = true)
    private String namaBarang;

    public Barang(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
}
