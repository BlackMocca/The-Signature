
import com.the.signature.listener.DotenvContextListener;
import com.the.signature.models.ENV;
import com.the.signature.utils.ConnectionBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author huag1
 */
public class ConnectDatabaseTest {
    protected String rootProjectLinux = System.getenv("MAVEN_PROJECTBASEDIR");
    protected String rootProjectWindow = System.getenv("=C:");
    
    public void initConnection(){
        if(rootProjectLinux != null){
            ENV.setDotenv(Dotenv.configure().directory(rootProjectLinux).load());
        } else {
            ENV.setDotenv(Dotenv.configure().directory(rootProjectWindow).load());
        }
          
        DotenvContextListener.initConnectionDatabase();
    }
    
    @Test
    public void testConnectDatabase(){
        initConnection();
        Assert.assertNotNull(ConnectionBuilder.getConnection());
    }
}
