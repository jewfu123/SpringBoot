package com.example.orders.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.orders.pojo.Order;

@Mapper
public interface OrderMapper {

	@Insert("insert into orders (user_id,number) values (#{uid},#{oid})")
    public boolean create(String uid, String oid);

    @Select("select * from orders")
    public List<Order> read();
    
    @Select("select * from orders where id=#{id}")
    public Order findById(int id);

    @Update("update orders set user_id = #{uid} where id = #{id}")
    public boolean update(int id, String uid);

    @Delete("delete from orders where id = #{id}")
    public boolean delete(int id);

}
