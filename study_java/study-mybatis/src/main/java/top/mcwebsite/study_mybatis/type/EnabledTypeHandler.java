package top.mcwebsite.study_mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mengchen
 * @time 18-12-30 下午2:06
 */
@MappedJdbcTypes(includeNullJdbcType = false, value = {JdbcType.INTEGER})
@MappedTypes(value = {Enabled.class})
public class EnabledTypeHandler implements TypeHandler<Enabled> {

    private final Enabled[] enums;

    public EnabledTypeHandler() {
        enums = new Enabled[2];
        enums[0] = Enabled.disabled;
        enums[1] = Enabled.enabled;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    @Override
    public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        }
        if (i !=0 && i != 1) {
            throw new IllegalArgumentException("Enum Enabled range of 0 and 1");
        }
        return enums[i];
    }

    @Override
    public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        }
        if (i !=0 && i != 1) {
            throw new IllegalArgumentException("Enum Enabled range of 0 and 1");
        }
        return enums[i];
    }

    @Override
    public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        }
        if (i !=0 && i != 1) {
            throw new IllegalArgumentException("Enum Enabled range of 0 and 1");
        }
        return enums[i];
    }
}
