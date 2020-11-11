package WebApp.EasyLearn.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "speechstats")
@Entity
public class SpeechStatsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "points", nullable = false)
    private Integer points;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "userid", nullable = false)
    private Integer userid;

}
