package top.lemenk.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/13 10:23
 * @Description :
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private String name;
    private Double value;
}
