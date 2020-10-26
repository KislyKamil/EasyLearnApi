package WebApp.EasyLearn.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "exammodel")
@Entity
public class WordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, nullable = false)
    private int id;

    @Column(name = "engword", nullable = false)
    private String engword;

    @Column(name = "plword", nullable = false)
    private String plword;

    @Column(name = "groupid", nullable = false)
    private int groupID;
}
