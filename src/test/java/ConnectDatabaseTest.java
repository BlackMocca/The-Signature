
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
    
    public void initConnection(){
        String rootProject = System.getenv("=C:");
        ENV.setDotenv(Dotenv.configure().directory(rootProject).load());  
        DotenvContextListener.initConnectionDatabase();
    }
    
    @Test
    public void testConnectDatabase(){
        initConnection();
        Assert.assertNotNull(ConnectionBuilder.getConnection());
    }
}
