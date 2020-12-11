package WebApp.EasyLearn.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "userdetail")
@Entity
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "pkt", nullable = false)
    private int pkt;


    @Column(name = "testamount", nullable = false)
    private int testamount;

    @Column(name = "userid", nullable = false)
    private int userid;

    @Column(name = "textdone", nullable = false)
    private int textdone;


}