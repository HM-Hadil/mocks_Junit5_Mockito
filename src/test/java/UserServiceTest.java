import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    User user;


     /**
      * @Mock :
     Empêche l'objet "repo" de se connecter à la base de données par cette annotation,donc le repo devient
     un "objet fictif plutôt que réel
      **/
    @Mock
    private UserRepo repo;

   /**
     *
    InjectMocks :
     La méthode réelle addUser va utiliser la version qui existe dans l'objet fictif mock.
     Ainsi, cette annotation @InjectMocks fera appel au mock à la place de l'objet réel repo
     pour se connecter à la base de données.
    **/
   @InjectMocks
    private UserService service;

    // Avant d'exécuter chaque test, il faut exécuter la méthode init()
    @BeforeEach
    void init(){
        user = new User();
    }
    @Test
    public void test(){

         // when then return : Lorsque 'any' appelle à la méthode save() avec n'importe quel utilisateur, => retourner l'utilisateur en question.
        when(repo.save(any(User.class))).thenReturn(user);

        // Vérifiez la méthode addUser() pour vous assurer qu'elle s'est bien exécutée. Si la valeur est nulle, cela indique une erreur.
        assertNotNull(service.addUser("hadil","123"));

        // Vérifiez si l'appel a été effectué une fois, deux fois ou trois fois, etc.
        verify(repo,times(1)).save(any(User.class));
    }

// test validé

}