package dao;
import factory.ConnectionFactory;
import bean.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContatoDao {
    Connection conn;
    PreparedStatement stmt;
    public ContatoDao() {
        conn = ConnectionFactory.getConnection();        
    }
        
    public ResultSet filtrar(String texto) {
        String sql = "select * from contatos where "
                + "concat (nome, ' ', email) like ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%"+texto+"%");
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException (ex);
        }        
    }
    
    public ResultSet listar() {        
        String sql = "select * from contatos";        
        try {
            stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException ex) {            
            return null;
        }        
    }
            
    
    
    public void salvar(Contato contato) {
        String sql = "insert into contatos (nome, telefone, email) "
                + "values (?,?,?)";
        try {
            Connection conn = ConnectionFactory.getConnection();        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Contato contato) {
        String sql = "delete from contatos where id_contato = ?";
        try {            
            stmt = conn.prepareStatement(sql); 
            stmt.setInt(1, contato.getId());
            stmt.execute();   
        } catch (SQLException ex) {                    
            ex.printStackTrace();
        }
    }    

    public void atualizar(Contato contato) {
    String sql = "UPDATE contatos SET nome = ?, email = ?, telefone = ? where id_contato = ?";
    try {         
        stmt = conn.prepareStatement(sql); 
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getTelefone());
        stmt.setInt(4, contato.getId());
	stmt.execute();   
    } catch (SQLException ex) {                    
        ex.printStackTrace();
    }
}    


}
