package dao;

import bean.Usuario;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDao {
    Connection conn;
    PreparedStatement stmt;
    
    public LoginDao () {
        conn = ConnectionFactory.getConnection();
    }
    public Usuario loginValido(Usuario user) {
        String sql = "select * from usuarios where usuario = ? and senha = ?";
        ResultSet rs;
        int n;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            rs.last();
            n = rs.getRow();
            if (n == 1) {
                user.setLogado(true);
                user.setAdmin(rs.getBoolean("admin"));
            }
            else
                user.setLogado(false);
            
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
