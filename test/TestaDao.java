
import dao.ContatoDao;
import bean.Contato;

public class TestaDao {
    public static void main(String[] args) {
        Contato meuContato = new Contato();
        ContatoDao dao = new ContatoDao();
        meuContato.setNome("Joao Paulo");
        meuContato.setTelefone("555-5555");
        meuContato.setEmail("jp@gmail.com");
        dao.salvar(meuContato);
    }    
}
