package com.lyp.consumer.pojo;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>@filename User</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 10:49
 **/

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    //id
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别 1 男 2女
    private Integer sex;
    //出生日期
    private Date birthday;
    //创建时间
    private Date created;
    //更新时间
    private Date updated;
    //备注
    private String note;

}
