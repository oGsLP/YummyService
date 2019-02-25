package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.MerchantTypeEnum;
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
@MappedTypes(MerchantTypeEnum.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MerTypTypeHandler implements TypeHandler<MerchantTypeEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, MerchantTypeEnum merchantTypeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,merchantTypeEnum.getStr());
    }

    @Override
    public MerchantTypeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        return MerchantTypeEnum.getTypByStr(str);
    }

    @Override
    public MerchantTypeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        return MerchantTypeEnum.getTypByStr(str);
    }

    @Override
    public MerchantTypeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        return MerchantTypeEnum.getTypByStr(str);
    }
}
