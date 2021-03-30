package xyz.erupt.jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import xyz.erupt.annotation.EruptField;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author liyuepeng
 * @date 2018-10-11.
 */
@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "native")
    @Column(name = "id")
    @EruptField
    private Long id;
}
