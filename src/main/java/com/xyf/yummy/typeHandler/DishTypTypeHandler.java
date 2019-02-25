package com.xyf.yummy.typeHandler;

import com.xyf.yummy.model.enums.DishTypeEnum;
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
@MappedTypes(DishTypeEnum.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DishTypTypeHandler implements TypeHandler<DishTypeEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, DishTypeEnum dishTypeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,dishTypeEnum.getStr());
    }

    @Override
    public DishTypeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        return DishTypeEnum.getTypByStr(str);
    }

    @Override
    public DishTypeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        return DishTypeEnum.getTypByStr(str);
    }

    @Override
    public DishTypeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        return DishTypeEnum.getTypByStr(str);
    }
}
