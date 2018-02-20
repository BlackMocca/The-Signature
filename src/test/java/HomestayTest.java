/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.the.signature.models.ENV;
import com.the.signature.models.Homestay;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KazeShin
 */
public class HomestayTest extends ConnectDatabaseTest {
  private String pathToImage;
    public HomestayTest() {
        initConnection();
        pathToImage = "/src/main/webapp/images/";
    }
            
    @Test
    public void testCreateHomestay(){
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("User_id", 1);
        data.put("Homestay_name", "huaghome");
        data.put("Content_image", pathToImage+"test-image.jpg");
        data.put("Cover_img", pathToImage+"test-cover-image.jpeg");
        data.put("Hourse_document", pathToImage+"test-house-document.jpg");
        data.put("Homestay_License_document", pathToImage+"test-house-document.jpg");
        data.put("Description", "desc");
        data.put("Rule", "rule");
        data.put("Telno", "0123456789");
        data.put("Category", "beach");
        data.put("Open_time", "08.00");
        data.put("Close_time", "20.00");
        data.put("Status", "verifying");
        int expect = Homestay.createHomestay(data);
        
        Assert.assertEquals(1, expect);
   }
    
}
