package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "kilograms")
    private int kilograms;

    public Fruit(String name, int kilograms) {

        this.name = name;
        this.kilograms = kilograms;
    }

    public Fruit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

}
