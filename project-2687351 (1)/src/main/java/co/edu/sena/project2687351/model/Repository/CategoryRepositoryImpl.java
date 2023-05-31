//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.Repository.Repository;
import co.edu.sena.project2687351.util.DBConnection;
import co.edu.sena.projectv2687350.model.Category;
import co.edu.sena.project2687351.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository {
    private String sql = null;

    public CategoryRepositoryImpl() {
    }

    public List<Category> listAllObj() throws SQLException {
        this.sql = "select c.category_id, c.category_name from categories_tbl c order by c.category_id, c.category_name ";
        List<Category> category = new ArrayList();
        Connection conn = DBConnection.getConnection();

        try {
            Statement stmt = conn.createStatement();

            try {
                ResultSet rs = stmt.executeQuery(this.sql);

                try {
                    while(rs.next()) {
                        Category c = this.createObj(rs);
                        category.add(c);
                    }
                } catch (Throwable var10) {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Throwable var11) {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (Throwable var12) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var7) {
                    var12.addSuppressed(var7);
                }
            }

            throw var12;
        }

        if (conn != null) {
            conn.close();
        }

        return category;
    }

    @Override
    public List listAllobj() throws SQLException {
        return null;
    }

    public Category byIdObj(Integer id) throws SQLException {
        this.sql = this.sql = "select c.category_id, c.category_name from categories_tbl c where c.category_id=? ";
        Category category = null;
        Connection conn = DBConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(this.sql);

            try {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                try {
                    if (rs.next()) {
                        category = this.createObj(rs);
                    }
                } catch (Throwable var11) {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Throwable var12) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var13) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var8) {
                    var13.addSuppressed(var8);
                }
            }

            throw var13;
        }

        if (conn != null) {
            conn.close();
        }

        return category;
    }

    @Override
    public Integer saveObj(Object o) throws SQLException {
        return null;
    }

    public Integer saveObj(Category category) throws SQLException {
        if (category.getCategory_id() != null && category.getCategory_id() > 0) {
            this.sql = "update categories set  category_name  where user_id =?";
        } else {
            this.sql = "insert into categories (category_name)";
        }

        Connection conn = DBConnection.getConnection();

        int rowsAffected;
        try {
            PreparedStatement ps = conn.prepareStatement(this.sql);

            try {
                ps.setString(1, category.getCategory_name());
                if (category.getCategory_id() != null && category.getCategory_id() > 0) {
                    ps.setInt(2, category.getCategory_id());
                }

                rowsAffected = ps.executeUpdate();
            } catch (Throwable var9) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var10) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (conn != null) {
            conn.close();
        }

        return rowsAffected;
    }

    public void deleteObj(Integer id) throws SQLException {
        this.sql = "delete from categories_tbl where category_id =?";
        Connection conn = DBConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(this.sql);

            try {
                ps.setInt(1, id);
                ps.execute();
            } catch (Throwable var8) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var9) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var6) {
                    var9.addSuppressed(var6);
                }
            }

            throw var9;
        }

        if (conn != null) {
            conn.close();
        }

    }

    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name(rs.getString("category_name"));
        return category;
    }
}
