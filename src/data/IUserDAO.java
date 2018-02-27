package data;

public interface IUserDAO {

	UserDTO getUser(int userId) throws DALException;
	void createUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;

}