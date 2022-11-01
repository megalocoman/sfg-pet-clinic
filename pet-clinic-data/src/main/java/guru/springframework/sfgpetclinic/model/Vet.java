package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
public class Vet extends Person {
    private Set<Speciality> specialty = new HashSet<>();

    public Set<Speciality> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Set<Speciality> specialty) {
        this.specialty = specialty;
    }
}
