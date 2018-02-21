/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.the.signature.models.ENV;
import com.the.signature.models.Homestay;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.ArrayList;
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
    public void testCreateHomestay() {
        Map<String, Object> data = new HashMap<String, Object>();
        
        data.put("User_id", 1);
        data.put("Homestay_name", "huaghome");
        data.put("Content_image", pathToImage + "test-image.jpg");
        data.put("Cover_img", pathToImage + "test-cover-image.jpeg");
        data.put("Hourse_document", pathToImage + "test-house-document.jpg");
        data.put("Homestay_License_document", pathToImage + "test-house-document.jpg");
        data.put("Province", "Bangkok");
        data.put("District", "Bangkhunthien");
        data.put("Sub_district", "Jomthong");
        data.put("Address_detail", "622/208 Casacity village Bangkhunthien-chaitale rtd.");
        data.put("Description", "desc");
        data.put("Rule", "rule");
        data.put("Telno", "0123456789");
        data.put("Category", "beach");
        data.put("Open_time", "08.00");
        data.put("Close_time", "20.00");
        data.put("Status", "verifying");
        data.put("Price", "500");
        int expect = Homestay.createHomestay(data);

        Assert.assertEquals(1, expect);
    }
    
    @Test
    public void testGetHomestayByUserId(){
        ArrayList<Homestay> homestayList = Homestay.getHomestayByUserId(1);
        System.out.println(homestayList);
        Assert.assertNotNull(homestayList);
    }

    @Test
    public void testCheckHomestayNameRepeat() {
        Map<String, Object> data = new HashMap<String, Object>();
        Homestay homestay = new Homestay();
        
        data.put("Homestay_name", "huaghome");
        boolean expect = homestay.checkHomestayNameRepeat(data);
        
        Assert.assertEquals(false, expect);
    }

    @Test
    public void testIsPDFFile(){
        String pdfFileTest = "test.pdf";
        boolean expect = Homestay.isPDFFile(pdfFileTest);
        
        Assert.assertEquals(true, expect);
    }
    
    @Test
    public void testIsJPGFile(){
        String jpgFileTest = "test.jpg";
        boolean expect = Homestay.isJPGFile(jpgFileTest);
        
        Assert.assertEquals(true, expect);
    }
    
    @Test
    public void testIsPNGFile(){
        String pngFileTest = "test.png";
        boolean expect = Homestay.isPNGFile(pngFileTest);
        
        Assert.assertEquals(true, expect);
    }
}
