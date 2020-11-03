package WebApp.EasyLearn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Table(name = "examstats")
@Entity
public class ExamStats implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "words", nullable = true)
    private String words;

//    @OneToOne
//    @JoinColumn(name = "userid", referencedColumnName = "id")
    @Column(name = "userid")
    private Integer userid;


}