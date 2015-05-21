package interfaces.daos;

import java.sql.Connection;
import java.util.List;

import transfers.Funcionario;


public interface IFuncionarioDao {

	public List<Funcionario> findAll(Connection connection);
	List<Funcionario> findByName(Connection connection, String nombre);
	int insertAdmin(Connection connection, Funcionario funcionario);
	int borrarAdmin(Connection connection, String nick);
	Funcionario findByNick(Connection connection, String nick);
	int modificarFuncionario(Connection connection, Funcionario funcionario);
}
