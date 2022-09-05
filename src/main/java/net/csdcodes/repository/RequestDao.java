package net.csdcodes.repository;

import net.csdcodes.model.Request;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author jmatos
 * @since 2022-4-09
 */
@Mapper
public interface RequestDao {

        @Insert("INSERT INTO request(title, description, assigned) " +
                        " VALUES (#{title}, #{description}, #{assigned})")
        @SelectKey(statement = "SELECT LAST_INSERT_ID();", keyProperty = "id", before = false, resultType = int.class)
        int insert(Request request);

        @Results({ @Result(property = "id", column = "id_request") })
        @Select("SELECT * FROM request")
        List<Request> findAll();

        @Select("SELECT * FROM request WHERE id_request = #{id}")
        Request findById(@Param("id") int id);

        @Update("Update request set title=#{title}, " +
                        " description=#{description}, assigned=#{assigned} where id_request=#{id}")
        int update(Request request);

        @Delete("DELETE FROM request WHERE id_request = #{id}")
        int deleteById(@Param("id") int id);

}
