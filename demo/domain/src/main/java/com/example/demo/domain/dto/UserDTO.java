package com.example.demo.domain.dto;

import com.alibaba.cola.dto.DTO;
import lombok.*;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends DTO {
    private Long id;
    private String username;
}
