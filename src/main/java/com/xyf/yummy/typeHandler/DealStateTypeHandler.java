package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.DealStateEnum;
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
 * @Date: 2019/2/24
 * @Time: 14:56
 * @Package: com.xyf.yummy.typeHandler
 */
@MappedTypes(DealStateEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class DealStateTypeHandler implements TypeHandler<DealStateEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, DealStateEnum dealStateEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,dealStateEnum.getId());
    }

    @Override
    public DealStateEnum getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return DealStateEnum.getStateById(id);
    }

    @Override
    public DealStateEnum getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return DealStateEnum.getStateById(id);
    }

    @Override
    public DealStateEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return DealStateEnum.getStateById(id);
    }
}
