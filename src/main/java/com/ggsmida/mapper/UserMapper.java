package com.ggsmida.mapper;

import com.ggsmida.beans.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by junwuguo on 2017/1/9 0009.
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findUserById(@Param("id") Integer id) throws Exception;

    @Select("SELECT * FROM USER WHERE EMAIL = #{email} AND PASSWORD = #{password}")
    User findUserByEmailPwd(@Param("email") String email, @Param("password") String password) throws Exception;

    @Insert("INSERT INTO USER" +
            " (email, nick_name, password, birth_date, create_time, modify_time) values (" +
            " #{email}, #{nick_name}, #{password}, #{birth_date}, #{create_time}, #{modify_time})")
    int insertUser( @Param("email") String email,
                    @Param("nick_name") String nick_name,
                    @Param("password") String password,
                    @Param("birth_date") Date birth_date,
                    @Param("create_time") Date create_time,
                    @Param("modify_time") Date modify_time);
}
