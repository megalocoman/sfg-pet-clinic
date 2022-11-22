package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialty = new HashSet<>();

    public Set<Speciality> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Set<Speciality> specialty) {
        this.specialty = specialty;
    }
}
