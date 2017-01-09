package com.ggsmida.mapper;

import com.ggsmida.beans.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by junwuguo on 2017/1/9 0009.
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findUserById(@Param("id") Integer id) throws Exception;
}
