package com.example.users.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.users.pojo.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user (name) values (#{name})")
    public boolean create(String name);

    @Select("select * from user")
    public List<User> read();
    
    @Select("select * from user where id= #{id}")
    public User check(int id);
    
    @Update("update user set name = #{name} where id = #{id}")
    public boolean update(int id, String name);

    @Delete("delete from user where id = #{id}")
    public boolean delete(int id);

}
