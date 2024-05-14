package Repository;

import Model.Category;
import com.example.proyectocorte2.Dto.CategoryDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryJdbcImpl implements Repository<CategoryDto>{
    private Connection conn;

    public CategoryRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<CategoryDto> listar() throws SQLException {
        List<CategoryDto> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categoria")) {
            while (rs.next()) {
                Category categoria = getCategory(rs);
                CategoryDto categoriaDto = CategoryMapper.mapFrom(categoria);
                categorias.add(categoriaDto);
            }
        }
        return categorias;
    }
}
