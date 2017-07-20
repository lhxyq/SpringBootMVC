package com.lh.web.RabbitMQConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {
    private String id;
    private String name;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "EventEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
