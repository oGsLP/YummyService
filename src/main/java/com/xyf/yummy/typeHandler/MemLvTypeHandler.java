package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.MemLvEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 17:06
 * @Package: com.xyf.yummy.typeHandler
 */
@MappedTypes(MemLvEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MemLvTypeHandler implements TypeHandler<MemLvEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, MemLvEnum memLvEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,memLvEnum.getId());
    }

    @Override
    public MemLvEnum getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return MemLvEnum.getLvById(id);
    }

    @Override
    public MemLvEnum getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return MemLvEnum.getLvById(id);
    }

    @Override
    public MemLvEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return MemLvEnum.getLvById(id);
    }
}
