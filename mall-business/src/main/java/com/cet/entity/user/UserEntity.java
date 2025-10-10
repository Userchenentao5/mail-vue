package com.cet.entity.user;

import com.cet.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 30952
 */

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class UserEntity extends BaseEntity {
    
	private static final long serialVersionUID = 1L;
  
  private String userName;

}
