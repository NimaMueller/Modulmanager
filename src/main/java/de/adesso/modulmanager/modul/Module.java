package de.adesso.modulmanager.modul;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "modules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Module {



    @Id
    @Column(name = "module_id")
    private int moduleId;

    @Column(name = "description")
    private String description;

    @Column(name = "c_p")
    private int cP;

/*     public String checkIfRequiredCreditpointsReached(Integer moduleId) {

        int totalCreditPoints=0;

     for (int cP :moduleIds)

        if (totalCreditPoints >= 150) {

            System.out.println("Student is able to write his Bachelor Thesis");
        }

    }  */
    

 /*    @Column (name= "course_id")
    private int courseId; */


  /*   enum Wirtschaftsinformatik {

        Algebra,
        ObjektorientiertesProgrammieren,
        Betriebswirtschaftslehre,
        GrundlagenWirtschaftsInformatik,

    } */
  
/* 
    @OneToMany(mappedBy = "module")
    Set<SignUpFoModule> signUp; */

}
