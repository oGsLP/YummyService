package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.MemValEnum;
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
 * @Time: 18:11
 * @Package: com.xyf.yummy.typeHandler
 */
@MappedTypes(MemValEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MemValTypeHandler implements TypeHandler<MemValEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, MemValEnum memValEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, memValEnum.getId());
    }

    @Override
    public MemValEnum getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return MemValEnum.getValById(id);
    }

    @Override
    public MemValEnum getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return MemValEnum.getValById(id);
    }

    @Override
    public MemValEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return MemValEnum.getValById(id);
    }
}
