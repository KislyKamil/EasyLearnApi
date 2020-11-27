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

    @Column(name = "engvalue", nullable = false)
    private String engword;

    @Column(name = "plvalue", nullable = false)
    private String plword;

    @Column(name = "groupid", nullable = false)
    private int groupID;

    public WordModel(int id, String engword, String plword, int groupID) {
        this.id = id;
        this.engword = engword;
        this.plword = plword;
        this.groupID = groupID;
    }
}
