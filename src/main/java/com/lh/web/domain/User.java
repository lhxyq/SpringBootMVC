package com.lh.web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by LH 2446059046@qq.com on 2017/7/16.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    @Id
    private String id;
    private String name;
    private String password;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
}
