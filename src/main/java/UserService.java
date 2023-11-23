// Pour créer une classe de test : faites un clic droit sur la classe UserService, allez dans "Generate", puis sélectionnez "Test" et enfin "setUP Before".
public class UserService {
    private UserRepo repo;
    public User addUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return repo.save(user);
    }
}
