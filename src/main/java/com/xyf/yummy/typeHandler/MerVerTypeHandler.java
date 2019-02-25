package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.MerchantVerEnum;
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
 * @Time: 14:57
 * @Package: com.xyf.yummy.typeHandler
 */
@MappedTypes(MerchantVerEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MerVerTypeHandler implements TypeHandler<MerchantVerEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, MerchantVerEnum merchantVerEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,merchantVerEnum.getId());
    }

    @Override
    public MerchantVerEnum getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return MerchantVerEnum.getVerById(id);
    }

    @Override
    public MerchantVerEnum getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return MerchantVerEnum.getVerById(id);
    }

    @Override
    public MerchantVerEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return MerchantVerEnum.getVerById(id);
    }
}
